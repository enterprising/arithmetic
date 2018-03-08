package net.tanpeng.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 链表实现 阻塞队列
 * 关键点在于，有两个锁。而且结构是链表，自己写节点，自己维护节点间的联系
 */
public class LinkedBlockingQueueComplete {

    // 链表的节点
    static class Node {
        int item;
        Node next;

        Node(int i) {
            item = i;
        }
    }

    private int capacity; //当前容量
    private AtomicInteger count = new AtomicInteger(); //当前队列中的元素数量

    private ReentrantLock takeLock = new ReentrantLock();
    private Condition notEmpty = takeLock.newCondition();

    private ReentrantLock putLock = new ReentrantLock();
    private Condition notFull = putLock.newCondition();

    //头结点
    transient Node head;
    //尾结点
    transient Node last;

    //使用 Integer.MAX_VALUE 作为容量
    public LinkedBlockingQueueComplete() {
        this(Integer.MAX_VALUE);
    }

    //指定最大容量
    public LinkedBlockingQueueComplete(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        last = head = new Node(-1);
    }

    private void SignalNotEmpty() {
        ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private void SignalNotFull() {
        ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    private void enqueue(Node node) {
        last.next = last = node;  // 相当于 last=node; 然后 last.next=last;
    }

    private int dequeue() {
        Node h = head; //头结点不存储元素
        Node first = h.next;
        h.next = h;  //为了GC
        head = first; //队头的结点向后移动
        int x = first.item;
        first.item = -1; //队首不存值
        return x;
    }

    void put(int t) throws InterruptedException {
        int c;
        ReentrantLock putLock = this.putLock;
        AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        try {
            while (count.get() == capacity) {
                notFull.await();
            }
            enqueue(new Node(t));
            c = count.getAndIncrement();
            if (c + 1 < capacity)
                notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    int take() throws InterruptedException {
        int c; //队列当前元素数量
        int x; //返回结果
        ReentrantLock takeLock = this.takeLock;
        AtomicInteger count = this.count;
        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            x = dequeue();
            c = count.getAndDecrement();
            if (c > 1)
                notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
        return x;
    }

}
