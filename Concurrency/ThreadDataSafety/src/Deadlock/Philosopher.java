// Dining philosopher problem
package Deadlock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher extends Thread{

    private String name;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() {
        log("Thinking");
    }

    private void eat() {
        try {
            log("Eating");
            int eatingTime = getRandomEatingTime();
            TimeUnit.NANOSECONDS.sleep(eatingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            keepThinkingAndEating();
        }
    }

    public void keepThinkingAndEating() {
        think();
        synchronized (leftFork) {
            log("Grabbed the left fork");
            synchronized (rightFork) {
                log("Grabbed the right fork");
                eat();
                log("Putting down the right fork");
            }
            log("Putting down the left fork");
        }
    }

    private void log(String msg) {
        String time = DateTimeFormatter.ISO_LOCAL_TIME.format(LocalDateTime.now());
        String thread = Thread.currentThread().getName();
        System.out.printf("%12s Thread: %s %s: %s%n", time, thread, name, msg);
        System.out.flush();
    }

    private static int getRandomEatingTime() {
        Random random = new Random();
        return random.nextInt(100) + 50;
    }
}
