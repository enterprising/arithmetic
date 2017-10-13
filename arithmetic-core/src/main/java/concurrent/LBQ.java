package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by peng.tan on 17/10/13.
 */
public class LBQ {

    static class Node {
        int item;
        Node next;

        Node(int x) {
            item = x;
        }
    }

    private ReentrantLock takeLock = new ReentrantLock();
    private Condition notEmpty = takeLock.newCondition();

    private ReentrantLock putLock = new ReentrantLock();
    private Condition notFull = putLock.newCondition();

    private Node head;
    private Node last;

    private int size; //容量
    private AtomicInteger count = new AtomicInteger(); //当前数量

    LBQ(int size) {
        this.size = size;
        head = new Node(-1);
        last = head;
    }

    public void put(int x) throws InterruptedException {
        ReentrantLock putLock = this.putLock;
        AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        int c;
        try {
            while (count.get() == size) {
                notFull.await();
            }
            // 入队列
            last.next = last = new Node(x);
            c = count.getAndIncrement();
            if (c + 1 < size)
                notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    public int take() throws InterruptedException {
        int result;
        int c; //表示当前容量
        ReentrantLock takeLock = this.takeLock;
        AtomicInteger count = this.count;
        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            // 出队列，这个有点麻烦
            Node first = head.next;
            result = first.item;
            head.next = head; // 方便回收
            first.item = -1; //表示删除这个点的值
            head = first;

            c = count.getAndDecrement();
            if (c - 1 > 0)
                notEmpty.signal();

        } finally {
            takeLock.unlock();
        }
        return result;
    }


}
