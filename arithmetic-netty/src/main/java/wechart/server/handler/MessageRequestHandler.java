package wechart.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import wechart.protocol.request.MessageRequestPacket;
import wechart.protocol.response.MessageResponsePacket;
import wechart.session.Session;
import wechart.util.SessionUtil;

/**
 * Created by peng.tan on 2019/5/2.
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
//        // 处理客户端发过来的消息
//        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
//        System.out.println(new Date() + ": 收到客户端消息： " + messageRequestPacket.getMessage());
//        messageResponsePacket.setMessage("服务端回复：[" + messageRequestPacket.getMessage() + "]");
//        ctx.channel().writeAndFlush(messageResponsePacket);

        // 1.拿到消息发送方的会话信息
        Session session = SessionUtil.getSession(ctx.channel());

        // 2.通过消息发送方的会话信息构造要发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(messageRequestPacket.getMessage());

        // 3.拿到消息接收方的 channel
        Channel toUserChannel = SessionUtil.getChannel(messageRequestPacket.getToUserId());

        // 4.将消息发送给消息接收方
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.err.println("[" + messageRequestPacket.getToUserId() + "] 不在线，发送失败!");
        }
    }
}
