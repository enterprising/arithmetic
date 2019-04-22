package wechart.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
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
