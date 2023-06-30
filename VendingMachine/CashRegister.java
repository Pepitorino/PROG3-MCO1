package VendingMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a cash register
 */
public class CashRegister{

    private double price;
    private double value;
    private double change;

    private int thousands;
    private int fiveHundreds;
    private int twoHundreds;
    private int hundreds;
    private int fifties;
    private int twenties;
    private int tens;
    private int fives;
    private int ones;

    private ArrayList<Integer> internalBank;

    //CashRegister constructor
    public CashRegister(double price, double value, int thousands, int fiveHundreds, int twoHundreds, int hundreds, int fifties, int twenties, int tens, int fives, int ones){
        this.price = price;
        this.value = value;
        this.change = 0.0;

        this.thousands = thousands;
        this.fiveHundreds = fiveHundreds;
        this.twoHundreds = twoHundreds;
        this.hundreds = hundreds;
        this.fifties = fifties;
        this.twenties = twenties;
        this.tens = tens;
        this.fives = fives;
        this.ones = ones;

        this.internalBank = new ArrayList<Integer>();

        //Initialize internal bank with available denominations
        this.internalBank.add(ones);
        this.internalBank.add(fives);
        this.internalBank.add(tens);
        this.internalBank.add(twenties);
        this.internalBank.add(fifties);
        this.internalBank.add(hundreds);
        this.internalBank.add(twoHundreds);
        this.internalBank.add(fiveHundreds);
        this.internalBank.add(thousands);
    }

    //Calculate change to be given based on given price and value
    public ArrayList<Integer> calculateChange(double price, double value){
        int thousand = 0;
        int fiveH = 0;
        int twoH = 0;
        int hundred = 0;
        int fifty = 0;
        int twenty = 0;
        int ten = 0;
        int five = 0;
        int one = 0;


        ArrayList<Integer> changes = new ArrayList<>();

        if(price>0 && value>0 && value>=price) {
            this.change = value - price;
            int tempChange = this.change;

            //calculate the change using the available denominations
            while(this.change>=1000&&this.thousands>0) {
                this.change = this.change - 1000;
                this.thousands--;
                thousand++;
            }

            while(this.change>=500&&this.fiveHundreds>0) {
                this.change = this.change - 500;
                this.fiveHundreds--;
                fiveH++;
            }

            while(this.change>=200&&this.twoHundreds>0) {
                this.change = this.change - 200;
                this.twoHundreds--;
                twoH++;
            }

            while(this.change>=100&&this.hundreds>0) {
                this.change = this.change - 100;
                this.hundreds--;
                hundred++;
            }

            while(this.change>=50&&this.fifties>0) {
                    this.change = this.change - 50;
                    this.fifties--;
                    fifty++;
            }

            while(this.change>=20&&this.twenties>0) {
                this.change = this.change - 20;
                this.twenties--;
                twenty++;
            }

            while(this.change>=10&&this.tens>0) {
                this.change = this.change - 10;
                this.tens--;
                ten++;
            }

            while(this.change>=5&&this.fives>0) {
                this.change = this.change - 5;
                this.fives--;
                five++;
            }

            while(this.change>=1&&this.ones>0) {
                this.change = this.change - 1;
                this.ones--;
                one++;
            }

            //Add calculated values to changes list
            changes.add(thousand);
            changes.add(fiveH);
            changes.add(twoH);
            changes.add(hundred);
            changes.add(fifty);
            changes.add(twenty);
            changes.add(ten);
            changes.add(five);
            changes.add(one);

            //If there is still remaining change, add -1 to indicate insufficient denominations
            if(this.change != 0)
                changes.add(-1);

            this.change=tempChange;
        }

        return changes;
    }

    //Restock the internal bank with given denominations
    public void stockInternal(ArrayList<Integer> restock) {
        int oldValue;
        int newValue;

        //Update each denomination in the internal bank
        for(int x = 0;x<9;x++) {
            oldValue = this.internalBank.get(x);
            newValue = oldValue + restock.get(x);

            this.internalBank.set(x,newValue);
        }
    }

    //Getter for change
    public double getChange() {return this.change;}
}
