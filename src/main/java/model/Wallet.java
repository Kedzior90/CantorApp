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
        System.out.println("Charge Wallet: ");
        Scanner scan = new Scanner(System.in);
        this.enterWallet = Double.parseDouble(scan.nextLine());
    }

    public double getEnterWallet(){
        return enterWallet;
    }

    public void setDatabaseWalletEUR () throws IOException {
       //dodac pobieranie z bazy
        double wallet = readWalletDatabaseFile();
        System.out.println("wczytano: " + wallet);
        this.databaseWalletEUR = wallet;
    }

    public double getDatabaseWallet(){
        return databaseWallet;
    }

    public void setWalletEUR () throws IOException {
        //dodac pobieranie z bazy
        double wallet = getEnterWalletEUR() + getDatabaseWalletEUR();
        saveWalletInDatabase(wallet);
        System.out.println("zapisano: " + wallet);
        this.walletEUR = wallet;
    }

    public double getWallet(){
        return wallet;
    }

    public void saveWalletInDatabase(double wallet) throws IOException {
//        FileWriter fileWriter = new FileWriter(System.getProperty("user.database"), true);
        //useniete nadpisywanie pliku, flaga true
        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(wallet);
//        printWriter.print(user.userId + ", " + user.login + ", " + user.name + ", " + user.surname + ", "
//                + user.password + ", " + user.emailAddress + ", " + user.creationDate + "\n");
        printWriter.close();
    }

    public void updateWalletInDatabase(Wallet wallet) throws IOException {
        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(wallet.wallet);
        printWriter.close();
    }

    static Wallet readWalletDatabaseFile() {
        Wallet walletOutput = new Wallet();
        try {
            File myObj = new File(System.getProperty("wallet.database"));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(", ");
                walletOutput = createDatabaseWallet(attributes);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return walletOutput;

//        ----------------- original --------------
//        List<Wallet> walletList = new ArrayList<>();
//        try {
//            File myObj = new File(System.getProperty("wallet.database"));
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                String[] attributes = data.split(", ");
//                Wallet wallet = createDatabaseWallet(attributes);
//                walletList.add(wallet);
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//        return walletList;
    }
}