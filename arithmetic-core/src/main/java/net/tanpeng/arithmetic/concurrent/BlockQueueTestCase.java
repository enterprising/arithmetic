package net.tanpeng.arithmetic.concurrent;

import java.util.Random;

/**
 * Created by peng.tan on 17/10/11.
 */
public class BlockQueueTestCase {
    public static class Producer implements Runnable {
        private final BlockQueueDemo BlockQueueDemo;
        private volatile boolean flag;
        private Random random;

        Producer(BlockQueueDemo BlockQueueDemo) {
            this.BlockQueueDemo = BlockQueueDemo;
            this.flag = false;
            this.random = new Random();
        }

        @Override
        public void run() {
            while (!flag) {
                int info = random.nextInt(100);
                try {
                    BlockQueueDemo.put(info);
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
        private final BlockQueueDemo BlockQueueDemo;
        private volatile boolean flag;

        Consumer(BlockQueueDemo BlockQueueDemo) {
            this.BlockQueueDemo = BlockQueueDemo;
            this.flag = false;
        }

        @Override
        public void run() {
            while (!flag) {
                int info;
                try {
                    info = BlockQueueDemo.take();
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
        BlockQueueDemo BlockQueueDemo = new BlockQueueDemo(10);
        Producer producer = new Producer(BlockQueueDemo);
        Consumer consumer = new Consumer(BlockQueueDemo);
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
