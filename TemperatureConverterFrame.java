import javax.swing.*;

public class TemperatureConverterFrame extends JFrame {

    private MainPanel mainPanel;
    private ResultPanel resultPanel;

    public TemperatureConverterFrame() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //عشان يبقا الفريم فالنص
        setSize(700, 300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setResizable(false);

        resultPanel = new ResultPanel();
        mainPanel = new MainPanel(this);

        add(mainPanel);
        add(resultPanel);

        setVisible(true);
    }

    public void updateResult(String result, double celsiusValue) {
        resultPanel.setResult(result);
        resultPanel.setBackgroundBasedOnTemp(celsiusValue);
    }
}