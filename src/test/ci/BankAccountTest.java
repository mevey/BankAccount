package ci;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BankAccountTest {
    @Test
    public void aNewBankAccountShouldHaveZeroBalance() {
        BankAccount a = new BankAccount();
        assertEquals(a.balance(), 0.0);
    }

    @Test
    public void bankBalanceShouldBeTwentyDollarsAfterDepositingTwentyDollars() {
        BankAccount a = new BankAccount();
        a.makeDeposit(20.0);
        assertEquals(a.balance(), 20.0);
    }

    @Test
    public void bankBalanceShouldbeNineFiftyAfterWithdrawingtenDollars() {
        BankAccount a = new BankAccount();
        a.makeDeposit(20.0);
        a.withdraw(10.0);
        assertEquals(a.balance(), 9.5);
    }

}
