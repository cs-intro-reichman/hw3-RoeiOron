public class LoanCalc {

    static double epsilon = 0.001;  
    static int iterationCounter;    

    public static void main(String[] args) {        
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    private static double endBalance(double loan, double rate, int n, double payment) { 
        double balance = loan; 
        for (int i = 0; i < n; i++) {        
            double afterPayment = balance - payment;
            balance = afterPayment * (1 + rate / 100);
        }
        return balance;
    }

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        double g = loan / n; 
        iterationCounter = 0;
        while (endBalance(loan, rate, n, g) > 0) {
            g = g + epsilon;
            iterationCounter++;
        }
        return g;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double L = loan / n;
        double H = loan;
        double g = (L + H) / 2; 
        iterationCounter = 0;
        while ((H - L) > epsilon) {
            if (endBalance(loan, rate, n, g) > 0) {
                L = g;
            } else {
                H = g; 
            }
            g = (L + H) / 2;
            iterationCounter++;
        }
        return g;
    }
}