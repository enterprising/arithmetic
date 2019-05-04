package wechart.util;

import io.netty.channel.Channel;
import wechart.attrribute.Attributes;
import wechart.session.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by peng.tan on 2019/5/4.
 */
public class SessionUtil {
    // 这个map是最关键的，里面存的是用户标识到channel的映射
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    public static boolean hasLogin(Channel channel) {

        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {

        return userIdChannelMap.get(userId);
    }
}
