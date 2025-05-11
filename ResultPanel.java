import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    private JLabel resultLabel;

    public ResultPanel() {
        setBackground(new Color(0, 128, 128));
        setLayout(new GridBagLayout());

        resultLabel = new JLabel("0 °C");
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 40));
        resultLabel.setOpaque(true);
        resultLabel.setBackground(new Color(0, 128, 128));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);


        add(resultLabel);
    }

    public void setBackgroundBasedOnTemp(double celsius) {
        if (celsius < 10) {
            setBackground(new Color(0, 153, 204)); // بارد
            resultLabel.setBackground(new Color(0, 153, 204));
        } else if (celsius > 30) {
            setBackground(new Color(204, 0, 0)); // حر
            resultLabel.setBackground(new Color(204, 0, 0));
        } else {
            setBackground(new Color(0, 128, 128)); // معقول
            resultLabel.setBackground(new Color(0, 128, 128));
        }
    }

    public void setResult(String text) {
        resultLabel.setText(text);
    }
}