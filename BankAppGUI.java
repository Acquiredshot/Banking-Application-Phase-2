import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankAppGUI extends JFrame {
    private final Map<String, CustomerAccountData> customerAccounts = new LinkedHashMap<>();

    public BankAppGUI() {
        setTitle("Banking Application");
        setSize(720, 720);
        setMinimumSize(new Dimension(640, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Banking Application", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        formPanel.add(new JLabel("Customer ID:"), gbc);
        gbc.gridx = 1;
        JTextField customerIdField = new JTextField(15);
        formPanel.add(customerIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("SSN:"), gbc);
        gbc.gridx = 1;
        JTextField ssnField = new JTextField(15);
        formPanel.add(ssnField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        JTextField firstNameField = new JTextField(15);
        formPanel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        JTextField lastNameField = new JTextField(15);
        formPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Address:"), gbc);
        gbc.gridx = 1;
        JTextField addressField = new JTextField(15);
        formPanel.add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("City:"), gbc);
        gbc.gridx = 1;
        JTextField cityField = new JTextField(15);
        formPanel.add(cityField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("State:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> stateDropdown = new JComboBox<>(new String[] {
            "AL", "CA", "FL", "NY", "TX"
        });
        formPanel.add(stateDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Zip Code:"), gbc);
        gbc.gridx = 1;
        JTextField zipField = new JTextField(15);
        formPanel.add(zipField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        JTextField phoneField = new JTextField(15);
        formPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Account Number:"), gbc);
        gbc.gridx = 1;
        JTextField accountNumberField = new JTextField(15);
        formPanel.add(accountNumberField, gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        JLabel accountNumberHint = new JLabel("Hint: Enter up to 5 characters (ex: CHK01 or SAV01)");
        accountNumberHint.setFont(accountNumberHint.getFont().deriveFont(Font.ITALIC, 11f));
        formPanel.add(accountNumberHint, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Initial Balance:"), gbc);
        gbc.gridx = 1;
        JTextField initialBalanceField = new JTextField(15);
        formPanel.add(initialBalanceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Account Type:"), gbc);
        gbc.gridx = 1;
        JRadioButton savingsRadio = new JRadioButton("Savings");
        JRadioButton checkingRadio = new JRadioButton("Checking");
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingsRadio);
        accountTypeGroup.add(checkingRadio);
        JPanel accountTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        accountTypePanel.add(savingsRadio);
        accountTypePanel.add(checkingRadio);
        formPanel.add(accountTypePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Transaction Date:"), gbc);
        gbc.gridx = 1;
        JTextField transactionDateField = new JTextField(15);
        formPanel.add(transactionDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Transaction Amount:"), gbc);
        gbc.gridx = 1;
        JTextField transactionAmountField = new JTextField(15);
        formPanel.add(transactionAmountField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Transaction Type:"), gbc);
        gbc.gridx = 1;
        JRadioButton depositRadio = new JRadioButton("Deposit");
        JRadioButton withdrawalRadio = new JRadioButton("Withdrawal");
        ButtonGroup transactionTypeGroup = new ButtonGroup();
        transactionTypeGroup.add(depositRadio);
        transactionTypeGroup.add(withdrawalRadio);
        JPanel transactionTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        transactionTypePanel.add(depositRadio);
        transactionTypePanel.add(withdrawalRadio);
        formPanel.add(transactionTypePanel, gbc);

        JScrollPane formScrollPane = new JScrollPane(formPanel);
        formScrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(formScrollPane, BorderLayout.CENTER);

        JTextArea outputArea = new JTextArea(6, 40);
        outputArea.setEditable(false);

        JLabel transactionCustomerIdLabel = new JLabel("Customer ID: ");
        JLabel transactionAccountNumberLabel = new JLabel("Account Number: ");
        JLabel transactionAccountTypeLabel = new JLabel("Account Type: ");
        JLabel transactionDateLabel = new JLabel("Transaction Date: ");
        JLabel transactionTypeLabel = new JLabel("Transaction Type: ");
        JLabel transactionAmountLabel = new JLabel("Transaction Amount: ");
        JLabel transactionFeesLabel = new JLabel("Fees/Charges: ");
        JLabel transactionBalanceLabel = new JLabel("Balance: ");
        JLabel statusLabel = new JLabel("Status: Ready");

        JButton addCustomerBtn = new JButton("Add New Customer and Account");
        JButton displayCustomerBtn = new JButton("Display Customer and Account Data");
        JButton performTransactionBtn = new JButton("Perform Transaction");
        JButton clearBtn = new JButton("Clear");
        JButton runTestBtn = new JButton("Run Test Transactions");

        addCustomerBtn.addActionListener(event -> {
            String accountNumber = accountNumberField.getText().trim();
            String customerId = customerIdField.getText().trim();
            String ssn = ssnField.getText().trim();
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String address = addressField.getText().trim();
            String city = cityField.getText().trim();
            String state = (String) stateDropdown.getSelectedItem();
            String zip = zipField.getText().trim();
            String phone = phoneField.getText().trim();
            String balanceText = initialBalanceField.getText().trim();

            if (customerId.isEmpty() || ssn.isEmpty() || accountNumber.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
                statusLabel.setText("Status: Missing required customer data.");
                JOptionPane.showMessageDialog(this,
                    "Customer ID, SSN, account number, first name, and last name are required.",
                    "Missing Data",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!savingsRadio.isSelected() && !checkingRadio.isSelected()) {
                statusLabel.setText("Status: Missing account type selection.");
                JOptionPane.showMessageDialog(this,
                    "Please select an account type (Savings or Checking).",
                    "Missing Data",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            double balance;
            try {
                balance = balanceText.isEmpty() ? 0.0 : Double.parseDouble(balanceText);
            } catch (NumberFormatException ex) {
                statusLabel.setText("Status: Invalid initial balance.");
                JOptionPane.showMessageDialog(this,
                    "Initial balance must be a valid number.",
                    "Invalid Data",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            String accountType = savingsRadio.isSelected() ? "Savings" : "Checking";
            try {
                CustomerAccountData data = CustomerAccountData.fromInput(
                    customerId, ssn, firstName, lastName, address, city, state, zip, phone,
                    accountNumber, balance, accountType
                );
                customerAccounts.put(accountNumber, data);

                outputArea.setText("Added customer/account:\n" + data.toDisplayString());
                statusLabel.setText("Status: Customer/account added successfully.");
            } catch (IllegalArgumentException ex) {
                statusLabel.setText("Status: " + ex.getMessage());
                JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Invalid Data",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        displayCustomerBtn.addActionListener(event -> {
            String accountNumber = accountNumberField.getText().trim();
            if (accountNumber.isEmpty()) {
                statusLabel.setText("Status: Missing account number for display.");
                JOptionPane.showMessageDialog(this,
                    "Enter an account number to display the customer data.",
                    "Missing Data",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            CustomerAccountData data = customerAccounts.get(accountNumber);
            if (data == null) {
                outputArea.setText("No customer found for account number: " + accountNumber);
                statusLabel.setText("Status: No customer found for that account number.");
                return;
            }

            outputArea.setText(data.toDisplayString());
            statusLabel.setText("Status: Customer/account data displayed.");
        });

        performTransactionBtn.addActionListener(event -> {
            String accountNumber = accountNumberField.getText().trim();
            if (accountNumber.isEmpty()) {
                statusLabel.setText("Status: Missing account number for transaction.");
                JOptionPane.showMessageDialog(this,
                    "Enter an account number to perform a transaction.",
                    "Missing Data",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            CustomerAccountData data = customerAccounts.get(accountNumber);
            if (data == null) {
                outputArea.setText("No customer found for account number: " + accountNumber);
                statusLabel.setText("Status: No customer found for that account number.");
                return;
            }

            String transactionDate = transactionDateField.getText().trim();
            String transactionAmountText = transactionAmountField.getText().trim();

            if (transactionAmountText.isEmpty()) {
                statusLabel.setText("Status: Missing transaction amount.");
                JOptionPane.showMessageDialog(this,
                    "Enter a transaction amount.",
                    "Missing Data",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!depositRadio.isSelected() && !withdrawalRadio.isSelected()) {
                statusLabel.setText("Status: Missing transaction type.");
                JOptionPane.showMessageDialog(this,
                    "Select Deposit or Withdrawal for the transaction type.",
                    "Missing Data",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            double amount;
            try {
                amount = Double.parseDouble(transactionAmountText);
            } catch (NumberFormatException ex) {
                statusLabel.setText("Status: Invalid transaction amount.");
                JOptionPane.showMessageDialog(this,
                    "Transaction amount must be a valid number.",
                    "Invalid Data",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (amount <= 0) {
                statusLabel.setText("Status: Transaction amount must be greater than zero.");
                JOptionPane.showMessageDialog(this,
                    "Transaction amount must be greater than zero.",
                    "Invalid Data",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            String transactionType = depositRadio.isSelected() ? "Deposit" : "Withdrawal";
            try {
                TransactionResult result = data.applyTransaction(transactionDate, transactionType, amount);

                transactionCustomerIdLabel.setText("Customer ID: " + data.customer.getCustomerID());
                transactionAccountNumberLabel.setText("Account Number: " + data.account.getAccountNumber());
                transactionAccountTypeLabel.setText("Account Type: " + data.account.getAccountType());
                transactionDateLabel.setText("Transaction Date: " + (transactionDate.isEmpty() ? "" : transactionDate));
                transactionTypeLabel.setText("Transaction Type: " + transactionType);
                transactionAmountLabel.setText(String.format("Transaction Amount: $%.2f", amount));
                transactionFeesLabel.setText(String.format("Fees/Charges: $%.2f", result.fees));
                transactionBalanceLabel.setText(String.format("Balance: $%.2f", result.balance));

                outputArea.setText("Transaction complete.\n" + data.toDisplayString());
                statusLabel.setText("Status: Transaction completed successfully.");
            } catch (IllegalArgumentException ex) {
                statusLabel.setText("Status: " + ex.getMessage());
                JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Invalid Transaction",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        clearBtn.addActionListener(event -> {
            customerIdField.setText("");
            ssnField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            addressField.setText("");
            cityField.setText("");
            zipField.setText("");
            phoneField.setText("");
            accountNumberField.setText("");
            initialBalanceField.setText("");
            transactionDateField.setText("");
            transactionAmountField.setText("");
            statusLabel.setText("Status: Cleared all input fields.");
        });

        runTestBtn.addActionListener(event -> {
            outputArea.setText("");
            statusLabel.setText("Status: Running test transactions.");

            try {
                CustomerAccountData checkingCustomer = CustomerAccountData.fromInput(
                    "C1001", "123456789", "Alex", "Morgan", "100 Elm St", "Miami", "FL", "33101", "3055551234",
                    "CHK01", 0.0, "Checking"
                );
                CustomerAccountData savingsCustomer = CustomerAccountData.fromInput(
                    "C2002", "987654321", "Jamie", "Lee", "200 Oak Ave", "Orlando", "FL", "32801", "4075559876",
                    "SAV01", 0.0, "Savings"
                );

                customerAccounts.put(checkingCustomer.account.getAccountNumber(), checkingCustomer);
                customerAccounts.put(savingsCustomer.account.getAccountNumber(), savingsCustomer);

                StringBuilder log = new StringBuilder();

                log.append(runTransaction(checkingCustomer, "03/11/2026", "Deposit", 1000.0));
                log.append(runTransaction(checkingCustomer, "03/11/2026", "Withdrawal", 500.0));
                log.append(runTransaction(checkingCustomer, "03/11/2026", "Withdrawal", 501.0));
                log.append(runTransaction(checkingCustomer, "03/11/2026", "Deposit", 500.0));
                log.append(runInterest(checkingCustomer, "03/11/2026"));

                log.append(runTransaction(savingsCustomer, "03/11/2026", "Deposit", 1000.0));
                log.append(runTransaction(savingsCustomer, "03/11/2026", "Withdrawal", 500.0));
                log.append(runTransaction(savingsCustomer, "03/11/2026", "Withdrawal", 501.0));
                log.append(runTransaction(savingsCustomer, "03/11/2026", "Deposit", 500.0));
                log.append(runInterest(savingsCustomer, "03/11/2026"));

                outputArea.setText(log.toString());
                statusLabel.setText("Status: Test transactions completed.");
            } catch (IllegalArgumentException ex) {
                statusLabel.setText("Status: " + ex.getMessage());
                JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Invalid Test Data",
                    JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 6));
        buttonPanel.add(addCustomerBtn);
        buttonPanel.add(displayCustomerBtn);
        buttonPanel.add(performTransactionBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(runTestBtn);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(heading, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel transactionInfoPanel = new JPanel(new GridLayout(0, 1));
        transactionInfoPanel.add(transactionCustomerIdLabel);
        transactionInfoPanel.add(transactionAccountNumberLabel);
        transactionInfoPanel.add(transactionAccountTypeLabel);
        transactionInfoPanel.add(transactionDateLabel);
        transactionInfoPanel.add(transactionTypeLabel);
        transactionInfoPanel.add(transactionAmountLabel);
        transactionInfoPanel.add(transactionFeesLabel);
        transactionInfoPanel.add(transactionBalanceLabel);
        transactionInfoPanel.add(statusLabel);

        JPanel lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.add(transactionInfoPanel, BorderLayout.NORTH);
        lowerPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        bottomPanel.add(lowerPanel, BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private String runTransaction(CustomerAccountData data, String date, String type, double amount) {
        try {
            TransactionResult result = data.applyTransaction(date, type, amount);
            return String.format(
                "%s %s $%.2f | Fees: $%.2f | Balance: $%.2f\n",
                data.account.getAccountType(), type, amount, result.fees, result.balance
            );
        } catch (IllegalArgumentException ex) {
            return String.format("%s %s $%.2f | ERROR: %s\n",
                data.account.getAccountType(), type, amount, ex.getMessage());
        }
    }

    private String runInterest(CustomerAccountData data, String date) {
        double interest = data.applyInterest(date);
        return String.format(
            "%s Interest Added | Earned: $%.2f | Balance: $%.2f\n",
            data.account.getAccountType(), interest, data.account.getBalance()
        );
    }

    private static class TransactionResult {
        private final double fees;
        private final double balance;

        private TransactionResult(double fees, double balance) {
            this.fees = fees;
            this.balance = balance;
        }
    }

    private static class CustomerAccountData {
        private final Customer customer;
        private final Account account;
        private String lastTransactionDate;
        private String lastTransactionType;
        private double lastTransactionAmount;

        private CustomerAccountData(Customer customer, Account account) {
            this.customer = customer;
            this.account = account;
        }

        private static CustomerAccountData fromInput(String customerId, String ssn, String firstName, String lastName,
                                                     String address, String city, String state, String zip, String phone,
                                                     String accountNumber, double balance, String accountType) {
            Customer customer = new Customer();
            customer.setCustomerID(customerId);
            customer.setSsn(ssn);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setStreet(address);
            customer.setCity(city);
            customer.setState(state);
            customer.setZip(zip);
            customer.setPhone(phone);

            Account account;
            if ("Checking".equalsIgnoreCase(accountType)) {
                account = new CheckingAccount();
            } else {
                account = new SavingsAccount();
            }
            account.setAccountNumber(accountNumber);
            account.setBalance(balance);

            return new CustomerAccountData(customer, account);
        }

        private TransactionResult applyTransaction(String transactionDate, String transactionType, double amount) {
            double startingBalance = account.getBalance();
            String normalizedType = "Deposit".equals(transactionType) ? "DEP" : "WTH";

            if (account instanceof CheckingAccount) {
                CheckingAccount checking = (CheckingAccount) account;
                checking.setTransactionDate(transactionDate);
                checking.setTransactionType(normalizedType);
                checking.setTransactionAmount(amount);
                if ("DEP".equals(normalizedType)) {
                    checking.deposit();
                } else {
                    checking.withdrawal();
                }
            } else if (account instanceof SavingsAccount) {
                SavingsAccount savings = (SavingsAccount) account;
                savings.setTransactionDate(transactionDate);
                savings.setTransactionType(normalizedType);
                savings.setTransactionAmount(amount);
                if ("DEP".equals(normalizedType)) {
                    savings.deposit();
                } else {
                    savings.withdrawal();
                }
            }

            double endingBalance = account.getBalance();
            double fees;
            if ("Deposit".equals(transactionType)) {
                fees = amount - (endingBalance - startingBalance);
            } else {
                fees = (startingBalance - endingBalance) - amount;
            }

            lastTransactionDate = transactionDate == null ? "" : transactionDate.trim();
            lastTransactionType = transactionType;
            lastTransactionAmount = amount;

            return new TransactionResult(Math.max(fees, 0.0), endingBalance);
        }

        private double applyInterest(String transactionDate) {
            double startingBalance = account.getBalance();
            double withInterest = account.balance();
            account.setBalance(withInterest);
            lastTransactionDate = transactionDate == null ? "" : transactionDate.trim();
            lastTransactionType = "Interest";
            lastTransactionAmount = withInterest - startingBalance;
            return lastTransactionAmount;
        }

        private String toDisplayString() {
            String transactionInfo = lastTransactionType == null
                ? ""
                : String.format("\nLast Transaction: %s $%.2f on %s",
                    lastTransactionType, lastTransactionAmount,
                    lastTransactionDate == null ? "" : lastTransactionDate);
            return String.format(
                "Customer: %s %s\nCustomer ID: %s\nAddress: %s\nCity: %s, %s %s\nPhone: %s\nAccount: %s (%s)\nBalance: $%.2f%s",
                customer.getFirstName(), customer.getLastName(), customer.getCustomerID(),
                customer.getStreet(), customer.getCity(), customer.getState(), customer.getZip(),
                customer.getPhone(), account.getAccountNumber(), account.getAccountType(), account.getBalance(),
                transactionInfo
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankAppGUI().setVisible(true);
        });
    }
}
