package com.juejin.netty.startnetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * 在客户端程序中，group对应了我们IOClient.java中main函数起的线程
 * <p>
 * Created by peng.tan on 2019/3/12.
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)   // 指定线程模型
                .channel(NioSocketChannel.class)  //指定IO模型
                .handler(new ChannelInitializer<SocketChannel>() {  //IO处理逻辑
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });

        // 建立连接
        ChannelFuture channelFuture = connect(bootstrap);

        Channel channel = channelFuture.channel();
        while (true) {
            channel.writeAndFlush(new Date() + ": hello world!");
            Thread.sleep(2000);
        }
    }

    /**
     * 失败重连
     *
     * @param bootstrap
     * @return
     */
    private static ChannelFuture connect(Bootstrap bootstrap) {
        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8000).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功");
            } else {
                System.out.println("连接失败");
                connect(bootstrap);
            }
        });
        return channelFuture;
    }
}
