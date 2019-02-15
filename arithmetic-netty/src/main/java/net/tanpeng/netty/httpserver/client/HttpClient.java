package net.tanpeng.netty.httpserver.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

public class HttpClient {
    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);
    private final String url;
    private ClientHandler clientHandler;
    private URI uri = null;
    private final Bootstrap bootstrap;
    private final ChannelFuture channelFuture;

    public HttpClient(String url) {
        this.url = url;
        clientHandler = new ClientHandler();

        EventLoopGroup loopGroup = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(loopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new HttpRequestEncoder()).addLast(new HttpResponseDecoder()).addLast(new HttpObjectAggregator(1024 * 1024 * 64))
                        .addLast(clientHandler);
            }
        });

        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            logger.error("URL format error", e);
        }
        channelFuture = bootstrap.connect(uri.getHost(), uri.getPort() < 0 ? 80 : uri.getPort());

    }

    public void connect() throws Exception {
        logger.debug("connect to " + url);
        uri = new URI(url);
        Channel channel = channelFuture.sync().channel();
    }

    public byte[] send(String msg, String path) throws Exception {
        DefaultFullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, path);
        request.content().writeBytes(msg.getBytes());
        request.headers().set(HttpHeaders.Names.HOST, uri.getHost());
        request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());
        channelFuture.addListener(future -> {
            if (future.isSuccess()) {
                ChannelPromise promise = clientHandler.sendMessage(request);
                promise.await();
            }
        });
        return clientHandler.getData();
    }
}
