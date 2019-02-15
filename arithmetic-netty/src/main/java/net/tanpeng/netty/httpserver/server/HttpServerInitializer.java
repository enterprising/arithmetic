package net.tanpeng.netty.httpserver.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Created by peng.tan on 2019/1/5.
 */
public class HttpServerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast("decoder",new HttpRequestDecoder());

        pipeline.addLast(new HttpObjectAggregator(1024*1024*64));
        pipeline.addLast(new HttpServerHandler());
    }
}
