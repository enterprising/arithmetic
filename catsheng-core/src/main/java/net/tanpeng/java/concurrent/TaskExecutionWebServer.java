package net.tanpeng.java.concurrent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 基于线程池的 web 服务器，用Executor框架
 */
public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;

    /**
     * 注：alibaba建议手动创建连接池，用ThreadPoolExecutor
     */
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    // do sth
                }
            };
            exec.execute(task);
        }
    }

}
