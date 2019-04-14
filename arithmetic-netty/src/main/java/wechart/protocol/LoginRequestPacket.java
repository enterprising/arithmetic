package wechart.protocol;

import lombok.Data;

/**
 * Created by peng.tan on 2019/4/6.
 */
@Data
public class LoginRequestPacket extends Packet implements Command {
    private String userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
