import VendingMachine.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Factory factory = new Factory();

        boolean vmExists = false;

        int i = -1;
        do {
            System.out.printf("WELCOME\n");
            System.out.printf("Menu:\n1. Exit\n2. Create Vending Machine\n3. Test Vending Machine\nINPUT: ");
            try {
                i = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.printf("\nINVALID ERROR\n");
                input.nextLine();
            }

            switch (i)
            {
                case 1:
                    break;
                case 2:
                    factory.createVM();
                    vmExists = true;
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