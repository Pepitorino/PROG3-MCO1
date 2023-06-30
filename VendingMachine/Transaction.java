package VendingMachine;

/*Also, the vending machine has the capability of printing a summary of transactions. In other words, the 
vending machine should at least list the quantity of each item sold and the total amount collected in the 
sales starting from the previous stocking. This implies that there should also be a display of the starting 
inventory and the ending inventory from the last restocking*/

public class Transaction {
    private double cashReceived;
    private double changeGiven;

    //Constructor to initialize a transaction object
    public Transaction(double cashReceived, double changeGiven) {this.cashReceived = cashReceived; this.changeGiven = changeGiven;}

    //Getters
    //Getter for cashReceived
    public double getCashReceived() {return this.cashReceived;}
    //Getter for changeGiven
    public double getChangeGiven() {return this.changeGiven;}
    
}