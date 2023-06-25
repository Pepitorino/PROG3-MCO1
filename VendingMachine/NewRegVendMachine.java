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
    public void featuresVending() {

    }

    //Maintenance Features
    public void featuresMaintenance() {
        Scanner input = new Scanner(System.in);
        int x = -1;
        do {
            System.out.printf("\nVENDING MACHINE MAINTENANCE MENU\n");
            System.out.printf("1. Back\n2. Restock Items\n3. Destock Items\n4. Add New Item\n5. Remove Item\n6. Set Item Price");
            try {
                System.out.printf("\nINPUT: ");
                x = input.nextInt();       
            }
            catch (InputMismatchException e) {
                System.out.printf("\nINVALID INPUT\n");
                input.nextLine();
            }
            switch (x) {
                case 1: 
                    break;
                case 2:
                    this.restockItem();
                    break;
                case 3:
                    this.destockItem();
                    break;
                case 4:
                    this.addNewItemStack();
                    break;
                case 5:
                    this.removeItemStack();
                    break;
                case 6:
                    this.setItemPrice();
                    break;
                default:
                    System.out.printf("\nINVALID INPUT\n");
            }
        } while (x!=1);
    }

    private void restockItem(int index, int stock) {
        for (int i=0 ; i<stock ; i++) {
            itemTypes.get(index).pushItem();
        }
    }

    private void destockItem(int index, int num) {
        for (int i=0 ; i<stock ; i++) {
            itemTypes.get(index).popItem();
        }
    }

    private void addNewItemStack(Item item) {
        if (this.itemTypes.size()<16) this.itemTypes.add(new ItemStack(item));
        else System.out.printf("ALL SLOTS BEING USED");
    }

    private void removeItemStack(int index) {
        this.itemTypes.remove(index);
    }

    private void setItemPrice() {

    }

    //Getters
    public ArrayList<String> getItemNames() {
        ArrayList<String> items = new ArrayList<String>();
        for(int i=0 ; i < this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            items.add(tempItem.getItemName());
        }
        return items;
    }

    public ArrayList<int> getItemStock() {
        ArrayList<int> items = new ArrayList<int>();
        for(int i=0 ; i < this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            items.add(tempItem.getItemStock());
        }
        return items;
    }

    public ArrayList<int> getItemCalories() {
        ArrayList<int> items = new ArrayList<int>();
        for(int i=0 ; i < this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            items.add(tempItem.getItemCalories());
        }
        return items;
    }

    public ArrayList<double> getItemPrice() {
        ArrayList<double> items = new ArrayList<double>();
        for(int i=0 ; i < this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            items.add(tempItem.getItemPrice());
        }
        return items;
    }

    //Helper functions
    public boolean checkIfItemExists(String string) {
        for (int i=0 ; i < this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            if (string.equals(tempItem.getItemName())) return true;
        }
        return false;
    }

    public void displayItems() {
        ArrayList<String> itemNames = this.getItemNames();
        ArrayList<int> itemStock = this.getItemStock();
        ArrayList<int> itemCalories = this.getItemCalories();
        ArrayList<double> itemPrice = this.getItemPrice();
        
        System.out.printf("\nNAME\tSTOCK\tCAL\tPRICE");
        for (int i=0 ; i < this.itemTypes.size() ; i++) {
            System.out.printf("\n%s\t%d\t%d\t%s", itemNames.get(i), itemStock.get(i), itemCalories.get(i), itemPrice.get(i));
        }
    }
}

