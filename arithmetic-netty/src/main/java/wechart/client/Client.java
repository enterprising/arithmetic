package wechart.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import wechart.checkalive.IMIdleStateHandler;
import wechart.client.console.ConsoleCommandManager;
import wechart.client.console.LoginConsoleCommand;
import wechart.client.handler.*;
import wechart.codec.PacketDecoder;
import wechart.codec.PacketEncoder;
import wechart.codec.Spliter;
import wechart.util.SessionUtil;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 演示客户端发送数据给服务端
 */
public class Client {

    private static final int MAX_RETRY = 5;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8001;

    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        // 空闲检测
                        ch.pipeline().addLast(new IMIdleStateHandler());
                        ch.pipeline().addLast(new Spliter());
                        ch.pipeline().addLast(new PacketDecoder());
                        // 登录响应处理器
                        ch.pipeline().addLast(new LoginResponseHandler());
                        // 收消息处理器
                        ch.pipeline().addLast(new MessageResponseHandler());
                        // 创建群响应处理器
                        ch.pipeline().addLast(new CreateGroupResponseHandler());
                        // 加群响应处理器
                        ch.pipeline().addLast(new JoinGroupResponseHandler());
                        // 退群响应处理器
                        ch.pipeline().addLast(new QuitGroupResponseHandler());
                        // 获取群成员响应处理器
                        ch.pipeline().addLast(new ListGroupMembersResponseHandler());
                        // 群消息响应
                        ch.pipeline().addLast(new GroupMessageResponseHandler());
                        // 登出响应处理器
                        ch.pipeline().addLast(new LogoutResponseHandler());
                        ch.pipeline().addLast(new PacketEncoder());

                        // 心跳定时器
                        ch.pipeline().addLast(new HeartBeatTimerHandler());
                    }
                });

        connect(bootstrap, HOST, PORT, MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 连接成功！开始启动控制台线程...");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
                System.out.println("重连次数用尽，依旧连接失败！");
            } else {
                // 第几次重连
                int order = (MAX_RETRY - retry) + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit.SECONDS);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
        Scanner scanner = new Scanner(System.in);

        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (!SessionUtil.hasLogin(channel)) {
                    loginConsoleCommand.exec(scanner, channel);
                } else {
                    consoleCommandManager.exec(scanner, channel);
                }
            }
        }).start();


        // 单聊版本
//        Scanner sc = new Scanner(System.in);
//        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
//
//        new Thread(() -> {
//            while (!Thread.interrupted()) {
//                if (!SessionUtil.hasLogin(channel)) {
//                    System.out.print("输入用户名登录: ");
//                    String username = sc.nextLine();
//                    loginRequestPacket.setUsername(username);
//
//                    // 密码使用默认的
//                    loginRequestPacket.setPassword("pwd");
//
//                    // 发送登录数据包
//                    channel.writeAndFlush(loginRequestPacket);
//                    waitForLoginResponse();
//                } else {
//                    String toUserId = sc.next();
//                    String message = sc.next();
//                    channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
//                }
//            }
//        }).start();

//        new Thread(() -> {
//            while (!Thread.interrupted()) {
//                // 登录验证换种方式实现
////                if (LoginUtil.hasLogin(channel)) {
//                System.out.println("输入消息发送到服务端：");
//                Scanner sc = new Scanner(System.in);
//                String line = sc.nextLine();
//                channel.writeAndFlush(new MessageRequestPacket(line));
////                }
//            }
//        }).start();
    }

//    private static void waitForLoginResponse() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ignored) {
//        }
//    }
}
