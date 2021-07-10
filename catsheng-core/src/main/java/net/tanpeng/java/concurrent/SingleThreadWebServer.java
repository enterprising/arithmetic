package net.tanpeng.java.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 串行地执行任务
 * <p>
 * 一次只执行一个任务
 */
public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket sock = new ServerSocket(80);
        while (true) {
            Socket connection = sock.accept();
            // 处理connection连接上的请求
        }
    }
}
