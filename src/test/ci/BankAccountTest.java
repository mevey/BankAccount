package ci;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BankAccountTest {
    @Test
    public void aNewBankAccountShouldHaveZeroBalance() {
        BankAccount a = new BankAccount();
        assertEquals(a.balance(), 0.0);
    }

}
