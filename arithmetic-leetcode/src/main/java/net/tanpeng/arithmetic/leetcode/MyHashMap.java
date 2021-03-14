package net.tanpeng.arithmetic.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: peng.tan
 * @create: 2021/03/14 11:28
 */
public class MyHashMap {

    private static final int BASE = 769;
    private LinkedList[] data;

    private class Entry {
        private int key;
        private int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Entry>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Entry> linkedList = data[hash];
        Iterator<Entry> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.getKey() == key) {
                entry.value = value;
                return;
            }
        }
        data[hash].offerLast(new Entry(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        LinkedList<Entry> linkedList = data[hash];
        Iterator<Entry> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.getKey() == key) {
                return entry.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Entry> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.getKey() == key) {
                data[hash].remove(entry);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
