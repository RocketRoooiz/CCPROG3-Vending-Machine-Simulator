package Controller;

import Model.BankNotes;
import Model.Items;
import Model.SpecialVM;
import Model.VendingMachine;
import View.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Driver class that facilitates the simulation of the transactions between
 * the user and operator and the vending machine. It allows the user to create one and test
 * all its functions and capabilities by accessing the other classes through
 * their instances. It functions as that initiator of all the methods found
 * in each of the classes
 */

public class Controller {

    private int nChoice;
    private VendingMachine CurrentM;
    private BankNotes userMoney;
    private CreateMachine CMFrame;
    private TestMenu TMFrame;
    private BuyMenu BMFrame;
    private MainMenu MFrame;
    private BillInsert BInsert;
    private MaintenanceMenu MMFrame;
    private Restock RSFrame;
    private SetPrice SPFrame;
    private VendFeat VFFrame;
    private SVMCustom SVMCFrame;
    private TransactionForm TransForm;
    private boolean specialCheck;

    /**
     * Initiates an instance of the Model.VendingMachine class as well as
     * fill up its slots with predefined items. Whether it is a regular or
     * special variant that can curate products is chosen by the user
     *
     * @param CurrentM is the vending machine to be created
     * @return the vending machine that is created
     */
    public VendingMachine CreateVM(VendingMachine CurrentM) {

        BankNotes insert = AddMoneytoSystem();
        //Determines what type of vending machine is created
        if(nChoice == 1) {
            specialCheck = false;
            CurrentM = new VendingMachine(insert);
        }
        else if(nChoice == 5) {
            CurrentM = new SpecialVM(insert);
            specialCheck = true;
        }

        //initializes the items to be added in the vending machine
        Items Potato = new Items("Potato", 20,  100);
        Items Cheese = new Items("Cheese", 50,  20);
        Items Gravy = new Items("Gravy", 10,  27);
        Items Bacon = new Items("Bacon", 70,  45);
        Items BBQPowder = new Items("BBQ Powder", 8,  7);
        Items Salt = new Items("Salt", 3,  0);
        Items SourCream = new Items("Sour Cream", 15,  50);
        Items Chili = new Items("Chili", 10,  8);
        CurrentM.addItem(Potato, 0, 10);
        CurrentM.addItem(Cheese, 1, 10);
        CurrentM.addItem(Gravy, 2, 10);
        CurrentM.addItem(Bacon, 3, 10);
        CurrentM.addItem(BBQPowder, 4, 10);
        CurrentM.addItem(Salt, 5, 10);
        CurrentM.addItem(SourCream, 6, 10);
        CurrentM.addItem(Chili, 7, 10);
        CurrentM.initializeHistory();

        return CurrentM;
    }

