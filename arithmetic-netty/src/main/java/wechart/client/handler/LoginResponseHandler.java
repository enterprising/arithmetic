package wechart.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import wechart.protocol.request.LoginRequestPacket;
import wechart.protocol.response.LoginResponsePacket;
import wechart.util.LoginUtil;

import java.util.UUID;

/**
 * Created by peng.tan on 2019/5/2.
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端开始登陆！");

        // 创建登陆对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("tan");
        loginRequestPacket.setPassword("peng");

        // 写数据
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.isSuccess()) {
            System.out.println("客户端登陆成功！");
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            System.out.println("客户端登陆失败，因为" + loginResponsePacket.getReason());
        }
    }
}
