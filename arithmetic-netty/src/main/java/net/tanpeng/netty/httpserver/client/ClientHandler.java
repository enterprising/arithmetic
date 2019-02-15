package net.tanpeng.netty.httpserver.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientHandler extends SimpleChannelInboundHandler<FullHttpResponse> {
    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);
    private ChannelHandlerContext ctx;
    private ChannelPromise promise;
    byte buf[];

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        this.ctx = ctx;
    }

    public ChannelPromise sendMessage(Object message) {
        if (ctx == null)
            throw new IllegalStateException();
        promise = ctx.writeAndFlush(message).channel().newPromise();
        return promise;
    }

    public byte[] getData() {
        return buf;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        promise.setFailure(cause);
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpResponse msg) throws Exception {
        buf = new byte[msg.content().readableBytes()];
        msg.content().readBytes(buf);
        logger.debug("respose: {}", new String(buf));
        promise.setSuccess();
    }
}

