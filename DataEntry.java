import java.util.Scanner;

public class DataEntry {

    private static Scanner scanner = new Scanner(System.in);

    // a. String with no limit
    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // b. String with length limit
    public static String getString(String prompt, int maxLength) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.isEmpty() || input.length() > maxLength);
        return input;
    }

    // c. Numeric string only
    public static String getNumericString(String prompt, int length) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (!input.matches("\\d{" + length + "}"));
        return input;
    }

    // d. Integer
    public static int getInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    // e. Integer with range
    public static int getInt(String prompt, int min, int max) {
        int value;
        do {
            value = getInt(prompt);
        } while (value < min || value > max);
        return value;
    }

    // f. Decimal
    public static double getDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal. Try again.");
            }
        }
    }

    // g. Decimal with range
    public static double getDouble(String prompt, double min, double max) {
        double value;
        do {
            value = getDouble(prompt);
        } while (value < min || value > max);
        return value;
    }

    // h. Date (simple string for Phase 1)
    public static String getDate(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
