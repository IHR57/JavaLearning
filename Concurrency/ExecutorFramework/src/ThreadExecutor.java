import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadExecutor {
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        IntStream.range(0, 100).forEach(i -> {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.printf("Thread: %s is executing task: %d%n", threadName, i);
                }
            };
            executorService.execute(task);
        });

        executorService.shutdown();
    }
}
