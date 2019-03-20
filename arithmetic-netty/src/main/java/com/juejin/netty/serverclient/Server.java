package com.juejin.netty.serverclient;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * 服务端读取客户端数据
 * Created by peng.tan on 2019/3/20.
 */
public class Server {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        System.out.println("服务启动中...");
                        ch.pipeline().addLast(new FirstServerHandler());
                    }
                }).bind(8001);
    }

    public static class FirstServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            ByteBuf byteBuf = (ByteBuf) msg;

            System.out.println(new Date() + ": 服务端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));

            // 收到之后往客户端返回数据
            System.out.println(new Date() + ": 服务端写出数据");
            ByteBuf out = getByteBuf(ctx);

            ctx.channel().writeAndFlush(out);
        }

        private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
            byte[] bytes = "你好，我收到你发来的东西了。".getBytes(Charset.forName("utf-8"));
            ByteBuf byteBuf = ctx.alloc().buffer();
            byteBuf.writeBytes(bytes);
            return byteBuf;
        }


    }

    /**
     * 思考题。如何实现新连接接入的时候，服务端主动向客户端推送消息，客户端回复服务端消息？欢迎留言讨论。
     * 答：把客户端channelActive()的代码去除，在服务端channelActive()方法里增加给客户端发送消息代码。在客户端ChannelRead()方法里增加给服务端发送消息代码。主要就是一个生命周期问题。
     */

}
