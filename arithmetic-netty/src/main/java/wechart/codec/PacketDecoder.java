package wechart.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import wechart.protocol.PacketCodeC;

import java.util.List;

/**
 * 客户端用decoder，主要是把服务端传过来的字节流转成这边认识的 包对象
 *
 * Created by peng.tan on 2019/5/2.
 */
public class PacketDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) {
        out.add(PacketCodeC.INSTANCE.decode(in));
    }
}