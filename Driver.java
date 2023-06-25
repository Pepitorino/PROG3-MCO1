import java.util.Scanner;

public class Driver {
    public static void Main() {
        Scanner input = new Scanner(System.in);
        Factory factory = new Factory();

        int i = -1;
        do {
            System.out.printf("WELCOME\n");
            System.out.printf("Menu:\n1. Create a Vending Machine\n2. Test a Vending Machine\n3. Exit");
            switch (i)
            {
                case 1:
                    factory.createVM();
                    break;
                case 2:
                    factory.testVM();
                    break;
                case 3:
                    break;
                default:
                    System.out.printf("\nINVALID OPTION\n");
            }
        } while (i!=3);
    }
}