package Model;

import javax.swing.*;

/**
 * The Model.SpecialVM class is a child class of the Model.VendingMachine class.
 * It inherits all of its parents attributes and methods. An object of this class
 * can accept a combination of items that can result in the creation of special
 * products based on the input
 */
public class SpecialVM extends VendingMachine{

    /**
     * Constructor method to create an instance of the SpecialVM class
     * @param money is the amount of banknotes the machine will start with
     */
    public SpecialVM(BankNotes money)
    {
        super(money);
    }

    /**
     * BuyCustom method allows the user to input multiple items and
     * create a special product based on the combination of items
     * that the user inputs and subtracts from their money accordingly
     * @param userMoney is the amount of money the user has inserted
     * @param nQtyChoice is the amount of each item inserted by the user
     * @return the change to the user
     */

    public BankNotes BuyCustom(BankNotes userMoney, int nQtyChoice[])
    {
        //Sets the required amount of change to be returned based money being inserted
        int change = userMoney.getTotal();
        int i;
        String Product;
        for(i = 0; i < this.getSlots().length; i++)
            change -= (this.getSlots()[i].get(0).getItemPrice() * nQtyChoice[i]);

        int change1 = 0, change5 = 0, change10 = 0, change20 = 0, change50 = 0,
                change100 = 0, change200 = 0, change500 = 0, change1000 = 0;

        if(change < 0) //Stops transaction if user money is not sufficient
            JOptionPane.showMessageDialog(null, "Not enough money inserted! Transaction Cancelled", "Transaction Failure", JOptionPane.ERROR_MESSAGE);
        else
        {
            addMoneytoSystem(userMoney); // adds all the user's money to the system.

            //Converts the needed change into denominations needed by the user
            while(change >= 1000 && this.getMoney().getOneKP() > change1000)
            {
                change1000++;
                change-=1000;
            }
            while(change >= 500 && this.getMoney().getFiveHunP() > change500)
            {
                change500++;
                change-=500;
            }
            while(change >= 200 && this.getMoney().getTwoHunP() > change200)
            {
                change200++;
                change-=200;
            }
            while(change >= 100 && this.getMoney().getOneHunP() > change100)
            {
                change100++;
                change-=100;
            }
            while(change >= 50 && this.getMoney().getFiftyP() > change50)
            {
                change50++;
                change-=50;
            }
            while(change >= 20 && this.getMoney().getTwentyP() > change20)
            {
                change20++;
                change-=20;
            }
            while(change >= 10 && this.getMoney().getTenP() > change10)
            {
                change10++;
                change-=10;
            }
            while(change >= 5 && this.getMoney().getFiveP() > change5)
            {
                change5++;
                change-=5;
            }
            while(change >= 1 && this.getMoney().getOneP() > change1)
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
                for(i = 0; i < this.getSlots().length; i++)
                {
                    for (int j = 0; j < nQtyChoice[i]; j++) {   // decreases stock
                        this.getSlots()[i].remove(this.getSlots()[i].size() - 1);
                    }
                    this.getHistory()[i] += nQtyChoice[i]; //Updates transaction history
                    this.getHistory()[this.getNumItems()] += (this.getSlots()[i].get(0).getItemPrice() * nQtyChoice[i]);
                }
                takeMoneyfromSystem(userMoney);// removes excess amount from system
                Product = this.processProduct(nQtyChoice);
                JOptionPane.showMessageDialog(null, Product, "Product Created!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return userMoney;
    }

    /**
     * buildProduct is the method that allows the user to create the
     * product to be displayed to the user
     * @param Qty is the amount of each item the user inputs
     * @return the name of the product the user created
     */
    public String buildProduct(int Qty[])
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
        int totalCal = 0;
        String product = "";
        boolean specialProduct = false;

        //Builds the product string based on the user input
        if(Qty[0] > 0 && Qty[1] > 0 && Qty[3] > 0 && Qty[5] > 0 && Qty[6] > 0 && Qty[7] > 0)
        {
            product = product.concat("Loaded Fries");
            specialProduct = true;
        }
        else if(Qty[0] > 0 && Qty[1] > 0 && Qty[2] > 0 && Qty[5] > 0)
        {
            product = product.concat("Poutine");
            specialProduct = true;
        }
        else if(Qty[0] > 0 && Qty[1] > 0 && Qty[3] > 0 && Qty[5] > 0)
        {
            product = product.concat("Cheesy Bacon Fries");
            specialProduct = true;
        }
        else if(Qty[0] > 0 && Qty[4] > 0 && Qty[7] > 4 && Qty[5] > 0)
        {
            product = product.concat("Nuclear BBQ Fries");
            specialProduct = true;
        }
        else if(Qty[0] > 0 && Qty[1] > 0 && Qty[2] > 0)
        {
            product = product.concat("Mashed Potatoes");
            specialProduct = true;
        }

        if(specialProduct == false) {
            if (Qty[0] > 5)
                product = product.concat("Large ");
            else if (Qty[0] > 3)
                product = product.concat("Medium ");
            else if (Qty[0] > 0)
                product = product.concat("Small ");

            if (Qty[7] > 0)
                product = product.concat("Spicy ");

            if (Qty[1] > 2)
                product = product.concat("Extra Cheesy ");
            else if (Qty[1] > 0)
                product = product.concat("Cheese ");

            if (Qty[2] > 0)
                product = product.concat("Gravy ");

            if (Qty[4] > 0)
                product = product.concat("BBQ ");

            if (Qty[6] > 0)
                product = product.concat("Sour Cream ");

            if (Qty[3] > 0)
                product = product.concat("Bacon ");

            if (Qty[5] > 0 && Qty[0] > 0)
                product = product.concat("Fries");
            else if(Qty[0] > 0)
                product = product.concat("Baked Potato");

            if(Qty[3] == 0 && Qty[0] == 0)
                product = product.concat("Sauce");
        }
        this.setAllProducts(this.getAllProducts().concat(product+" x 1\n"));
        product = product.concat("!");
        for(int i = 0; i < this.getSlots().length; i++)
        {
            totalCal += this.getSlots()[i].get(0).getItemCal() * Qty[i];
        }
        product = product.concat("\nCalories: ("+Integer.toString(totalCal)+"g)");


        return product;
    }

    /**
     * processProduct builds the string process that will be showed
     * to the user in the creation of their specified product
     * @param Qty is the amount of each item the user inputs
     * @return the total procedure for the item
     */

    public String processProduct(int Qty[])
    {
        String process = "";

        //Adds to the message depending on the user input
        if(Qty[0] > 0)
        {
            process = process.concat("Peeling and cutting potatoes...\n");
            process = process.concat("Processing Potatoes...\n");
            process = process.concat("Putting potatoes into container...\n");
        }
        if(Qty[3] > 0)
        {
            process = process.concat("Frying bacon...\n");
            process = process.concat("Putting bacon into container...\n");
        }
        if(Qty[7] > 0)
        {
            process = process.concat("Slicing chili...\n");
            process = process.concat("Putting chili into container...\n");
        }
        if(Qty[1] > 0)
        {
            process = process.concat("Melting cheese...\n");
        }
        if(Qty[2] > 0)
        {
            process = process.concat("Pouring gravy...\n");
        }
        if(Qty[4] > 0)
        {
            process = process.concat("Adding barbeque powder...\n");
        }
        if(Qty[5] > 0)
        {
            process = process.concat("Salting it up...\n");
        }
        if(Qty[6] > 0)
        {
            process = process.concat("Preparing sour cream...\n");
        }
        process = process.concat("The aroma of freshly cooked food wafts through the air!\n");
        process = process.concat("Enjoy your "+buildProduct(Qty));

        return process;
    }
}
