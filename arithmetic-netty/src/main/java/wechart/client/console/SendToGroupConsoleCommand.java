package wechart.client.console;

import io.netty.channel.Channel;
import wechart.protocol.request.GroupMessageRequestPacket;

import java.util.Scanner;

/**
 * Created by peng.tan on 2019/5/6.
 */
public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个群组：");

        String toGroupId = scanner.next();
        String message = scanner.next();
        GroupMessageRequestPacket groupMessageRequestPacket = new GroupMessageRequestPacket();
        groupMessageRequestPacket.setToGroupId(toGroupId);
        groupMessageRequestPacket.setMessage(message);

        channel.writeAndFlush(groupMessageRequestPacket);
    }
}
