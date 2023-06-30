package VendingMachine;

import java.util.ArrayList;

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
            
            while(this.change>=1000) {
                if(thousands==0) {
                    break;
                }
                else{
                    this.change = this.change - 1000;
                    this.thousands--;
                    thousand++;
                }
            }
            changes.add(thousand);
            
            while(this.change>=500) {
                if(fiveHundreds==0) {
                    break;
                }
                else{
                    this.change = this.change - 500;
                    this.fiveHundreds--;
                    fiveH++;
                }
            }
            changes.add(fiveH);
            
            while(this.change>=200) {
                if(twoHundreds==0) {
                    break;
                }
                else{
                    this.change = this.change - 200;
                    this.twoHundreds--;
                    twoH++;
                }
            }
            changes.add(twoH);
            
            while(this.change>=100) {
                if(hundreds==0) {
                    break;
                }
                else{
                    this.change = this.change - 100;
                    this.hundreds--;
                    hundred++;
                }
            }
            changes.add(hundred);
            
            while(this.change>=50) {
                if(fifties==0) {
                    break;
                }
                else{
                    this.change = this.change - 50;
                    this.fifties--;
                    fifty++;
                }
            }
            changes.add(fifty);
            
            while(this.change>=20) {
                if(twenties==0) {
                    break;
                }
                else{
                    this.change = this.change - 20;
                    this.twenties--;
                    twenty++;
                }
            }
            changes.add(twenty);
            
            while(this.change>=10) {
                if(tens==0) {
                    break;
                }
                else{
                    this.change = this.change - 10;
                    this.tens--;
                    ten++;
                }
            }
            changes.add(ten);
            
            while(this.change>=5) {
                if(fives==0){
                    break;
                }
                else{
                    this.change = this.change - 5;
                    this.fives--;
                    five++;
                }
            }
            changes.add(five);
            
            while(this.change>=1) {
                if(ones==0) {
                    break;
                }
                else{
                    this.change = this.change - 1;
                    this.ones--;
                    one++;
                }
            }
            changes.add(one);
            
            if(this.change != 0)
                changes.add(-1);
        }
        
        return changes;
    }
    
    public void stockInternal(ArrayList<Integer> restock) {
        int oldValue;
        int newValue;
        
        for(int x = 0;x<9;x++) {
            oldValue = this.internalBank.get(x);
            newValue = oldValue + restock.get(x);
            
            this.internalBank.set(x,newValue);
        }
    }

    public double getChange() {return this.change;}
}
