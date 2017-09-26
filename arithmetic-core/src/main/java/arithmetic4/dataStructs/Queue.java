package arithmetic4.dataStructs;

import java.util.Iterator;

/**
 * 队列的实现
 */
public class Queue<Integer> implements Iterable {
    private Node first; //指向队头
    private Node last; //指向队尾
    private int N; //队列的长度

    private class Node {
        int item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    // 向队列尾部添加元素
    public void enqueue(int item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    // 从队列头部删除元素
    public int dequeue() {
        int item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
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
