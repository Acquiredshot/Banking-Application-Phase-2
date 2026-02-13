public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected Customer customer;

    public BankAccount(String accountNumber, Customer customer, double balance) {
        setAccountNumber(accountNumber);
        setCustomer(customer);
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be blank.");
        }
        if (accountNumber.trim().length() > 5) {
            throw new IllegalArgumentException("Account number must be 1-5 characters.");
        }
        this.accountNumber = accountNumber.trim();
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
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        this.customer = customer;
    }

    public abstract String getAccountType();

    @Override
    public String toString() {
        return String.format("Account Number: %s, Type: %s, Balance: $%.2f, Customer: %s %s", 
            accountNumber, getAccountType(), balance, 
            customer.getFirstName(), customer.getLastName());
    }
}
