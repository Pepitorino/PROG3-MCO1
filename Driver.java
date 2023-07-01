import VendingMachine.*;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This driver tests the factory and vending machine.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Factory factory = new Factory();

        boolean vmExists = false;

        int i = -1;
        do {
            System.out.printf("\nWELCOME\n");
            System.out.printf("Menu:\n1. Exit\n2. Create New Regular Vending Machine\n3. Test Vending Machine\nINPUT: ");
            try {
                i = input.nextInt();
            }
            catch (InputMismatchException e) {
                input.nextLine();
            }

            switch (i)
            {
                case 1:
                    break;
                case 2:
                    factory.createVM();
                    vmExists = true;
                    System.out.printf("\nVENDING MACHINE SUCCESSFULLY CREATED\n");
                    break;
                case 3:
                    if (vmExists) factory.testVM();
                    else System.out.printf("\nVENDING MACHINE DOES NOT EXIST\n");
                    break;
                default:
                    System.out.printf("\nINVALID OPTION\n");
            }
        } while (i!=1);
    }
}