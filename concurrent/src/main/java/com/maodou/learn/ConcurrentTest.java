package com.maodou.learn;

/**
 * Created by yangyonghui on 16/11/11.
 */
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ConcurrentTest {

    public static void main(String[] args) throws Exception {
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        System.out.println("thread1 is running");
                        Thread.sleep(1000);
                        System.exit(1);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("call hook exit");
                System.exit(1);
            }
        });

        Thread dt = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("thread2 is running, rotate " + i);
                        Thread.sleep(10000);
                        System.out.println("thread2 after sleep");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        dt.setDaemon(true);
        dt.start();

        Thread.sleep(1000000);
    }
}
