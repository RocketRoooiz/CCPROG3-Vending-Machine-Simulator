package Model;

/**
 * The Model.BankNotes class acts as the money denominations being paid
 * or the denominations currently being owned by a whole class
 * It is vital for the transactions and maintenance being done
 * to the vending machine
 */
public class BankNotes {
    private int oneP;
    private int fiveP;
    private int tenP;
    private int twentyP;
    private int fiftyP;
    private int oneHunP;
    private int twoHunP;
    private int fiveHunP;
    private int oneKP;
    private int total;

    /**
     * Constructor method that allows the initiation of an instance
     * of the Model.BankNotes class with all denominations set to 0
     */
    public BankNotes()
    {
        this.oneP = 0;
        this.fiveP = 0;
        this.tenP = 0;
        this.twentyP = 0;
        this.fiftyP = 0;
        this.oneHunP = 0;
        this.twoHunP = 0;
        this.fiveHunP = 0;
        this.oneKP = 0;
        this.total = 0;
    }

    /**
     * Constructor method that allows the initiation of an instance
     * of the Model.BankNotes class
     * @param oneP is the amount of 1 peso coins
     * @param fiveP is the amount of 5 peso coins
     * @param tenP is the amount of 10 peso coins
     * @param twentyP is the amount of 20 peso coins
     * @param fiftyP is the amount of 50 peso bills
     * @param oneHunP is the amount of 100 peso bills
     * @param twoHunP is the amount of 200 peso bills
     * @param fiveHunP is the amount of 500 peso bills
     * @param oneKP is the amount of 1000 peso bills
     */
    public BankNotes(int oneP, int fiveP, int tenP, int twentyP, int fiftyP,
                     int oneHunP, int twoHunP, int fiveHunP, int oneKP)
    {
        //Sets all denominations to the user inputted money
        this.oneP = oneP;
        this.fiveP = fiveP;
        this.tenP = tenP;
        this.twentyP = twentyP;
        this.fiftyP = fiftyP;
        this.oneHunP = oneHunP;
        this.twoHunP = twoHunP;
        this.fiveHunP = fiveHunP;
        this.oneKP = oneKP;
        this.total = 1*oneP + 5*fiveP + 10*tenP + 20*twentyP + 50*fiftyP + 100*oneHunP + 200*twoHunP + 500*fiveHunP + 1000*oneKP;
    }

    /**
     *
     * @return the number of 1 peso coins that can be returned as change
     */
    public int getOneP() {
        return oneP;
    }

    /**
     *
     * @param oneP is the number of 1 peso coins that can be returned as change
     */
    public void setOneP(int oneP) {
        this.oneP = oneP;
    }

    /**
     *
     * @return the number of 5 peso coins that can be returned as change
     */

    public int getFiveP() {
        return fiveP;
    }

    /**
     *
     * @param fiveP is is the number of 5 peso coins that can be returned as change
     */

    public void setFiveP(int fiveP) {
        this.fiveP = fiveP;
    }

    /**
     *
     * @return the number of 10 peso coins that can be returned as change
     */

    public int getTenP() {
        return tenP;
    }

    /**
     *
     * @param tenP is the number of 10 peso coins that can be returned as change
     */
    public void setTenP(int tenP) {
        this.tenP = tenP;
    }

    /**
     *
     * @return the number of 20 peso coins that can be returned as change
     */

    public int getTwentyP() {
        return twentyP;
    }

    /**
     *
     * @param twentyP is the number of 20 peso coins that can be returned as change
     */

    public void setTwentyP(int twentyP) {
        this.twentyP = twentyP;
    }

    /**
     *
     * @return the number of 50 peso bills that can be returned as change
     */

    public int getFiftyP() {
        return fiftyP;
    }

    /**
     *
     * @param fiftyP is the number of 50 peso bills that can be returned as change
     */

    public void setFiftyP(int fiftyP) {
        this.fiftyP = fiftyP;
    }

    /**
     *
     * @return the number of 100 peso bills that can be returned as change
     */

    public int getOneHunP() {
        return oneHunP;
    }

    /**
     *
     * @param oneHunP is the number of 100 peso bills that can be returned as change
     */
    public void setOneHunP(int oneHunP) {
        this.oneHunP = oneHunP;
    }

