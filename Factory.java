import VendingMachine.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Factory {
    private NewRegVendMachine vm;

    public void createVM() {
        int x = -1;
        Scanner input = new Scanner(System.in);

        NewRegVendMachine newVM = new NewRegVendMachine();

        do {
            try {
                System.out.printf("\nHow many items will this vending machine have? (Max 16)\nINPUT:");
                x = input.nextInt();       
            }
            catch (InputMismatchException e) {
                System.out.printf("\nINVALID INPUT\n");
                input.nextLine();
            }
        } while ( x<1 || x>16 );

        for (int i = 0 ; i<x ; i++) {
            System.out.printf("\nItem #%d\n", i+1);
            System.out.printf("Enter item name: ");
            do {
                
            } while (input.nextLine().equals("\n"));
        }

        this.vm = newVM;

    }

    public void testVM() {

    }
}