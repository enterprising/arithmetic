package com.juejin.netty.serverclient;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * 演示客户端发送数据给服务端
 * Created by peng.tan on 2019/3/20.
 */
public class Client {
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new FirstClientHandler());
                    }
                }).connect("127.0.0.1", 8001);
    }

    private static class FirstClientHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf byteBuf = (ByteBuf) msg;
            System.out.println(new Date() + ": 客户端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println(new Date() + " : 客户端写出数据");

            // 1.获取数据
            ByteBuf byteBuf = getByteBuff(ctx);

            // 2.写数据
            ctx.writeAndFlush(byteBuf);
        }

        private ByteBuf getByteBuff(ChannelHandlerContext ctx) {
            // 1.获取二进制抽象
            ByteBuf byteBuf = ctx.alloc().buffer();

            // 2.准备数据，指定字符串的字符集为 utf-8
            byte[] bytes = "hello 谭".getBytes(Charset.forName("utf-8"));

            // 3.填充到bytebuf
            byteBuf.writeBytes(bytes);

            return byteBuf;
        }
    }
}
