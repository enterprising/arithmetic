package net.tanpeng.java.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @author 九风萍舟
 * @Class: Test
 * @Description: 简单websocket demo
 * 简单的说就是一种协议，和HTTP的区别在于，websocket是全双工，双向连接，服务器端可以主动向客户端发送消息
 */
@ServerEndpoint(value = "/websocketTest/{userId}")
public class WebSocketServer {
    private Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private static String userId;

    //连接时执行
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) throws IOException {
        WebSocketServer.userId = userId;
        logger.debug("新连接：{}", userId);
    }

    //关闭时执行
    @OnClose
    public void onClose() {
        logger.debug("连接：{} 关闭", userId);
    }

    //收到消息时执行
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        logger.debug("收到用户{}的消息{}", userId, message);
        session.getBasicRemote().sendText("收到 " + userId + " 的消息 "); //回复用户
    }

    //连接错误时执行
    @OnError
    public void onError(Session session, Throwable error) {
        logger.debug("用户id为：{}的连接发送错误", userId);
        error.printStackTrace();
    }

}