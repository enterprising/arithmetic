package net.tanpeng.netty.channelHandler.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * 入站处理，主要处理读数据的逻辑，将数据从 channel 中读到内存
 * @author: peng.tan
 * @create: 2020/07/12 20:02
 */
public class InBoundHandlerA extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + ": 服务端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));

        System.out.println("InBoundHandlerA: " + msg);
        super.channelRead(ctx, msg);
    }
}
