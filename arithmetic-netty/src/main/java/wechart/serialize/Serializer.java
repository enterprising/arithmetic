package wechart.serialize;

/**
 * Created by peng.tan on 2019/4/6.
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     *
     * @return
     */
    byte getSerializerAlogrithm();

    /**
     * 序列化
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 反序列化
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
