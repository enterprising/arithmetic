package wechart.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import wechart.protocol.request.MessageRequestPacket;
import wechart.protocol.response.MessageResponsePacket;

import java.util.Date;

/**
 * Created by peng.tan on 2019/5/2.
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        // 处理客户端发过来的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        System.out.println(new Date() + ": 收到客户端消息： " + messageRequestPacket.getMessage());
        messageResponsePacket.setMessage("服务端回复：[" + messageRequestPacket.getMessage() + "]");
        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}
