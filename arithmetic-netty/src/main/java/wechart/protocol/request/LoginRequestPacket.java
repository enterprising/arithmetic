package wechart.protocol.request;

import lombok.Data;
import wechart.protocol.Packet;

import static wechart.protocol.command.Command.LOGIN_REQUEST;

/**
 * Created by peng.tan on 2019/4/6.
 */
@Data
public class LoginRequestPacket extends Packet {
    private String userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
