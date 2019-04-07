package wechart.bean;

/**
 * Created by peng.tan on 2019/4/6.
 */
public interface Serializer {

    /**
     * json 序列化
     */
    byte JSON_SERIALIZER = 1;

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 获取序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * Java对象转换为二进制对象
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成Java对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
