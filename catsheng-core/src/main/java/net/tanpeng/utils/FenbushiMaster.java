package net.tanpeng.utils;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by peng.tan on 2019/4/10.
 */
public class FenbushiMaster {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer integer : list) {
            System.out.println(integer);
        }

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
