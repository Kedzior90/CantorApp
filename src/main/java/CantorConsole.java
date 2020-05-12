import utils.Display;
import utils.ConfigurationLoader;
import java.io.IOException;
import java.util.Scanner;

public class CantorConsole {
    public static Display display = new Display();
    public static ConfigurationLoader configurationLoader = new ConfigurationLoader();

    public static void main(String[] args) throws IOException {
        configurationLoader.loadProperties();

//        display.displayWalletMenu();
//        display.displayWalletBalance();
//        display.displayChargeBalance();
//        display.displayWalletBalance();

        int value;

        do
        {
            display.displayMainMenu();
            System.out.print("Enter value: \n");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch(value) {
                case 1:
                    display.displayUserRegister();
                    break;
                case 2:
                    if (display.displayLogin() == true){
                        do {
                            display.displayUserMenu();
                            System.out.printf("Enter value: \n");
                            value = scanner.nextInt();

                            switch (value) {
                                case 1:
                                    display.displayTransaction();
                                    break;
                                case 2:
                                    display.displayWalletCharge();
                                    break;
                                case 3:
                                    display.displayWalletBalance();
                                    break;
                                case 4:
                                    display.displayUserDatabaseFile();
                                    break;
                                case 5:
                                    display.displayTradeFile();
                                    break;
                                case 6:
//                                    do zrobienia
//                                    System.out.print("1. Transaction\n");
//                                    System.out.print("2. Charge Wallet\n");
//                                    System.out.print("3. Display Wallet's Balance\n");
//                                    System.out.print("4. Display User's Database\n");
//                                    System.out.print("5. Display Trade's Database\n");
//                                    System.out.print("6. Display Transaction's Database -> TO DO\n");
//                                    System.out.print("9. <- Back Menu\n");
                                    break;
                            }
                        } while (value!=9);
                    }
                    break;
                case 3:
                    display.displayCheckRates();
                    break;
                case 4:
                    display.displayTransaction();
                    break;
            }
        } while(value!=0);
    }
}

//import utils.Display;
//        import utils.ConfigurationLoader;
//        import java.io.IOException;
//        import java.util.Scanner;
//
//public class CantorConsole {
//    public static Display display = new Display();
//    public static ConfigurationLoader configurationLoader = new ConfigurationLoader();
//
//    public static void main(String[] args) throws IOException {
//        configurationLoader.loadProperties();
//
////        display.displayWalletMenu();
////        display.displayWalletBalance();
////        display.displayChargeBalance();
////        display.displayWalletBalance();
//
//        int value;
//
//        do
//        {
//            display.displayMainMenu();
//            System.out.print("Enter value: \n");
//            Scanner scanner = new Scanner(System.in);
//            value = scanner.nextInt();
//
//            switch(value) {
//                case 1:
//                    display.displayUserRegister();
//                    break;
//                case 2:
//                    if (display.displayLogin() == true){
//                        do {
//                            display.displayUserMenu();
//                            System.out.printf("Enter value: \n");
//                            value = scanner.nextInt();
//
//                            switch (value) {
//                                case 1:
//                                    display.displayTransaction();
//                                    break;
//                                case 2:
//                                    display.displayTradeFile();
//                                    break;
//                                case 3:
//                                    display.displayUserDatabaseFile();
//                                    break;
//                                case 4:
//                                    display.displayUserListSortedById();
//                                    break;
//                                case 5:
//                                    display.displayUserListSortedByLogin();
//                                    break;
//                                case 6:
//                                    display.displayUserListSortedByName();
//                                    break;
//                                case 7:
//                                    display.displayUserListSortedBySurname();
//                                    break;
//                                case 8:
//                                    display.displayUserListSortedByEmailAddress();
//                                    break;
//                                case 9:
//                                    display.displayUserListSortedByCreationDate();
//                                    break;
//                            }
//                        } while (value!=10);
//                    }
//                    break;
//                case 3:
//                    display.displayCheckRates();
//                    break;
//                case 4:
//                    display.displayTransaction();
//                    break;
//            }
//        } while(value!=0);
//    }
//}