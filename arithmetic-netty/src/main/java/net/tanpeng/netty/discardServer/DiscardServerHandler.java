package net.tanpeng.netty.discardServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by peng.tan on 2018/9/5.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 当客户端收到新的数据时，这个方法会在收到消息时被调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 默默地丢弃收到的数据
        ((ByteBuf) msg).release();
        super.channelRead(ctx, msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
