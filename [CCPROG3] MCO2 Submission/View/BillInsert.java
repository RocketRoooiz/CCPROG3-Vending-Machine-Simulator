package View;

import javax.swing.*;

public class BillInsert extends JFrame{
    private JTextField money1;
    private JTextField money1000;
    private JTextField money200;
    private JTextField money50;
    private JTextField money10;
    private JTextField money5;
    private JTextField money20;
    private JTextField money100;
    private JTextField money500;
    private JButton insertbutton;
    private JPanel BillForm;
    private JLabel MoneyDisplay1;
    private JLabel MoneyDisplay2;

    public JPanel getBillForm() {
        return BillForm;
    }

    public JTextField getMoney1() {
        return money1;
    }

    public JTextField getMoney1000() {
        return money1000;
    }

    public JTextField getMoney200() {
        return money200;
    }

    public JTextField getMoney50() {
        return money50;
    }

    public JTextField getMoney10() {
        return money10;
    }

    public JTextField getMoney5() {
        return money5;
    }

    public JTextField getMoney20() {
        return money20;
    }

    public JTextField getMoney100() {
        return money100;
    }

    public JTextField getMoney500() {
        return money500;
    }

    public JButton getInsertbutton() {
        return insertbutton;
    }

    public BillInsert()
    {
        setContentPane(BillForm);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 500);
        setLocationRelativeTo(null);
        setVisible(false);

    }

    public JLabel getMoneyDisplay1() {
        return MoneyDisplay1;
    }

    public void setMoneyDisplay1(JLabel moneyDisplay1) {
        MoneyDisplay1 = moneyDisplay1;
    }

    public JLabel getMoneyDisplay2() {
        return MoneyDisplay2;
    }

    public void setMoneyDisplay2(JLabel moneyDisplay2) {
        MoneyDisplay2 = moneyDisplay2;
    }
}
