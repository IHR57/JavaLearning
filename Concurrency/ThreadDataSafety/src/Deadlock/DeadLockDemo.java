package Deadlock;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {

    public void start() {
        DeadLock deadLock = new DeadLock();
        Thread runningThread = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()) {
                deadLock.running();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread walkingThread = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()) {
                deadLock.walking();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        runningThread.setName("RUNNING");
        walkingThread.setName("WALKING");

        runningThread.start();
        walkingThread.start();
    }
}
