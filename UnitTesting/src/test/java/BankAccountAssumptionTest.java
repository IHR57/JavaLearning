import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionTest {
    @Test
    @DisplayName("Test activation account after creation")
    public void testActivationAccountNotNull() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assumeTrue(bankAccount != null);
        assertTrue(bankAccount.getActive());    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActivationAccountNull() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assumeFalse(bankAccount == null);
        assertTrue(bankAccount.getActive());
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActivationAccountWithAssuming() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assumingThat(bankAccount == null, () -> assertTrue(bankAccount.getActive()));
    }
}
