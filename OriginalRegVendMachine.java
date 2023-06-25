import java.util.ArrayList;

public class OriginalRegVendMachine {
    private ArrayList<Item> items = new ArrayList<Item>();

    private double intChange;
    private double insertCash;

    private double totalSales;
    private int totalItemSales;

    private boolean isPaid = false;
    
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

        if (isPaid) {
	        if (cash >= price && cash > 0) {
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