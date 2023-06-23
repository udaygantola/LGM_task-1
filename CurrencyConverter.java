import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CurrencyConverter implements ActionListener {

    JFrame j;
    JTextField amountTextField;
    JComboBox<String> fromComboBox, toComboBox;
    JButton convertButton;
    JLabel headingLabel, amountLabel, fromLabel, toLabel, resultLabel;
    String[] currencies = { "USD", "EUR", "GBP", "JPY", "CAD", "AUD", "INR"};
    double[][] rates = {
            { 1.0, 0.91, 0.79, 135.11, 1.34, 1.48, 82.11 },
            { 1.10, 1.0, 0.87, 148.00, 1.47, 1.62, 89.96 },
            { 1.26, 1.13, 1.15, 170.46, 1.69, 1.87, 103.61 },
            { 0.007, 0.006, 0.005, 1.0, 0.009, 0.011, 0.61 },
            { 0.75, 0.68, 0.59, 100.81, 1.0, 1.11, 61.29 },
            { 0.68, 0.62, 0.54, 91.20, 0.90, 1.0, 55.43 },
            { 0.012, 0.011, 0.009, 1.65, 0.016, 0.018, 1.0 }
    };

    public CurrencyConverter() {

        j = new JFrame("Currency Converter");
        j.setSize(600, 300);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);

        headingLabel = new JLabel("Currency Converter ");
        headingLabel.setBounds(160, 20, 280, 40);
        headingLabel.setFont(new Font("Helvetica", Font.BOLD, 26));
        j.add(headingLabel);

        amountLabel = new JLabel("Amount :");
        amountLabel.setBounds(50, 80, 60, 20);
        j.add(amountLabel);

        amountTextField = new JTextField(10);
        amountTextField.setBounds(150, 80, 100, 20);
        j.add(amountTextField);

        fromLabel = new JLabel("From :");
        fromLabel.setBounds(50, 120, 100, 20);
        j.add(fromLabel);

        fromComboBox = new JComboBox<>(currencies);
        fromComboBox.setBounds(150, 120, 100, 20);
        j.add(fromComboBox);

        toLabel = new JLabel("To :");
        toLabel.setBounds(260, 120, 100, 20);
        j.add(toLabel);

        toComboBox = new JComboBox<>(currencies);
        toComboBox.setBounds(350, 120, 100, 20);
        j.add(toComboBox);

        convertButton = new JButton("Convert");
        convertButton.setBounds(230, 170, 100, 20);
        convertButton.addActionListener(this);
        j.add(convertButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(250, 200, 100, 20);
        j.add(resultLabel);
        j.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amountString = amountTextField.getText();
            double amount = Double.parseDouble(amountString);

            int fromIndex = fromComboBox.getSelectedIndex();
            int toIndex = toComboBox.getSelectedIndex();

            double rate = rates[fromIndex][toIndex];
            double result = amount * rate;

            String resultString = String.format("%.2f %s", result, currencies[toIndex]);
            resultLabel.setText(resultString);
        } catch (NumberFormatException ex) {
            System.out.println("error");
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}