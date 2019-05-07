package wechart.checkalive;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * 所谓的假死就是其实连接断了，但服务端感知不到，从而造成资源的浪费等。
 * 用空闲检测来解决这个问题。
 * 何为空闲检测？空闲检测指的是每隔一段时间，检测这段时间内是否有数据读写，
 * 简化一下，我们的服务端只需要检测一段时间内，是否收到过客户端发来的数据即可，Netty 自带的 IdleStateHandler 就可以实现这个功能。
 * <p>
 * Created by peng.tan on 2019/5/7.
 */
public class IMIdleStateHandler extends IdleStateHandler {

    private static final int READER_IDLE_TIME = 15;

    public IMIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        System.out.println(READER_IDLE_TIME + "秒内未读到数据，关闭连接");
        ctx.channel().close();
    }
}
