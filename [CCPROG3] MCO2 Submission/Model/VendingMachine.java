package Model;

import Model.BankNotes;
import Model.Items;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Model.VendingMachine class is the class that consists of a Model.BankNotes storage and an array of items
 * which it can sell to earn money. It can accept money in Philippine peso denominations as well as produce
 * change in the same way as well. The machine can also restock, display transactions, and edit the prices
 * based on the needs of the operator
 */
public class VendingMachine {

    private String machineName;
    private ArrayList<Items>[] Slots = new ArrayList[8];
    private BankNotes money;
    private int numItems;
    private int[] history;

    private String allProducts;


    /**
     * A constructor method that allows that initiation of an
     * instance of the vending machine class
     * @param money a set of denominations that determines how much money the machine has
     */
    public VendingMachine(BankNotes money)
    {
        //Sets the initiated machine's money to the user inputted money
        this.money = new BankNotes();
        this.money.setOneP(money.getOneP());
        this.money.setFiveP(money.getFiveP());
        this.money.setTenP(money.getTenP());
        this.money.setTwentyP(money.getTwentyP());
        this.money.setFiftyP(money.getFiftyP());
        this.money.setOneHunP(money.getOneHunP());
        this.money.setTwoHunP(money.getTwoHunP());
        this.money.setFiveHunP(money.getFiveHunP());
        this.money.setOneKP(money.getOneKP());
        this.money.setTotal(money.getTotal());
        this.allProducts = "";
        this.numItems = 0;
    }

    /**
     * addItem method allows for the addition of an item slot in the machine
     * @param item is the type of item to be added
     * @param index is the slot number the item will be assigned to
     * @param qty is the amount of items to be added
     */
    public void addItem(Items item, int index, int qty)
    {
        //Adds an item inside a slot
        Slots[index] = new ArrayList<Items>();
        for(int i = 0; i < qty+1; i++)
        {
            Slots[index].add(item);
        }
        this.numItems++;
    }

    /**
     * Initializes the transactions made for each item to 0
     */
    public void initializeHistory()
    {
        // note: history[0 to numItems-1] stores quantity sold, history[numItems] store total money made.
        history = new int[numItems+1];
        for(int i = 0; i < numItems; i++)
        {
            history[i] = 0;
        }
    }

