package utils;

import model.Transaction;
import model.User;
import model.Wallet;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    Database database = new Database();

    public Helper(){

    }

    public List<User> searchUserInUserDatabase(User user) {
        List<User> searchUserList = database.readDatabaseFile(user);
        List<User> newUser = new ArrayList<>();

        for (int i = 0; i < searchUserList.size(); i++) {
            if (searchUserList.get(i).login.equals(user.login)) {
                user.createUser(searchUserList.get(i).userId, searchUserList.get(i).login, searchUserList.get(i).name, searchUserList.get(i).surname);
                newUser.add(user);
            }
        }
        return newUser;
    }

//    szukanie wszystkich tranzakcji uzytkownika
    public void searchUserTransactions(User user, Transaction transaction) {
        List<Transaction> transactionList = database.readDatabaseFile(transaction);
        int k = 1;
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i).login.equals(user.login)) {
                    System.out.println("ID: " + k + ", " + transactionList.get(i));
                    k++;
                }
            }
    }

    public List<Wallet> searchUserWallet(User user, Wallet wallet) {
        List<Wallet> searchWalletList = database.readDatabaseFile(wallet); // wczytanie bazy danych do listy
        List<Wallet> userWallet = new ArrayList<>(); // ta zmienna zeby wartosc tego portfela byla w funkcji/zwaracla ja
        for (int i = 0; i < searchWalletList.size(); i++) {
            if (searchWalletList.get(i).login.equals(user.login)) {
                wallet.createUserWallet(searchWalletList.get(i).walletBalance, searchWalletList.get(i).userId, searchWalletList.get(i).login,
                        searchWalletList.get(i).name, searchWalletList.get(i).surname);
                userWallet.add(wallet);
            }
        }
        return userWallet;
    }

    public void walletUpdate (Wallet wallet) throws IOException {
        double updateWalletValue = wallet.walletBalance + wallet.enterWallet; // obliczanie nowej wartosci portfela
        wallet.walletBalance = updateWalletValue; // zapisanie do glownej zmiennej
        List<Wallet> searchWalletList = database.readDatabaseFile(wallet); //wczystanie bazy danych wszystkich uzytkownikow

//        stworzenie nowej listy uzytkownikow (starzy + nowy)
        for (int i = 0; i < searchWalletList.size(); i++) {
            if (searchWalletList.get(i).login.equals(wallet.login)) {
                searchWalletList.get(i).walletBalance = wallet.walletBalance; // zamienia wartosci
            }
        }

//        zapisanie listy uzystkonikow w pliku
        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int i = 0; i < searchWalletList.size(); i++) { // petla zeby liste zapisalo (kazdy wpis po przecinku)
            printWriter.print(searchWalletList.get(i) + "\n");
        }
        printWriter.close();
    }

//    ---------------------------------------------------------------------
//    public void userListSortedById() {
//        List<User> userId = readUserDatabaseFile();
//        userId.sort( Comparator.comparing(user -> user.userId) );
//
//        int k = 1;
//        for (int i = 0; i < userId.size(); i++) {
//            System.out.println("ID: " + k + ", " + userId.get(i));
//            k++;
//        }
//    }
//
//    public void userListSortedByLogin() {
//        List<User> userLogin = readUserDatabaseFile();
//        userLogin.sort(Comparator.comparing(user -> user.login));
//
//        int k = 1;
//        for (int i = 0; i < userLogin.size(); i++) {
//            System.out.println("ID: " + k + ", " + userLogin.get(i));
//            k++;
//        }
//    }
//
//    public void userListSortedByName() {
//        List<User> userName = readUserDatabaseFile();
//        userName.sort( Comparator.comparing(user -> user.name) );
//
//        int k = 1;
//        for (int i = 0; i < userName.size(); i++) {
//            System.out.println("ID: " + k + ", " + userName.get(i));
//            k++;
//        }
//    }
//
//    public void userListSortedBySurname() {
//        List<User> userSurname = readUserDatabaseFile();
//        userSurname.sort( Comparator.comparing(user -> user.surname) );
//
//        int k = 1;
//        for (int i = 0; i < userSurname.size(); i++) {
//            System.out.println("ID: " + k + ", " + userSurname.get(i));
//            k++;
//        }
//    }
//
//    public void userListSortedByCreationDate() {
//        List<User> creationDate = readUserDatabaseFile();
//        creationDate.sort( Comparator.comparing(user -> user.creationDate) );
//
//        int k = 1;
//        for (int i = 0; i < creationDate.size(); i++) {
//            System.out.println("ID: " + k + ", " + creationDate.get(i));
//            k++;
//        }
//    }
//
//    public void tradeListSortedByCurrency1() {
//        List<Trade> tradeCurrency1 = readTradeDatabaseFile();
//        tradeCurrency1.sort( Comparator.comparing(trade -> trade.currency1) );
//
//        int k = 1;
//        for (int i = 0; i < tradeCurrency1.size(); i++) {
//            System.out.println("ID: " + k + ", " + tradeCurrency1.get(i));
//            k++;
//        }
//    }
//
//    public void tradeListSortedByCurrency2() {
//        List<Trade> tradeCurrency2 = readTradeDatabaseFile();
//        tradeCurrency2.sort( Comparator.comparing(trade -> trade.currency2) );
//
//        int k = 1;
//        for (int i = 0; i < tradeCurrency2.size(); i++) {
//            System.out.println("ID: " + k + ", " + tradeCurrency2.get(i));
//            k++;
//        }
//    }
//
//    public void tradeListSortedByAmount() {
//        List<Trade> tradeAmount = readTradeDatabaseFile();
//        tradeAmount.sort( Comparator.comparing(trade -> trade.amount) );
//
//        int k = 1;
//        for (int i = 0; i < tradeAmount.size(); i++) {
//            System.out.println("ID: " + k + ", " + tradeAmount.get(i));
//            k++;
//        }
//    }
//
//    public void tradeListSortedByRate() {
//        List<Trade> tradeRate = readTradeDatabaseFile();
//        tradeRate.sort( Comparator.comparing(trade -> trade.rate) );
//
//        int k = 1;
//        for (int i = 0; i < tradeRate.size(); i++) {
//            System.out.println("ID: " + k + ", " + tradeRate.get(i));
//            k++;
//        }
//    }
//
//    public void tradeListSortedByValue() {
//        List<Trade> tradeValue = readTradeDatabaseFile();
//        tradeValue.sort( Comparator.comparing(trade -> trade.value) );
//
//        int k = 1;
//        for (int i = 0; i < tradeValue.size(); i++) {
//            System.out.println("ID: " + k + ", " + tradeValue.get(i));
//            k++;
//        }
//    }
//
//    public void tradeListSortedByTradeDate() {
//        List<Trade> tradeDate = readTradeDatabaseFile();
//        tradeDate.sort( Comparator.comparing(trade -> trade.tradeDate) );
//
//        int k = 1;
//        for (int i = 0; i < tradeDate.size(); i++) {
//            System.out.println("ID: " + k + ", " + tradeDate.get(i));
//            k++;
//        }
//    }
//
////    na razie nie potrzebne moze na pozniej
//    public String getDate (){
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        return currentDate = dateFormat.format(date);
//    }
}