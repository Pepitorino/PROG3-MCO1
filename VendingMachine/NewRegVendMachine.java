package VendingMachine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    public static int MAX_ITEMTYPES = 16;
    public static int MAX_ITEMS = 16;

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

    public void stockItem(int index, int stock) {
        for(int i=0 ; i < stock ; i++) {
            this.itemTypes.get(index).pushItem();
        }
    }

    private void restockItem() {
        Scanner input = new Scanner(System.in);
        int index = 0;
        int stock = 0;

        this.displayItems();
        do {
            try {
                System.out.printf("\nWhich item would you like to restock: ");
                index = input.nextInt();       
            }
            catch (InputMismatchException e) {
                System.out.printf("\nINVALID INPUT\n");
                input.nextLine();
            }
        } while (index<1||index>this.itemTypes.size());

        System.out.printf("\nHow much of this item would you like to restock? ");
        do {
            try {
                System.out.printf("\nINPUT: ");
                stock = input.nextInt();       
            }
            catch (InputMismatchException e) {
                System.out.printf("\nINVALID INPUT\n");
                input.nextLine();
            }
        } while (stock<0||stock>MAX_ITEMS-(this.itemTypes.get(index).items.size()));

        for (int i=0 ; i<stock ; i++) {
            this.itemTypes.get(index).pushItem();
        }
    }

    private void destockItem() {
    }

    public void addNewItemStack(Item item) {
        if (this.itemTypes.size()<16) this.itemTypes.add(new ItemStack(item));
        else System.out.printf("ALL SLOTS BEING USED");
    }

    private void addNewItemStack() {

    }

    private void removeItemStack() {
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

    public ArrayList<Integer> getItemStock() {
        ArrayList<Integer> items = new ArrayList<Integer>();
        for(int i=0 ; i < this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            items.add(tempItem.items.size());
        }
        return items;
    }

    public ArrayList<Double> getItemCalories() {
        ArrayList<Double> items = new ArrayList<Double>();
        for(int i=0 ; i < this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            items.add(tempItem.getItemCalories());
        }
        return items;
    }

    public ArrayList<Double> getItemPrice() {
        ArrayList<Double> items = new ArrayList<Double>();
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
        ArrayList<Integer> itemStock = this.getItemStock();
        ArrayList<Double> itemCalories = this.getItemCalories();
        ArrayList<Double> itemPrice = this.getItemPrice();
        
        System.out.printf("\nNAME\tSTOCK\tCAL\tPRICE");
        for (int i=0 ; i < this.itemTypes.size() ; i++) {
            System.out.printf("\n%s\t%d\t%.2f\t%.2f", itemNames.get(i), itemStock.get(i), itemCalories.get(i), itemPrice.get(i));
        }
    }
}

