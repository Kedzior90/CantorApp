package utils;

import model.Transaction;
import model.User;
import model.Wallet;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Display {
    public User user = new User();
    public Transaction transaction = new Transaction();
    public Database database = new Database();
    public Wallet wallet = new Wallet();
    public Helper helper = new Helper();

    public void displayCantorRunner() throws IOException {
        int value;
        do
        {
            displayMainMenu();
            System.out.print("Enter value: \n");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch(value) {
                case 1:
                    displayUserRegister();
                    break;
                case 2:
                    if (displayLogin() == true){
                        do {
                            displayUserMenu();
                            System.out.printf("Enter value: \n");
                            value = scanner.nextInt();

                            switch (value) {
                                case 1:
                                    displayTransaction();
                                    break;
                                case 2:
                                    displayWalletCharge();
                                    break;
                                case 3:
                                    displayWalletBalance();
                                    break;
                                case 4:
                                    displayTransactionDatabaseFile();
                                    break;
                            }
                        } while (value!=9);
                    }
                    break;
                case 3:
                    displayCheckRates();
                    break;
                case 4:
                    displayTransaction();
                    break;
            }
        } while(value!=0);
    }

    public void displayMainMenu() {
        System.out.print("\n************************************\n");
        System.out.print("************   Cantor   ************");
        System.out.print("\n************************************\n");
        System.out.print("1. Register\n");
        System.out.print("2. Login\n");
        System.out.print("3. Check rates\n");
        System.out.print("4. Transaction\n");
        System.out.print("0. Exit");
        System.out.print("\n************************************\n");
    }

    public void displayUserRegister() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tRegister User");
        System.out.print("\n************************************\n");
        user.setLogin();
        user.setName();
        user.setSurname();
        user.setPassword();
        user.setUserId();
        user.setDataCreation();

//        zapisanie w bazach danych
        database.saveInDatabase(user);
        database.saveNewUserInWalletDatabase(user);

        System.out.print("\n*********** Created User ***********\n");
        System.out.print("User ID:\t\t" + user.userId +
                "\nLogin:\t\t\t" + user.login +
                "\nUser Name:\t\t" + user.name +
                "\nUser Surname:\t" + user.surname +
                "\nCreation Date:\t" + user.creationDate);
        System.out.print("\n************************************\n");
    }

    public void displayTransaction() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tTransaction");
        System.out.print("\n************************************\n");
        transaction.setAmount();
        transaction.setCurrency1();
        transaction.setCurrency2();

//        obliczanie kursu waluty
        transaction.setRate(transaction.getCurrency1(), transaction.getCurrency2());

//        obliczanie wartosci wymiany
        transaction.setValue(transaction.getRate(), transaction.getAmount());

//        ustalanie daty tranzakcji
        transaction.setTradeDate();

