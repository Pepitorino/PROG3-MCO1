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
    private ArrayList<ItemStack> itemTypes;
    private ArrayList<ItemStack> lastItemStock;
    private ArrayList<Transaction> transactions;
    private CashRegister cashHandler;
    private static int MAX_ITEMTYPES = 16;
    private static int MAX_ITEMS = 16;

    public NewRegVendMachine() {
        this.cashHandler = new CashRegister(0,0,0,0,0,0,0,0,0,0,0);
        this.transactions = new ArrayList<Transaction>();
        this.itemTypes = new ArrayList<ItemStack>(8);
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
        System.out.printf("\nBasic Items Set!\n");
    }

    //Testing Features
    public void featuresVending() {
        Scanner input = new Scanner(System.in);
        int x = -1;
        do {
            System.out.printf("\nVENDING MACHINE MENU\n");
            System.out.printf("1. Back\n2. Display Items\n3. Buy Item");
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
                    if (this.itemsInStock()) this.buyItem();
                    else System.out.printf("\nNO ITEMS IN STOCK\n");
                    break;
                default:
                    System.out.printf("\nINVALID INPUT\n");
            }
        } while (x!=1);

    }

    private Item buyItem() {
        Scanner input = new Scanner(System.in);
        int index=0;

        this.displayItems();

        do {
            try {
                System.out.printf("\nEnter item you would like to buy (0 to exit): ");
                index = input.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("\nINVALID INPUT\n");
                input.nextLine();
            }
            if (index==0) return null;
            else if (index < 0 || index > this.itemTypes.size()) System.out.printf("\nINVALID INPUT\n");
            else if (this.itemTypes.get(index-1).getNumItems()==0) {
                System.out.printf("\nOUT OF STOCK\n");
                index=-1;
            }
        } while (index < 1 || index > this.itemTypes.size());

        double price = this.itemTypes.get(index-1).getItemPrice();

        int[] monies = {0,0,0,0,0,0,0,0,0,0};

        int choice=0;
        double sum=0;

        System.out.printf("\nINSERT BILLS\n");
        do {
            System.out.printf("1. Cancel\n2. Ones\n3. Fives\n4.Tens\n5. Twenties\n6. Fifties\n7. One Hundreds\n8. Two Hundreds\n9. Five Hundred\n9. One Thousands\nINPUT: ");
            try {
                choice = input.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("\nINVALID INPUT\n");
                input.nextLine();
            }
            if (choice < 1 || choice > monies.length) System.out.printf("\nINVALID INPUT\n");
            else {
                monies[choice-2]++;
                switch (choice) {
                    case 1:
                        sum+=1;
                        break;
                    case 2:
                        sum+=5;
                        break;
                    case 3:
                        sum+=10;
                        break;
                    case 4:
                        sum+=20;
                        break;
                    case 5:
                        sum+=50;
                        break;
                    case 6:
                        sum+=100;
                        break;
                    case 7:
                        sum+=200;
                        break;
                    case 8:
                        sum+=500;
                        break;
                    case 9:
                        sum+=1000;
                        break;
                    default:
                        break;
                }
            }
        } while (choice != 1 && sum < price);

        if (choice==1) {
            System.out.printf("\nRETURNING INSERTED BILLS\n");
            return null;
        }

        ArrayList<Integer> change = this.cashHandler.calculateChange(price, sum);

        if (change.get(change.size()-1)==-1) {
            System.out.printf("\nSORRY NOT ENOUGH CHANGE");
            System.out.printf("\nRETURNING INSERTED BILLS\n");
             System.out.printf("\nCANCELLING TRANSACTION...\n");
             return null;
        }

        System.out.printf("\nDISPENSING CHANGE\n");

        ArrayList<Integer> newBills = new ArrayList<Integer>();

        for (int i = 0; i < monies.length; i++)
            newBills.add(monies[i]);

        this.cashHandler.stockInternal(newBills); 

        System.out.printf("\nDISPENSING ITEM\n");     

        this.transactions.add(new Transaction(this.cashHandler.getChange(), price));

        return this.itemTypes.get(index-1).popItem();
    }

    //Maintenance Features
    public void featuresMaintenance() {
        Scanner input = new Scanner(System.in);
        int x = -1;
        do {
            System.out.printf("\nVENDING MACHINE MAINTENANCE MENU\n");
            System.out.printf("1. Back\n2. Display Items\n3. Restock Items\n4. Set Item Price\n5. Restock Money\n6. Add New Item\n7. Remove Item");
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
                case 6:
                    this.addNewItemStack();
                    break;
                case 7:
                    this.removeItemStack();
                    break;
                default:
                    System.out.printf("\nINVALID INPUT\n");
            }
        } while (x!=1);
    }

    private void stockItem(int index, int stock) {
        for(int i=0 ; i < stock ; i++) {
            this.itemTypes.get(index).pushItem();
        }
        this.lastItemStock = this.itemTypes;
        this.transactions.clear();
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

        this.lastItemStock = this.itemTypes;
        this.transactions.clear();
    }

    private void addNewItemStack(Item item) {
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
        
        this.cashHandler.stockInternal(restock);
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
    private boolean checkIfItemExists(String string) {
        for (int i=0 ; i < this.itemTypes.size() ; i++) {
            ItemStack tempItem = this.itemTypes.get(i);
            if (string.equals(tempItem.getItemName())) return true;
        }
        return false;
    }

    private void displayItems() {
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

    private boolean itemsInStock() {
        int i=0;
        int itemsNotInStock=0;
        for (i=0 ; i<this.itemTypes.size() ; i++) {
            if (this.itemTypes.get(i).getNumItems()==0) itemsNotInStock++;
        }
        if (itemsNotInStock==this.itemTypes.size()) return false;
        return true;
    }
}
