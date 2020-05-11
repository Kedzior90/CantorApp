package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wallet {
//    public double walletEUR;
    //dana co oblicza i zapisuje
    public double walletEUR;
    public String walletUSD;
    public String walletGBP;
    //dana co wprowadzasz z klawiatury
    public double enterWalletEUR;
    public String enterWalletUSD;
    public String enterWalletGBP;
    //dana wczytana z bazy danych
    public double databaseWalletEUR;
    public String databaseWalletUSD;
    public String databaseWalletGBP;

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
//        wziete ze stronki https://www.baeldung.com/find-list-element-java
//        Customer james = customers.stream()
//                .filter(customer -> "James".equals(customer.getName()))
//                .findAny()
//                .orElse(null);

//        for (int i = 0; i < searchWalletList.size(); i++) {
//            printWriter.print(searchWalletList.get(i) + "\n");
//        }

        List<Wallet> searchWalletList3 = readWalletDatabaseFile();
        System.out.println("lista PO setWallet: " + searchWalletList3);

        int dupa = 0;
        for (int i = 0; i < searchWalletList3.size(); i++) {
//            System.out.println("lista e petli for: " + searchWalletList3.get(i));
            System.out.println("wartosc kazdego: " + searchWalletList3.get(i).walletBalance);
            System.out.println("wartosc jednego: " + searchWalletList3);

//            TUTAJ ROBIC linijka wartosc jednego

//            dupa = searchWalletList3.indexOf(walletBalance);
//            System.out.println("wartosc jednego: " + dupa);
        }

//        for (int i = 0; i < searchWalletList.size(); i++) {
//            if (searchUserWallet.equals(wallet.walletLogin)) {
//                this.walletBalance = searchUserWallet.walletBalance;
//            }
//        }
//              Wallet searchUserWallet3 = searchWalletList.stream()
//                .filter(wallet -> walletLogin.equals(wallet.walletLogin))
//                .findAny()
//                .orElse(null);

//        Wallet searchUserWallet3 = searchWalletList.stream()
//                .filter(wallet -> walletLogin.equals(wallet.walletLogin))
//                .findAny()
//                .orElse(null);
        System.out.println("walet jednego uzytkownika: " + searchWalletList3.get(1).walletBalance);
//        return searchUserWallet.walletBalance;
//        return this.walletBalance = searchUserWallet3.walletBalance;
        return 1;
    }

//    public Wallet searchUserWallet() {
////        wziete ze stronki https://www.baeldung.com/find-list-element-java
////        Customer james = customers.stream()
////                .filter(customer -> "James".equals(customer.getName()))
////                .findAny()
////                .orElse(null);
//        List<Wallet> searchWalletList3 = readWalletDatabaseFile();
//        Wallet searchUserWallet2 = (Wallet) searchWalletList3.stream()
//                .filter(wallet -> walletLogin.equals(wallet.walletLogin));
////                .findAny()
////                .orElse(null);
////        System.out.println(searchUserWallet);
//        return searchUserWallet2;
//    }

    public double checkWalletBalance () {
//        System.out.println("Wallet balance: "+ wallet);
        return walletBalance;
    }

    public void walletUpdate () throws IOException {
        //        obliczanie nowej wartosci portfela
        double updateWalletValue = setWallet() + enterWallet;
//        this.walletBalance = updateWalletValue;
//
//        wczystanie bazy danych wszystkich uzytkownikow z bazy danych
        List<Wallet> searchWalletList = readWalletDatabaseFile();
//        System.out.println("stara zawartosc calej bazy \n" + searchWalletList);
//
//        znalezienie z tej listy jednego uzytkownika (jeden wpis/eden wiersz z listy)
        Wallet searchUserWallet = searchWalletList.stream()
                .filter(wallet -> walletLogin.equals(wallet.walletLogin))
                .findAny()
                .orElse(null);
//        System.out.println("znaleziony jeden uzytkownik z bazy danych -> \n" + searchUserWallet);

//        zmiana wartosci portfela dla tego jednego uzytkownika
        searchUserWallet.walletBalance = updateWalletValue;
//        System.out.println("uzytkownik z nowa wartoscia portfela -> \n" + searchUserWallet);
//        System.out.println("wartosc portfela PRZED update -> \n" + this.walletBalance);
        this.walletBalance = updateWalletValue;
//        System.out.println("wartosc portfela PO update -> \n" + this.walletBalance);
//
//        tworzenie listy uzytkownikow z uzytkownikiem ktory ma nowa wartosc portfela
//        System.out.println("lista uzytkownikow z nowym portfelem -> \n" + searchWalletList);

//        zapisanie listy uzystkonikow w pliku
        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"));
        PrintWriter printWriter = new PrintWriter(fileWriter);
//        petla po to zeby mi w pliku zapisalo dobrze po przecinku
        for (int i = 0; i < searchWalletList.size(); i++) {
            printWriter.print(searchWalletList.get(i) + "\n");
        }
        printWriter.close();
    }

    static List<Wallet> readWalletDatabaseFile() {
        List<Wallet> walletList = new ArrayList<>();
        try {
            File myObj = new File(System.getProperty("wallet.database"));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(", ");
                Wallet wallet = createWalletDatabase(attributes);
                walletList.add(wallet);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return walletOutput;
    }
//    public String toString() {
//        return "Wallet: " + walletBalance + ", User ID: " + walletUserId + ", Login: " + walletLogin +
//                ", Name: " + walletName + ", Surname: " + walletSurname;
//    }
}