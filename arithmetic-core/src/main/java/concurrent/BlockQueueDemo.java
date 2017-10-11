package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列的实现
 */
public class BlockQueueDemo {

    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    private int[] data = null;

    private int putIndex, takeIndex, count;

    BlockQueueDemo(int size) {
        data = new int[size];
    }


    public void put(int t) {
        lock.lock();
        try {
            // 队列满了，需要等空了才行
            while (data.length == count) {
                full.await();
            }
            data[putIndex] = t;
            if (++putIndex == data.length)
                putIndex = 0;
            count--;
            empty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int take() {
        int t = 0;
        lock.lock();
        try {
            while (count == 0) {
                empty.await();
            }
            t = data[takeIndex];
            if (++takeIndex == data.length)
                takeIndex = 0;
            count++;
            full.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        BlockQueueDemo blockQueueDemo = new BlockQueueDemo(10);
        blockQueueDemo.put(4);
        int a = blockQueueDemo.take();
        blockQueueDemo.take();
        blockQueueDemo.put(5);
        System.out.println(a);
    }

}
