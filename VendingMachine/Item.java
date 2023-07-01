package VendingMachine;

/**
 * A class representing a singular item
 */
public class Item {
    private String name;
    private double price;
    private double calories;

    /**
     * Constructor for the Item class
     * @param name - name of Item
     * @param price - price of Item
     * @param calories - amount of calories in Item
     */
    public Item(String name, double price, double calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    /**
     * Constructor for the Item class using existing item
     * @param item - Item to copy
     */
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
}