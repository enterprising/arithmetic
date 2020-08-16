package net.tanpeng.arithmetic.offers;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author: peng.tan
 * @create: 2020/08/16 18:00
 */
public class MidNumber {
    private static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
    }

    public static void Insert(Integer num) {
        treeSet.add(num);
    }

    public static Double GetMedian() {
        double result = 0;
        if (treeSet.size() % 2 == 0) {
            Iterator<Integer> integers = treeSet.iterator();
            int index = 0;
            int first = 0;
            while (integers.hasNext()) {
                if (index == treeSet.size() / 2 - 1) {
                    first = integers.next();
                } else if (index == treeSet.size() / 2) {
                    return (first + integers.next()) / 2.0;
                } else {
                    integers.next();
                }
                index++;
            }
        } else {
            Iterator<Integer> integers = treeSet.iterator();
            int index = 0;
            while (integers.hasNext()) {
                if (index == treeSet.size() / 2) {
                    return Double.parseDouble(integers.next() + "");
                }
                integers.next();
                index++;
            }
        }
        return result;
    }
}
