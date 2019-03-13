package com.juejin.netty.startnetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;

/**
 * 1.boos对应，IOServer.java中的接受新连接线程，主要负责创建新连接
 * 2.worker对应 IOClient.java中的负责读取数据的线程，主要用于读取数据以及业务逻辑处理
 *
 * Created by peng.tan on 2019/3/12.
 */
public class NettyServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ReadTimeoutHandler(1));
                        ch.pipeline().addLast(new WriteTimeoutHandler(1));
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                                ctx.channel().writeAndFlush("shoudaolemei?");
                            }
                            @Override
                            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                                System.out.println("timeout exception");
                                System.out.println(ctx.toString());
                                System.out.println(cause);
                                ctx.close();
                            }
                        });
                    }
                })
                .bind(8000);
    }
}
