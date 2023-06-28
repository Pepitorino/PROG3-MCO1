package VendingMachine;

import java.util.ArrayList;

public class ItemStack {
        private ArrayList<Item> items;
        private Item itemType;

        public ItemStack(Item item) {
            this.items = new ArrayList<Item>();
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

        public void setItemPrice(double price) {
            this.itemType.setPrice(price);
        }
    }