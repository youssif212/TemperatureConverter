import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private JTextField degreeField;
    private JComboBox<String> inputUnit;
    private JComboBox<String> convertUnit;
    private JButton convertButton;
    private TemperatureConverterFrame parent;

    public MainPanel(TemperatureConverterFrame parent) {
        this.parent = parent;
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Enter Temperature");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 20, 10);
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Degree: "), gbc);

        degreeField = new JTextField(10);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(degreeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Input Unit: "), gbc);

        inputUnit = new JComboBox<>(new String[]{"Celsius (°C)", "Fahrenheit (°F)", "Kelvin (K)"});
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(inputUnit, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Convert To: "), gbc);

        convertUnit = new JComboBox<>(new String[]{"Celsius (°C)", "Fahrenheit (°F)", "Kelvin (K)"});
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(convertUnit, gbc);

        convertButton = new JButton("Convert ➜");
        convertButton.setBackground(new Color(0, 128, 128));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);
        convertButton.setFont(new Font("SansSerif", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        add(convertButton, gbc);

        convertButton.addActionListener(e -> {
            String inputText = degreeField.getText();
            String fromUnit = ((String) inputUnit.getSelectedItem()).split(" ")[0];
            String toUnit = ((String) convertUnit.getSelectedItem()).split(" ")[0];

            try {
                double inputValue = Double.parseDouble(inputText);
                double convertedValue = TemperatureUtils.convertTemperature(inputValue, fromUnit, toUnit);
                String resultText = String.format("%.2f %s", convertedValue, toUnit);

                // Convert to Celsius for background color decision
                double celsiusValue = inputValue;
                if (fromUnit.equals("Fahrenheit")) {
                    celsiusValue = (inputValue - 32) * 5 / 9;
                } else if (fromUnit.equals("Kelvin")) {
                    celsiusValue = inputValue - 273.15;
                }

                parent.updateResult(resultText, celsiusValue);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(parent, "Please enter a valid number for the temperature.");
            }
        });
    }
}
