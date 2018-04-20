package  ci;

import java.util.ArrayList;

public class BankAccount {
    private static final double WITHDRAWAL_FEE = 0.5;
    private double balance;
    private final ArrayList<Object> transactions;

    public BankAccount() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public double balance() {
        return this.balance ;
    }

    public double makeDeposit(Double amount) {
        this.balance += amount;
        this.transactions.add(amount);
        return this.balance;
    }

    public double withdraw(double amount) {
        if ((this.balance - WITHDRAWAL_FEE)  < amount) {
            throw new RuntimeException("You do not have enough money in your account to withdraw" + amount);
        }
        this.balance -= (amount + WITHDRAWAL_FEE);
        this.transactions.add(amount * -1);
        this.transactions.add(WITHDRAWAL_FEE);
        return this.balance;
    }
}
