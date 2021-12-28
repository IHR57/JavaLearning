import org.w3c.dom.Text;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // single threaded server; only one request will process at a time
        ServerSocket serverSocket = new ServerSocket(8080);
        ServeRequest request = new ServeRequest();
//        while(true) {
//            Socket connection = serverSocket.accept();
//            request.serveRequest(connection);
//        }

        // multithreaded; will create new thread for each new request; can throw outOfMemoryError
        // or other issues for huge number of threads
//        while(true) {
//            Socket connection = serverSocket.accept();
//            Thread thread = new Thread(() -> {
//                request.serveRequest(connection);
//            });
//            thread.start();
//        }

        // solution using executor framework
        // will create fixed amount of thread and re-use all the created threads
//        Executor executor = Executors.newFixedThreadPool(10);
//        while(true) {
//            Socket connection = serverSocket.accept();
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    request.serveRequest(connection);
//                }
//            });
//        }

        // simple thread executor example using thread pool
//        ThreadExecutor threadExecutor = new ThreadExecutor();
//        threadExecutor.run();

        // running callable example
        runCallableExample();
    }

    public static void runCallableExample() {
        TextCopier jugbd = new TextCopier("https://www.jugbd.org/");
        TextCopier devSkill = new TextCopier("https://codeforces.com/");

        List<TextCopier> tasks = Arrays.asList(jugbd, devSkill);
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            List<Future<String>> futures = executorService.invokeAll(tasks);
            for(Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}
