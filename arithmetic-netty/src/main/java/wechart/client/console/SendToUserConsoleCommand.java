package wechart.client.console;

import io.netty.channel.Channel;
import wechart.protocol.request.MessageRequestPacket;

import java.util.Scanner;

/**
 * Created by peng.tan on 2019/5/5.
 */
public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个用户：");

        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId, message));
    }
}
