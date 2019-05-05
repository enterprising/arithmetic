package wechart.protocol.request;

import lombok.Data;
import wechart.protocol.Packet;

import static wechart.protocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * Created by peng.tan on 2019/5/5.
 */
@Data
public class JoinGroupRequestPacket extends Packet {
    private String groupId;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_REQUEST;
    }
}
