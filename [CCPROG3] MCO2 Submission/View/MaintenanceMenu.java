package View;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceMenu extends JFrame{
    private JPanel MaintenanceMenu;
    private JButton editItemPricesButton;
    private JButton replenishMoneyButton;
    private JButton restockItemButton;
    private JButton collectMoneyButton;
    private JButton exitButton;

    public MaintenanceMenu()
    {
        setContentPane(MaintenanceMenu);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

    }

    public JPanel getMaintenanceMenu() {
        return MaintenanceMenu;
    }

    public JButton getEditItemPricesButton() {
        return editItemPricesButton;
    }

    public JButton getReplenishMoneyButton() {
        return replenishMoneyButton;
    }

    public JButton getRestockItemButton() {
        return restockItemButton;
    }

    public JButton getCollectMoneyButton() {
        return collectMoneyButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
