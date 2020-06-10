package wechart.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * package协议参考：https://juejin.im/book/5b4bc28bf265da0f60130116/section/5b4db045f265da0f83647c35
 * Created by peng.tan on 2019/4/6.
 */
@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;


    @JSONField(serialize = false)
    public abstract Byte getCommand();
}
