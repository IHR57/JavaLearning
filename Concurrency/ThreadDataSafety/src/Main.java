import Deadlock.DeadLockDemo;
import Deadlock.PhilosopherDemo;
import WaitNotify.BufferDemo;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        //runUncaughtExceptionHandler();      //running uncaught exception handling example
        //runThreadLocal();   // running thread local example

        // race condition example
//        BankAccountMain bankAccountMain = new BankAccountMain();
//        bankAccountMain.start();

        // race condition solve example
//        SolveRaceCondition.BankAccountMain solveBankAccount= new SolveRaceCondition.BankAccountMain();
//        solveBankAccount.start();

        // deadlock example
//        DeadLockDemo deadLockDemo = new DeadLockDemo();
//        deadLockDemo.start();

        // deadlock dining philosopher problem
//        PhilosopherDemo philosopherDemo = new PhilosopherDemo();
//        philosopherDemo.start();

        // run waitNotify Example
        BufferDemo bufferDemo = new BufferDemo();
        bufferDemo.start();

    }

    public static void runUncaughtExceptionHandler() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }

                throw new RuntimeException("Throwing Runtime Exception!!");
            }
        });

        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler());
        thread.start();
    }

    public static void runThreadLocal() {

        // changing value in a thread does not effect value of a another thread

        SharedObject sharedObject = new SharedObject();
        setARandomNumber(sharedObject);

        Thread t1 = new Thread(() -> {
            setARandomNumber(sharedObject);
        });

        Thread t2 = new Thread(() -> {
            setARandomNumber(sharedObject);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Value: " + sharedObject.getNumber());
    }

    private static void setARandomNumber(SharedObject sharedObject) {
        sharedObject.setNumber((int) (Math.random() * 100));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Value: " + sharedObject.getNumber());

    }
}
