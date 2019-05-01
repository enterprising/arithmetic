package wechart.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import wechart.protocol.request.LoginRequestPacket;
import wechart.protocol.request.MessageRequestPacket;
import wechart.protocol.response.LoginResponsePacket;
import wechart.protocol.Packet;
import wechart.protocol.PacketCodeC;
import wechart.protocol.response.MessageResponsePacket;

import java.util.Date;

/**
 * Created by peng.tan on 2019/4/7.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(new Date() + ": 客户端开始登陆...");
        ByteBuf requestByteBuf = (ByteBuf) msg;

        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);

        if (packet instanceof LoginRequestPacket) {
            // 登陆流程
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;

            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());
            if (valid(loginRequestPacket)) {
                loginResponsePacket.setSuccess(true);
                System.out.println(new Date() + ": 登陆成功！");
            } else {
                loginResponsePacket.setReason("账号密码校验失败！");
                loginResponsePacket.setSuccess(false);
                System.out.println(new Date() + ": 登陆失败！");
            }
            // 响应登陆
            ByteBuf response = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
            ctx.channel().writeAndFlush(response);
        } else if (packet instanceof MessageRequestPacket) {
            // 处理客户端发过来的消息
            MessageRequestPacket messageRequestPacket = (MessageRequestPacket) packet;

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            System.out.println(new Date() + ": 收到客户端消息： " + messageRequestPacket.getMessage());
            messageResponsePacket.setMessage("服务端回复：[" + messageRequestPacket.getMessage() + "]");
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), messageResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }


    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
