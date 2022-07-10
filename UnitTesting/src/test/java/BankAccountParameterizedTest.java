import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 8, 16, 32, 64})
    @DisplayName("Checking int params")
    void testDepositValueSource(int amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    @DisplayName("parameterized test enum source test")
    void testEnumSourceTest(DayOfWeek day) {
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
    @CsvSource({"100,Samsung", "200,Nokia", "300,Toshiba"})
    @DisplayName("csv source test")
    void testCsvSource(double amount, String accountName, BankAccount bankAccount) {
        bankAccount.setAccountName(accountName);
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
        assertEquals(accountName, bankAccount.getAccountName());
    }
}
