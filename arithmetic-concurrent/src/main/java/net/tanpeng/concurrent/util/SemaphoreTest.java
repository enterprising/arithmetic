package net.tanpeng.concurrent.util;

import java.util.concurrent.Semaphore;

/**
 * 假若一个工厂有5台机器，但是有8个工人，
 * 一台机器同时只能被一个工人使用，只有使用完了，其他工人才能继续使用。
 * 那么我们就可以通过Semaphore来实现：
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        int n = 8;
        Semaphore semaphore = new Semaphore(5); //机器数
        for (int i = 0; i < n; i++) {
            new Worker(i,semaphore).start();
        }
    }

    private static class Worker extends Thread{
        int num;
        Semaphore semaphore;
        public Worker(int i, Semaphore semaphore) {
            this.num = i;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
