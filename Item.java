public class Item {
    private String name;
    private int position;
    private double price;
    private double calories;

    public Item(String name, int position, double price, double calories) {
        this.name=name;
        this.position=position;
        this.price=price;
        this.calories=calories;
    }
    
    public String getName() {
        return name;
    }
    
    // idt name should be settable?
    // public setName(String name){
    //     this.name = name;
    // }
    
    public int getPosition() {
        return position;
    }
    
    public setPosition(int position){
        this.position = position;
    }
    
    public double getPrice() {
        return price;
    }
    
    public setPrice(double price){
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