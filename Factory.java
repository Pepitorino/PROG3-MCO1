import VendingMachine.*;
import java.util.Scanner;

public class Factory {
    private NewRegVendMachine vm;

    public void createVM() {
        int x = -1;
        Scanner input = new Scanner(System.in);

        do {
            System.out.printf("\nHow many items will this vending machine have? (Max 8)\nINPUT:");
            x = input.nextInt();   
        } while ( x<1 || x>8 );

        for (int i = 0 ; i<x ; i++) {
            System.out.printf("\nItem #%d\n", i);
        }

    }

    public void testVM() {

    }
}