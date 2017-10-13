package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by peng.tan on 17/10/13.
 */
public class ABQ {

    private ReentrantLock lock;
    private Condition notEmpty;
    private Condition notFull;
    private int count;
    private int putIndex, takeIndex;
    private int[] data;

    ABQ(int size) {
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
        data = new int[size];
    }

    private void put(int x) throws InterruptedException {
        // 判断 x 是否为空
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (data.length == count) {
                notFull.await();
            }
            data[putIndex] = x;
            if (++putIndex == data.length)
                putIndex = 0;
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    private int take() throws InterruptedException {
        int x;
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0)
                notEmpty.await();
            x = data[takeIndex];
            if (++takeIndex == data.length)
                takeIndex = 0;
            count--;
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return x;
    }

}
