package wechart.protocol.response;

import lombok.Data;
import wechart.protocol.Packet;

import static wechart.protocol.command.Command.LOGOUT_RESPONSE;

/**
 * Created by peng.tan on 2019/5/5.
 */
@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return LOGOUT_RESPONSE;
    }
}
