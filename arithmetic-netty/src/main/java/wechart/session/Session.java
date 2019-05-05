package wechart.session;

import io.netty.channel.Channel;
import lombok.Data;

/**
 * Created by peng.tan on 2019/5/4.
 */
@Data
public class Session {
    // 用户唯一性标识
    private String userId;
    private String userName;
    private Channel channel;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }

}
