package View;

import Model.VendingMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyMenu extends JFrame{
    private JPanel BuyFrame;
    private JLabel potatoQty;
    private JLabel baconQty;
    private JLabel sourcreamQty;
    private JLabel cheeseQty;
    private JLabel bbqpowderQty;
    private JLabel chilipowderQty;
    private JLabel gravyQty;
    private JLabel saltQty;
    private JTextField slotTextField;
    private JTextField QtyTextField;
    private JButton buyButton;
    private JLabel potatoPrice;
    private JLabel baconPrice;
    private JLabel sourcreamPrice;
    private JLabel cheesePrice;
    private JLabel bbqpowderPrice;
    private JLabel chilipowderPrice;
    private JLabel gravyPrice;
    private JLabel saltPrice;
    private JLabel MoneyDisplay1;
    private JLabel MoneyDisplay2;
    private JButton exitbuybutton;
    private JLabel potatoCal;
    private JLabel baconCal;
    private JLabel sourcreamCal;
    private JLabel cheeseCal;
    private JLabel bbqpowderCal;
    private JLabel chiliCal;
    private JLabel gravyCal;
    private JLabel saltCal;

    public void modifyTexts(VendingMachine CurrentM)
    {
        potatoQty.setText(Integer.toString(CurrentM.getSlots()[0].size()-1));
        cheeseQty.setText(Integer.toString(CurrentM.getSlots()[1].size()-1));
        gravyQty.setText(Integer.toString(CurrentM.getSlots()[2].size()-1));
        baconQty.setText(Integer.toString(CurrentM.getSlots()[3].size()-1));
        bbqpowderQty.setText(Integer.toString(CurrentM.getSlots()[4].size()-1));
        saltQty.setText(Integer.toString(CurrentM.getSlots()[5].size()-1));
        sourcreamQty.setText(Integer.toString(CurrentM.getSlots()[6].size()-1));
        chilipowderQty.setText(Integer.toString(CurrentM.getSlots()[7].size()-1));

        potatoPrice.setText(Integer.toString(CurrentM.getSlots()[0].get(0).getItemPrice()));
        cheesePrice.setText(Integer.toString(CurrentM.getSlots()[1].get(0).getItemPrice()));
        gravyPrice.setText(Integer.toString(CurrentM.getSlots()[2].get(0).getItemPrice()));
        baconPrice.setText(Integer.toString(CurrentM.getSlots()[3].get(0).getItemPrice()));
        bbqpowderPrice.setText(Integer.toString(CurrentM.getSlots()[4].get(4).getItemPrice()));
        saltPrice.setText(Integer.toString(CurrentM.getSlots()[5].get(0).getItemPrice()));
        sourcreamPrice.setText(Integer.toString(CurrentM.getSlots()[6].get(0).getItemPrice()));
        chilipowderPrice.setText(Integer.toString(CurrentM.getSlots()[7].get(0).getItemPrice()));

        potatoCal.setText(Integer.toString(CurrentM.getSlots()[0].get(0).getItemCal()));
        cheeseCal.setText(Integer.toString(CurrentM.getSlots()[1].get(0).getItemCal()));
        gravyCal.setText(Integer.toString(CurrentM.getSlots()[2].get(0).getItemCal()));
        baconCal.setText(Integer.toString(CurrentM.getSlots()[3].get(0).getItemCal()));
        bbqpowderCal.setText(Integer.toString(CurrentM.getSlots()[4].get(4).getItemCal()));
        saltCal.setText(Integer.toString(CurrentM.getSlots()[5].get(0).getItemCal()));
        sourcreamCal.setText(Integer.toString(CurrentM.getSlots()[6].get(0).getItemCal()));
        chiliCal.setText(Integer.toString(CurrentM.getSlots()[7].get(0).getItemCal()));
    }

    public JPanel getBuyFrame() {
        return BuyFrame;
    }

    public JTextField getSlotTextField() {
        return slotTextField;
    }

    public JTextField getQtyTextField() {
        return QtyTextField;
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public void setBuyFrame(JPanel buyFrame) {
        BuyFrame = buyFrame;
    }

    public JLabel getPotatoQty() {
        return potatoQty;
    }

    public JLabel getBaconQty() {
        return baconQty;
    }

    public JLabel getSourcreamQty() {
        return sourcreamQty;
    }

    public JLabel getCheeseQty() {
        return cheeseQty;
    }

    public JLabel getBbqpowderQty() {
        return bbqpowderQty;
    }

    public JLabel getChilipowderQty() {
        return chilipowderQty;
    }

    public JLabel getGravyQty() {
        return gravyQty;
    }

    public JLabel getSaltQty() {
        return saltQty;
    }

    public void setPotatoQty(JLabel potatoQty) {
        this.potatoQty = potatoQty;
    }

    public void setBaconQty(JLabel baconQty) {
        this.baconQty = baconQty;
    }

    public void setSourcreamQty(JLabel sourcreamQty) {
        this.sourcreamQty = sourcreamQty;
    }

    public void setCheeseQty(JLabel cheeseQty) {
        this.cheeseQty = cheeseQty;
    }

    public void setBbqpowderQty(JLabel bbqpowderQty) {
        this.bbqpowderQty = bbqpowderQty;
    }

    public void setChilipowderQty(JLabel chilipowderQty) {
        this.chilipowderQty = chilipowderQty;
    }

    public void setGravyQty(JLabel gravyQty) {
        this.gravyQty = gravyQty;
    }

    public void setSaltQty(JLabel saltQty) {
        this.saltQty = saltQty;
    }

    public JLabel getPotatoPrice() {
        return potatoPrice;
    }

    public void setPotatoPrice(JLabel potatoPrice) {
        this.potatoPrice = potatoPrice;
    }

    public JLabel getBaconPrice() {
        return baconPrice;
    }

    public void setBaconPrice(JLabel baconPrice) {
        this.baconPrice = baconPrice;
    }

    public JLabel getSourcreamPrice() {
        return sourcreamPrice;
    }

    public void setSourcreamPrice(JLabel sourcreamPrice) {
        this.sourcreamPrice = sourcreamPrice;
    }

    public JLabel getCheesePrice() {
        return cheesePrice;
    }

    public void setCheesePrice(JLabel cheesePrice) {
        this.cheesePrice = cheesePrice;
    }

    public JLabel getBbqpowderPrice() {
        return bbqpowderPrice;
    }

    public void setBbqpowderPrice(JLabel bbqpowderPrice) {
        this.bbqpowderPrice = bbqpowderPrice;
    }

    public JLabel getChilipowderPrice() {
        return chilipowderPrice;
    }

    public void setChilipowderPrice(JLabel chilipowderPrice) {
        this.chilipowderPrice = chilipowderPrice;
    }

    public JLabel getGravyPrice() {
        return gravyPrice;
    }

    public void setGravyPrice(JLabel gravyPrice) {
        this.gravyPrice = gravyPrice;
    }

    public JLabel getSaltPrice() {
        return saltPrice;
    }

    public void setSaltPrice(JLabel saltPrice) {
        this.saltPrice = saltPrice;
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

    public JButton getExitbuybutton() {
        return exitbuybutton;
    }

    public JLabel getPotatoCal() {
        return potatoCal;
    }

    public JLabel getBaconCal() {
        return baconCal;
    }

    public JLabel getSourcreamCal() {
        return sourcreamCal;
    }

    public JLabel getCheeseCal() {
        return cheeseCal;
    }

    public JLabel getBbqpowderCal() {
        return bbqpowderCal;
    }

    public JLabel getChiliCal() {
        return chiliCal;
    }

    public JLabel getGravyCal() {
        return gravyCal;
    }

    public JLabel getSaltCal() {
        return saltCal;
    }


    public BuyMenu()
    {
        setContentPane(BuyFrame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);

    }

}
