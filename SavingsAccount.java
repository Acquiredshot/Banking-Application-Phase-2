public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, Customer customer, double balance, double interestRate) {
        super(accountNumber, customer, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