    /**
     * The restockItem method allows the operator to replenish the quantity of the items
     * being sold inside the vending machine
     * @param ItemName is the name of the item the operator intends to replenish
     * @param addStock is the amount of items to be added
     * @return the index of the item being restocked
     */
    public int restockItem(String ItemName, int addStock)
    {
        int i;
        int restockedItem = -1;

        if(addStock > 0)
        {
            for (i = 0; i < Slots.length && restockedItem == -1; i++)
            {
                if (ItemName.equalsIgnoreCase(Slots[i].get(0).getitemName()) && Slots[i].size() - 1 + addStock <= Slots[i].get(0).getItemCap())
                {
                    //Searches the list to find the item based on their item name and adds the stock input
                    for (int j = 0; j < addStock; j++)
                        Slots[i].add(Slots[i].get(0));

                    restockedItem = i;
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Invalid Input!","Input Error", JOptionPane.ERROR_MESSAGE);

        return restockedItem;
    }

    /**
     * The editPrice method allows the operator to change the price of the item being sold
     * @param ItemName is the name of the item which will be modified
     * @param newPrice is the new price the item can be bought at
     * @return the index of the item being modified
     */
    public int editPrice(String ItemName, int newPrice)
    {
        int modItem = -1;
        if(newPrice > 0) {
            for (int i = 0; i < Slots.length && modItem == -1; i++) {
                if (ItemName.equalsIgnoreCase(Slots[i].get(0).getitemName())) {
                    //Search the list to find matching item name then edit their price
                    for (int j = 0; j < Slots[i].size(); j++) {//Every item at this slot gets updated
                        Slots[i].get(j).setItemPrice(newPrice);
                    }
                    modItem = i;
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Invalid Input!","Input Error", JOptionPane.ERROR_MESSAGE);

        return modItem;
    }

    /**
     * addMoneytoSystem allows the addition of Model.BankNotes inside the machine
     * @param money the denominations to be added in the machine
     */
    public void addMoneytoSystem(BankNotes money)
    {
        //Adds banknotes to the vending machine
        this.money.setOneP(this.money.getOneP() + money.getOneP());
        this.money.setFiveP(this.money.getFiveP() + money.getFiveP());
        this.money.setTenP(this.money.getTenP() + money.getTenP());
        this.money.setTwentyP(this.money.getTwentyP() + money.getTwentyP());
        this.money.setFiftyP(this.money.getFiftyP() + money.getFiftyP());
        this.money.setOneHunP(this.money.getOneHunP() + money.getOneHunP());
        this.money.setTwoHunP(this.money.getTwoHunP() + money.getTwoHunP());
        this.money.setFiveHunP(this.money.getFiveHunP() + money.getFiveHunP());
        this.money.setOneKP(this.money.getOneKP() + money.getOneKP());
        this.money.setTotal(this.money.getTotal() + money.getTotal());
    }

    /**
     * takeMoneyfromSystem method allows the operator to collect money from the machine, subtracting it
     * @param userMoney is the money to be subtracted from the machine
     */
    public void takeMoneyfromSystem(BankNotes userMoney)
    {
        //Collects the money from the machine if there is enough of that amount for each denomination
        //Fails to collect and prints out a message if process in unsuccessful
        if(this.money.getOneKP() - userMoney.getOneKP() >= 0)
            this.money.setOneKP(this.money.getOneKP() - userMoney.getOneKP());
        else
        {
            JOptionPane.showMessageDialog(null, "Failed to collect 1000 peso bills", "Collection failure", JOptionPane.ERROR_MESSAGE);
            userMoney.setTotal(userMoney.getTotal() - 1000*userMoney.getOneKP());
        }

        if(this.money.getFiveHunP() - userMoney.getFiveHunP() >= 0)
            this.money.setFiveHunP(this.money.getFiveHunP() - userMoney.getFiveHunP());
        else {
            JOptionPane.showMessageDialog(null, "Failed to collect 500 peso bills", "Collection failure", JOptionPane.ERROR_MESSAGE);
            userMoney.setTotal(userMoney.getTotal() - 500*userMoney.getFiveHunP());
        }

        if(this.money.getTwoHunP() - userMoney.getTwoHunP() >= 0)
            this.money.setTwoHunP(this.money.getTwoHunP() - userMoney.getTwoHunP());
        else {
            JOptionPane.showMessageDialog(null, "Failed to collect 200 peso bills", "Collection failure", JOptionPane.ERROR_MESSAGE);
            userMoney.setTotal(userMoney.getTotal() - 200*userMoney.getTwoHunP());
        }

        if(this.money.getOneHunP() - userMoney.getOneHunP() >= 0)
            this.money.setOneHunP(this.money.getOneHunP() - userMoney.getOneHunP());
        else {
            JOptionPane.showMessageDialog(null, "Failed to collect 100 peso bills", "Collection failure", JOptionPane.ERROR_MESSAGE);
            userMoney.setTotal(userMoney.getTotal() - 100*userMoney.getOneHunP());
        }

        if(this.money.getFiftyP() - userMoney.getFiftyP() >= 0)
            this.money.setFiftyP(this.money.getFiftyP() - userMoney.getFiftyP());
        else {
            JOptionPane.showMessageDialog(null, "Failed to collect 50 peso bills", "Collection failure", JOptionPane.ERROR_MESSAGE);
            userMoney.setTotal(userMoney.getTotal() - 50*userMoney.getFiftyP());
        }

        if(this.money.getTwentyP() - userMoney.getTwentyP() >= 0)
            this.money.setTwentyP(this.money.getTwentyP() - userMoney.getTwentyP());
        else {
            JOptionPane.showMessageDialog(null, "Failed to collect 20 peso bills", "Collection failure", JOptionPane.ERROR_MESSAGE);
            userMoney.setTotal(userMoney.getTotal() - 20*userMoney.getTwentyP());
        }

        if(this.money.getTenP() - userMoney.getTenP() >= 0)
            this.money.setTenP(this.money.getTenP() - userMoney.getTenP());
        else {
            JOptionPane.showMessageDialog(null, "Failed to collect 10 peso coins", "Collection failure", JOptionPane.ERROR_MESSAGE);
            userMoney.setTotal(userMoney.getTotal() - 10*userMoney.getTenP());
        }

        if(this.money.getFiveP() - userMoney.getFiveP() >= 0)
            this.money.setFiveP(this.money.getFiveP() - userMoney.getFiveP());
        else {
            JOptionPane.showMessageDialog(null, "Failed to collect 5 peso coins", "Collection failure", JOptionPane.ERROR_MESSAGE);
            userMoney.setTotal(userMoney.getTotal() - 5*userMoney.getFiveP());
        }

        if(this.money.getOneP() - userMoney.getOneP() >= 0)
            this.money.setOneP(this.money.getOneP() - userMoney.getOneP());
        else {
            JOptionPane.showMessageDialog(null, "Failed to collect 1 peso coins", "Collection failure", JOptionPane.ERROR_MESSAGE);
            userMoney.setTotal(userMoney.getTotal() - userMoney.getOneP());
        }
        //Updates the total amount in the machine
        this.money.setTotal(this.money.getTotal() - userMoney.getTotal());
    }

    /**
     * BuyItem is the method that facilitates the purchase of an item; from the stock being depleted, receiving
     * the money from the buyer, and returning adequate change to the buyer. It also updates the
     * transaction history
     * @param userMoney is the money being inserted in the machine
     * @param nSlotChoice is the index of the item being purchased
     * @param nQtyChoice is the amount of an item a user wants to purchase
     * @return the excess money after the purchase
     */
    public BankNotes BuyItem(BankNotes userMoney, int nSlotChoice, int nQtyChoice)
    {
        //Sets the required amount of change to be returned based money being inserted
        int change = userMoney.getTotal() - (Slots[nSlotChoice].get(0).getItemPrice() * nQtyChoice);
        int change1 = 0, change5 = 0, change10 = 0, change20 = 0, change50 = 0,
                change100 = 0, change200 = 0, change500 = 0, change1000 = 0;

        if(change < 0) //Stops transaction if user money is not sufficient
            JOptionPane.showMessageDialog(null, "Not enough money inserted! Transaction Cancelled", "Transaction Failure", JOptionPane.ERROR_MESSAGE);
        else
        {
            addMoneytoSystem(userMoney); // adds all the user's money to the system.

            //Converts the needed change into denominations needed by the user
            while(change >= 1000 && this.money.getOneKP() > change1000)
            {
                change1000++;
                change-=1000;
            }
            while(change >= 500 && this.money.getFiveHunP() > change500)
            {
                change500++;
                change-=500;
            }
            while(change >= 200 && this.money.getTwoHunP() > change200)
            {
                change200++;
                change-=200;
            }
            while(change >= 100 && this.money.getOneHunP() > change100)
            {
                change100++;
                change-=100;
            }
            while(change >= 50 && this.money.getFiftyP() > change50)
            {
                change50++;
                change-=50;
            }
            while(change >= 20 && this.money.getTwentyP() > change20)
            {
                change20++;
                change-=20;
            }
            while(change >= 10 && this.money.getTenP() > change10)
            {
                change10++;
                change-=10;
            }
            while(change >= 5 && this.money.getFiveP() > change5)
            {
                change5++;
                change-=5;
            }
            while(change >= 1 && this.money.getOneP() > change1)
            {
                change1++;
                change-=1;
            }

            //Stops transaction if machine does not have enough change
            if(change != 0)
            {
                JOptionPane.showMessageDialog(null, "Error in Producing Change!", "Transaction Error", JOptionPane.ERROR_MESSAGE);
                takeMoneyfromSystem(userMoney);
            }
            else
            {
                //Saves the change denominations inside a Model.BankNotes instance
                userMoney = new BankNotes(change1, change5, change10, change20, change50, change100, change200, change500, change1000); // sets new user money

                for(int i = 0; i < nQtyChoice; i++)
                    Slots[nSlotChoice].remove(Slots[nSlotChoice].size()-1); // decreases stock

                takeMoneyfromSystem(userMoney); // removes excess amount from system
                JOptionPane.showMessageDialog(null, "x"+ nQtyChoice +" " + Slots[nSlotChoice].get(0).getitemName() + " bought!", "Item Bought", JOptionPane.INFORMATION_MESSAGE);
                history[nSlotChoice] += nQtyChoice; //Updates transaction history
                history[numItems] += (Slots[nSlotChoice].get(0).getItemPrice() * nQtyChoice);
            }
        }
        return userMoney;
    }

    /**
     * BuyCustom method allows the user to input multiple items and
     * create a special product based on the combination of items
     * that the user inputs and subtracts from their money accordingly
     * To be Overidden in SpecialVM
     * @param userMoney is the amount of money the user has inserted
     * @param nQtyChoice is the amount of each item inserted by the user
     * @return the change to the user
     */
    public BankNotes BuyCustom(BankNotes userMoney, int nQtyChoice[])
    {
        return userMoney;
    }

    /**
     * buildProduct is the method that allows the user to create the
     * product to be displayed to the user. To be overidden in SpecialVM
     * @param Qty is the amount of each item the user inputs
     * @return the name of the product the user created
     */
    public String buildProduct(int Qty[])
    {
        return "";
    }

    /**
     * processProduct builds the string process that will be showed
     * to the user in the creation of their specified product. To be overidden
     * in SpecialVM
     * @param Qty is the amount of each item the user inputs
     * @return the total procedure for the item
     */
    public String processProduct(int Qty[])
    {
        return "";
    }


    /**
     *
     * @return the name used to identify the machine
     */
    public String getMachineName() {
        return machineName;
    }

    /**
     *
     * @param machineName is the name used to identify the machine
     */

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    /**
     *
     * @return all the slots containing the items and their properties
     */

    public ArrayList<Items>[] getSlots() {
        return Slots;
    }

    /**
     *
     * @param slots are all the slots containing the items and their properties
     */

    public void setSlots(ArrayList<Items>[] slots) {
        Slots = slots;
    }

    /**
     *
     * @return the denominations in the machine that aid in transaction completion
     */
    public BankNotes getMoney() {
        return money;
    }

    /**
     *
     * @param money are the denominations in the machine that aid in transaction completion
     */

    public void setMoney(BankNotes money) {
        this.money = money;
    }

    /**
     *
     * @return the transaction history
     */
    public int[] getHistory() {
        return history;
    }

    /**
     *
     * @return the number of item slots in the machine
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     *
     * @param allProducts are all the products that the user has purchased
     */

    public void setAllProducts(String allProducts) {
        this.allProducts = allProducts;
    }

    /**
     *
     * @return the list of products the user has purchased
     */
    public String getAllProducts() {
        return allProducts;
    }
}

