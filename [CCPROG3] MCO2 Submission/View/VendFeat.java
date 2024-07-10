package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendFeat extends JFrame{
    private JPanel VendFeatures;
    private JButton InsertMoneyButton;
    private JButton BuyButton;
    private JButton ExitButton;
    public VendFeat()
    {
        setContentPane(VendFeatures);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

    }

    public JPanel getVendFeatures() {
        return VendFeatures;
    }

    public JButton getInsertMoneyButton() {
        return InsertMoneyButton;
    }

    public JButton getBuyButton() {
        return BuyButton;
    }

    public JButton getExitButton() {
        return ExitButton;
    }
}
