import java.util.ArrayList;

public class RegVendMachine {
    ArrayList<Item> itemA = new ArrayList<>();
    ArrayList<Item> itemB = new ArrayList<>();
    ArrayList<Item> itemC = new ArrayList<>();
    ArrayList<Item> itemD = new ArrayList<>();
    ArrayList<Item> itemE = new ArrayList<>();
    ArrayList<Item> itemF = new ArrayList<>();
    ArrayList<Item> itemG = new ArrayList<>();
    ArrayList<Item> itemH = new ArrayList<>();
    
    double intChange;
    double insertCash;
    double totalSales;
    
    int totalItemSales;
    
    boolean isPaid = false;
    
    public void addItem(ArrayList<Item> itemList, Item item) {
        itemList.add(item);
    }
    
    public void removeItem(ArrayList<Item> itemList, int index, boolean isPaid) {
        if (isPaid) {
            if (index >= 0 && index < itemList.size()) {
                itemList.remove(index);
                System.out.println("Item removed successfully.");
            } else {
                System.out.println("Invalid index.");
            }
        } else {
            System.out.println("Payment not received. Cannot remove item.");
        }
    }

    public void checkPay(double price, double cash, boolean isPaid){

        if(cash >= price)
	  isPaid = true;
    }

    public double getChange(double intChange, double price, double cash,boolean isPaid){

	 double realChange = 0;	

         if (isPaid){
	    if (cash >= price && cash > 0){
		realChange = price - cash;
		intChange = intChange - realChange;
	    }
	 }

	 return realChange;
    }

    public void collectChange(double intChange){
	intChange = intChange - intChange;
    }

    public void addChange(double intChange){

 	intChange = intChange + 
    }
}