package wechart.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import wechart.protocol.PacketCodeC;

/**
 * 主要解决拆包粘包问题
 * LengthFieldBasedFrameDecoder 表示读取特定位数 表示length，然后读取后面的length位
 * 这个是最常用的方案
 *
 * Created by peng.tan on 2019/5/3.
 */
public class Spliter extends LengthFieldBasedFrameDecoder {
    // 前面的固定信息
    private static final int LENGTH_FIELD_OFFSET = 7;
    // 这四位表示的数字，意思是后面多长是本条数据的长度
    private static final int LENGTH_FIELD_LENGTH = 4;

    public Spliter() {
        super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        // 用这个判断是否是我们需要的包，这个是开头的魔数
        if (in.getInt(in.readerIndex()) != PacketCodeC.MAGIC_NUMBER) {
            ctx.channel().close();
            return null;
        }

        return super.decode(ctx, in);
    }
}
