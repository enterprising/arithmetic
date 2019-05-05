package wechart.client.console;

import io.netty.channel.Channel;
import wechart.protocol.request.JoinGroupRequestPacket;

import java.util.Scanner;

/**
 * Created by peng.tan on 2019/5/5.
 */
public class JoinGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        JoinGroupRequestPacket joinGroupRequestPacket = new JoinGroupRequestPacket();

        System.out.println("输入groupid，加入群聊：");
        String groupId = scanner.next();

        joinGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(joinGroupRequestPacket);
    }
}

