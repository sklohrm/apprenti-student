public class LoanPaymentCalculator {

    public static void main(String[] args) {
        //Declare and initialize variables:
        double loanAmount = 25000.00;
        double annualInterestRate = 5.5;
        int loanTermYears = 5;
        double monthlyPayment;

        // Calculate Monthly Payment using the Formula
        // monthlyPayment = (loanAmount×(interestRate/100)/12)
        monthlyPayment = (loanAmount * (annualInterestRate / 100) / 12);
        // 1. Use Assignment Operators:
        // Increase loanAmount by $5,000 (+=).
        loanAmount += 5000;
        // Reduce the annualInterestRate by 1% (-=).
        annualInterestRate -= 1;
        // Increase loanTermYears by 1 (++).
        loanTermYears++;


        // 2. Use Comparison Operators:
        // Check if the loanAmount exceeds $30,000.
        boolean isLoanBig = loanAmount > 30000;
        // Check if the monthlyPayment is more than $500.
        boolean isPaymentBig = monthlyPayment > 500;

        // 3. Use Logical Operators:
        // Determine if the loan is affordable (monthly payment is below $500 AND term is over 3 years).
        boolean isLoanAffordable = (monthlyPayment < 500 && loanTermYears > 3);
        // Determine if the loan is expensive (monthly payment is above $700 OR interest rate is over 6%).
        boolean isLoanExpensive = (monthlyPayment > 700 || annualInterestRate > 6);

        // 4. Print all results.
        System.out.printf("Loan Amount: $%,.2f%n", loanAmount);
        System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
        System.out.println("Loan Term: " + loanTermYears + " years");
        System.out.println("Monthly Payment: " + monthlyPayment + "\n");

        System.out.println("This loan is " + (isLoanBig ? "big!" : "small."));
        System.out.println("This loan's payments are " + ((isPaymentBig) ? "big!" : "small."));
        System.out.println("This loan is " + ((isLoanAffordable) ? "affordable." : "unaffordable!"));
        System.out.println("This loan is " + ((isLoanExpensive) ? "expensive!" : "inexpensive."));


    }

}
