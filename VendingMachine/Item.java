package VendingMachine;

public class Item {
    private String name;
    private double price;
    private double calories;

    //Item class constructor
    public Item(String name, double price, double calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    //Item class constructor override for item that exists
    public Item(Item item) {
        this.name = item.name;
        this.price = item.price;
        this.calories = item.calories;
    }

    //Getters and setters
    //Getter for name
    public String getName() {
        return name;
    }
    
    // idt name should be settable?
    // public setName(String name){
    //     this.name = name;
    // }
    
    // public int getPosition() {
    //     return position;
    // }
    
    // public void setPosition(int position){
    //     this.position = position;
    // }

    //Getter for price
    public double getPrice() {
        return price;
    }

    //Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    //Getter for calories
    public double getCalories() {
        return calories;
    }
    
    // idt calories should be settable either?
    // public setCalories(double calories){
    //     this.calories = calories;
    // }
}