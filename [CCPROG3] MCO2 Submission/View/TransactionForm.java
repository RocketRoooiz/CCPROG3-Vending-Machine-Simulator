package View;

import Model.VendingMachine;

import javax.swing.*;
public class TransactionForm extends JFrame{
    private JPanel TransForm;
    private JButton closeButton;
    private JLabel potatoprice;
    private JLabel cheeseprice;
    private JLabel gravyprice;
    private JLabel baconprice;
    private JLabel bbqprice;
    private JLabel saltprice;
    private JLabel sourcreamprice;
    private JLabel chiliprice;
    private JLabel potatostartinv;
    private JLabel cheesestartinv;
    private JLabel gravystartinv;
    private JLabel baconstartinv;
    private JLabel bbqstartinv;
    private JLabel saltstartinv;
    private JLabel sourcreamstartinv;
    private JLabel chilistartinv;
    private JLabel potatoendinv;
    private JLabel cheeseendinv;
    private JLabel gravyendinv;
    private JLabel baconendinv;
    private JLabel bbqendinv;
    private JLabel saltendinv;
    private JLabel sourcreamendinv;
    private JLabel chiliendinv;
    private JLabel potatosold;
    private JLabel cheesesold;
    private JLabel gravysold;
    private JLabel baconsold;
    private JLabel bbqsold;
    private JLabel saltsold;
    private JLabel sourcreamsold;
    private JLabel chilisold;

    public JPanel getTransForm() {
        return TransForm;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public JLabel getPotatoprice() {
        return potatoprice;
    }

    public JLabel getCheeseprice() {
        return cheeseprice;
    }

    public JLabel getGravyprice() {
        return gravyprice;
    }

    public JLabel getBaconprice() {
        return baconprice;
    }

    public JLabel getBbqprice() {
        return bbqprice;
    }

    public JLabel getSaltprice() {
        return saltprice;
    }

    public JLabel getSourcreamprice() {
        return sourcreamprice;
    }

    public JLabel getChiliprice() {
        return chiliprice;
    }

    public JLabel getPotatostartinv() {
        return potatostartinv;
    }

    public JLabel getCheesestartinv() {
        return cheesestartinv;
    }

    public JLabel getGravystartinv() {
        return gravystartinv;
    }

    public JLabel getBaconstartinv() {
        return baconstartinv;
    }

    public JLabel getBbqstartinv() {
        return bbqstartinv;
    }

    public JLabel getSaltstartinv() {
        return saltstartinv;
    }

    public JLabel getSourcreamstartinv() {
        return sourcreamstartinv;
    }

    public JLabel getChilistartinv() {
        return chilistartinv;
    }

    public JLabel getPotatoendinv() {
        return potatoendinv;
    }

    public JLabel getCheeseendinv() {
        return cheeseendinv;
    }

    public JLabel getGravyendinv() {
        return gravyendinv;
    }

    public JLabel getBaconendinv() {
        return baconendinv;
    }

    public JLabel getBbqendinv() {
        return bbqendinv;
    }

    public JLabel getSaltendinv() {
        return saltendinv;
    }

    public JLabel getSourcreamendinv() {
        return sourcreamendinv;
    }

    public JLabel getChiliendinv() {
        return chiliendinv;
    }

    public JLabel getPotatosold() {
        return potatosold;
    }

    public JLabel getCheesesold() {
        return cheesesold;
    }

    public JLabel getGravysold() {
        return gravysold;
    }

    public JLabel getBaconsold() {
        return baconsold;
    }

    public JLabel getBbqsold() {
        return bbqsold;
    }

    public JLabel getSaltsold() {
        return saltsold;
    }

    public JLabel getSourcreamsold() {
        return sourcreamsold;
    }

    public JLabel getChilisold() {
        return chilisold;
    }

    public TransactionForm()
    {
        setContentPane(TransForm);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 520);
        setLocationRelativeTo(null);
    }
    public void modifyTexts(VendingMachine CurrentM)
    {
        potatoprice.setText(Integer.toString(CurrentM.getSlots()[0].get(0).getItemPrice()));
        cheeseprice.setText(Integer.toString(CurrentM.getSlots()[1].get(0).getItemPrice()));
        gravyprice.setText(Integer.toString(CurrentM.getSlots()[2].get(0).getItemPrice()));
        baconprice.setText(Integer.toString(CurrentM.getSlots()[3].get(0).getItemPrice()));
        bbqprice.setText(Integer.toString(CurrentM.getSlots()[4].get(0).getItemPrice()));
        saltprice.setText(Integer.toString(CurrentM.getSlots()[5].get(0).getItemPrice()));
        sourcreamprice.setText(Integer.toString(CurrentM.getSlots()[6].get(0).getItemPrice()));
        chiliprice.setText(Integer.toString(CurrentM.getSlots()[7].get(0).getItemPrice()));

        potatostartinv.setText(Integer.toString(CurrentM.getSlots()[0].size()-1+CurrentM.getHistory()[0]));
        cheesestartinv.setText(Integer.toString(CurrentM.getSlots()[1].size()-1+CurrentM.getHistory()[1]));
        gravystartinv.setText(Integer.toString(CurrentM.getSlots()[2].size()-1+CurrentM.getHistory()[2]));
        baconstartinv.setText(Integer.toString(CurrentM.getSlots()[3].size()-1+CurrentM.getHistory()[3]));
        bbqstartinv.setText(Integer.toString(CurrentM.getSlots()[4].size()-1+CurrentM.getHistory()[4]));
        saltstartinv.setText(Integer.toString(CurrentM.getSlots()[5].size()-1+CurrentM.getHistory()[5]));
        sourcreamstartinv.setText(Integer.toString(CurrentM.getSlots()[6].size()-1+CurrentM.getHistory()[6]));
        chilistartinv.setText(Integer.toString(CurrentM.getSlots()[7].size()-1+CurrentM.getHistory()[7]));

        potatoendinv.setText(Integer.toString(CurrentM.getSlots()[0].size()-1));
        cheeseendinv.setText(Integer.toString(CurrentM.getSlots()[1].size()-1));
        gravyendinv.setText(Integer.toString(CurrentM.getSlots()[2].size()-1));
        baconendinv.setText(Integer.toString(CurrentM.getSlots()[3].size()-1));
        bbqendinv.setText(Integer.toString(CurrentM.getSlots()[4].size()-1));
        saltendinv.setText(Integer.toString(CurrentM.getSlots()[5].size()-1));
        sourcreamendinv.setText(Integer.toString(CurrentM.getSlots()[6].size()-1));
        chiliendinv.setText(Integer.toString(CurrentM.getSlots()[7].size()-1));

        potatosold.setText(Integer.toString(CurrentM.getHistory()[0]));
        cheesesold.setText(Integer.toString(CurrentM.getHistory()[1]));
        gravysold.setText(Integer.toString(CurrentM.getHistory()[2]));
        baconsold.setText(Integer.toString(CurrentM.getHistory()[3]));
        bbqsold.setText(Integer.toString(CurrentM.getHistory()[4]));
        saltsold.setText(Integer.toString(CurrentM.getHistory()[5]));
        sourcreamsold.setText(Integer.toString(CurrentM.getHistory()[6]));
        chilisold.setText(Integer.toString(CurrentM.getHistory()[7]));
    }
}
