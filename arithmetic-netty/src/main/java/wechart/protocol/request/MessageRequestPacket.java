package wechart.protocol.request;

import lombok.Data;
import wechart.protocol.Packet;

import static wechart.protocol.command.Command.MESSAGE_REQUEST;

/**
 * Created by peng.tan on 2019/5/1.
 */
@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }

}
