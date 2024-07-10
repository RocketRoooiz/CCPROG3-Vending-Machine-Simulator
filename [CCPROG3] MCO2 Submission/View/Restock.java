package View;

import Model.VendingMachine;

import javax.swing.*;

public class Restock extends JFrame{
    private JTextField NameInput;
    private JTextField QtyInput;
    private JButton Submit;
    private JPanel RestockFrame;
    private JLabel potatostock;
    private JLabel cheesestock;
    private JLabel gravystock;
    private JLabel baconstock;
    private JLabel bbqstock;
    private JLabel saltstock;
    private JLabel sourcreamstock;
    private JLabel chilistock;
    private JButton exitrestockbtn;

    public Restock()
    {
        setContentPane(RestockFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
    }
    public void modifyText(VendingMachine CurrentM)
    {
        potatostock.setText(Integer.toString(CurrentM.getSlots()[0].size()-1));
        cheesestock.setText(Integer.toString(CurrentM.getSlots()[1].size()-1));
        gravystock.setText(Integer.toString(CurrentM.getSlots()[2].size()-1));
        baconstock.setText(Integer.toString(CurrentM.getSlots()[3].size()-1));
        bbqstock.setText(Integer.toString(CurrentM.getSlots()[4].size()-1));
        saltstock.setText(Integer.toString(CurrentM.getSlots()[5].size()-1));
        sourcreamstock.setText(Integer.toString(CurrentM.getSlots()[6].size()-1));
        chilistock.setText(Integer.toString(CurrentM.getSlots()[7].size()-1));
    }

    public JButton getExitrestockbtn() {
        return exitrestockbtn;
    }

    public JTextField getNameInput() {
        return NameInput;
    }

    public JTextField getQtyInput() {
        return QtyInput;
    }

    public JButton getSubmit() {
        return Submit;
    }

    public JPanel getRestockFrame() {
        return RestockFrame;
    }
}
