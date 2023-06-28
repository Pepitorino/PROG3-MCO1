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
        
        if(price>0 && value>0 && value>=price) {
            change = value - price;
            
            while(change>=1000) {
                if(thousands==0) {
                    break;
                }
                else{
                    change = change - 1000;
                    thousands--;
                    thousand++;
                }
            }
            changes.add(thousand);
            
            while(change>=500) {
                if(fiveHundreds==0) {
                    break;
                }
                else{
                    change = change - 500;
                    fiveHundreds--;
                    fiveH++;
                }
            }
            changes.add(fiveH);
            
            while(change>=200) {
                if(twoHundreds==0) {
                    break;
                }
                else{
                    change = change - 200;
                    twoHundreds--;
                    twoH++;
                }
            }
            changes.add(twoH);
            
            while(change>=100) {
                if(hundreds==0) {
                    break;
                }
                else{
                    change = change - 100;
                    hundreds--;
                    hundred++;
                }
            }
            changes.add(hundred);
            
            while(change>=50) {
                if(fifties==0) {
                    break;
                }
                else{
                    change = change - 50;
                    fifties--;
                    fifty++;
                }
            }
            changes.add(fifty);
            
            while(change>=20) {
                if(twenties==0) {
                    break;
                }
                else{
                    change = change - 20;
                    twenties--;
                    twenty++;
                }
            }
            changes.add(twenty);
            
            while(change>=10) {
                if(tens==0) {
                    break;
                }
                else{
                    change = change - 10;
                    tens--;
                    ten++;
                }
            }
            changes.add(ten);
            
            while(change>=5) {
                if(fives==0){
                    break;
                }
                else{
                    change = change - 5;
                    fives--;
                    five++;
                }
            }
            changes.add(five);
            
            while(change>=1) {
                if(ones==0) {
                    break;
                }
                else{
                    change = change - 1;
                    ones--;
                    one++;
                }
            }
            changes.add(one);
            
            if(change != 0)
                changes.add(-1);
        }
        
        return changes;
    }
    
    public void stockInternal(ArrayList<Integer> restock) {
        int oldValue;
        int newValue;
        
        for(int x = 0;x<9;x++) {
            oldValue = internalBank.get(x);
            newValue = oldValue + restock.get(x);
            
            internalBank.set(x,newValue);
        }
    }
}