//        zapisanie tranzakcji w bazie danych
//        database.saveTransactionInDatabase(transaction, user);
        database.saveInDatabase(user, transaction);

        System.out.print("\n********* Transaction data *********\n");
        System.out.print("TradeDate:\t" + transaction.tradeDate +
                "\nAmount:\t\t" + transaction.amount +
                "\nCurrency1:\t" + transaction.currency1 +
                "\nCurrency2:\t" + transaction.currency2 +
                "\nRate:\t\t" + transaction.rate +
                "\nUser ID:\t" + user.userId +
                "\nLogin:\t\t" + user.login +
                "\nName:\t\t" + user.name +
                "\nSurname:\t" + user.surname);

        System.out.print("\n************************************\n");
    }

    public boolean displayLogin() {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tLogin");
        System.out.print("\n************************************\n");
        user.setLogin(); // System.out.print("Enter User Login: ");
        user.setPassword(); // System.out.print("Enter User Password: ");
        boolean login = false;

        if (database.loginChecker(user.login, user.password) == true) {
//            zeby utowrzyc obiekt user z danych z bazy danych o userDatabase
            helper.searchUserInUserDatabase(user);
            login = true;
            System.out.println("\tLogin accepted");
        } else {
            System.out.println("\tWrong login/password");
        }

        return login;
    }

    public void displayCheckRates () throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tCheck Rates");
        System.out.print("\n************************************\n");
        transaction.setTradeDate();
        System.out.print("Today is: " + transaction.getTradeDate());

        System.out.println("\nEnter currency1: ");
        transaction.setCurrency1();

        System.out.println("Enter currency2: ");
        transaction.setCurrency2();

        transaction.setRate(transaction.getCurrency1(), transaction.getCurrency2());
        System.out.println("Rate: " + transaction.getRate());
    }

    public void displayUserMenu() {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tUser Menu");
        System.out.print("\n************************************\n");
        System.out.print("\t\tWelcome: " + user.login + "\n");
        System.out.print("1. Transaction\n");
        System.out.print("2. Charge Wallet\n");
        System.out.print("3. Display Wallet's Balance\n");
        System.out.print("4. Display User's transactions\n");
        System.out.print("9. <- Back Menu\n");
        System.out.print("\n************************************\n");
    }
    ;
    public void displayTransactionDatabaseFile() {
        System.out.print("\n************************************\n");
        System.out.print("\tTransaction Database file");
        System.out.print("\n************************************\n");
        helper.searchUserTransactions(user, transaction);
    }

    public void displayWalletBalance() {
        System.out.print("\n************************************\n");
        System.out.print("\t*" + user.login + "* wallet balance");
        System.out.print("\n************************************\n");
//        wallet.searchUserWallet(user); // szukanie uzytkownika po loginie w bazie danych i tworzenie mu portfela na podstawie danych z bazy danych
        helper.searchUserWallet(user, wallet);
        System.out.println("Wallet Balance: " + wallet.walletBalance);
    }

    public void displayWalletCharge() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t*" + user.login + "* charge wallet balance");
        System.out.print("\n************************************\n");
        helper.searchUserWallet(user, wallet); //tworzenie portfela zalagowanego uzytkownika
        System.out.println("Enter Value: ");
        wallet.setEnterWallet();
//        helper.walletUpdate();

        System.out.print("\n********** Wallet Status **********\n");
        System.out.print("Wallet balance: " + wallet.walletBalance +
                "\nLogin:\t\t\t" + wallet.walletLogin +
                "\nName:\t\t\t" + wallet.walletName +
                "\nSurname:\t\t" + wallet.walletSurname);
        System.out.print("\n************************************\n");
    }

    public void displayUserDatabaseFile() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers Database file");
        System.out.print("\n************************************\n");
//        List<User> usersList = database.readUserDatabaseFile();
        List<User> usersList = database.readDatabaseFile(user);

        int k = 1;
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println("ID: " + k + ", " + usersList.get(i).toString());
            k++;
        }
    }

    public void displayUserListSortedById() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by User ID");
        System.out.print("\n************************************\n");
//        database.userListSortedById();
    }

    public void displayUserListSortedByLogin() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Login");
        System.out.print("\n************************************\n");
//        database.userListSortedByLogin();
    }

    public void displayUserListSortedByName() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Name");
        System.out.print("\n************************************\n");
//        database.userListSortedByName();
    }

    public void displayUserListSortedBySurname() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Surname");
        System.out.print("\n************************************\n");
//        database.userListSortedBySurname();
    }

    public void displayUserListSortedByCreationDate() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Creation Date");
        System.out.print("\n************************************\n");
//        database.userListSortedByCreationDate();
    }

    public void displayTest (){
        System.out.print("\n************************************\n");
        System.out.print("\t\tTest *");
        System.out.print("\n************************************\n");
    }

//    -------------------------------do not remove !!! to use for future main menu fixing ------------------------------------

