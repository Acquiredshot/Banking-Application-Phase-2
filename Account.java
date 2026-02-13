public class Account {
    // Basic account information fields
    private String accountNumber;    // max 5 characters
    private String accountType;      // CHK or SAV only
    private double serviceFee;       // 0.00 to 10.00 inclusive
    private double interestRate;     // 0.0 to 10.0 percent inclusive (stored as decimal)
    private double overdraftFee;     // no range specified
    private double balance;          // initially zero
    
    // Default constructor
    public Account() {
        this.accountNumber = "";
        this.accountType = "";
        this.serviceFee = 0.0;
        this.interestRate = 0.0;
        this.overdraftFee = 0.0;
        this.balance = 0.0;
    }
    
    // Parameterized constructor with validation
    public Account(String accountNumber, String accountType, double serviceFee, 
                   double interestRate, double overdraftFee, double balance) throws IllegalArgumentException {
        setAccountNumber(accountNumber);
        setAccountType(accountType);
        setServiceFee(serviceFee);
        setInterestRate(interestRate);
        setOverdraftFee(overdraftFee);
        setBalance(balance);
    }
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public double getServiceFee() {
        return serviceFee;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    public double getOverdraftFee() {
        return overdraftFee;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Setters with validation
    public void setAccountNumber(String accountNumber) throws IllegalArgumentException {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be blank.");
        }
        String trimmed = accountNumber.trim();
        if (trimmed.length() > 5) {
            throw new IllegalArgumentException("Account number must be 1-5 characters.");
        }
        this.accountNumber = trimmed;
    }
    
    public void setAccountType(String accountType) throws IllegalArgumentException {
        if (accountType == null || accountType.trim().isEmpty()) {
            throw new IllegalArgumentException("Account type cannot be blank.");
        }
        String trimmed = accountType.trim().toUpperCase();
        if (!trimmed.equals("CHK") && !trimmed.equals("SAV")) {
            throw new IllegalArgumentException("Account type must be CHK or SAV.");
        }
        this.accountType = trimmed;
    }
    
    public void setServiceFee(double serviceFee) throws IllegalArgumentException {
        if (serviceFee < 0.0 || serviceFee > 10.0) {
            throw new IllegalArgumentException("Service fee must be between 0.00 and 10.00.");
        }
        this.serviceFee = serviceFee;
    }
    
    public void setInterestRate(double interestRate) throws IllegalArgumentException {
        if (interestRate < 0.0 || interestRate > 10.0) {
            throw new IllegalArgumentException("Interest rate must be between 0.0 and 10.0 percent.");
        }
        this.interestRate = interestRate;
    }
    
    public void setOverdraftFee(double overdraftFee) throws IllegalArgumentException {
        if (overdraftFee < 0.0) {
            throw new IllegalArgumentException("Overdraft fee cannot be negative.");
        }
        this.overdraftFee = overdraftFee;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    // Display account information
    public String toString() {
        return String.format("Account Number: %s\nAccount Type: %s\nService Fee: $%.2f\n" +
                           "Interest Rate: %.2f%%\nOverdraft Fee: $%.2f\nBalance: $%.2f",
                           accountNumber, accountType, serviceFee, interestRate, 
                           overdraftFee, balance);
    }
}
