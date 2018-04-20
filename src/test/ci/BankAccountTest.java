package ci;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BankAccountTest {
    @Test
    public void aNewBankAccountShouldHaveZeroBalance() {
        BankAccount a = new BankAccount();
        assertEquals(a.getBalance(), 0.0);
    }

    @Test
    public void bankBalanceShouldBeTwentyDollarsAfterDepositingTwentyDollars() {
        BankAccount a = new BankAccount();
        a.makeDeposit(20.0);
        assertEquals(a.getBalance(), 20.0);
    }

    @Test
    public void bankBalanceShouldbeNineFiftyAfterWithdrawingtenDollars() {
        BankAccount a = new BankAccount();
        a.makeDeposit(20.0);
        a.withdraw(10.0);
        assertEquals(a.getBalance(), 9.5);
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
        assertEquals(a.getBalance(), 9.80);
        assertEquals(b.getBalance(), 10.0);
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
        assertEquals(b.getBalance(), 17.0);
    }

    @Test
    public void totalFeesMadeFromTwoTransfersAndTwoWithdrawalsShouldEqualOnePointFour() {
        BankAccount a = new BankAccount();
        BankAccount b = new BankAccount();
        a.makeDeposit(100.0);
        a.withdraw(10.0);
        a.withdraw(10.0);
        a.makeTransfer(b,10.0);
        a.makeTransfer(b,10.0);
        assertEquals(a.getTotalFees(), 1.40);
    }

    @Test
    public void loansShouldOnlyBeApprovedIfTheDepositsWorthSeventyPercentHaveBeenmadeInThePast() {
        BankAccount a = new BankAccount();
        a.makeDeposit(70.0);
        boolean approved = a.loanRequest(100.0);
        assertTrue(approved);
    }
}
