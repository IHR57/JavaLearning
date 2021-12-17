package WaitNotify;

import java.util.LinkedList;
import java.util.Random;

public class BufferDemo {

    public void start() {
        Buffer buff = new Buffer();
        Random random = new Random();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                buff.addItem(random.nextInt(100));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                buff.getItem();
            }
        });
        t1.start();
        t2.start();
    }

}
