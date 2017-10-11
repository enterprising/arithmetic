package concurrent;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列的实现
 * Created by peng.tan on 17/10/11.
 */
public class BlockQueueComplete {
    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;
    private int count;
    private int putIndex;
    private int takeIndex;
    private int[] data = null;

    BlockQueueComplete(int size) {
        data = new int[size];
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    /**
     * 正常的入队列
     *
     * @param t
     * @return
     */
    public boolean offer(int t) throws InterruptedException {
        // 不能插入 null，所以一般要先进行判空（空表示没有，或者说之前那个已经被弹出了）
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            if (count == data.length)
                return false;
            else
                enqueue(t);
            return true;
        } finally {
            lock.unlock();
        }
    }

    private void enqueue(int t) {
        data[putIndex] = t;
        if (++putIndex == data.length)
            putIndex = 0;
        count++;
        notEmpty.signal();  // 不空了  Wakes up one waiting thread.
    }

    /**
     * 正常的出队列，有则返回内容，没有就返回null(这里是返回-1)
     *
     * @return
     */
    public int poll() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            return count == 0 ? -1 : dequeue();
        } finally {
            lock.unlock();
        }
    }

    private int dequeue() {
        int t = data[takeIndex];
        data[takeIndex] = -1; //对这一项进行删除.. 嗯，本来是要赋值为null的
        if (++takeIndex == data.length)
            takeIndex = 0;
        count--;
        notFull.signal();
        return t;
    }

    /**
     * 阻塞队列的 入队列，到队列不满的时候才入
     *
     * @param t
     */
    public void put(int t) throws InterruptedException {
        // 帮 t 判空
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == data.length) {
                notFull.await();
            }
            enqueue(t);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 阻塞队列的 出队列，当队列不空的时候才出
     *
     * @return
     * @throws InterruptedException
     */
    public int take() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            return dequeue();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueueComplete blockQueueDemo = new BlockQueueComplete(10);
        blockQueueDemo.put(4);
        System.out.println(Arrays.toString(blockQueueDemo.data));
        blockQueueDemo.take();
        System.out.println(Arrays.toString(blockQueueDemo.data));
        blockQueueDemo.put(5);
        System.out.println(Arrays.toString(blockQueueDemo.data));
        blockQueueDemo.take();
        System.out.println(Arrays.toString(blockQueueDemo.data));
        blockQueueDemo.put(6);
        blockQueueDemo.put(7);
        blockQueueDemo.offer(8);
        System.out.println(Arrays.toString(blockQueueDemo.data));
        blockQueueDemo.poll();
        System.out.println(Arrays.toString(blockQueueDemo.data));
    }
}
