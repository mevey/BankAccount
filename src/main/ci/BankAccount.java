package  ci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*JOB: Understands how to credit and debit account */
public class BankAccount {
    private static final double WITHDRAWAL_FEE = 0.5;
    private static final double TRANSACTION_FEE = 0.2;
    private double loanBalance;
    private double balance;
    private  ArrayList<Double> transactions;
    private  ArrayList<Double> loanTransactions;

    public BankAccount() {
        this.balance = 0.0;
        this.loanBalance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return this.balance ;
    }

    public double getLoanBalance() {
        return this.loanBalance ;
    }

    public double makeDeposit(Double amount) {
        this.balance += amount;
        this.transactions.add(amount);
        return this.balance;
    }

    private void makeLoanDeposit(double amount) {
        this.loanBalance += amount;
        this.loanTransactions.add(-1 * amount);
    }

    public double withdraw(double amount) {
        return this.withdraw(amount, WITHDRAWAL_FEE);
    }

    private double withdraw(double amount, double fee) {
        if ((this.balance - fee)  < amount) {
            throw new RuntimeException("You do not have enough money in your account to withdraw" + amount);
        }
        if ((amount % 5) != 0 && fee == WITHDRAWAL_FEE)  {
            throw new RuntimeException("You can only withdraw money in multiples of five");
        }
        this.balance -= (amount + fee);
        this.transactions.add(amount * -1);
        this.transactions.add(fee * -1);
        return this.balance;
    }

    public void makeTransfer(BankAccount other,  double amount) {
        this.withdraw(amount, TRANSACTION_FEE);
        other.makeDeposit(amount);
    }

    public ArrayList getTransactionHistory() {
        return this.transactions;
    }

    public double getTotalFees() {
        double totalFees = 0;
        for (double transaction: transactions) {
            transaction = transaction * -1;
            if (transaction == TRANSACTION_FEE || transaction == WITHDRAWAL_FEE) {
                totalFees += transaction;
            }
        }
        return totalFees;
    }

    public boolean loanRequest(double amount) {
        double totalDeposits = 0;
        for (double transaction: transactions) {
            if (transaction > 0) {
                totalDeposits += transaction;
            }
        }
        if ((amount * 0.7)  <= totalDeposits) {
            return false;
        }
        makeLoanDeposit(amount);
        return true;
    }
}
