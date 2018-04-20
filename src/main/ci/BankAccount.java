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

}
