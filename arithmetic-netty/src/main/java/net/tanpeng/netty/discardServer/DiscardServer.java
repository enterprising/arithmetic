package net.tanpeng.netty.discardServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 丢弃任何进入的数据，这个类用于启动那个handler
 * Created by peng.tan on 2018/9/5.
 */
public class DiscardServer {
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {  // 4
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new DiscardServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)  //5
                    .childOption(ChannelOption.SO_KEEPALIVE, true);  //6

            //绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(port).sync();

            //等待服务器 socket 关闭
            // 在这个例子中，不会发生，但你可以优雅地关闭你的服务器
            f.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8000;
        }
        new DiscardServer(port).run();
    }
}

/**
 * 说明：
 * 1）NioEventLoopGroup是用来处理IO操作的多线程事件循环器，除了这个还有很多种别的
 *  服务端的应用需要两个处理器，一个叫boss，用来接收进来的连接。一个叫worker用来处理已经被接收的连接。
 *  一般boss接收到连接，就会把连接信息注册到worker上。
 *  如何知道多少个线程已经被使用，如何映射到已经创建的channel上，都需要依赖于EventLoopGroup的实现
 *
 *  2) ServerBootStrap是一个启动NIO服务的辅助启动类，直接在服务中使用channel会很复杂，使用这个会简化操作
 *
 *  3) NioServerSocketChannel，一个channel如何接收进来的连接
 *
 *  4) 事件处理器类通常会被用来处理一个最近的已经接收的Channel，ChannelInitializer用来帮使用者配置一个新的Channel
 *      处理类放到pipline上就好了。 当需要处理的特别多的时候，这个一般会被单独拎出来。
 *
 *  5) 参数，https://netty.io/4.0/api/io/netty/channel/ChannelOption.html
 *
 *  6) option和childOption的区别：
 *      option() 是提供给NioServerSocketChannel 用来接收进来的连接。
 *      childOption() 是提供给由父管道 ServerChannel 接收到的连接，在这个例子中也是 NioServerSocketChannel。
 *
 *  附：测试 telnet 127.0.0.1:8000 （mac下没有telnet可以先安装）
 */
