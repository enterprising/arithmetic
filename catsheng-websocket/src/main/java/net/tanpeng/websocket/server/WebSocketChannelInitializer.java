package net.tanpeng.websocket.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by peng.tan on 2019/6/22.
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        // websocket协议本身是基于HTTP协议的，所以解码器要用http解码器
        pipeline.addLast(new HttpServerCodec());
        // 以块的方式来写
        pipeline.addLast(new ChunkedWriteHandler());
        // netty是基于分段请求的，HttpObjectAggregator的作用是将请求分段再聚合,参数是聚合字节的最大长度
        pipeline.addLast(new HttpObjectAggregator(65536));

        // 跟websocket有关的配置
        // ws://server:port/context_path
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws",null,true));

        //websocket定义了传递数据的6中frame类型
        pipeline.addLast(new TextWebSocketFrameHandler());
    }
}
