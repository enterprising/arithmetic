package net.tanpeng.netty.discardServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * Created by peng.tan on 2018/9/5.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 每当从客户端收到新的数据时，这个方法会在收到消息时被调用
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;

//        // 1.丢弃收到的数据
//        in.release();
//
//        // 2. 打印收到的数据
//        System.out.println(in.toString(CharsetUtil.UTF_8));

        // 3. echo server
        ctx.write(msg); // (1)
        ctx.flush(); // (2)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}

/**
 * 说明：
 * 1、继承自ChannelInboundHandlerAdapter，这个类实现了ChannelInboundHandler接口；
 * ChannelInboundHandler提供了很多事件处理的接口方法，可以覆盖这些方法。
 * 现在仅需要继承ChannelInboundHandlerAdapter类，而不是自己去实现接口方法
 */
