package net.tanpeng.netty.lifeCyCle.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 回调顺序
 * handlerAdded() -> channelRegistered() -> channelActive() -> channelRead() -> channelReadComplete()
 * <p>
 * client关闭连接后的回调顺序
 * channelInactive() -> channelUnregistered() -> handlerRemoved()
 * <p>
 * 关于：channelActive() 与 channelInActive()
 * 这两个方法表明的含义是 TCP 连接的建立与释放，通常我们在这两个回调里面统计单机的连接数，channelActive() 被调用，连接数加一，channelInActive() 被调用，连接数减一
 * 另外，我们也可以在 channelActive() 方法中，实现对客户端连接 ip 黑白名单的过滤
 *
 * @author: peng.tan
 * @create: 2020/07/13 22:48
 */
public class LifeCyCleTestHandler extends ChannelInboundHandlerAdapter {

    /**
     * 指的是当检测到新连接之后，调用 ch.pipeline().addLast(new LifeCyCleTestHandler());
     * 之后的回调，表示在当前的 channel 中，已经成功添加了一个 handler 处理器。
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("逻辑处理器被添加：handlerAdded()");
        super.handlerAdded(ctx);
    }

    /**
     * 表示当前的 channel 的所有的逻辑处理已经和某个 NIO 线程建立了绑定关系。
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel 绑定到线程(NioEventLoop)：channelRegistered()");
        super.channelRegistered(ctx);
    }

    /**
     * 当 channel 的所有的业务逻辑链准备完毕（也就是说 channel 的 pipeline 中已经添加完所有的 handler）以及绑定好一个 NIO 线程之后，
     * 这条连接算是真正激活了，接下来就会回调到此方法。
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel 准备就绪：channelActive()");
        super.channelActive(ctx);
    }

    /**
     * 客户端向服务端发来数据，每次都会回调此方法，表示有数据可读。
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channel 有数据可读：channelRead()");
        super.channelRead(ctx, msg);
    }

    /**
     * 服务端每次读完一次完整的数据之后，回调该方法，表示数据读取完毕。
     * 前面小节中，我们在每次向客户端写数据的时候，都通过 writeAndFlush() 的方法写并刷新到底层，
     * 其实这种方式不是特别高效，我们可以在之前调用 writeAndFlush() 的地方都调用 write() 方法，
     * 然后在这个方面里面调用 ctx.channel().flush() 方法，相当于一个批量刷新的机制，
     * 当然，如果你对性能要求没那么高，writeAndFlush() 足矣。
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel 某次数据读完：channelReadComplete()");
        super.channelReadComplete(ctx);

    }

    /**
     * 表明这条连接已经被关闭了，这条连接在 TCP 层面已经不再是 ESTABLISH 状态了
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel 被关闭：channelInactive()");
        super.channelInactive(ctx);
    }

    /**
     * 既然连接已经被关闭，那么与这条连接绑定的线程就不需要对这条连接负责了，
     * 这个回调就表明与这条连接对应的 NIO 线程移除掉对这条连接的处理
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel 取消线程(NioEventLoop) 的绑定: channelUnregistered()");
        super.channelUnregistered(ctx);
    }

    /**
     * 给这条连接上添加的所有的业务逻辑处理器都给移除掉
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("逻辑处理器被移除：handlerRemoved()");
        super.handlerRemoved(ctx);
    }
}
