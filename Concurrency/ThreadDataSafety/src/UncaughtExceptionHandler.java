public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println("Exception has been thrown from: " +thread.getName());
        System.out.println("Exception Msg: " + throwable.getMessage());
    }
}
