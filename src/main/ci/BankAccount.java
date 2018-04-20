package  ci;

import java.util.ArrayList;

public class BankAccount {
    private static final double WITHDRAWAL_FEE = 0.5;
    private static final double TRANSACTION_FEE = 0.2;
    private double balance;
    private final ArrayList<Object> transactions;

    public BankAccount() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public double get_balance() {
        return this.balance ;
    }

    public double makeDeposit(Double amount) {
        this.balance += amount;
        this.transactions.add(amount);
        return this.balance;
    }

    public double withdraw(double amount) {
        return this.withdraw(amount, WITHDRAWAL_FEE);
    }

    private double withdraw(double amount, double fee) {
        if ((this.balance - fee)  < amount) {
            throw new RuntimeException("You do not have enough money in your account to withdraw" + amount);
        }
        this.balance -= (amount + fee);
        this.transactions.add(amount * -1);
        this.transactions.add(fee);
        return this.balance;
    }

    public void makeTransfer(BankAccount other,  double amount) {
        this.withdraw(amount, TRANSACTION_FEE);
        other.makeDeposit(amount);
    }

    public ArrayList getTransactionHistory() {
        return this.transactions;
    }
}
