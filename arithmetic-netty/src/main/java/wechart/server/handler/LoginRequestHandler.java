package wechart.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import wechart.protocol.request.LoginRequestPacket;
import wechart.protocol.response.LoginResponsePacket;
import wechart.session.Session;
import wechart.util.IDUtil;
import wechart.util.SessionUtil;

import java.util.Date;

/**
 * SimpleChannelInboundHandler 接受泛型参数，使得我们可以不用再判断 package 该被哪个handler处理的，写一大堆 if-else
 * 判断的逻辑交到 SimpleChannelInboundHandler 去做了，当类型符合泛型里面内的时候，就会被目标 handler 处理。
 *
 * Created by peng.tan on 2019/5/2.
 */
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    protected LoginRequestHandler() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        System.out.println(new Date() + ": 收到客户端登录请求");

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        loginResponsePacket.setUserName(loginRequestPacket.getUsername());
        if (valid(loginRequestPacket)) {
            loginResponsePacket.setSuccess(true);
            String userid = IDUtil.randomId();
            loginResponsePacket.setUserId(userid);
            System.out.println("[" + loginRequestPacket.getUsername() + "]登录成功");
            SessionUtil.bindSession(new Session(userid, loginRequestPacket.getUsername()), ctx.channel());
        } else {
            loginResponsePacket.setReason("账号密码校验失败！");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登陆失败！");
        }
        // 响应登陆
        ctx.writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }
}
