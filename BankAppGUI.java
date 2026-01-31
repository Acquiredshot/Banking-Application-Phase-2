import javax.swing.*;
import java.awt.*;

public class BankAppGUI extends JFrame {
    public BankAppGUI() {
        setTitle("Banking Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Banking Application", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JButton addCustomerBtn = new JButton("Add Customer");
        add(addCustomerBtn, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankAppGUI().setVisible(true);
        });
    }
}
