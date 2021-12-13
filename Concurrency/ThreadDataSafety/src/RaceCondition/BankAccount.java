package RaceCondition;

public class BankAccount {

    private long balance;

    public BankAccount(long amount) {
        this.balance = amount;
    }

    public void withdraw(long amount) {
        System.out.println("Withdrawing BDT : " + amount + " TK");
        System.out.println("Remaining Balance: " + (balance - amount));
        this.balance -= amount;
    }

    public void deposit(long amount) {
        System.out.println("Depositing BDT : " + amount + " TK");
        System.out.println("Remaining Balance: " + (balance + amount));
        this.balance += amount;
    }

    public long getBalance() {
        return balance;
    }
}
