package wechart.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Assert;
import org.junit.Test;
import wechart.protocol.request.LoginRequestPacket;
import wechart.serialize.JSONSerializer;
import wechart.serialize.Serializer;


/**
 * Created by peng.tan on 2019/5/4.
 */
public class PacketCodeCTest {

    @Test
    public void encodeAndDecodeTest() {
        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setVersion(((byte) 1));
        loginRequestPacket.setUsername("zhangsan");
        loginRequestPacket.setPassword("password");

        PacketCodeC packetCodeC = PacketCodeC.INSTANCE;
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.ioBuffer();

        // 将登陆包（Java对象），编码成 bytebuf
        packetCodeC.encode(byteBuf, loginRequestPacket);

        // 将 bytebuf 解码成 登陆包（Java对象）
        Packet decodedPacket = packetCodeC.decode(byteBuf);

        // 对比encode decode后的包，和最开始的包，序列化后的字节流是相等的
        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodedPacket));

    }

}