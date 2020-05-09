package model;

import java.io.*;
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

    public double getWallet(){
        return wallet;
    }

    public void walletUpdate () throws IOException {
        Wallet walletDatabase = readWalletDatabaseFile();
        System.out.println("z databazy zapisane: "+ walletDatabase.wallet);
//        dodanie wprowadzonej wartosci  i tej z bazy
        walletDatabase.wallet = walletDatabase.wallet + enterWallet;
        this.wallet = walletDatabase.wallet;
        saveWalletInDatabase(walletDatabase);
        System.out.println("wynik: "+ wallet);
    }

    public void saveWalletInDatabase(Wallet wallet) throws IOException {
        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(wallet);
//        printWriter.print(user.userId + ", " + user.login + ", " + user.name + ", " + user.surname + ", "
//                + user.password + ", " + user.emailAddress + ", " + user.creationDate + "\n");
        printWriter.close();
    }

    public void checkWalletForName(Wallet wallet) {
        Wallet walletDatabase = readWalletDatabaseFile();

//        user.setUserId();
//        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"));
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        printWriter.print(wallet.wallet);
//        printWriter.close();
    }

    static Wallet readWalletDatabaseFile() {
        Wallet walletOutput = null;
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
    }
}