package VendingMachine;

import java.util.ArrayList;

public class ItemStack {
    private ArrayList<Item> items;
    private Item itemType;

    // ItemStack constructor
    public ItemStack(Item item) {
        this.items = new ArrayList<Item>();
        this.itemType = item;
    }

    // Get the total number of items in the ItemStack
    public int getNumItems() {
        return this.items.size();
    }

    // Retrieve and remove an item from the stack
    public Item popItem() {
        this.items.remove(this.items.size()-1);
        return itemType;
    }

    // Add an item to the stack
    public void pushItem() {
        this.items.add(new Item(this.itemType));
    }

    // Getters

    // Get the name of the item in the stack
    public String getItemName() {
        return this.itemType.getName();
    }

    // Get the price of the item in the stack
    public double getItemPrice() {
        return this.itemType.getPrice();
    }

    // Get the calories of the item in the stack
    public double getItemCalories() {
        return this.itemType.getCalories();
    }

    // Set the price of the item in the stack
    public void setItemPrice(double price) {
        this.itemType.setPrice(price);
    }
}