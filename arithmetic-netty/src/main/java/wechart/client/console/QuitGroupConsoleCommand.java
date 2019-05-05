package wechart.client.console;

import io.netty.channel.Channel;
import wechart.protocol.request.QuitGroupRequestPacket;

import java.util.Scanner;

/**
 * Created by peng.tan on 2019/5/5.
 */
public class QuitGroupConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        QuitGroupRequestPacket quitGroupRequestPacket = new QuitGroupRequestPacket();
        System.out.println("输入 groupId, 退出群聊: ");
        String groupId = scanner.next();
        quitGroupRequestPacket.setGroupId(groupId);
        channel.writeAndFlush(quitGroupRequestPacket);
    }

}
