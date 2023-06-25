package VendingMachine;

import java.util.ArrayList;

public class NewRegVendMachine {
    private class itemStack {
        private ArrayList<Item> items;
        private Item itemType;

        public itemStack(Item item) {
            this.itemType = item;
        }

        public int getNumItems() {
            return this.items.size(); 
        }

        public Item popItem() {
            this.items.remove(itemType);
            return itemType;
        }

        public void pushItem() {
            this.items.add(new Item(this.itemType));
        }

        public String getItemName() {
            return this.itemType.getName();
        }

        public double getItemPrice() {
            return this.itemType.getPrice();
        }

        public double getItemCalories() {
            return this.itemType.getCalories();
        }
    }

    ArrayList<itemStack> itemTypes;

    public NewRegVendMachine() {
        this.itemTypes = new ArrayList<itemStack>(16);
    }

    //Testing Features

    //Maintenance Features
    public void restockItem() {
        
    }

    public void addNewItem(Item item) {
        this.itemTypes.add(new itemStack(item));
    }

    public void removeItem(Item item) {
        this.itemTypes.remove(item);
    }

    //Getters
    public ArrayList<String> getItems() {
        ArrayList<String> items;
        for(int i = 0 ; i<this.itemTypes.size() ; i++) {
            items.add(this.itemTypes.getItemName());
        }
        return items;
    }
}

