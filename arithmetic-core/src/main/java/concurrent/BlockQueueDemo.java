package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列的实现
 */
public class BlockQueueDemo {

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    private int[] data = null;

    private int putIndex;   //数据存的位置
    private int takeIndex;  //数据取的位置
    private int count; // data中存储数据的数量

    BlockQueueDemo(int size) {
        data = new int[size];
    }


    public void put(int t) {
        lock.lock();
        try {
            // 队列满了，需要等空了才行
            while (data.length == count) {
                notFull.await();
            }
            data[putIndex] = t;
            if (++putIndex == data.length)
                putIndex = 0;
            count++;
            notEmpty.signal();
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
                notEmpty.await();
            }
            t = data[takeIndex];
            if (++takeIndex == data.length)
                takeIndex = 0;
            count--;
            notFull.signal();
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
        blockQueueDemo.put(5);
        int b = blockQueueDemo.take();
        System.out.println(a);
        System.out.println(b);
    }

}
