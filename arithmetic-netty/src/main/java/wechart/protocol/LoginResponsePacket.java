package wechart.protocol;

import lombok.Data;

import static wechart.protocol.Command.LOGIN_RESPONSE;

/**
 * Created by peng.tan on 2019/4/22.
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
