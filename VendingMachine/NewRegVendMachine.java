package VendingMachine;

import java.util.ArrayList;

public class NewRegVendMachine {
    private class itemStack {
        private ArrayList<Item> items;
        Item itemType;

        public int getNumOfItems() {
            return items.length(); 
        }

        public Item popItem() {
            Item temp = items.get(items.length()-1);
            items.remove(temp);
            return temp;
        }

        public void pushItem() {
            items.add(new Item(itemType));
        }
    }
    ArrayList<itemStack> itemsAvailable;
}

