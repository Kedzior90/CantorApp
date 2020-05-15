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
    String currentDate;

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
        List<Wallet> searchWalletList = database.readWalletDatabaseFile(); // wczytanie bazy danych do listy
        List<Wallet> userWallet = new ArrayList<>(); // ta zmienna zeby wartosc tego portfela byla w funkcji/zwaracla ja
//        Wallet wallet = new Wallet();
        for (int i = 0; i < searchWalletList.size(); i++) {
            if (searchWalletList.get(i).walletLogin.equals(user.login)) {
                wallet.createUserWallet(searchWalletList.get(i).walletBalance, searchWalletList.get(i).walletUserId, searchWalletList.get(i).walletLogin,
                        searchWalletList.get(i).walletName, searchWalletList.get(i).walletSurname);
//                Wallet newWallet = createUserWallet(searchWalletList.get(i).walletBalance, searchWalletList.get(i).walletUserId, searchWalletList.get(i).walletLogin,
//                        searchWalletList.get(i).walletName, searchWalletList.get(i).walletSurname);
                userWallet.add(wallet);
            }
        }
//        System.out.println("User Wallet zwrocony z petli: " + userWallet);
        return userWallet;
    }

//    -----------------------------original ---------------------------
//    public List<Wallet> searchUserWallet(User user) {
//        List<Wallet> searchWalletList = database.readWalletDatabaseFile(); // wczytanie bazy danych do listy
////        System.out.println("searchWalletList2: " + searchWalletList);
//        List<Wallet> userWallet = new ArrayList<>(); // ta zmienna zeby wartosc tego portfela byla w funkcji/zwaracla ja
//
////        sortowanie po kazdym wierszu w liscie
//        for (int i = 0; i < searchWalletList.size(); i++) {
////            if dla wybrania z wiersza jednej wartosci -> szukamy po walletLogin to wartosc w liscie a user login to wartosc zalogowanego usera
//            if (searchWalletList.get(i).walletLogin.equals(user.login)) {
////                jesli nam znalazlo ten jeden wiersz to tworzymy nowy wallet z nowymi danymi (tutaj te dane pobrane z bazy danych) i na nim pozniej dzialamy
//                //przypisanie do glownej zmiennej wallet -> uzywamy tutaj creatora do stworzenia portfela dla danego uzytkownika
//                Wallet newWallet = createUserWallet(searchWalletList.get(i).walletBalance, searchWalletList.get(i).walletUserId, searchWalletList.get(i).walletLogin,
//                        searchWalletList.get(i).walletName, searchWalletList.get(i).walletSurname);
////                System.out.println("User Wallet: " + newWallet);
//                userWallet.add(newWallet);
//            }
//        }
////        System.out.println("User Wallet zwrocony z petli: " + userWallet);
//        return userWallet;
//    }

//    public void walletUpdate () throws IOException {
//        double updateWalletValue = walletBalance + enterWallet; // obliczanie nowej wartosci portfela
//        this.walletBalance = updateWalletValue; // zapisanie do glownej zmiennej
////        System.out.println("walletBallance w glownej zmiennej: " + walletBalance);
//        List<Wallet> searchWalletList = readWalletDatabaseFile(); //wczystanie bazy danych wszystkich uzytkownikow
////        System.out.println("stara zawartosc calej bazy " + searchWalletList);
//
////        stworzenie nowej listy uzytkownikow (starzy + nowy)
//        for (int i = 0; i < searchWalletList.size(); i++) {
//            if (searchWalletList.get(i).walletLogin.equals(walletLogin)) {
//                searchWalletList.get(i).walletBalance = walletBalance; // zamienia wartosci
//            }
//        }
//
////        zapisanie listy uzystkonikow w pliku
//        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"));
//        PrintWriter printWriter = new PrintWriter(fileWriter);
////        petla po to zeby mi w pliku zapisalo dobrze po przecinku
//        for (int i = 0; i < searchWalletList.size(); i++) {
//            printWriter.print(searchWalletList.get(i) + "\n");
//        }
//        printWriter.close();
//    }

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