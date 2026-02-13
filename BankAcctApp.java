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
        ArrayList<Account> accounts = new ArrayList<>();
        String continueChoice;

        do {
            final Customer currentCustomer = new Customer();
            final Account currentAccount = new Account();

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
            
            collectInputWithRetry(() -> {
                String acctNum = DataEntry.getString("Enter Account Number (max 5): ", 5);
                currentAccount.setAccountNumber(acctNum);
            });
            
            collectInputWithRetry(() -> {
                String acctType = DataEntry.getString("Enter Account Type (CHK or SAV): ", 3).toUpperCase();
                currentAccount.setAccountType(acctType);
            });
            
            collectInputWithRetry(() -> {
                double fee = DataEntry.getDouble("Enter Service Fee (0.00 to 10.00): ", 0.0, 10.0);
                currentAccount.setServiceFee(fee);
            });
            
            collectInputWithRetry(() -> {
                double rate = DataEntry.getDouble("Enter Interest Rate (0.0 to 10.0 percent): ", 0.0, 10.0);
                currentAccount.setInterestRate(rate);
            });
            
            collectInputWithRetry(() -> {
                double odFee = DataEntry.getDouble("Enter Overdraft Fee: ");
                if (odFee < 0) {
                    throw new IllegalArgumentException("Overdraft fee cannot be negative.");
                }
                currentAccount.setOverdraftFee(odFee);
            });
            
            collectInputWithRetry(() -> {
                double bal = DataEntry.getDouble("Enter Initial Balance: ");
                currentAccount.setBalance(bal);
            });

            customers.add(currentCustomer);
            accounts.add(currentAccount);

            continueChoice = DataEntry.getString("\nAdd another customer/account? (y/n): ", 1);

        } while (continueChoice.equalsIgnoreCase("Y"));

        // Display Results
        displayCustomerList(customers);
        displayAccountList(accounts);
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
    
    private static void displayAccountList(ArrayList<Account> accounts) {
        System.out.println("\n==================== ACCOUNT LIST ====================");
        for (Account a : accounts) {
            System.out.println(a);
            System.out.println("------------------------------------------------------");
        }
    }
}