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

    @Test
    public void numberOftransactionsShouldBeEightAfterTwoDepositsAndThreeWithdrawals() {
        BankAccount b = new BankAccount();
        b.makeDeposit(100.0);
        b.withdraw(50.0);
        b.makeDeposit(20.0);
        b.withdraw(30.0);
        b.withdraw(30.0);
        assertEquals(b.getTransactionHistory().size() , 8);
    }

    @Test(expected = RuntimeException.class)
    public void oneShouldNotBeAbleToWithdrawBillsWhosevalueIsIndivisibleByFive() {
        BankAccount b = new BankAccount();
        b.makeDeposit(100.0);
        b.withdraw(17.0);
    }

    @Test
    public void accountBbalanceShouldIncreaseBySeventeenWhenATransferIsMadeToIt() {
        BankAccount a = new BankAccount();
        BankAccount b = new BankAccount();
        a.makeDeposit(100.0);
        a.makeTransfer(b,17.0);
        assertEquals(b.get_balance(), 17.0);
    }
}
