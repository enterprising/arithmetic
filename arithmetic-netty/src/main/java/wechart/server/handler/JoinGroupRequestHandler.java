package wechart.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import wechart.protocol.request.JoinGroupRequestPacket;
import wechart.protocol.response.JoinGroupResponsePacket;
import wechart.util.SessionUtil;

/**
 * Created by peng.tan on 2019/5/5.
 */
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {
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
