package VendingMachine;

public class Item {
    private String name;
    private double price;
    private double calories;

    public Item(String name, double price, double calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public Item(Item item) {
        this.name = item.name;
        this.price = item.price;
        this.calories = item.calories;
    }
    
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
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getCalories() {
        return calories;
    }
    
    // idt calories should be settable either?
    // public setCalories(double calories){
    //     this.calories = calories;
    // }
}