import java.util.ArrayList;

public class BankAcctApp {
    
    // Helper method to handle input with exception handling and retry logic
    private static void collectInputWithRetry(Runnable inputAction) {
        boolean success = false;
        do {
            try {
                inputAction.run();
                success = true;
            } catch (IllegalArgumentException iae) {
                System.out.println("ERROR: " + iae.getMessage());
            } catch (Exception ex) {
                System.out.println("ERROR: Invalid input format. " + ex.getMessage());
            }
        } while (!success);
    }
    
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
        ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
        String continueChoice;
        String checkingCustomerId = null;
        String savingsCustomerId = null;
        CheckingAccount checkingAccount = null;
        SavingsAccount savingsAccount = null;

        do {
            final Customer currentCustomer = new Customer();
            CheckingAccount currentChecking = null;
            SavingsAccount currentSavings = null;

            System.out.println("\n========== NEW CUSTOMER & ACCOUNT ENTRY ==========");
            
            // Collect Customer Information
            collectInputWithRetry(() -> 
                currentCustomer.setCustomerID(DataEntry.getString("Enter Customer ID (max 5): ", 5))
            );
            
            collectInputWithRetry(() -> 
                currentCustomer.setSsn(DataEntry.getNumericString("Enter SSN (9 digits): ", 9))
            );
            
            collectInputWithRetry(() -> 
                currentCustomer.setLastName(DataEntry.getString("Enter Last Name (max 20): ", 20))
            );
            
            collectInputWithRetry(() -> 
                currentCustomer.setFirstName(DataEntry.getString("Enter First Name (max 15): ", 15))
            );
            
            collectInputWithRetry(() -> 
                currentCustomer.setStreet(DataEntry.getString("Enter Street (max 20): ", 20))
            );
            
            collectInputWithRetry(() -> 
                currentCustomer.setCity(DataEntry.getString("Enter City (max 20): ", 20))
            );
            
            collectInputWithRetry(() -> 
                currentCustomer.setState(DataEntry.getString("Enter State (2 letters): ", 2))
            );
            
            collectInputWithRetry(() -> 
                currentCustomer.setZip(DataEntry.getNumericString("Enter Zip (5 digits): ", 5))
            );
            
            collectInputWithRetry(() -> 
                currentCustomer.setPhone(DataEntry.getNumericString("Enter Phone (10 digits): ", 10))
            );

            // Collect Account Information
            System.out.println("\n--- Account Information ---");

            String acctType;
            while (true) {
                try {
                    acctType = DataEntry.getString("Enter Account Type (CHK or SAV): ", 3).toUpperCase();
                    if (!acctType.equals("CHK") && !acctType.equals("SAV")) {
                        throw new IllegalArgumentException("Account type must be CHK or SAV.");
                    }
                    break;
                } catch (IllegalArgumentException ex) {
                    System.out.println("ERROR: " + ex.getMessage());
                }
            }

            if (acctType.equals("CHK")) {
                currentChecking = new CheckingAccount();

                while (true) {
                    try {
                        String acctNum = DataEntry.getString("Enter Account Number (max 5): ", 5);
                        currentChecking.setAccountNumber(acctNum);
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                while (true) {
                    try {
                        double bal = DataEntry.getDouble("Enter Initial Balance: ");
                        currentChecking.setBalance(bal);
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                while (true) {
                    try {
                        String date = DataEntry.getString("Enter Transaction Date (MM/DD/YYYY): ");
                        currentChecking.setTransactionDate(date);
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                while (true) {
                    try {
                        String type = DataEntry.getString("Enter Transaction Type (DEP or WTH): ", 3);
                        currentChecking.setTransactionType(type);
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                while (true) {
                    try {
                        double amount = DataEntry.getDouble("Enter Transaction Amount: ");
                        currentChecking.setTransactionAmount(amount);
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                if (currentChecking.getTransactionType().equals("DEP")) {
                    currentChecking.deposit();
                } else {
                    currentChecking.withdrawal();
                }

                checkingAccounts.add(currentChecking);
                checkingCustomerId = currentCustomer.getCustomerID();
                checkingAccount = currentChecking;
            } else {
                currentSavings = new SavingsAccount();

                while (true) {
                    try {
                        String acctNum = DataEntry.getString("Enter Account Number (max 5): ", 5);
                        currentSavings.setAccountNumber(acctNum);
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                while (true) {
                    try {
                        double bal = DataEntry.getDouble("Enter Initial Balance: ");
                        currentSavings.setBalance(bal);
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                while (true) {
                    try {
                        String date = DataEntry.getString("Enter Transaction Date (MM/DD/YYYY): ");
                        currentSavings.setTransactionDate(date);
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                while (true) {
                    try {
                        String type = DataEntry.getString("Enter Transaction Type (DEP or WTH): ", 3);
                        currentSavings.setTransactionType(type);
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                while (true) {
                    try {
                        double amount = DataEntry.getDouble("Enter Transaction Amount: ");
                        currentSavings.setTransactionAmount(amount);
                        if (currentSavings.getTransactionType().equals("DEP")) {
                            currentSavings.deposit();
                        } else {
                            currentSavings.withdrawal();
                        }
                        break;
                    } catch (IllegalArgumentException ex) {
                        System.out.println("ERROR: " + ex.getMessage());
                    }
                }

                savingsAccounts.add(currentSavings);
                savingsCustomerId = currentCustomer.getCustomerID();
                savingsAccount = currentSavings;
            }

            customers.add(currentCustomer);

            continueChoice = DataEntry.getString("\nAdd another customer/account? (y/n): ", 1);

        } while (continueChoice.equalsIgnoreCase("Y"));

        // Display Results
        displayCustomerList(customers);
        displayCheckingAccountList(checkingAccounts);
        displaySavingsAccountList(savingsAccounts);

        if (checkingAccount != null) {
            runCheckingScenario(checkingCustomerId, checkingAccount);
        }

        if (savingsAccount != null) {
            runSavingsScenario(savingsCustomerId, savingsAccount);
        }
    }

    private static void runCheckingScenario(String customerId, CheckingAccount account) {
        System.out.println("\n==================== CHECKING ACCOUNT TRANSACTIONS ====================");
        printTransactionHeader();

        String accountNumber = account.getAccountNumber();
        String date = "02/25/2026";

        executeCheckingTransaction(customerId, accountNumber, date, account, "DEP", 1000.00);
        executeCheckingTransaction(customerId, accountNumber, date, account, "WTH", 500.00);
        executeCheckingTransaction(customerId, accountNumber, date, account, "WTH", 501.00);
        executeCheckingTransaction(customerId, accountNumber, date, account, "DEP", 500.00);

        double interest = account.balance() - account.getBalance();
        account.setBalance(account.balance());
        printTransactionRow(
            customerId,
            accountNumber,
            date,
            "DEP",
            interest,
            0.0,
            account.getBalance()
        );
    }

    private static void executeCheckingTransaction(String customerId, String accountNumber, String date,
                                                   CheckingAccount account, String type, double amount) {
        double before = account.getBalance();
        account.setTransactionDate(date);
        account.setTransactionType(type);
        account.setTransactionAmount(amount);

        if (type.equals("DEP")) {
            account.deposit();
        } else {
            account.withdrawal();
        }

        double after = account.getBalance();
        double charges = type.equals("DEP")
            ? (before + amount - after)
            : (before - amount - after);

        printTransactionRow(customerId, accountNumber, date, type, amount, charges, after);
    }

    private static void runSavingsScenario(String customerId, SavingsAccount account) {
        System.out.println("\n==================== SAVINGS ACCOUNT TRANSACTIONS ====================");
        printTransactionHeader();

        String accountNumber = account.getAccountNumber();
        String date = "02/25/2026";

        executeSavingsTransaction(customerId, accountNumber, date, account, "DEP", 1000.00);
        executeSavingsTransaction(customerId, accountNumber, date, account, "WTH", 500.00);
        executeSavingsTransaction(customerId, accountNumber, date, account, "WTH", 501.00);
        executeSavingsTransaction(customerId, accountNumber, date, account, "DEP", 500.00);

        double interest = account.balance() - account.getBalance();
        account.setBalance(account.balance());
        printTransactionRow(
            customerId,
            accountNumber,
            date,
            "DEP",
            interest,
            0.0,
            account.getBalance()
        );
    }

    private static void executeSavingsTransaction(String customerId, String accountNumber, String date,
                                                  SavingsAccount account, String type, double amount) {
        double before = account.getBalance();
        account.setTransactionDate(date);
        account.setTransactionType(type);
        account.setTransactionAmount(amount);
        boolean success = true;

        try {
            if (type.equals("DEP")) {
                account.deposit();
            } else {
                account.withdrawal();
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            success = false;
        }

        double after = account.getBalance();
        double charges = 0.0;
        if (success) {
            charges = type.equals("DEP")
                ? (before + amount - after)
                : (before - amount - after);
        }

        printTransactionRow(customerId, accountNumber, date, type, amount, charges, after);
    }

    private static void printTransactionHeader() {
        System.out.printf(
            "%-6s %-10s %-12s %-5s %-12s %-12s %-12s\n",
            "Cust", "Account", "Date", "Type", "Amount", "Charges", "Balance"
        );
        System.out.println("===============================================================");
    }

    private static void printTransactionRow(String customerId, String accountNumber, String date,
                                            String type, double amount, double charges, double balance) {
        System.out.printf(
            "%-6s %-10s %-12s %-5s $%-11.2f $%-11.2f $%-11.2f\n",
            customerId, accountNumber, date, type, amount, charges, balance
        );
    }
    
    private static void displayCustomerList(ArrayList<Customer> customers) {
        System.out.println("\n==================== CUSTOMER LIST ====================");
        System.out.printf("%-5s %-9s %-15s %-20s %-20s %-15s %-2s %-5s %-10s\n",
            "ID", "SSN", "First Name", "Last Name", "Street", "City", "ST", "Zip", "Phone"
        );
        System.out.println("========================================================");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
    
    private static void displayCheckingAccountList(ArrayList<CheckingAccount> accounts) {
        System.out.println("\n==================== CHECKING ACCOUNT LIST ====================");
        for (CheckingAccount a : accounts) {
            System.out.println(a);
            System.out.println("--------------------------------------------------------------");
        }
    }

    private static void displaySavingsAccountList(ArrayList<SavingsAccount> accounts) {
        System.out.println("\n==================== SAVINGS ACCOUNT LIST ====================");
        for (SavingsAccount a : accounts) {
            System.out.println(a);
            System.out.println("-------------------------------------------------------------");
        }
    }
}