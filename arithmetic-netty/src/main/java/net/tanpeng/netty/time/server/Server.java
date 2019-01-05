package net.tanpeng.netty.time.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import net.tanpeng.netty.pojotime.TimeDecoder;
import net.tanpeng.netty.pojotime.TimeEncoder;

/**
 * 在这个部分被实现的协议是 TIME 协议。
 * 和之前的例子不同的是在不接受任何请求时他会发送一个含32位的整数的消息，并且一旦消息发送就会立即关闭连接。
 * 在这个例子中，你会学习到如何构建和发送一个消息，然后在完成时关闭连接。
 * <p>
 * 为了测试我们的time服务如我们期望的一样工作，你可以使用 UNIX 的 rdate 命令
 * $ rdate -o <port> -p <host>
 * Port 是你在main()函数中指定的端口，host 使用 localhost 就可以了。
 * <p>
 * Created by peng.tan on 2019/1/5.
 */
public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
        // NioEventLoopGroup是用来处理IO操作的多线程事件循环器，除了这个还有很多种别的
        // 服务端的应用需要两个处理器，一个叫boss，用来接收进来的连接。一个叫worker用来处理已经被接收的连接。
        // *  一般boss接收到连接，就会把连接信息注册到worker上。
        // *  如何知道多少个线程已经被使用，如何映射到已经创建的channel上，都需要依赖于EventLoopGroup的实现
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // ServerBootStrap是一个启动NIO服务的辅助启动类，直接在服务中使用channel会很复杂，使用这个会简化操作
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup)
                    // NioServerSocketChannel，一个channel如何接收进来的连接
                    .channel(NioServerSocketChannel.class)
                    //  事件处理器类通常会被用来处理一个最近的已经接收的Channel，ChannelInitializer用来帮使用者配置一个新的Channel
                    // *      处理类放到pipline上就好了。 当需要处理的特别多的时候，这个一般会被单独拎出来。
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new TimeEncoder(), new TimeServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // option和childOption的区别：
                    // *      option() 是提供给NioServerSocketChannel 用来接收进来的连接。
                    // *      childOption() 是提供给由父管道 ServerChannel 接收到的连接，在这个例子中也是 NioServerSocketChannel。
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            //绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(port).sync();

            //等待服务器 socket 关闭
            // 在这个例子中，不会发生，但你可以优雅地关闭你的服务器
            f.channel().closeFuture().sync();
        } finally {
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
        new Server(port).run();
    }
}