    /**
     * AddMoneytoSystem is the method that allows the user to input
     * denominations in the vending machine, increasing the amount
     * of money it possesses
     *
     * @return the money to be added to the machine
     */
    public BankNotes AddMoneytoSystem() {
        int add1, add5, add10, add20, add50, add100, add200, add500, add1000;
        BankNotes AddNotes = new BankNotes();

        // Takes money input from BillInsert form.
        // If no input (text field is left blank), then sets it to 0.
        try {
            if (!BInsert.getMoney1().getText().equals(""))
                add1 = Integer.parseInt(BInsert.getMoney1().getText());
            else
                add1 = 0;

            if (!BInsert.getMoney5().getText().equals(""))
                add5 = Integer.parseInt(BInsert.getMoney5().getText());
            else
                add5 = 0;

            if (!BInsert.getMoney10().getText().equals(""))
                add10 = Integer.parseInt(BInsert.getMoney10().getText());
            else
                add10 = 0;

            if (!BInsert.getMoney20().getText().equals(""))
                add20 = Integer.parseInt(BInsert.getMoney20().getText());
            else
                add20 = 0;

            if (!BInsert.getMoney50().getText().equals(""))
                add50 = Integer.parseInt(BInsert.getMoney50().getText());
            else
                add50 = 0;

            if (!BInsert.getMoney100().getText().equals(""))
                add100 = Integer.parseInt(BInsert.getMoney100().getText());
            else
                add100 = 0;

            if (!BInsert.getMoney200().getText().equals(""))
                add200 = Integer.parseInt(BInsert.getMoney200().getText());
            else
                add200 = 0;

            if (!BInsert.getMoney500().getText().equals(""))
                add500 = Integer.parseInt(BInsert.getMoney500().getText());
            else
                add500 = 0;

            if (!BInsert.getMoney1000().getText().equals(""))
                add1000 = Integer.parseInt(BInsert.getMoney1000().getText());
            else
                add1000 = 0;

            // Reset text field inputs
            BInsert.getMoney1().setText("");
            BInsert.getMoney5().setText("");
            BInsert.getMoney10().setText("");
            BInsert.getMoney20().setText("");
            BInsert.getMoney50().setText("");
            BInsert.getMoney100().setText("");
            BInsert.getMoney200().setText("");
            BInsert.getMoney500().setText("");
            BInsert.getMoney1000().setText("");

            // For detecting if there's a negative value.
            if (add1 < 0 || add5 < 0 || add10 < 0 || add20 < 0 || add50 < 0 || add100 < 0 || add200 < 0 || add500 < 0 || add1000 < 0) {
                JOptionPane.showMessageDialog(null, "Invalid value detected! Setting all inputs to 0", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            // If valid, saves input in a Model.BankNotes class used for transactions
            else {
                AddNotes = new BankNotes(add1, add5, add10, add20, add50, add100, add200, add500, add1000);
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }

        return AddNotes;
    }

    /**
     * updateTransFile is the method that appends new transaction history
     * into the "TransactionHistory.txt" file every time it gets called.
     * @param CurrentM is the vending machine to be created
     */
    public void updateTransFile(VendingMachine CurrentM)
    {
        File f = new File("TransactionHistory.txt");

        try{
            FileOutputStream fout = new FileOutputStream(f, true);
            PrintWriter Writer = new PrintWriter(fout);
            Writer.write("----- Transaction History -----");
            for(int i = 0; i < CurrentM.getSlots().length; i++) {
                Writer.write("\nItem Name: " + CurrentM.getSlots()[i].get(0).getitemName());
                Writer.write("\nPrice: P" + CurrentM.getSlots()[i].get(0).getItemPrice());
                Writer.write("\nStarting Inv.: " + (CurrentM.getSlots()[i].size() - 1 + CurrentM.getHistory()[i]));
                Writer.write("\nEnding Inv.: " + (CurrentM.getSlots()[i].size() - 1));
                Writer.write("\nSold: " + CurrentM.getHistory()[i]);
                Writer.write("\n-------------------------------");
            }
            Writer.write("\nSpecial Products: \n" + CurrentM.getAllProducts());
            Writer.write("\nTransaction Total: " + CurrentM.getHistory()[CurrentM.getSlots().length]);
            Writer.write("\n-------------------------------\n\n");
            Writer.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * stockManage is the method that allows user to increase an
     * item's stock via the methods written in the model which can
     * increase the amount of an item that can be bought later on
     * @param CurrentM is the instance of the vending machine being modified
     * @return the modified vending machine
     */
    public VendingMachine stockManage(VendingMachine CurrentM)
    {
        int index;
        int addStock;
        String itemName;

        try {

            itemName = RSFrame.getNameInput().getText();
            addStock = Integer.parseInt(RSFrame.getQtyInput().getText());

            index = CurrentM.restockItem(itemName, addStock);
            // index contains the index of where the product name is found, if -1, then it means product doesn't exist.
            if (index != -1) {
                JOptionPane.showMessageDialog(null, "New number of " + CurrentM.getSlots()[index].get(0).getitemName() + ": " + (CurrentM.getSlots()[index].size() - 1), "Stock Edit", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Stock change unsuccessful!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return CurrentM;
    }

    /**
     * priceManage is the method that allows the user to change the
     * price of all instances of an item contained inside a
     * specific slot
     * @param CurrentM is the instance of the vending machine being modified
     * @return the modified vending machine
     */
    public VendingMachine priceManage(VendingMachine CurrentM)
    {
        int index;
        String itemName;
        int newPrice;

        try {
            itemName = SPFrame.getItemInput().getText();
            newPrice = Integer.parseInt(SPFrame.getPriceInput().getText());

            index = CurrentM.editPrice(itemName, newPrice);
            // index contains the index of where the product name is found, if -1, then it means product doesn't exist.
            if (index != -1) {
                JOptionPane.showMessageDialog(null, "New Price of " + CurrentM.getSlots()[index].get(0).getitemName() + ": " + CurrentM.getSlots()[index].get(0).getItemPrice() + "p", "Price Edit", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Price change unsuccessful!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return CurrentM;
    }

    /**
     * collectionManage allows the user to collect/reduce the amount of
     * money inside the vending machine that it can dispense for change
     * @param CurrentM is the instance of the vending machine being modified
     * @return the modified vending machine
     */
    public VendingMachine collectionManage(VendingMachine CurrentM)
    {
        // Amount to be collected is taken from BillInsert.
        try {
            BankNotes AddNotes = AddMoneytoSystem();
            CurrentM.takeMoneyfromSystem(AddNotes);
            // Displays the results of the process
            JOptionPane.showMessageDialog(null, "Collected Amount: " + AddNotes.getTotal(), "Collected", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return CurrentM;
    }

    /**
     * Allows the user to add money inside the vending machine that it can
     * use to produce change to the buyer
     * @param CurrentM is the instance of the vending machine being modified
     * @return the modified vending machine
     */
    public VendingMachine replenishManage(VendingMachine CurrentM)
    {
        // Amount to be collected is taken from BillInsert.
        try {
            BankNotes AddNotes = AddMoneytoSystem();
            CurrentM.addMoneytoSystem(AddNotes);
            // Displays results of the process
            JOptionPane.showMessageDialog(null, "Replenished Amount: " + AddNotes.getTotal(), "Replenished", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return CurrentM;
    }

    /**
     * insertManage is the method that allows the user to insert money
     * inside the vending machine to be used for transactions
     * @param currentM is the instance of the vending machine being modified
     * @return the modified vending machine
     */
    public VendingMachine insertManage(VendingMachine currentM)
    {
        BankNotes addMoney;

        try{
            if (userMoney == null) { // if user hasn't inserted money yet.
                userMoney = AddMoneytoSystem();
            } else { // if user has already inserted money, then prompting insert money again will add to the original amount.
                addMoney = AddMoneytoSystem();
                userMoney.setOneP(userMoney.getOneP() + addMoney.getOneP());
                userMoney.setFiveP(userMoney.getFiveP() + addMoney.getFiveP());
                userMoney.setTenP(userMoney.getTenP() + addMoney.getTenP());
                userMoney.setTwentyP(userMoney.getTwentyP() + addMoney.getTwentyP());
                userMoney.setFiftyP(userMoney.getFiftyP() + addMoney.getFiftyP());
                userMoney.setOneHunP(userMoney.getOneHunP() + addMoney.getOneHunP());
                userMoney.setTwoHunP(userMoney.getTwoHunP() + addMoney.getTwoHunP());
                userMoney.setFiveHunP(userMoney.getFiveHunP() + addMoney.getFiveHunP());
                userMoney.setOneKP(userMoney.getOneKP() + addMoney.getOneKP());
                userMoney.setTotal(userMoney.getTotal() + addMoney.getTotal());
            }

            // updates the user's money amount in BInsert form
            BInsert.getMoneyDisplay1().setText(userMoney.LabelBankNotes1());
            BInsert.getMoneyDisplay2().setText(userMoney.LabelBankNotes2());
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return currentM;
    }

    /**
     * buyItem is the method that allows the user to buy items
     * from the vending machine
     * @param CurrentM is the instance of the vending machine being modified
     * @return the modified vending machine
     */
    public VendingMachine buyItem(VendingMachine CurrentM)
    {
        boolean validQty = true, validItemSlot = true;
        int nSlotChoice, nQtyChoice;


        try {
            nSlotChoice = Integer.parseInt(BMFrame.getSlotTextField().getText());
            //Prompt a frame if chosen option is invalid
            if (nSlotChoice < 0 || nSlotChoice > CurrentM.getSlots().length - 1) {
                validItemSlot = false;
                JOptionPane.showMessageDialog(null, "Invalid Item Slot Input!", "Invalid Slot Choice", JOptionPane.ERROR_MESSAGE);
            }

            nQtyChoice = Integer.parseInt(BMFrame.getQtyTextField().getText());
            if (validItemSlot == true) {
                if (CurrentM.getSlots()[nSlotChoice].size() - 1 <= 0) {
                    JOptionPane.showMessageDialog(null, "Item Out of Stock!", "Out of Stock", JOptionPane.ERROR_MESSAGE);
                    validQty = false;
                }
                if (nQtyChoice < 1 || nQtyChoice > CurrentM.getSlots()[nSlotChoice].size() - 1) {
                    // makes sure there's still stock.
                    JOptionPane.showMessageDialog(null, "Invalid Quantity Input!", "Invalid Quantity Choice", JOptionPane.ERROR_MESSAGE);
                    validQty = false;
                }
            }
            //Initiate transaction if conditions are met
            if (validQty == true && validItemSlot == true) {
                userMoney = CurrentM.BuyItem(userMoney, nSlotChoice, nQtyChoice);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return CurrentM;
    }

    /**
     * QtyChecker is the method that checks if the quantity
     * of each item in the custom order is valid
     * @param CurrentM is the instance of the vending machine being modified
     * @param Qty is the array containing the quantity of each item of the custom order
     * @return true if quantity is valid, false if not
     */
    public boolean QtyChecker(VendingMachine CurrentM, int Qty[])
    {
        boolean validQty = true;

        try {
            for (int i = 0; i < CurrentM.getSlots().length; i++) {
                if (Qty[i] > 0 && CurrentM.getSlots()[i].size() == 1 || Qty[i] > CurrentM.getSlots()[i].size() - 1 || Qty[i] < 0) {
                    // makes sure there's still stock.
                    validQty = false;
                }
            }
            if (validQty == false)
                JOptionPane.showMessageDialog(null, "Invalid Quantity Input!", "Invalid Quantity Choice", JOptionPane.ERROR_MESSAGE);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return validQty;
    }

    /**
     * buyPremade allows the user to purchase a premade item via
     * a function in the vending machine by building the Qty[]
     * array used to determine the amount of items being bought
     * @param CurrentM is the instance of the vending machine being modified
     * @return the modified vending machine
     */

    public VendingMachine buyPremade(VendingMachine CurrentM)
    {
        int Qty[] = new int[8];
        int specialSlot = -1;
        boolean validQty;

        try {
            for (int i = 0; i < CurrentM.getSlots().length; i++)
                Qty[i] = 0;

            if (!SVMCFrame.getPremadetxtfield().getText().equals(""))
            {
                specialSlot = Integer.parseInt(SVMCFrame.getPremadetxtfield().getText());
                if(specialSlot >= 1 && specialSlot <= 5)
                {
                    if (specialSlot == 1) {
                        Qty[0] = 1;
                        Qty[1] = 1;
                        Qty[3] = 1;
                        Qty[5] = 1;
                        Qty[6] = 1;
                        Qty[7] = 1;
                    } else if (specialSlot == 2) {
                        Qty[0] = 1;
                        Qty[1] = 1;
                        Qty[2] = 1;
                        Qty[5] = 1;
                    } else if (specialSlot == 3) {
                        Qty[0] = 1;
                        Qty[1] = 1;
                        Qty[3] = 1;
                        Qty[5] = 1;
                    } else if (specialSlot == 4) {
                        Qty[0] = 1;
                        Qty[4] = 1;
                        Qty[5] = 1;
                        Qty[7] = 5;
                    } else if (specialSlot == 5) {
                        Qty[0] = 1;
                        Qty[1] = 1;
                        Qty[2] = 1;
                    }
                    validQty = QtyChecker(CurrentM, Qty);
                    if (validQty == true) {
                        userMoney = CurrentM.BuyCustom(userMoney, Qty);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Invalid Input!", "Invalid Slot Choice", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return CurrentM;
    }

    /**
     * buyCustom is the method that takes in the quantity of each
     * product from the special vending machine custom form and puts
     * it into an array (Qty)
     * @param CurrentM is the instance of the vending machine being modified
     * @return the modified vending machine
     */
    public VendingMachine buyCustom(VendingMachine CurrentM)
    {
        /*
        Items Potato = 0 /
        Items Cheese = 1 /
        Items Gravy = 2 /
        Items Bacon = 3 /
        Items BBQPowder = 4 /
        Items Salt = 5 /
        Items SourCream = 6
        Items Chili = 7 /
        */
        int Qty[] = new int[8];
        int itemcounter = 0;
        int slotChoice = -1;
        boolean validQty;


        try {
            //Saves the input of the user in an array of integers corresponding to the items
            if (!SVMCFrame.getPotatoAmt().getText().equals("")) {
                Qty[0] = Integer.parseInt(SVMCFrame.getPotatoAmt().getText());
                itemcounter++;
            } else
                Qty[0] = 0;

            if (!SVMCFrame.getCheeseAmt().getText().equals("")) {
                Qty[1] = Integer.parseInt(SVMCFrame.getCheeseAmt().getText());
                itemcounter++;
            } else
                Qty[1] = 0;

            if ((!SVMCFrame.getGravyAmt().getText().equals(""))) {
                Qty[2] = Integer.parseInt(SVMCFrame.getGravyAmt().getText());
                itemcounter++;
            } else
                Qty[2] = 0;

            if ((!SVMCFrame.getBaconAmt().getText().equals(""))) {
                Qty[3] = Integer.parseInt(SVMCFrame.getBaconAmt().getText());
                itemcounter++;
            } else
                Qty[3] = 0;

            if ((!SVMCFrame.getBbqAmt().getText().equals(""))) {
                Qty[4] = Integer.parseInt(SVMCFrame.getBbqAmt().getText());
                itemcounter++;
            } else
                Qty[4] = 0;

            if ((!SVMCFrame.getSaltAmt().getText().equals(""))) {
                Qty[5] = Integer.parseInt(SVMCFrame.getSaltAmt().getText());
                itemcounter++;
            } else
                Qty[5] = 0;

            if (!SVMCFrame.getScAmt().getText().equals("")) {
                Qty[6] = Integer.parseInt(SVMCFrame.getScAmt().getText());
                itemcounter++;
            } else
                Qty[6] = 0;

            if (!SVMCFrame.getChiliAmt().getText().equals("")) {
                Qty[7] = Integer.parseInt(SVMCFrame.getChiliAmt().getText());
                itemcounter++;
            } else
                Qty[7] = 0;

            validQty = QtyChecker(CurrentM, Qty);
            if (validQty == true) {
                //If there's more than 1 item, create a product
                if (itemcounter > 1)
                    userMoney = CurrentM.BuyCustom(userMoney, Qty);
                    //If not, buy individually
                //if (nSlotChoice < 0 || nSlotChoice > CurrentM.getSlots().length - 1)
                else if (itemcounter == 1 && Qty[4] == 0 && Qty[5] == 0) {
                    for (int i = 0; i < CurrentM.getSlots().length; i++) {
                        if (Qty[i] > 0)
                            slotChoice = i;
                    }
                    if (slotChoice >= 0 && slotChoice < CurrentM.getSlots().length)
                        userMoney = CurrentM.BuyItem(userMoney, slotChoice, Qty[slotChoice]);
                    else
                        JOptionPane.showMessageDialog(null, "Invalid Input!", "Slot Error", JOptionPane.ERROR_MESSAGE);

                } else if (itemcounter == 1 && (Qty[4] > 0 || Qty[5] > 0))
                    JOptionPane.showMessageDialog(null, "Cannot buy item individually", "Item Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return CurrentM;
    }

    /**
     * updateTextinBuy is the method that updates the quantity, price,
     * and calorie values of each product in BMFrame (Buy Menu) and
     * SVMCFrame (Special Vending Machine Custom) each time it gets called.
     */
    public void updateTextinBuy()
    {
        // updates money count in BMFrame, SVMCFrame and BillInsert
        BMFrame.getMoneyDisplay1().setText(userMoney.LabelBankNotes1());
        BMFrame.getMoneyDisplay2().setText(userMoney.LabelBankNotes2());
        SVMCFrame.getMoneyDisplay1().setText(userMoney.LabelBankNotes1());
        SVMCFrame.getMoneyDisplay2().setText(userMoney.LabelBankNotes2());
        BInsert.getMoneyDisplay1().setText(userMoney.LabelBankNotes1());
        BInsert.getMoneyDisplay2().setText(userMoney.LabelBankNotes2());

        // update text labels of items in BMFrame and SVMCFrame
        BMFrame.modifyTexts(CurrentM);
        SVMCFrame.modifyTexts(CurrentM);
    }

    /**
     * Menu is the method that initializes all the functions of the buttons
     * of each JFrame that allows the user to navigate the program
     */
    public void Menu() {
        MFrame.setVisible(true);

    // ------ CREATE MACHINE
        MFrame.getCreateVMButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MFrame.setVisible(false);
                CMFrame.setVisible(true);
            }
        });

    // ----- NORMAL VM [CREATE MACHINE]
        CMFrame.getCreateVMButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // sets all background color of each form to green (regular vm color)
                Color VMGreen = new Color(199,229,199);
                BInsert.getBillForm().setBackground(VMGreen);
                BMFrame.getBuyFrame().setBackground(VMGreen);
                CMFrame.getCreateFrame().setBackground(VMGreen);
                MFrame.getMenuFrame().setBackground(VMGreen);
                MMFrame.getMaintenanceMenu().setBackground(VMGreen);
                RSFrame.getRestockFrame().setBackground(VMGreen);
                SPFrame.getPriceFrame().setBackground(VMGreen);
                TMFrame.getTestFrame().setBackground(VMGreen);
                TransForm.getTransForm().setBackground(VMGreen);
                VFFrame.getVendFeatures().setBackground(VMGreen);
                BInsert.setVisible(true);
                CMFrame.setVisible(false);
                nChoice = 1;
            }
        });

    // ----- BILL INSERT [NORMAL VM/COLLECT MONEY/REPLENISH MONEY/USER INSERT MONEY/SPECIAL VM]
        BInsert.getInsertbutton().addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                if(nChoice == 1) {
                    // new normal machine set up
                    CurrentM = CreateVM(CurrentM);
                    MFrame.setVisible(true);
                    BInsert.setVisible(false);
                    nChoice = 0;
                }

                if (nChoice == 2) {
                    // collect money
                    CurrentM = collectionManage(CurrentM);
                    MMFrame.setVisible(true);
                    BInsert.setVisible(false);
                    nChoice = 0;
                }

                if (nChoice == 3) {
                    // replenish money
                    CurrentM = replenishManage(CurrentM);
                    MMFrame.setVisible(true);
                    BInsert.setVisible(false);
                    nChoice = 0;
                }

                if(nChoice == 4) {
                    // vending features user insert money
                    CurrentM = insertManage(CurrentM);
                    VFFrame.setVisible(true);
                    BInsert.setVisible(false);
                    nChoice = 0;
                }

                if(nChoice == 5) {
                    // new special machine set up
                    CurrentM = CreateVM(CurrentM);
                    MFrame.setVisible(true);
                    BInsert.setVisible(false);
                    nChoice = 0;
                }
             }
        });


    // ----- SPECIAL VM [CREATE MACHINE]
        CMFrame.getCreateSVMButton().addActionListener(new ActionListener() {
                    @Override
             public void actionPerformed(ActionEvent e) {
                  // sets all background color of each form to yellow (special vm color)
                  Color SVMYellow = new Color(229,228,181);
                  BInsert.getBillForm().setBackground(SVMYellow);
                  BMFrame.getBuyFrame().setBackground(SVMYellow);
                  CMFrame.getCreateFrame().setBackground(SVMYellow);
                  MFrame.getMenuFrame().setBackground(SVMYellow);
                  MMFrame.getMaintenanceMenu().setBackground(SVMYellow);
                  RSFrame.getRestockFrame().setBackground(SVMYellow);
                  SPFrame.getPriceFrame().setBackground(SVMYellow);
                  TMFrame.getTestFrame().setBackground(SVMYellow);
                  TransForm.getTransForm().setBackground(SVMYellow);
                  VFFrame.getVendFeatures().setBackground(SVMYellow);
                  BInsert.setVisible(true);
                  CMFrame.setVisible(false);
                  nChoice = 5;
             }
        });
    // ----- BUY SPECIAL VM
        SVMCFrame.getConfirmCustomOrderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentM = buyCustom(CurrentM);
                updateTextinBuy();
            }
        });

        SVMCFrame.getBuypremadebtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentM = buyPremade(CurrentM);
                updateTextinBuy();
            }
        });

        // ----- EXITING CUSTOM ORDER IN SPECIAL VM
        SVMCFrame.getExitcustombtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SVMCFrame.setVisible(false);
                VFFrame.setVisible(true);
            }
        });

    // ----- TEST VENDING MACHINE
        MFrame.getTestVMButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CurrentM != null) {
                    MFrame.setVisible(false);
                    TMFrame.setVisible(true);
                } else
                { // message for when CurrentM doesn't exist
                    JOptionPane.showMessageDialog(MMFrame, "No vending machine exists yet!", "Test Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    // ----- VENDING FEATURES [TEST]
        TMFrame.getVendingFeaturesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TMFrame.setVisible(false);
                VFFrame.setVisible(true);
            }
        });

    // ----- START OF MAINTENANCE FEATURES
    // ----- MAINTENANCE FEATURES [TEST]
        TMFrame.getMaintenanceFeaturesButton().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 TMFrame.setVisible(false);
                 MMFrame.setVisible(true);
             }
        });

    // ----- RESTOCK ITEMS [TEST > MAINTENANCE]
        MMFrame.getRestockItemButton().addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                TransForm.modifyTexts(CurrentM);
                RSFrame.modifyText(CurrentM);
                updateTransFile(CurrentM);
                MMFrame.setVisible(false);
                RSFrame.setVisible(true);
                TransForm.setVisible(true);
                CurrentM.initializeHistory();
            }
        });

        // ----- CLOSING TRANSACTION HISTORY FORM
        TransForm.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransForm.setVisible(false);
            }
        });

        // ----- SUBMITTING RESTOCK INFO
        RSFrame.getSubmit().addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                CurrentM = stockManage(CurrentM);
                RSFrame.modifyText(CurrentM);
             }
        });

        // ----- EXITING RESTOCK INFO
        RSFrame.getExitrestockbtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RSFrame.setVisible(false);
                MMFrame.setVisible(true);
            }
        });

    // ----- EDIT PRICE [TEST > MAINTENANCE]
       MMFrame.getEditItemPricesButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SPFrame.modifyText(CurrentM);
                MMFrame.setVisible(false);
                SPFrame.setVisible(true);
            }
       });

       // ----- SUBMITTING EDIT PRICE INFO
       SPFrame.getEditPriceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentM = priceManage(CurrentM);
                SPFrame.modifyText(CurrentM);
            }
       });

       // ----- EXITING EDIT PRICE INFO
       SPFrame.getExiteditbtn().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               SPFrame.setVisible(false);
               MMFrame.setVisible(true);
           }
       });

    // ----- COLLECT MONEY [TEST > MAINTENANCE]
        MMFrame.getCollectMoneyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BInsert.getMoneyDisplay1().setText(CurrentM.getMoney().LabelBankNotes1());
                BInsert.getMoneyDisplay2().setText(CurrentM.getMoney().LabelBankNotes2());
                MMFrame.setVisible(false);
                BInsert.setVisible(true);
                nChoice = 2;
            }
        });

    // ----- REPLENISH MONEY [TEST > MAINTENANCE]
        MMFrame.getReplenishMoneyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BInsert.getMoneyDisplay1().setText(CurrentM.getMoney().LabelBankNotes1());
                BInsert.getMoneyDisplay2().setText(CurrentM.getMoney().LabelBankNotes2());
                MMFrame.setVisible(false);
                BInsert.setVisible(true);
                nChoice = 3;
            }
        });

    // ----- EXIT MAINTENANCE MENU
        MMFrame.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MMFrame.setVisible(false);
                TMFrame.setVisible(true);
            }
        });
    // ----- END OF MAINTENANCE FEATURES

    // ----- EXIT TEST MENU
        TMFrame.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MFrame.setVisible(true);
                TMFrame.setVisible(false);
            }
        });

    // ----- EXIT MAIN MENU [EXIT SYSTEM]
        MFrame.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MFrame.setVisible(false);
                System.exit(0);
            }
        });

    // ----- BUY MENU [VENDING FEATURES]
        VFFrame.getBuyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(!specialCheck)
               {
                   if (userMoney == null) {
                       JOptionPane.showMessageDialog(null, "No money inserted yet!", "Buy Error", JOptionPane.ERROR_MESSAGE);
                   } else {
                       updateTextinBuy();
                       VFFrame.setVisible(false);
                       BMFrame.setVisible(true);
                   }
               }
               else
               {
                   if (userMoney == null)
                       JOptionPane.showMessageDialog(null, "No money inserted yet!", "Buy Error", JOptionPane.ERROR_MESSAGE);
                   else {
                       updateTextinBuy();
                       SVMCFrame.setPremadePrice(CurrentM);
                       VFFrame.setVisible(false);
                       SVMCFrame.setVisible(true);
                   }
               }

            }
        });

        // ----- BUY ITEM [VENDING FEATURES > BUY MENU]
        BMFrame.getBuyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentM = buyItem(CurrentM);
                updateTextinBuy();
            }
        });

        // ----- EXIT BUY MENU [VENDING FEATURES > BUY MENU]
        BMFrame.getExitbuybutton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BMFrame.setVisible(false);
                VFFrame.setVisible(true);
            }
        });

        // ----- EXIT VENDING FEATURES [TEST > VENDING FEATURES]
        VFFrame.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TMFrame.setVisible(true);
                if(userMoney != null)
                {
                    JOptionPane.showMessageDialog(null, "Produced Change\n\n1000 peso bills: " + userMoney.getOneKP() +
                            "\n500 peso bills: " + userMoney.getFiveHunP() + "\n200 peso bills: " + userMoney.getTwoHunP() + "\n100 peso bills: " + userMoney.getOneHunP() +
                            "\n50 peso bills: " + userMoney.getFiftyP() + "\n20 peso bills: " + userMoney.getTwentyP() + "\n10 peso coins: " + userMoney.getTenP() +
                            "\n5 peso coins: " + userMoney.getFiveP() + "\n1 peso coins: " + userMoney.getOneP() + "\nTotal: " + userMoney.getTotal(), "Returned Change", JOptionPane.INFORMATION_MESSAGE);
                    userMoney = null;
                    BInsert.getMoneyDisplay1().setText("");
                    BInsert.getMoneyDisplay2().setText("");
                }
                VFFrame.setVisible(false);
            }
        });

    // ----- INSERT MONEY [VENDING FEATURES]
        VFFrame.getInsertMoneyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userMoney == null)
                {
                    BInsert.getMoneyDisplay1().setText("");
                    BInsert.getMoneyDisplay2().setText("");
                }
                VFFrame.setVisible(false);
                BInsert.setVisible(true);
                nChoice = 4;
            }
        });

    }

    /**
     * Constructor method for the creation of an instance of the Controller class
     */
    public Controller() {
        nChoice = 0;
        CurrentM = null;
        userMoney = null;
        CMFrame = new CreateMachine();
        TMFrame = new TestMenu();
        BMFrame = new BuyMenu();
        MFrame = new MainMenu();
        BInsert = new BillInsert();
        MMFrame = new MaintenanceMenu();
        RSFrame = new Restock();
        SPFrame = new SetPrice();
        VFFrame = new VendFeat();
        SVMCFrame = new SVMCustom();
        TransForm = new TransactionForm();
        specialCheck = false;
        Menu();
    }

}
