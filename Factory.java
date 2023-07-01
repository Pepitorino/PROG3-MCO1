import VendingMachine.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A class representing the vending machine factory
 */
public class Factory {
    private NewRegVendMachine vm;

    //VM creation

    /**
     * Creates a vending machine for the factory
     */
    public void createVM() {
        this.vm = new NewRegVendMachine();
    }

    //VM testing

    /**
     * Tests current vending machine in factory
     */
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
            //Perform action based on user's input
            switch (x) {
                case 1: 
                    break;
                case 2:
                    this.vm.featuresVending(); //Call featuresVending() method of NewRegVendMachine
                    break;
                case 3:
                    this.vm.featuresMaintenance(); //Call featuresMaintenace() method NewRegVendMachine
                    break;
                default:
                    System.out.printf("\nINVALID INPUT\n");
            }
        } while (x!=1); //loop until user chooses to return
    }
}