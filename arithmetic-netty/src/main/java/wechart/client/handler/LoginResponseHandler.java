package wechart.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import wechart.protocol.response.LoginResponsePacket;
import wechart.session.Session;
import wechart.util.SessionUtil;

/**
 * Created by peng.tan on 2019/5/2.
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        String userId = loginResponsePacket.getUserId();
        String username = loginResponsePacket.getUserName();

        if (loginResponsePacket.isSuccess()) {
            System.out.println("[" + username + "]登录成功，userId 为: " + loginResponsePacket.getUserId());
            SessionUtil.bindSession(new Session(userId, username), ctx.channel());
        } else {
            System.out.println("[" + username + "]登录失败，原因：" + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭!");
    }
}