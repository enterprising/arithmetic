package net.tanpeng.netty.httpserver;

/**
 * 入口程序
 * Created by peng.tan on 2019/1/5.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.start(1080);
        server.sync();
    }
}
