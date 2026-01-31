public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected Customer customer;

    public BankAccount(String accountNumber, Customer customer, double balance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public abstract String getAccountType();

    @Override
    public String toString() {
        return String.format("Account Number: %s, Type: %s, Balance: %.2f, Customer: %s", accountNumber, getAccountType(), balance, customer);
    }
}
