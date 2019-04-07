package wechart.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import wechart.bean.Packet;

/**
 * Created by peng.tan on 2019/4/6.
 */
public class PacketCodeC {
    private static final int MAGIC_NUMBER = 0x12345678;

    public ByteBuf encode(Packet packet) {
        // 1.创建bytebuf对象
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();


    }
}
