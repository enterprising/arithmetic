package wechart.protocol.response;

import lombok.Data;
import wechart.protocol.Packet;
import wechart.session.Session;

import static wechart.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

/**
 * Created by peng.tan on 2019/5/6.
 */
@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {

        return GROUP_MESSAGE_RESPONSE;
    }
}
