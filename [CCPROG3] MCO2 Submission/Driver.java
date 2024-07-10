import Controller.Controller;
import Model.BankNotes;
import Model.Items;
import Model.VendingMachine;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
/*
Buencamino, Prince Bendrik C.
Ruiz, Chester Bryan C.
This program simulates the process of making transactions with a vending machine using
different banknotes and denominations. It also simulates the process of managing the contents
of a machine including the item's stock and price.
*/

/**
 * Driver class that facilitates the simulation of the transactions between
 * the user and operator and the vending machine. It allows the user to create one and test
 * all its functions and capabilities by accessing the other classes through
 * their instances. It functions as that initiator of all the methods found
 * in each of the classes
 */
public class Driver {

    /**
     * Main method that is responsible for facilitating the program
     * and allows the access ot other methods and objects
     * @param args parameter used for main methods
     */

    public static void main(String[] args) {
        Controller C = new Controller();
    }
}

