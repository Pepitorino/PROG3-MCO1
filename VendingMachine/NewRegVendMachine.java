package VendingMachine;

import java.util.ArrayList;

public class NewRegVendMachine {

    private class ItemStack {
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
    }

    ArrayList<ItemStack> itemTypes;

    public NewRegVendMachine() {
        this.itemTypes = new ArrayList<ItemStack>(16);
    }

    //Testing Features

    //Maintenance Features
    public void restockItem(int index) {
        
    }

    public void depleteItem(int index) {

    }

    public void addNewItemStack(Item item) {
        if (this.itemTypes.size()<16) this.itemTypes.add(new ItemStack(item));
        else System.out.printf("ALL SLOTS BEING USED");
    }

    public void removeItemStack(int index) {
        this.itemTypes.remove(index);
    }

    //Getters
    public ArrayList<String> getItemNames() {
        ArrayList<String> items = new ArrayList<String>();
        for(int i=0 ; i<this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            items.add(tempItem.getItemName());
        }
        return items;
    }

    //Helper functions
    public boolean checkIfItemExists(String string) {
        for (int i=0 ; i<this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            if (string.equals(tempItem.getItemName())) return true;
        }
        return false;
    }
}

