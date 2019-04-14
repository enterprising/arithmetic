package wechart.serialize;

/**
 * Created by peng.tan on 2019/4/6.
 */
public class JSONSerializer implements Serializer, SerializerAlgorithm {
    @Override
    public byte getSerializerAlogrithm() {
        return JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return com.alibaba.fastjson.JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return com.alibaba.fastjson.JSON.parseObject(bytes, clazz);
    }
}
