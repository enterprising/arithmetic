package wechart.attrribute;

import io.netty.util.AttributeKey;

/**
 * Created by peng.tan on 2019/5/1.
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
