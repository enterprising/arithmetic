package net.tanpeng.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 参考https://www.jianshu.com/p/79ca08116d57
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        //设置 RabbitMQ 地址
        factory.setHost("localhost");
        //建立到代理服务器到连接
        Connection conn = factory.newConnection();
        //获得信道
        Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "exchange_name";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true);

        String routingKey = "hola";
        String message = "{xxx:xxx}";
        //发布消息
        byte[] messageBodyBytes = message.getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

        channel.close();
        conn.close();
    }

}
