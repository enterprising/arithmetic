package net.tanpeng.java.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 显式地为任务创建线程
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        // 在web服务器中为每个请求启动一个新的线程
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    // do sth
                }
            };
            new Thread(task).start();
        }
    }
    /*
        总结：
        结构上类似前面的单线程版本。
        区别在于：对于每个连接，主循环都将创建一个新的线程来处理请求，而不是在主循环中进行处理。
        三个主要的结论：
           1. 任务处理过程从主线程中分离出来，主循环能够更快地等待下一个到来的连接。这提高了系统的响应性；
           2. 任务可以并行处理，从而能够同时服务多个请求；
           3. 任务处理代码必须是线程安全的，因为当有多个任务时会并发地调用这段代码
     */
}
