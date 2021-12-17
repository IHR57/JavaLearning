package SolveRaceCondition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccountMain {

    public void start() {
        BankAccount bankAccount = new BankAccount(100);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;

        Thread depositThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started at: " +
                    formatter.format(LocalDateTime.now()));
            for(int i = 0; i < 10; i++) {
                bankAccount.deposit(100);
                this.sleep();
            }
        });

        Thread withdrawThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started at: " +
                    formatter.format(LocalDateTime.now()));
            for(int i = 0; i < 10; i++) {
                bankAccount.withdraw(100);
                sleep();
            }
        });

        depositThread.setName("DEPOSIT");
        withdrawThread.setName("WITHDRAW");
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
