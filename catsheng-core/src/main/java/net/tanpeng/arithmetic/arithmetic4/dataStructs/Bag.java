package net.tanpeng.arithmetic.arithmetic4.dataStructs;

import java.util.Iterator;

/**
 * 背包类的实现。背包只进不出，相当于去掉 pop 的Stack，把push改成 add 就可以了
 */
public class Bag<Integer> implements Iterable {
    private Node first; //首结点
    private int N;

    private class Node {
        int item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;  //用 N==0 也是可以的
    }

    public int size() {
        return N;
    }

    // 向栈顶加元素
    public void add(int i) {
        Node oldFirst = first;
        first = new Node();
        first.item = i;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Iterator iterator() {
        return new ListIterators();
    }

    private class ListIterators implements Iterator {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            int i = current.item;
            current = current.next;
            return i;
        }
    }
}
