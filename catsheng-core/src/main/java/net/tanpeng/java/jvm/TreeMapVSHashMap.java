package net.tanpeng.java.jvm;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class TreeMapVSHashMap {
    private static Random random = new Random();
    private static Random random2 = new Random();

    private static final int SIZE = 1000000;
    private static final int GETCNT = 1000000;


    public static void main(String[] args) throws InterruptedException {
        TreeMapTest();
        System.out.println("----------");
        HashMapTest();
    }

    public static void TreeMapTest() throws InterruptedException {
        System.out.println("\nTreeMap Test");
        System.gc();
        printHeapMemoryInfo();
        TreeMap<String, Short> trMap = new TreeMap<>();
        int i = 0;
        Short val;
        while (i < SIZE) {
            val = trMap.put(getRandomPhone(), (short) (i % 4));

            if (val == null) {
                i++;
            }
        }
        System.out.println("=====");
        printHeapMemoryInfo();
        System.out.println("size : " + trMap.size());
        System.out.println("=====");
        System.gc();
        Thread.sleep(1000);
        printHeapMemoryInfo();

        long startTime = System.currentTimeMillis();
        for (i = 0; i < GETCNT; i++) {
            trMap.get(getRandomPhone2());
        }
        System.out.println("search " + GETCNT + " times, usedTime: " + (System.currentTimeMillis() - startTime) + "ms.");

    }

    public static void HashMapTest() {
        System.out.println("\nHashMap Test");
        System.gc();
        printHeapMemoryInfo();
        HashMap<String, Short> hashMap = new HashMap<String, Short>();
        int i = 0;
        Short val;
        while (i < SIZE) {
            val = hashMap.put(getRandomPhone(), (short) (i % 4));

            if (val == null) {
                i++;
            }
        }

        System.out.println("size : " + hashMap.size());

        System.gc();
        printHeapMemoryInfo();

        long startTime = System.currentTimeMillis();
        for (i = 0; i < GETCNT; i++) {
            hashMap.get(getRandomPhone2());
        }
        System.out.println("search " + GETCNT + " times, usedTime: " + (System.currentTimeMillis() - startTime) + "ms.");

    }

    /**
     * 返回一个手机号码，有十亿种可能性，（中国移动用户总数约十亿）
     *
     * @return
     */
    public static String getRandomPhone() {
        return String.valueOf(13000000000L + random.nextInt(1000000000));
    }

    /**
     * 返回一个测试手机号码，有十亿种可能性，（中国移动用户总数约十亿）
     *
     * @return
     */
    public static String getRandomPhone2() {
        return String.valueOf(13000000000L + random2.nextInt(1000000000));
    }


    public static void printHeapMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();
        System.out.printf("maxMemory : %.2fM\n", runtime.maxMemory() * 1.0 / 1024 / 1024);
        System.out.printf("totalMemory : %.2fM\n", runtime.totalMemory() * 1.0 / 1024 / 1024);
        System.out.printf("freeMemory : %.2fM\n", runtime.freeMemory() * 1.0 / 1024 / 1024);
        System.out.printf("usedMemory : %.2fM\n", (runtime.totalMemory() - runtime.freeMemory()) * 1.0 / 1024 / 1024);
    }

    /**
     * 结论，TreeMap比HashMap要占内存小一些，在百万级数据的时候（单个key,value不能太大），要小10%左右
     * 但是查询速度慢了一倍多。
     */
}