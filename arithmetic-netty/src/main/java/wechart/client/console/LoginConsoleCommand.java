package wechart.client.console;

import io.netty.channel.Channel;
import wechart.protocol.request.LoginRequestPacket;

import java.util.Scanner;

/**
 * Created by peng.tan on 2019/5/5.
 */
public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        System.out.println("输入用户名登录：");
        loginRequestPacket.setUsername(scanner.next());
        loginRequestPacket.setPassword("tan");

        // 发送登录数据包
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
