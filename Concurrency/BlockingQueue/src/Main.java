import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Random random = new Random();

        Thread producer = new Thread(() -> {
            while(true) {
                int val = random.nextInt(100);
                System.out.println("Produced: " + val);
                buffer.addItem(val);
                sleep(10);
            }
        });

        Thread consumer = new Thread(() -> {
            while(true) {
                int val = buffer.getItem();
                System.out.println("Consumed: " + val);
                sleep(1000);
            }
        });

        producer.start();
        consumer.start();
    }

    private static void sleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
