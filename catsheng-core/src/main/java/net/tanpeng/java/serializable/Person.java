package net.tanpeng.java.serializable;

import java.io.Serializable;

/**
 * 序列化：将一个Java对象转换成字节流序列
 * 反序列化：将字节流序列转换成Java对象
 * 用途：
 *      持久化，把内存中的对象状态保存到一个文件中或者数据库中时候
 *      网络传输，serialVersionUID相等才能互相转来转去
 *
 * Created by peng.tan on 2018/3/8.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + name + "\t age: " + age;
    }
}
