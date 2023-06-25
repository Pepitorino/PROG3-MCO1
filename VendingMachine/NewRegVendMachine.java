package VendingMachine;

import java.util.ArrayList;

public class NewRegVendMachine {
    private class itemStack {
        private ArrayList<Item> items;
        private Item itemType;

        public int getNumItems() {
            return this.items.length(); 
        }

        public Item popItem() {
            Item temp = this.items.get((this.items.length())-1);
            this.items.remove(temp);
            return temp;
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

    }

    //Testing Features

    //Maintenance Features
    public void restockItem() {
        
    }
}

