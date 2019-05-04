package wechart.attrribute;

import io.netty.util.AttributeKey;
import wechart.session.Session;

/**
 * Created by peng.tan on 2019/5/1.
 */
public interface Attributes {

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

}
