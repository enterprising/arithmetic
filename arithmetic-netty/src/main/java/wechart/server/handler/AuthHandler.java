package wechart.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import wechart.util.SessionUtil;

/**
 *
 * AuthHandler 继承自 ChannelInboundHandlerAdapter，覆盖了 channelRead() 方法，表明他可以处理所有类型的数据
 *
 * Created by peng.tan on 2019/5/4.
 */
@ChannelHandler.Sharable
public class AuthHandler extends ChannelInboundHandlerAdapter {
    public static final AuthHandler INSTANCE = new AuthHandler();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!SessionUtil.hasLogin(ctx.channel())) {
            ctx.channel().close();
        } else {
            // 如果某一个独立的逻辑在执行几次之后（这里是一次）不需要再执行了，
            // 那么我们可以通过 ChannelHandler 的热插拔机制来实现动态删除逻辑，应用程序性能处理更为高效
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    }

//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) {
//        if (SessionUtil.hasLogin(ctx.channel())) {
//            System.out.println("当前连接登录验证完毕，无需再次验证, AuthHandler 被移除");
//        } else {
//            System.out.println("无登录验证，强制关闭连接!");
//        }
//    }
}
