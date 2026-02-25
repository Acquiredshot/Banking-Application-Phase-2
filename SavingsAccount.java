import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class SavingsAccount extends Account {
    private static final double SERVICE_FEE = 0.25;
    private static final double INTEREST_RATE = 0.05;
    private static final DateTimeFormatter DATE_FORMAT =
        DateTimeFormatter.ofPattern("MM/dd/uuuu").withResolverStyle(ResolverStyle.STRICT);

    private LocalDate transactionDate;
    private String transactionType;
    private double transactionAmount;

    public SavingsAccount() {
        setAccountType("SAV");
    }

    public SavingsAccount(String accountNumber, double balance, String transactionDate,
                          String transactionType, double transactionAmount) {
        setAccountNumber(accountNumber);
        setAccountType("SAV");
        setBalance(balance);
        setTransactionDate(transactionDate);
        setTransactionType(transactionType);
        setTransactionAmount(transactionAmount);
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        if (transactionDate == null || transactionDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Transaction date cannot be blank.");
        }
        try {
            this.transactionDate = LocalDate.parse(transactionDate.trim(), DATE_FORMAT);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Transaction date must be valid (MM/DD/YYYY).");
        }
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        if (transactionType == null || transactionType.trim().isEmpty()) {
            throw new IllegalArgumentException("Transaction type cannot be blank.");
        }
        String trimmed = transactionType.trim().toUpperCase();
        if (!trimmed.equals("DEP") && !trimmed.equals("WTH")) {
            throw new IllegalArgumentException("Transaction type must be DEP or WTH.");
        }
        this.transactionType = trimmed;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        if (transactionAmount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero.");
        }
        this.transactionAmount = transactionAmount;
    }

    @Override
    public void withdrawal() {
        double totalDebit = transactionAmount + SERVICE_FEE;
        if (totalDebit > getBalance()) {
            throw new IllegalArgumentException("Savings account balances cannot be negative.");
        }
        setBalance(getBalance() - totalDebit);
    }

    @Override
    public void deposit() {
        setBalance(getBalance() + transactionAmount - SERVICE_FEE);
    }

    @Override
    public double balance() {
        return getBalance() + (getBalance() * INTEREST_RATE);
    }

    @Override
    public String toString() {
        return String.format(
            "Savings Account: %s\nTransaction Date: %s\nTransaction Type: %s\n" +
            "Transaction Amount: $%.2f\nBalance: $%.2f\nBalance w/ Interest: $%.2f",
            getAccountNumber(),
            transactionDate == null ? "" : DATE_FORMAT.format(transactionDate),
            transactionType == null ? "" : transactionType,
            transactionAmount,
            getBalance(),
            balance()
        );
    }
}
