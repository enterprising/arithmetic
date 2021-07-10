package net.tanpeng.java.serializable.binary;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * 序列化的一种，以二进制的方式保存。但从测试结果上来看好像不如jackson，可能是这个api太老了吧
 * 二进制里面的序列化与反序列化，最关键的在于：ObjectOutputStream 和 ObjectInputStream
 * Created by peng.tan on 2018/9/29.
 */
public class BinaryTest {
    public static void main(String[] args) throws Exception {
        Map<Long, Integer> localCacheMap = new HashMap<>();

        File file = new File("/conf/test.dat");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // 以二进制的方式写入
            oos.writeObject(localCacheMap);
            System.out.println("文件已存入");
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Instant start2 = Instant.now();
            // 读取
            Object localCacheMap2 = ois.readObject();
            Instant end2 = Instant.now();
            Duration duration2 = Duration.between(end2,start2);
            System.out.println(duration2);
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
