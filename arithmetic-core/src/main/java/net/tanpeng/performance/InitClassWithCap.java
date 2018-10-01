package net.tanpeng.performance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * 初始化对象时指定对象大小，可以极大地提升性能。（hashmap的原理是不够的时候，申请当前容量的两倍内存，反复地申请内存空间，会影响效率）
 * Created by peng.tan on 2018/10/1.
 */
public class InitClassWithCap {
    protected static boolean readData(String fileName, LinkedList<String> versionList, BiConsumer<String, Integer> biConsumer){
        // 解析文件
        return true;
    }
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> localCacheMap = new HashMap<>();
        LinkedList<String> versionList = new LinkedList<>();

        Long now = System.currentTimeMillis();
        readData("xxxx.record", versionList, localCacheMap::put);
        Long end = System.currentTimeMillis();

        System.out.println("未设置hashmap初始化大小时，花费时间为：" + (end - now));


        // 清空内存
        localCacheMap = null;
        Thread.sleep(3000);

        Map<String, Integer> localCacheMap7 = new HashMap<>(6000);
        LinkedList<String> versionList7 = new LinkedList<>();

        Long now7 = System.currentTimeMillis();
        readData("xxxx.record", versionList7, localCacheMap7::put);
        Long end7 = System.currentTimeMillis();

        System.out.println("设置hashmap初始化大小为6千时，花费时间为：" + (end7 - now7));


        // 清空内存
        localCacheMap7 = null;
        Thread.sleep(3000);

        Map<String, Integer> localCacheMap6 = new HashMap<>(60000);
        LinkedList<String> versionList6 = new LinkedList<>();

        Long now6 = System.currentTimeMillis();
        readData("xxxx.record", versionList6, localCacheMap6::put);
        Long end6 = System.currentTimeMillis();

        System.out.println("设置hashmap初始化大小为6万时，花费时间为：" + (end6 - now6));


        // 清空内存
        localCacheMap6 = null;
        Thread.sleep(3000);

        Map<String, Integer> localCacheMap2 = new HashMap<>(600000);
        LinkedList<String> versionList2 = new LinkedList<>();

        Long now2 = System.currentTimeMillis();
        readData("xxxx.record", versionList2, localCacheMap2::put);
        Long end2 = System.currentTimeMillis();

        System.out.println("设置hashmap初始化大小为60万时，花费时间为：" + (end2 - now2));


        // 清空内存
        localCacheMap2 = null;
        Thread.sleep(3000);

        Map<String, Integer> localCacheMap3 = new HashMap<>(6000000);
        LinkedList<String> versionList3 = new LinkedList<>();

        Long now3 = System.currentTimeMillis();
        readData("xxxx.record", versionList3, localCacheMap3::put);
        Long end3 = System.currentTimeMillis();

        System.out.println("设置hashmap初始化大小为600万时，花费时间为：" + (end3 - now3));


        // 清空内存
        localCacheMap3 = null;
        Thread.sleep(3000);

        Map<String, Integer> localCacheMap4 = new HashMap<>(6749369);
        LinkedList<String> versionList4 = new LinkedList<>();

        Long now4 = System.currentTimeMillis();
        readData("xxxx.record", versionList4, localCacheMap4::put);
        Long end4 = System.currentTimeMillis();

        System.out.println("设置hashmap初始化大小为刚好那个大小时，花费时间为：" + (end4 - now4));

        /**
         * 输出内容为：
         * 未设置hashmap初始化大小时，花费时间为：8746
         *
         * 设置hashmap初始化大小为6千时，花费时间为：6413
         *
         * 设置hashmap初始化大小为6万时，花费时间为：6113
         *
         * 设置hashmap初始化大小为60万时，花费时间为：5490
         *
         * 设置hashmap初始化大小为600万时，花费时间为：6152
         *
         * 设置hashmap初始化大小为刚好那个大小时，花费时间为：5072
         */
    }
}