    /**
     *
     * @return the number of 200 peso bills that can be returned as change
     */

    public int getTwoHunP() {
        return twoHunP;
    }

    /**
     *
     * @param twoHunP is the number of 200 peso bills that can be returned as change
     */

    public void setTwoHunP(int twoHunP) {
        this.twoHunP = twoHunP;
    }

    /**
     *
     * @return the number of 500 peso bills that can be returned as change
     */
    public int getFiveHunP() {
        return fiveHunP;
    }

    /**
     *
     * @param fiveHunP is the number of 500 peso bills that can be returned as change
     */
    public void setFiveHunP(int fiveHunP) {
        this.fiveHunP = fiveHunP;
    }

    /**
     *
     * @return the number of 1000 peso bills that can be returned as change
     */

    public int getOneKP() {
        return oneKP;
    }

    /**
     *
     * @param oneKP is the number of 1000 peso bills that can be returned as change
     */
    public void setOneKP(int oneKP) {
        this.oneKP = oneKP;
    }

    /**
     * method that sets the total amount of cash inside the machine
     * based on the number of denominations
     * @param oneP is the amount of 1 peso coins
     * @param fiveP is the amount of 5 peso coins
     * @param tenP is the amount of 10 peso coins
     * @param twentyP is the amount of 20 peso coins
     * @param fiftyP is the amount of 50 peso bills
     * @param oneHunP is the amount of 100 peso bills
     * @param twoHunP is the amount of 200 peso bills
     * @param fiveHunP is the amount of 500 peso bills
     * @param oneKP is the amount of 1000 peso bills
     */
    public void setTotal(int oneP, int fiveP, int tenP, int twentyP, int fiftyP,
                         int oneHunP, int twoHunP, int fiveHunP, int oneKP)
    {
        this.total = 1*oneP + 5*fiveP + 10*tenP + 20*twentyP + 50*fiftyP + 100*oneHunP + 200*twoHunP + 500*fiveHunP + 1000*oneKP;
    }

    /**
     * method that sets the total amount of cash inside the machine
     * based on the number of denominations
     */
    public void setTotal()
    {
        this.total = 1*getOneP() + 5*getFiveP() + 10*getTenP() + 20*getTwentyP() + 50*getFiftyP() + 100*getOneHunP() +
                200*getTwoHunP() + 500*getFiveHunP() + 1000*getOneKP();
    }

    /**
     *
     * @param total is the total amount of money in the machines, combining the value of all denominations
     */
    public void setTotal(int total)
    {
        this.total = total;
    }

    /**
     *
     * @return the total amount of money in the machines, combining the value of all denominations
     */

    public int getTotal()
    {
        return total;
    }

    /**
     * displays the money on the gui interface
     * @return The display of the money
     */
    public String LabelBankNotes1()
    {
        // note: &nbsp; is space and <br> is /n in html
        String MoneyP1 = "";
        MoneyP1 = MoneyP1.concat("<html>1000 peso bills: "+getOneKP()+"<br>");
        MoneyP1 = MoneyP1.concat("200 peso bills: &nbsp;"+getTwoHunP()+"<br>");
        MoneyP1 = MoneyP1.concat("50 peso bills: &nbsp;&nbsp;"+getFiftyP()+"<br>");
        MoneyP1 = MoneyP1.concat("10 peso bills: &nbsp;&nbsp;"+getTenP()+"<br>");
        MoneyP1 = MoneyP1.concat("1 peso bills: &nbsp;&nbsp;&nbsp;"+getOneP()+"</html>");

        return MoneyP1;
    };

    /**
     * displays the money on the gui interface
     * @return The display of the money
     */
    public String LabelBankNotes2()
    {
        String MoneyP2 = "";
        MoneyP2 = MoneyP2.concat("<html>500 peso bills: "+getFiveHunP()+ "<br>");
        MoneyP2 = MoneyP2.concat("100 peso bills: "+getOneHunP()+"<br>");
        MoneyP2 = MoneyP2.concat("20 peso bills: &nbsp;"+getTwentyP()+"<br>");
        MoneyP2 = MoneyP2.concat("5 peso bills:  &nbsp;&nbsp;"+getFiveP()+"<br>");
        MoneyP2 = MoneyP2.concat("Total: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getTotal()+"</html>");

        return MoneyP2;
    };
}
