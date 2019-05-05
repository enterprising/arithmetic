package wechart.protocol.response;

import lombok.Data;
import wechart.protocol.Packet;

import static wechart.protocol.command.Command.QUIT_GROUP_RESPONSE;

/**
 * Created by peng.tan on 2019/5/5.
 */
@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_RESPONSE;
    }
}
