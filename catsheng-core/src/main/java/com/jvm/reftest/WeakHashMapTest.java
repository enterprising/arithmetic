package com.jvm.reftest;

import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

/**
 * @author: peng.tan
 * @create: 2020/06/07 12:00
 */
public class WeakHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        Map<Object, Object> remap = new WeakHashMap<>();
        for (int i = 0; i < 10000; i++) {
            remap.put(UUID.randomUUID().toString(), i);
//            System.gc();
            System.out.println("size: " + remap.size());
        }

        System.out.println("----");
        System.out.println(remap.get(1));

        Thread.sleep(1000000000);
    }
}
