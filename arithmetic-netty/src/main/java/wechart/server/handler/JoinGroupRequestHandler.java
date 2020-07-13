package wechart.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import wechart.protocol.request.JoinGroupRequestPacket;
import wechart.protocol.response.JoinGroupResponsePacket;
import wechart.util.SessionUtil;

/**
 * 首先，我们这里创建一个 ChannelGroup。这里简单介绍一下 ChannelGroup：它可以把多个 chanel 的操作聚合在一起，可以往它里面添加删除 channel，可以进行 channel 的批量读写，关闭等操作，详细的功能读者可以自行翻看这个接口的方法。这里我们一个群组其实就是一个 channel 的分组集合，使用 ChannelGroup 非常方便。
 * 接下来，我们遍历待加入群聊的 userId，如果存在该用户，就把对应的 channel 添加到 ChannelGroup 中，用户昵称也添加到昵称列表中。
 * 然后，我们创建一个创建群聊响应的对象，其中 groupId 是随机生成的，群聊创建结果一共三个字段，这里就不展开对这个类进行说明了。
 * 最后，我们调用 ChannelGroup 的聚合发送功能，将拉群的通知批量地发送到客户端，接着在服务端控制台打印创建群聊成功的信息，至此，服务端处理创建群聊请求的逻辑结束。
 *
 * Created by peng.tan on 2019/5/5.
 */
@ChannelHandler.Sharable
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {
    public static final JoinGroupRequestHandler INSTANCE = new JoinGroupRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket requestPacket) throws Exception {
        // 1.获取群对应的 channelGroup，然后将当前用户的 channel 添加进去
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelgroup = SessionUtil.getChannelGroup(groupId);
        channelgroup.add(ctx.channel());

        // 2. 构造加群响应发送给客户端
        JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();
        responsePacket.setSuccess(true);
        requestPacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(responsePacket);
    }
}
