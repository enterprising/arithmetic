package wechart.protocol.request;

import lombok.Data;
import wechart.protocol.Packet;

import static wechart.protocol.command.Command.QUIT_GROUP_REQUEST;

/**
 * Created by peng.tan on 2019/5/5.
 */
@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_REQUEST;
    }
}