//    public void displayUserDatabase() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\t\tUser Database");
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tWelcome: " + user.login);
//        System.out.print("\n1. Display User Database");
//        System.out.print("\n2. Display Users sorted by ID");
//        System.out.print("\n3. Display Users sorted by Login");
//        System.out.print("\n4. Display Users sorted by Name");
//        System.out.print("\n5. Display Users sorted by Surname");
//        System.out.print("\n6. Display Users sorted by Email Address");
//        System.out.print("\n7. Display Users sorted by Creation date");
//        System.out.print("\n9. <- Back Menu");
//        System.out.print("\n************************************\n");
//    }
//
//    public void displayTradeDatabase() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\t\tTrade Database");
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tWelcome: " + user.login);
//        System.out.print("\n1. Display Trade Database");
//        System.out.print("\n2. Display Trade sorted by Amount");
//        System.out.print("\n3. Display Trade sorted by Currency1");
//        System.out.print("\n4. Display Trade sorted by Currency2");
//        System.out.print("\n5. Display Trade sorted by Rate");
//        System.out.print("\n6. Display Trade sorted by Value");
//        System.out.print("\n7. Display Trade sorted by TradeDate");
//        System.out.print("\n9. <- Back Menu");
//        System.out.print("\n************************************\n");
//    }
//
//    public void displayTradeFile() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade Database file");
//        System.out.print("\n************************************\n");
//        List<Trade> tradeList = database.readTradeDatabaseFile();
//
//        int k = 1;
//        for (int i = 0; i < tradeList.size(); i++) {
//            System.out.println("ID: " + k + ", " + tradeList.get(i));
//            k++;
//        }
//    }
//
//    public void displayUserDatabaseFile() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser Database file");
//        System.out.print("\n************************************\n");
//        List<User> usersList = database.readUserDatabaseFile();
//
//        int k = 1;
//        for (int i = 0; i < usersList.size(); i++) {
//            System.out.println("ID: " + k + ", " + usersList.get(i));
//            k++;
//        }
//    }
//
//    public void displayUserListSortedById() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by User ID");
//        System.out.print("\n************************************\n");
//        database.userListSortedById();
//    }
//
//    public void displayUserListSortedByLogin() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by Login");
//        System.out.print("\n************************************\n");
//        database.userListSortedByLogin();
//    }
//
//    public void displayUserListSortedByName() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by Name");
//        System.out.print("\n************************************\n");
//        database.userListSortedByName();
//    }
//
//    public void displayUserListSortedBySurname() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by Surname");
//        System.out.print("\n************************************\n");
//        database.userListSortedBySurname();
//    }
//
//    public void displayUserListSortedByEmailAddress() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tUser List Sorted by Email Address");
//        System.out.print("\n************************************\n");
//        database.userListSortedByEmailAddress();
//    }
//
//    public void displayUserListSortedByCreationDate() {
//        System.out.print("\n************************************\n");
//        System.out.print("\tUser List Sorted by Creation Date");
//        System.out.print("\n************************************\n");
//        database.userListSortedByCreationDate();
//    }
//
//    public void displayTest() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTest");
//        System.out.print("\n************************************\n");
//
////        displayTradeListSortedByAmount();
////        displayTradeListSortedByCurrency1();
////        displayTradeListSortedByCurrency2();
////        displayTradeListSortedByRate();
////        displayTradeListSortedByValue();
////        displayTradeListSortedByTradeDate();
//    }
//
//    public void displayTradeListSortedByAmount() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Amount");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByAmount();
//    }
//
//    public void displayTradeListSortedByCurrency1() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Currency1");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByCurrency1();
//    }
//
//    public void displayTradeListSortedByCurrency2() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Currency2");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByCurrency2();
//    }
//
//    public void displayTradeListSortedByRate() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Rate");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByRate();
//    }
//
//    public void displayTradeListSortedByValue() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by Value");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByValue();
//    }
//
//    public void displayTradeListSortedByTradeDate() {
//        System.out.print("\n************************************\n");
//        System.out.print("\t\tTrade List Sorted by TradeDate");
//        System.out.print("\n************************************\n");
//        database.tradeListSortedByTradeDate();
//    }
}