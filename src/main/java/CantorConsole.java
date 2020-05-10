import model.User;
import model.Wallet;
import utils.Display;
import utils.ConfigurationLoader;
import java.io.IOException;

public class CantorConsole {
    public static Display display = new Display();
    public static ConfigurationLoader configurationLoader = new ConfigurationLoader();

    public static void main(String[] args) throws IOException {
        configurationLoader.loadProperties();

//        display.displayWalletMenu();
        display.displayWalletBalance();
        display.displayChargeBalance();
        display.displayWalletBalance();

//        Wallet wallet = new Wallet(456, 55, "aaa", "bbb", "ccc");
//        Wallet walletKoncowy = new Wallet();
//
//        walletKoncowy.setEnterWallet();
//        walletKoncowy.walletUpdate();
//        System.out.println("WYNIK KONCOWY: " + walletKoncowy);


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
    }
}