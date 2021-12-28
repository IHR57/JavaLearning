import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Buffer {
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

    // put() - if no space left in queue it will wait and resumes after finding space in queue
    // take() - opposite to put() method
    public void addItem(Integer item) {
        try {
            queue.put(item);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }

    public Integer getItem() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}
