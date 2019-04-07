package wechart.bean;

/**
 * Created by peng.tan on 2019/4/6.
 */
public class LoginRequestPacket extends Packet implements Command {
    private Integer userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
