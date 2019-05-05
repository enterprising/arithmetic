package wechart.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * Created by peng.tan on 2019/5/5.
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
