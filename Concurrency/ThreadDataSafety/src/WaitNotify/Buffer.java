package WaitNotify;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final static int SIZE = 10;
    private Queue<Integer> queue = new LinkedList<>();
    private final Object lock = new Object();

    public void addItem(int item) {
        synchronized (lock) {
            while(queue.size() == SIZE) {
                System.out.println("Size is full !! let's wait");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread Resumed!!");
            System.out.println("Adding item: " + item);
            queue.add(item);

            System.out.println("Item Added Successfully!");
            lock.notifyAll();
        }
    }

    public synchronized Integer getItem() {
        synchronized (lock) {
            while(queue.isEmpty()) {
                System.out.println("Queue is empty! let's wait..");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("RESUMED");
            System.out.println("Let's consume value");
            Integer value = queue.poll();
            System.out.println("Consumed: " + value);
            lock.notifyAll();

            return value;
        }
    }
}
