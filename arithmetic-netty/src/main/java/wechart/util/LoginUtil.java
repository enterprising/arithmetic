package wechart.util;


import io.netty.channel.Channel;
import io.netty.util.Attribute;
import wechart.attrribute.Attributes;

/**
 * 学习过程中的代码，已废弃，用session
 * 记录是否登录成功，核心方法是在channel加一个 attr 标记
 * Created by peng.tan on 2019/5/1.
 */
public class LoginUtil {
//    public static void markAsLogin(Channel channel) {
//        channel.attr(Attributes.LOGIN).set(true);
//    }
//
//    public static boolean hasLogin(Channel channel) {
//        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);
//
//        return loginAttr.get() != null;
//    }
}
