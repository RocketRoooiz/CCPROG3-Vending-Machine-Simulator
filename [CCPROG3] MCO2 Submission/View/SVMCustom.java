package View;

import Model.VendingMachine;

import javax.swing.*;

public class SVMCustom extends JFrame{
    private JTextField potatoAmt;
    private JLabel potatoqty;
    private JLabel cheeseqty;
    private JLabel gravyqty;
    private JLabel baconqty;
    private JLabel potatoprice;
    private JLabel cheeseprice;
    private JLabel gravyprice;
    private JLabel baconprice;
    private JLabel potatocal;
    private JLabel cheesecal;
    private JLabel gravycal;
    private JLabel baconcal;
    private JLabel bbqqty;
    private JLabel bbqprice;
    private JLabel bbqcal;
    private JLabel saltqty;
    private JLabel saltprice;
    private JLabel saltcal;
    private JLabel scqty;
    private JLabel scprice;
    private JLabel sccal;
    private JLabel chiliqty;
    private JLabel chiliprice;
    private JLabel chilical;
    private JButton confirmCustomOrderButton;
    private JLabel MoneyDisplay1;
    private JLabel MoneyDisplay2;
    private JPanel SVMCFrame;
    private JTextField cheeseAmt;
    private JTextField gravyAmt;
    private JTextField baconAmt;
    private JTextField bbqAmt;
    private JTextField saltAmt;
    private JTextField scAmt;
    private JTextField chiliAmt;
    private JButton exitcustombtn;
    private JLabel loadedfriesprice;
    private JLabel cheesybaconfriesprice;
    private JLabel mashedprice;
    private JLabel poutineprice;
    private JLabel nuclearbbqprice;
    private JButton buypremadebtn;
    private JTextField premadetxtfield;

    public void modifyTexts(VendingMachine CurrentM)
    {
        potatoqty.setText(Integer.toString(CurrentM.getSlots()[0].size()-1));
        cheeseqty.setText(Integer.toString(CurrentM.getSlots()[1].size()-1));
        gravyqty.setText(Integer.toString(CurrentM.getSlots()[2].size()-1));
        baconqty.setText(Integer.toString(CurrentM.getSlots()[3].size()-1));
        bbqqty.setText(Integer.toString(CurrentM.getSlots()[4].size()-1));
        saltqty.setText(Integer.toString(CurrentM.getSlots()[5].size()-1));
        scqty.setText(Integer.toString(CurrentM.getSlots()[6].size()-1));
        chiliqty.setText(Integer.toString(CurrentM.getSlots()[7].size()-1));

        potatoprice.setText(Integer.toString(CurrentM.getSlots()[0].get(0).getItemPrice()));
        cheeseprice.setText(Integer.toString(CurrentM.getSlots()[1].get(0).getItemPrice()));
        gravyprice.setText(Integer.toString(CurrentM.getSlots()[2].get(0).getItemPrice()));
        baconprice.setText(Integer.toString(CurrentM.getSlots()[3].get(0).getItemPrice()));
        bbqprice.setText(Integer.toString(CurrentM.getSlots()[4].get(0).getItemPrice()));
        saltprice.setText(Integer.toString(CurrentM.getSlots()[5].get(0).getItemPrice()));
        scprice.setText(Integer.toString(CurrentM.getSlots()[6].get(0).getItemPrice()));
        chiliprice.setText(Integer.toString(CurrentM.getSlots()[7].get(0).getItemPrice()));

        potatocal.setText(Integer.toString(CurrentM.getSlots()[0].get(0).getItemCal()));
        cheesecal.setText(Integer.toString(CurrentM.getSlots()[1].get(0).getItemCal()));
        gravycal.setText(Integer.toString(CurrentM.getSlots()[2].get(0).getItemCal()));
        baconcal.setText(Integer.toString(CurrentM.getSlots()[3].get(0).getItemCal()));
        bbqcal.setText(Integer.toString(CurrentM.getSlots()[4].get(0).getItemCal()));
        saltcal.setText(Integer.toString(CurrentM.getSlots()[5].get(0).getItemCal()));
        sccal.setText(Integer.toString(CurrentM.getSlots()[6].get(0).getItemCal()));
        chilical.setText(Integer.toString(CurrentM.getSlots()[7].get(0).getItemCal()));
    }

