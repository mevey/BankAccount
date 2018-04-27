import ci.BankAccount;
import ci.LoanApprover;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class LoanApproverTest {

    @Test
    public void loansShouldOnlyBeApprovedIfTheDepositsWorthSeventyPercentHaveBeenmadeInThePast() {
        LoanApprover la = new LoanApprover(0.5);
        BankAccount a = new BankAccount();
        a.makeDeposit(70.0);
        boolean approved = la.loanRequest(a,100.0);

        BankAccount b = new BankAccount();
        b.makeDeposit(30.0);
        boolean notApproved = la.loanRequest(b,100.0);

        assertTrue(approved);
        assertTrue(!notApproved);
    }

}
