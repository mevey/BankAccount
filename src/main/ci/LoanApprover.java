package ci;

import java.util.ArrayList;

/* JOB: understands when to approve a loan*/
public class LoanApprover {


    private final double threshold;

    public LoanApprover(double threshold) {
        this.threshold = 0.5;
    }

    public boolean loanRequest(BankAccount account , double amount) {
        double totalDeposits = 0.0;
        ArrayList<Double> transactions = account.getTransactionHistory();
        for (double transaction: transactions ) {
            if (transaction > 0.0) {
                totalDeposits += transaction;
            }
        }

        if ((amount * threshold)  >= totalDeposits) {
            return false;
        }
        return true;
    }
}
