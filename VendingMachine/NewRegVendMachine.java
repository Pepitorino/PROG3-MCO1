package VendingMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class representing a vending machine.
 */
public class NewRegVendMachine {
    private CashRegister cashHandler;
    private ArrayList<ItemStack> itemTypes;

    public static int MAX_ITEMTYPES = 8;
    public static int MAX_ITEMS = 16;

    public NewRegVendMachine() {
        this.itemTypes = new ArrayList<ItemStack>(MAX_ITEMTYPES);
        this.itemTypes.add(new ItemStack(new Item( 
        "Egg", 10, 100
        )));
        this.itemTypes.add(new ItemStack(new Item(
        "Beef",150,500
        )));
        this.itemTypes.add(new ItemStack(new Item(
        "Carrot",20,25
        )));
        this.itemTypes.add(new ItemStack(new Item(
        "Rice",50,130
        )));
        this.itemTypes.add(new ItemStack(new Item(
        "Peas",75,80
        )));
        this.itemTypes.add(new ItemStack(new Item(
        "Spring Onions",30,25
        )));
        this.itemTypes.add(new ItemStack(new Item(
        "Sweet sauce",15,5
        )));
        this.itemTypes.add(new ItemStack(new Item(
        "Spicy sauce",15,10
        )));
        this.cashHandler = new CashRegister(0,0,0,0,0,0,0,0,0,0,0); 
    }

    //Testing Features
    public void featuresVending() {
        Scanner input = new Scanner(System.in);
        int x = -1;
        do {
            System.out.printf("\nVENDING MACHINE MENU\n");
            System.out.printf("1. Back\n2. Display Items\n3. ");
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
                default:
                    System.out.printf("\nINVALID INPUT\n");
            }
        } while (x!=1);

    }

    //Maintenance Features
    public void featuresMaintenance() {
        Scanner input = new Scanner(System.in);
        int x = -1;
        do {
            System.out.printf("\nVENDING MACHINE MAINTENANCE MENU\n");
            System.out.printf("1. Back\n2. Display Items\n3. Restock Items\n4. Set Item Price\n5. Restock Money");
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
                    this.setItemPrice();
                    break;
                case 5:
                    this.restockMoney();
                    break;
                default:
                    System.out.printf("\nINVALID INPUT\n");
            }
        } while (x!=1);
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
            if (stock<0||stock>MAX_ITEMS-(this.itemTypes.get(index-1).getNumItems())) System.out.printf("\nINVALID INPUT\n");
        } while (stock<0||stock>MAX_ITEMS-(this.itemTypes.get(index-1).getNumItems()));

        for (int i=0 ; i<stock ; i++) {
            this.itemTypes.get((index-1)).pushItem();
        }
    }

    private void setItemPrice() {
        Scanner input = new Scanner(System.in);
        int x = 0;
        double price = 0;

        do {
            this.displayItems();
            System.out.printf("\nWhich item would you like to change price? ");
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

        System.out.printf("\nENTER NEW PRICE: ");
        try {
            System.out.printf("\nINPUT: ");
            price = input.nextDouble();       
        }
        catch (InputMismatchException e) {
            System.out.printf("\nINVALID INPUT\n");
            input.nextLine();
        }

        this.itemTypes.get(x-1).setItemPrice(price);
    }

    private void restockMoney() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> restock = new ArrayList<Integer>();
        ArrayList<String> denominations = new ArrayList<String>();
        List<String> stringsToAdd = Arrays.asList("Ones","Fives","Tens","Twenties","Fifties","One Hundreds","Two Hundreds","Five Hundreds","One Thousands");
        denominations.addAll(stringsToAdd);
        
        int quantity;
        
        for(int i=0 ; i < 9;i++) {
            System.out.println("How many " + denominations.get(i) + " To add ");
            quantity = input.nextInt();
            restock.add(quantity);
        }
        
        cashHandler.stockInternal(restock);
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
            items.add(tempItem.getNumItems());
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
        
        System.out.printf("\nNAME--STOCK--CAL--PRICE");
        for (int i=0 ; i < this.itemTypes.size() ; i++) {
            System.out.printf("\n%d. %s--%d--%.2f--%.2f", i+1, itemNames.get(i), itemStock.get(i), itemCalories.get(i), itemPrice.get(i));
        }
        System.out.printf("\n");
    }
}
