import java.util.ArrayList;
public class BankAcctApp {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        String choice;

        do {
            Customer c = new Customer();

            c.setCustomerID(DataEntry.getString("Enter Customer ID (max 5): ", 5));
            c.setSsn(DataEntry.getNumericString("Enter SSN (9 digits): ", 9));
            c.setLastName(DataEntry.getString("Enter Last Name (max 20): ", 20));
            c.setFirstName(DataEntry.getString("Enter First Name (max 15): ", 15));
            c.setStreet(DataEntry.getString("Enter Street (max 20): ", 20));
            c.setCity(DataEntry.getString("Enter City (max 20): ", 20));
            c.setState(DataEntry.getString("Enter State (2 letters): ", 2));
            c.setZip(DataEntry.getNumericString("Enter Zip (5 digits): ", 5));
            c.setPhone(DataEntry.getNumericString("Enter Phone (10 digits): ", 10));

            customers.add(c);

            choice = DataEntry.getString("Add another customer? (y/n): ", 1);

        } while (choice.equalsIgnoreCase("Y"));

        // Output
        System.out.println("\nCustomer List");
        System.out.println("==============");
        System.out.printf("%-5s %-9s %-15s %-20s %-20s %-15s %-2s %-5s %-10s\n",
            "ID", "SSN", "First Name", "Last Name", "Street", "City", "ST", "Zip", "Phone"
        );
        System.out.println("-------------------------------------------------------------------------------");

        for (Customer c : customers) {
            System.out.println(c);
        }
    }    
}