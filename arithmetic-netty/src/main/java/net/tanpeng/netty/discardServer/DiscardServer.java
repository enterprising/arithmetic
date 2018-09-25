package net.tanpeng.netty.discardServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * 丢弃任何进入的数据
 * Created by peng.tan on 2018/9/5.
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run(){
        // NioEventLoopGroup是用来处理I/O操作的多线程事件处理器
        // 一般会建两个，boss用来接收进来的连接，worker用来处理已经被接收的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
    }
}
