package model;

import java.io.*;
import java.util.*;

public class Wallet extends Transaction {
    public double walletBalance;
    public double enterWallet;
    public int walletUserId;
    public String walletLogin;
    public String walletName;
    public String walletSurname;

    public Wallet (double walletBalance, int walletUserId, String walletLogin, String walletName, String walletSurname) {
        this.walletBalance = walletBalance;
        this.walletUserId = walletUserId;
        this.walletLogin = walletLogin;
        this.walletName = walletName;
        this.walletSurname = walletSurname;
    }

    public Wallet () {
        this.walletBalance = getWalletBalance();
        this.walletUserId = getUserID();
        this.walletLogin = getLogin();
        this.walletName = getName();
        this.walletSurname = getSurname();
    }

    public int getUserID() {
        User user = new User();
        return walletUserId = user.userId;
    }

    public String getLogin() {
        User user = new User();
        return walletLogin = user.login;
    }

    public String getName() {
        User user = new User();
        return walletName = user.name;
    }

    public String getSurname() {
        User user = new User();
        return walletSurname = user.surname;
    }

    public void setEnterWallet() {
//        System.out.println("Charge Wallet: ");
        Scanner scan = new Scanner(System.in);
        this.enterWallet = Double.parseDouble(scan.nextLine());
    }

    public double getEnterWallet(){
        return enterWallet;
    }

    public double getWalletBalance(){
        return walletBalance;
    }

    public double setWallet() {
        return walletBalance;
    }

//    public List<Wallet> searchUserWallet(User user) {
//        List<Wallet> searchWalletList = readWalletDatabaseFile(); // wczytanie bazy danych do listy
////        System.out.println("searchWalletList2: " + searchWalletList);
//
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

    public double checkWalletBalance () {
//        System.out.println("Wallet balance: "+ wallet);
        return walletBalance;
    }

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

//    public void saveNewUserInWalletDatabase(User user) throws IOException {
//        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"), true);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        printWriter.print(walletBalance + ", " + user.userId + ", " + user.login + ", " + user.name + ", " + user.surname + "\n");
//        printWriter.close();
//    }

//    static List<Wallet> readWalletDatabaseFile() {
//        List<Wallet> walletList = new ArrayList<>();
//        try {
//            File myObj = new File(System.getProperty("wallet.database"));
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                String[] attributes = data.split(", ");
//                Wallet wallet = createWalletDatabase(attributes);
//                walletList.add(wallet);
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//        return walletList;
//    }

//    private static Wallet createWalletDatabase(String[] metadata) {
//        double wallet = Double.parseDouble(metadata[0]);
//        int walletUserId = Integer.parseInt(metadata[1]);
//        String walletLogin = metadata[2];
//        String walletName = metadata[3];
//        String walletSurname = metadata[4];
//
//        return new Wallet(wallet, walletUserId, walletLogin, walletName, walletSurname);
//    }

    public Wallet createUserWallet(double walletBalanceCreator, int walletUserIdCreator, String walletLoginCreator,
                                           String walletNameCreator, String walletSurnameCreator) {
        this.walletBalance = walletBalanceCreator;
        this.walletUserId = walletUserIdCreator;
        this.walletLogin = walletLoginCreator;
        this.walletName = walletNameCreator;
        this.walletSurname = walletSurnameCreator;

        return new Wallet(walletBalance, walletUserId, walletLogin, walletName, walletSurname);
    }

    public String toString() {
        return walletBalance + ", " + walletUserId + ", " + walletLogin +
                ", " + walletName + ", " + walletSurname;
    }
}