package wechart.protocol.response;

import lombok.Data;
import wechart.protocol.Packet;

import static wechart.protocol.Command.MESSAGE_RESPONSE;

/**
 * Created by peng.tan on 2019/5/1.
 */
@Data
public class MessageResponsePacket extends Packet {
    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}
