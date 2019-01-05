package net.tanpeng.netty.time.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.tanpeng.netty.pojotime.UnixTime;

/**
 * 和之前的例子不同的是在不接受任何请求时他会发送一个含32位的整数的消息，并且一旦消息发送就会立即关闭连接。
 * 在这个例子中，你会学习到如何构建和发送一个消息，然后在完成时关闭连接。
 * Created by peng.tan on 2018/10/15.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * channelActive() 方法将会在连接被建立并且准备进行通信时被调用，要弄清楚read和active的区别
     *
     * @param ctx
     * @throws Exception
     */
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        // 2、为了发送一个新的消息，我们需要分配一个包含这个消息的新的缓冲。因为我们需要写入一个32位的整数，
//        // 因此我们需要一个至少有4个字节的 ByteBuf。通过 ChannelHandlerContext.alloc() 得到一个当前的ByteBufAllocator，
//        // 然后分配一个新的缓冲。
//        final ByteBuf time = ctx.alloc().buffer(4);
//        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//
//        // 3、这里返回的是ChannelFuture，也就是说写入缓冲区并不会马上完成，里面全是异步的。
//        final ChannelFuture f = ctx.writeAndFlush(time);
//        // 4、需要知道什么时候完成，这时候需要加入一个listener。这里，用来在操作完成时关闭 Channel。
//        f.addListener((ChannelFutureListener) future -> ctx.close());
//    }

    // pojotime专用
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
