package net.tanpeng.netty.httpserver.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * Created by peng.tan on 2019/1/5.
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        byte buf[] = new byte[msg.content().readableBytes()];
        msg.content().readBytes(buf);
        if (msg.getUri().contains("init")) {
            System.out.println("init");
            System.out.println(msg.content());
        }
        // 向客户端返回内容
        ByteBuf content = Unpooled.copiedBuffer("hello netty", CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
        response.headers().set(HttpHeaders.Names.CONTENT_TYPE, "application/text");
        response.headers().set(HttpHeaders.Names.CONTENT_LENGTH, content.readableBytes());
        ctx.write(response);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

}
