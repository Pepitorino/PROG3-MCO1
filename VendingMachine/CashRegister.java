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
        
        internalBank = new ArrayList<>();
        
        internalBank.add(ones);
        internalBank.add(fives);
        internalBank.add(tens);
        internalBank.add(twenties);
        internalBank.add(fifties);
        internalBank.add(hundreds);
        internalBank.add(twoHundreds);
        internalBank.add(fiveHundreds);
        internalBank.add(thousands);
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
        
        if(price > 0 && value > 0 && value >= price){
            change = value - price;
            
            while(change >= 1000){
                change = change - 1000;
                thousand++;
            }
            changes.add(thousand);
            
            while(change >= 500){
                change = change - 500;
                fiveH++;
            }
            changes.add(fiveH);
            
            while(change >= 200){
                change = change - 200;
                twoH++;
            }
            changes.add(twoH);
            
            while(change >= 100){
                change = change - 100;
                hundred++;
            }
            changes.add(hundred);
            
            while(change >= 50){
                change = change - 50;
                fifty++;
            }
            changes.add(fifty);
            
            while(change >= 20){
                change = change - 20;
                twenty++;
            }
            changes.add(twenty);
            
            while(change >= 10){
                change = change - 10;
                ten++;
            }
            changes.add(ten);
            
            while(change >= 5){
                change = change - 5;
                five++;
            }
            changes.add(five);
            
            while(change >= 1){
                change = change - 1;
                one++;
            }
            changes.add(one);
            
        }
        return changes;
    }
}