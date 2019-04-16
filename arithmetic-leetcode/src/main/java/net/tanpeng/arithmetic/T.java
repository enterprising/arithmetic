package net.tanpeng.arithmetic;

import java.util.Random;

/**
 * Created by peng.tan on 2019/1/12.
 */
public class T {
    public static void main(String[] args) {
        System.out.println("1111");
        Random random = new Random();
        for (int i = 100; i < 100000; i++) {
            System.out.println(String.format("insert into gzs_shop_a (shop_id,shop_oid,shard_id) VALUES(%s,0,1);", i));
        }
    }
}
