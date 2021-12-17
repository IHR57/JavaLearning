package Deadlock;

public class DeadLock {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void running() {
        synchronized (lock1) {
            System.out.println("Acquired Lock1");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " Acquired Lock2");
                System.out.println("Running!");
                System.out.println(Thread.currentThread().getName() + " About to release lock2");
            }
            System.out.println(Thread.currentThread().getName() + " About to release lock1");
        }
    }

    public void walking() {
        synchronized (lock2) {
            System.out.println("Acquired Lock2");
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " Acquired Lock1");
                System.out.println("Running!");
                System.out.println(Thread.currentThread().getName() + " About to release lock1");
            }
            System.out.println(Thread.currentThread().getName() + " About to release lock2");
        }
    }
}
