public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, Customer customer, double balance, double overdraftLimit) {
        super(accountNumber, customer, balance);
        setOverdraftLimit(overdraftLimit);
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative.");
        }
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(", Overdraft Limit: $%.2f", overdraftLimit);
    }
}
