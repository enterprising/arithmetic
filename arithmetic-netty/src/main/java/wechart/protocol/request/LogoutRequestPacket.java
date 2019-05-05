package wechart.protocol.request;

import lombok.Data;
import wechart.protocol.Packet;

import static wechart.protocol.command.Command.LOGOUT_REQUEST;

/**
 * Created by peng.tan on 2019/5/5.
 */
@Data
public class LogoutRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return LOGOUT_REQUEST;
    }
}
