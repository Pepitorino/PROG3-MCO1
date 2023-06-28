import VendingMachine.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A class representing a factory
 */
public class Factory {
    private NewRegVendMachine vm;

    //VM creation
    public void createVM() {
        this.newVM = new NewRegVendMachine();
    }

    //VM testing
    public void testVM() {
        Scanner input = new Scanner(System.in);
        int x = -1;
        do {
            System.out.printf("\nVENDING MACHINE TEST MENU\n");
            System.out.printf("1. Back\n2. Vending Features\n3. Maintenance Feature");
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
                    this.vm.featuresVending();
                    break;
                case 3:
                    this.vm.featuresMaintenance();
                    break;
                default:
                    System.out.printf("\nINVALID INPUT\n");
            }
        } while (x!=1);
    }
}