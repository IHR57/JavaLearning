import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

// mvn surefire-report:report for generating report
class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount(500, -1000);
    }
    @Test
    @DisplayName("withdrawing 200 successfully!")
    void withdraw() {
        bankAccount.withdraw(200);
        assertEquals(300, bankAccount.getBalance());
    }

    @Test
    void deposit() {
        bankAccount.deposit(200);
        assertEquals(700, bankAccount.getBalance());
    }

    @Test
    @DisplayName("balance Will be negative")
    void testWithdrawNotStuckAtZero() {
        bankAccount.withdraw(900);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("checking bank activation is true")
    void testBankAccountIsActive() {
        assertTrue(bankAccount.getActive());
    }

    @Test
    @DisplayName("test set bank account name")
    void testBankAccountNameSet() {
        bankAccount.setAccountName("Iqbal");
        assertNotNull(bankAccount.getAccountName());
    }

    @Test
    @DisplayName("test we can not withdraw below minimum")
    void testNotWithdrawBelowMinimum() {
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("test deposit and withdraw without exceptions")
    void testDepositAndWithdrawWithoutExceptions() {
        assertAll(
                () -> bankAccount.withdraw(500),
                () -> bankAccount.deposit(200)
        );
    }

    @Test
    @DisplayName("test speed")
    void testDepositTimeout() {
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.withdraw(500));
    }

    @Test
    @Disabled("Disabled temporary")
    void testDisabled() {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}