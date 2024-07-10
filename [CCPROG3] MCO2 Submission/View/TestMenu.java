package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestMenu extends JFrame{
    private JButton vendingFeaturesButton;
    private JButton maintenanceFeaturesButton;
    private JButton exitButton;
    private JPanel TestFrame;

    public TestMenu()
    {
        setContentPane(TestFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

    }

    public JButton getVendingFeaturesButton() {
        return vendingFeaturesButton;
    }

    public JButton getMaintenanceFeaturesButton() {
        return maintenanceFeaturesButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JPanel getTestFrame() {
        return TestFrame;
    }
}
