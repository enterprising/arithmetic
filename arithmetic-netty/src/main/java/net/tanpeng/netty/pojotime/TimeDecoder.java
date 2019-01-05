package net.tanpeng.netty.pojotime;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 处理数据拆分的问题
 * <p>
 * Created by peng.tan on 2019/1/5.
 */
public class TimeDecoder extends ByteToMessageDecoder {

    /**
     * 每当有新数据接收的时候，ByteToMessageDecoder 都会调用 decode() 方法来处理内部的那个累积缓冲。
     *
     * @param ctx
     * @param in
     * @param out
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }

        // out.add(in.readBytes(4));
        // 现在我们可以修改下 TimeDecoder 类，返回一个 UnixTime，以替代ByteBuf
        out.add(new UnixTime(in.readUnsignedInt()));
    }
}
