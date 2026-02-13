public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, Customer customer, double balance, double interestRate) {
        super(accountNumber, customer, balance);
        setInterestRate(interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0.0 || interestRate > 10.0) {
            throw new IllegalArgumentException("Interest rate must be between 0.0 and 10.0 percent.");
        }
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(", Interest Rate: %.2f%%", interestRate);
    }
}
