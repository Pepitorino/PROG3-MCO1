import VendingMachine.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Factory {
    private NewRegVendMachine vm;

    public void inputItem(NewRegVendMachine vm, int itemNum) {
        Scanner input = new Scanner(System.in);
        for (int i = 0 ; i<itemNum ; i++) {
            String tempName = "\n";
            double tempPrice = 0;
            double tempCal = 0;
            System.out.printf("\nItem #%d\n", i+1);
            System.out.printf("Enter item name: ");

            do {
                tempName = input.nextLine();
                if (tempName.equals("\n")) System.out.printf("\nINVALID INPUT\n");
            } while (tempName.equals("\n"));

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

            input.nextLine();

            vm.addNewItem(new Item(tempName, tempPrice, tempCal));
        }
    }

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

        input.nextLine();

        inputItem(newVM, x);

        this.vm = newVM;
    }

    public void testVM() {

    }
}