package wechart.protocol;

import lombok.Data;

/**
 * Created by peng.tan on 2019/4/6.
 */
@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     *
     * @return
     */
    public abstract Byte getCommand();
}