    public void setPremadePrice(VendingMachine CurrentM)
    {
        int premadeprice[] = new int[5];
        // loaded fries - poutine - cheesy bacon fries - nuclear bbq fries - mashed potato
        premadeprice[0] = CurrentM.getSlots()[0].get(0).getItemPrice() + CurrentM.getSlots()[1].get(0).getItemPrice() +
                CurrentM.getSlots()[3].get(0).getItemPrice() + CurrentM.getSlots()[5].get(0).getItemPrice() +
                CurrentM.getSlots()[6].get(0).getItemPrice() + CurrentM.getSlots()[7].get(0).getItemPrice();
        premadeprice[1] = CurrentM.getSlots()[0].get(0).getItemPrice() + CurrentM.getSlots()[1].get(0).getItemPrice() +
                CurrentM.getSlots()[2].get(0).getItemPrice() + CurrentM.getSlots()[5].get(0).getItemPrice();
        premadeprice[2] = CurrentM.getSlots()[0].get(0).getItemPrice() + CurrentM.getSlots()[1].get(0).getItemPrice() +
                CurrentM.getSlots()[3].get(0).getItemPrice() + CurrentM.getSlots()[5].get(0).getItemPrice();
        premadeprice[3] = CurrentM.getSlots()[0].get(0).getItemPrice() + CurrentM.getSlots()[4].get(0).getItemPrice() +
                CurrentM.getSlots()[7].get(0).getItemPrice() * 5 + CurrentM.getSlots()[5].get(0).getItemPrice();
        premadeprice[4] = CurrentM.getSlots()[0].get(0).getItemPrice() + CurrentM.getSlots()[1].get(0).getItemPrice() +
                CurrentM.getSlots()[2].get(0).getItemPrice();

        loadedfriesprice.setText(Integer.toString(premadeprice[0]));
        poutineprice.setText(Integer.toString(premadeprice[1]));
        cheesybaconfriesprice.setText(Integer.toString(premadeprice[2]));
        nuclearbbqprice.setText(Integer.toString(premadeprice[3]));
        mashedprice.setText(Integer.toString(premadeprice[4]));
    }

    public JTextField getPremadetxtfield() {
        return premadetxtfield;
    }

    public JButton getBuypremadebtn() {
        return buypremadebtn;
    }

    public JLabel getPotatoqty() {
        return potatoqty;
    }

    public JLabel getCheeseqty() {
        return cheeseqty;
    }

    public JLabel getGravyqty() {
        return gravyqty;
    }

    public JLabel getBaconqty() {
        return baconqty;
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

    public JLabel getPotatocal() {
        return potatocal;
    }

    public JLabel getCheesecal() {
        return cheesecal;
    }

    public JLabel getGravycal() {
        return gravycal;
    }

    public JLabel getBaconcal() {
        return baconcal;
    }

    public JLabel getBbqqty() {
        return bbqqty;
    }

    public JLabel getBbqprice() {
        return bbqprice;
    }

    public JLabel getBbqcal() {
        return bbqcal;
    }

    public JLabel getSaltqty() {
        return saltqty;
    }

    public JLabel getSaltprice() {
        return saltprice;
    }

    public JLabel getSaltcal() {
        return saltcal;
    }

    public JLabel getScqty() {
        return scqty;
    }

    public JLabel getScprice() {
        return scprice;
    }

    public JLabel getSccal() {
        return sccal;
    }

    public JLabel getChiliqty() {
        return chiliqty;
    }

    public JLabel getChiliprice() {
        return chiliprice;
    }

    public JLabel getChilical() {
        return chilical;
    }

    public JLabel getMoneyDisplay1() {
        return MoneyDisplay1;
    }

    public JLabel getMoneyDisplay2() {
        return MoneyDisplay2;
    }

    public JTextField getPotatoAmt() {
        return potatoAmt;
    }

    public JButton getConfirmCustomOrderButton() {
        return confirmCustomOrderButton;
    }

    public JTextField getCheeseAmt() {
        return cheeseAmt;
    }

    public JTextField getGravyAmt() {
        return gravyAmt;
    }

    public JTextField getBaconAmt() {
        return baconAmt;
    }

    public JTextField getBbqAmt() {
        return bbqAmt;
    }

    public JTextField getSaltAmt() {
        return saltAmt;
    }

    public JTextField getScAmt() {
        return scAmt;
    }

    public JTextField getChiliAmt() {
        return chiliAmt;
    }

    public JButton getExitcustombtn() {
        return exitcustombtn;
    }

    public SVMCustom()
    {
        setContentPane(SVMCFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

    }
}
