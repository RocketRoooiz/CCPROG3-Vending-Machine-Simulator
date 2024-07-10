package View;

import Model.VendingMachine;

import javax.swing.*;

public class SetPrice extends JFrame{
    private JButton editPriceButton;
    private JTextField PriceInput;
    private JTextField ItemInput;
    private JPanel PriceFrame;
    private JLabel cheeseprice;
    private JLabel gravyprice;
    private JLabel baconprice;
    private JLabel potatoprice;
    private JLabel bbqprice;
    private JLabel saltprice;
    private JLabel sourcreamprice;
    private JLabel chiliprice;
    private JButton exiteditbtn;

    public SetPrice()
    {
        setContentPane(PriceFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
    }
    public void modifyText(VendingMachine CurrentM)
    {
        potatoprice.setText(Integer.toString(CurrentM.getSlots()[0].get(0).getItemPrice()));
        cheeseprice.setText(Integer.toString(CurrentM.getSlots()[1].get(0).getItemPrice()));
        gravyprice.setText(Integer.toString(CurrentM.getSlots()[2].get(0).getItemPrice()));
        baconprice.setText(Integer.toString(CurrentM.getSlots()[3].get(0).getItemPrice()));
        bbqprice.setText(Integer.toString(CurrentM.getSlots()[4].get(0).getItemPrice()));
        saltprice.setText(Integer.toString(CurrentM.getSlots()[5].get(0).getItemPrice()));
        sourcreamprice.setText(Integer.toString(CurrentM.getSlots()[6].get(0).getItemPrice()));
        chiliprice.setText(Integer.toString(CurrentM.getSlots()[7].get(0).getItemPrice()));
    }
    public JButton getEditPriceButton() {
        return editPriceButton;
    }

    public JButton getExiteditbtn() {
        return exiteditbtn;
    }

    public JTextField getPriceInput() {
        return PriceInput;
    }

    public JTextField getItemInput() {
        return ItemInput;
    }

    public JPanel getPriceFrame() {
        return PriceFrame;
    }
}
