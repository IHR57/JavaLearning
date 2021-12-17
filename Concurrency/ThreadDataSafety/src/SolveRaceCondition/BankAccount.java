package SolveRaceCondition;

import java.util.concurrent.TimeUnit;

public class BankAccount {

    private long balance;

    public BankAccount(long amount) {
        this.balance = amount;
    }

    public synchronized void withdraw(long amount) {
        System.out.println("Inside the withdraw method! Lock acquired!");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Withdrawing BDT : " + amount + " TK");
        System.out.println("Remaining Balance: " + (balance - amount));
        this.balance -= amount;
        System.out.println("End of withdraw method! Releasing the lock!");
    }

    public synchronized void deposit(long amount) {
        System.out.println("Inside the deposit method! Lock acquired!");
        try {
            TimeUnit.MICROSECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Depositing BDT : " + amount + " TK");
        System.out.println("Remaining Balance: " + (balance + amount));
        this.balance += amount;
        System.out.println("End of deposit method! Releasing the lock!");
    }

    public long getBalance() {
        return balance;
    }
}
