package Model;

/**
 * The Model.Items class consists of all the details present
 * inside an item slot including its name, price, quantity,
 * capacity, and calories. they are what the user can purchase
 * using their denominations
 */
public class Items
{
    private String itemName;
    private int itemPrice;
    private int itemCap;
    private int itemCal;

    /**
     * Constructor method that allows the initiation of an instance
     * of the Model.Items class
     * @param itemName is the name of the item
     * @param itemPrice is the numerical price needed to purchase the item
     * @param itemCal the amount of calories an item possesses
     */
    public Items(String itemName, int itemPrice, int itemCal) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCal = itemCal;
        this.itemCap = 20;
    }

    /**
     *
     * @return the name that identifies the item
     */
    public String getitemName() {
        return itemName;
    }

    /**
     *
     * @param itemName is the name that identifies the item
     */
    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @return the price required to purchase the item
     */

    public int getItemPrice() {
        return itemPrice;
    }

    /**
     *
     * @param itemPrice is the amount of money required to purchase the item
     */
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     *
     * @return the maximum amount of an item that can be sold in the machine
     */
    public int getItemCap() {
        return itemCap;
    }

    /**
     *
     * @param itemCap is the maximum amount of an item that can be sold in the machine
     */
    public void setItemCap(int itemCap) {
        this.itemCap = itemCap;
    }

    /**
     *
     * @return the amount of calories an item has
     */
    public int getItemCal() {
        return itemCal;
    }

    /**
     *
     * @param itemCal is the amount of calories an item has
     */
    public void setItemCal(int itemCal) {
        this.itemCal = itemCal;
    }
}

