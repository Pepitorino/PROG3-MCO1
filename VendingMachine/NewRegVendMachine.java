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
            System.out.printf("1. Back\n2. Display Items\n3. Restock Items\n4. Add New Item\n5. Remove Item\n6. Set Item Price");
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
                    this.displayItems();
                    break;
                case 3:
                    this.restockItem();
                    break;
                case 4:
                    if (this.itemTypes.size()<this.MAX_ITEMTYPES) this.addNewItemStack();
                    else System.out.printf("MAX ITEMS REACHED");
                    break;
                case 5:
                    if (this.itemTypes.size()>0) this.removeItemStack();
                    else System.out.printf("VENDING MACHINE EMPTY");
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

    public void addNewItemStack(Item item) {
        if (this.itemTypes.size()<MAX_ITEMTYPES) this.itemTypes.add(new ItemStack(item));
        else System.out.printf("ALL SLOTS BEING USED");
    }

    private void addNewItemStack() {
        Scanner input = new Scanner(System.in);
        String tempName = "\n";
        double tempPrice = 0;
        double tempCal = 0;
        int stock = 0;
        System.out.printf("\nItem #%d\n", this.itemTypes.size()+1);

        do {
            System.out.printf("Enter item name: ");
            tempName = input.nextLine();
            if (tempName.equals("\n")) System.out.printf("\nNAME CANNOT BE EMPTY\n");
            else if (this.checkIfItemExists(tempName)) System.out.printf("\nITEM ALREADY EXISTS\n");
        } while (tempName.equals("\n")||this.checkIfItemExists(tempName));

        do {
            try {
                System.out.printf("Enter item price (php): ");
                tempPrice = input.nextDouble();       
            }
            catch (InputMismatchException e) {
                System.out.printf("\nINVALID INPUT\n");
                input.nextLine();
            }
            if (tempPrice<0) System.out.printf("\nPRICE CANNOT BE NEGATIVE\n");
        } while (tempPrice<0);
        
        input.nextLine();

        do {
            try {
                System.out.printf("Enter item calories: ");
                tempCal = input.nextDouble();       
            }
            catch (InputMismatchException e) {
                System.out.printf("\nINVALID INPUT\n");
                input.nextLine();
            }
            if (tempCal<0) System.out.printf("\nCALORIES CANNOT BE NEGATIVE\n");
        } while (tempCal<0);

        do {
            try {
                System.out.printf("Enter item stock: ");
                stock = input.nextInt();       
            }
            catch (InputMismatchException e) {
                System.out.printf("\nINVALID INPUT\n");
                input.nextLine();
            }
            if (stock<0) System.out.printf("\nSTOCK CANNOT BE NEGATIVE\n");
            else if (stock>MAX_ITEMS) System.out.printf("\nSTOCK CANNOT BE GREATER THAN 16\n");
        } while (stock<0);

        input.nextLine();

        this.addNewItemStack(new Item(tempName, tempPrice, tempCal));
        this.stockItem(this.itemTypes.size()-1, stock);
    }

    private void removeItemStack() {
        Scanner input = new Scanner(System.in);
        int x = 0;

        do {
            this.displayItems();
            System.out.printf("\nWhich item would you like to remove? ");
            try {
                System.out.printf("\nINPUT: ");
                x = input.nextInt();       
            }
            catch (InputMismatchException e) {
                System.out.printf("\nINVALID INPUT\n");
                input.nextLine();
            }
            if (x<0||x>this.itemTypes.size()) System.out.printf("\nINVALID INPUT\n");
        } while (x<0||x>this.itemTypes.size());

        this.itemTypes.remove(x-1);
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
            System.out.printf("\n%d. %s\t%d\t%.2f\t%.2f", i+1, itemNames.get(i), itemStock.get(i), itemCalories.get(i), itemPrice.get(i));
        }
        System.out.printf("\n");
    }
}

