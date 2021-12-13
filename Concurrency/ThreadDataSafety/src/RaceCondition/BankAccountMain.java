package RaceCondition;

public class BankAccountMain {

    public void start() {
        BankAccount bankAccount = new BankAccount(1000);
        Thread depositThread = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                bankAccount.deposit(100);
                this.sleep();
            }
        });

        Thread withdrawThread = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                bankAccount.withdraw(100);
                sleep();
            }
        });

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Available Balance: " + bankAccount.getBalance());
    }

    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}
