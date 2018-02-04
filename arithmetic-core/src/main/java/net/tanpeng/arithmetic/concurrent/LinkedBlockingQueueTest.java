package net.tanpeng.arithmetic.concurrent;

import java.util.Random;

/**
 * 基于链表的拥塞队列 - 测试
 */
public class LinkedBlockingQueueTest {

    public static class Producer implements Runnable {
        private final LinkedBlockingQueueComplete blockingQueue;
        private volatile boolean flag;
        private Random random;

        Producer(LinkedBlockingQueueComplete blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.flag = false;
            this.random = new Random();
        }

        @Override
        public void run() {
            while (!flag) {
                int info = random.nextInt(100);
                try {
                    blockingQueue.put(info);
                    System.out.println(Thread.currentThread().getName() + " produce " + info);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        void shutDown() {
            flag = true;
        }

    }

    public static class Consumer implements Runnable {
        private final LinkedBlockingQueueComplete blockingQueue;
        private volatile boolean flag;

        Consumer(LinkedBlockingQueueComplete blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.flag = false;
        }

        @Override
        public void run() {
            while (!flag) {
                int info;
                try {
                    info = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + " consumer " + info);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public void shutDown() {
            flag = true;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueueComplete blockingQueue = new LinkedBlockingQueueComplete(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        // 创建生产者和消费者
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                new Thread(producer, "producer" + i).start();
            } else {
                new Thread(consumer, "consumer" + i).start();
            }
        }

        Thread.sleep(1000);

        producer.shutDown();
        consumer.shutDown();

    }
}
