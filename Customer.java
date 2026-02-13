public class Customer {

    private String customerID;
    private String ssn;
    private String lastName;
    private String firstName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    // Getters and Setters with validation
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) throws IllegalArgumentException {
        if (customerID == null || customerID.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be blank.");
        }
        String trimmed = customerID.trim();
        if (trimmed.length() > 5) {
            throw new IllegalArgumentException("Customer ID cannot exceed 5 characters.");
        }
        this.customerID = trimmed;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) throws IllegalArgumentException {
        if (ssn == null || ssn.trim().isEmpty()) {
            throw new IllegalArgumentException("SSN cannot be blank.");
        }
        String trimmed = ssn.trim();  // ✅ Trim first
        if (trimmed.length() != 9) {
            throw new IllegalArgumentException("SSN must be exactly 9 characters.");
        }
        if (!trimmed.matches("\\d{9}")) {
            throw new IllegalArgumentException("SSN must contain only numeric digits.");
        }
        this.ssn = trimmed;  // ✅ Store trimmed
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be blank.");
        }
        String trimmed = lastName.trim();
        if (trimmed.length() > 20) {
            throw new IllegalArgumentException("Last name cannot exceed 20 characters.");
        }
        this.lastName = trimmed;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be blank.");
        }
        String trimmed = firstName.trim();
        if (trimmed.length() > 15) {
            throw new IllegalArgumentException("First name cannot exceed 15 characters.");
        }
        this.firstName = trimmed;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws IllegalArgumentException {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street cannot be blank.");
        }
        String trimmed = street.trim();
        if (trimmed.length() > 20) {
            throw new IllegalArgumentException("Street cannot exceed 20 characters.");
        }
        this.street = trimmed;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws IllegalArgumentException {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be blank.");
        }
        String trimmed = city.trim();
        if (trimmed.length() > 20) {
            throw new IllegalArgumentException("City cannot exceed 20 characters.");
        }
        this.city = trimmed;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) throws IllegalArgumentException {
        if (state == null || state.trim().isEmpty()) {
            throw new IllegalArgumentException("State cannot be blank.");
        }
        String trimmed = state.trim();
        if (trimmed.length() != 2) {
            throw new IllegalArgumentException("State must be exactly 2 characters.");
        }
        this.state = trimmed;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) throws IllegalArgumentException {
        if (zip == null || zip.trim().isEmpty()) {
            throw new IllegalArgumentException("Zip code cannot be blank.");
        }
        String trimmed = zip.trim();
        if (trimmed.length() != 5) {
            throw new IllegalArgumentException("Zip code must be exactly 5 characters.");
        }
        if (!trimmed.matches("\\d{5}")) {
            throw new IllegalArgumentException("Zip code must contain only numeric digits.");
        }
        this.zip = trimmed;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws IllegalArgumentException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be blank.");
        }
        String trimmed = phone.trim();
        if (trimmed.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 characters.");
        }
        if (!trimmed.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must contain only numeric digits.");
        }
        this.phone = trimmed;
    }

    // toString()
    public String toString() {
        return String.format(
            "%-5s %-9s %-15s %-20s %-20s %-15s %-2s %-5s %-10s",
            customerID, ssn, firstName, lastName, street, city, state, zip, phone
        );
    }
}
