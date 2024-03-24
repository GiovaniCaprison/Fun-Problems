public class LengthOfLoan {
    public static void main(String[] args) {
        // Can replace hard coded values with user input from scanner if desired.
        int loan = 250000;
        int interestRate = 3;
        int repayment = 1600;
        System.out.println("Making monthly repayments of €" + repayment + ", on a loan of €" + loan + ", with an annual interest rate of " + interestRate + "%, will take " + recursiveLoanCalculator(loan, interestRate, repayment) + " years to repay.");
    }

    public static int recursiveLoanCalculator(int loan, int interestRate, int repayment) {
        if (loan <= 0) {
            return 0;
        } else {
            return 1 + recursiveLoanCalculator((loan + (loan * interestRate / 100)) - repayment * 12, interestRate, repayment);
        }
    }
}
