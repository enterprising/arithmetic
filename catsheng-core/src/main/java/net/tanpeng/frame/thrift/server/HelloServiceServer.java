package net.tanpeng.frame.thrift.server;

import net.tanpeng.frame.thrift.demo.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import net.tanpeng.frame.thrift.demo.Hello;

public class HelloServiceServer {
    /**
     * 启动 Thrift 服务器
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 设置服务端口为 7911
            TServerSocket serverTransport = new TServerSocket(7911);
            // 设置协议工厂为 TBinaryProtocol.Factory
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            // 关联处理器与 Hello 服务的实现
            TProcessor processor = new Hello.Processor(new HelloServiceImpl());
//            TServer server = new TThreadPoolServer(processor, serverTransport,
//                    proFactory);   这个方法已经无效
//            System.out.println("Start server on port 7911...");
//            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
