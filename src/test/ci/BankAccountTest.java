package ci;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BankAccountTest {
    @Test
    public void aNewBankAccountShouldHaveZeroBalance() {
        BankAccount a = new BankAccount();
        assertEquals(a.get_balance(), 0.0);
    }

    @Test
    public void bankBalanceShouldBeTwentyDollarsAfterDepositingTwentyDollars() {
        BankAccount a = new BankAccount();
        a.makeDeposit(20.0);
        assertEquals(a.get_balance(), 20.0);
    }

    @Test
    public void bankBalanceShouldbeNineFiftyAfterWithdrawingtenDollars() {
        BankAccount a = new BankAccount();
        a.makeDeposit(20.0);
        a.withdraw(10.0);
        assertEquals(a.get_balance(), 9.5);
    }

    @Test(expected = RuntimeException.class)
    public void attemptToWithdrawMoreThanThebalanceAndWithdrawalFeeShouldFail() {
        BankAccount a = new BankAccount();
        a.makeDeposit(20.0);
        a.withdraw(20.0);
    }

    @Test
    public void aTransferOfMoneyShouldCreditTheAccountAndDebitTheOtherAccountAndChargeTwentyCentsTransferFee() {
        BankAccount a = new BankAccount();
        BankAccount b = new BankAccount();
        a.makeDeposit(20.0);
        a.makeTransfer(b,10.0);
        assertEquals(a.get_balance(), 9.80);
        assertEquals(b.get_balance(), 10.0);
    }

}
