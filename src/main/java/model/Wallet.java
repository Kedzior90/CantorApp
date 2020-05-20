package model;

import java.util.*;

public class Wallet extends Transaction {
    public double walletBalance;
    public double walletBalanceEUR;
    public double walletBalanceUSD;
    public double walletBalanceGBP;
    public double enterWallet;

    public Wallet (double walletBalance, int userId, String login, String name, String surname) {
        this.walletBalance = walletBalance;
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    public Wallet () {
    }

    public void setEnterWallet() {
        System.out.println("Charge Wallet: ");
        Scanner scan = new Scanner(System.in);
        this.enterWallet = Double.parseDouble(scan.next());
    }

    public double getEnterWallet(){
        return enterWallet;
    }

    public void setWalletBalance(){

    }

    public double getWalletBalance(){
        return walletBalance;
    }

    public double getWalletBalanceEUR() {
        return walletBalanceEUR;
    }

    public void setWalletBalanceEUR(double walletBalanceEUR) {
        this.walletBalanceEUR = walletBalanceEUR;
    }

    public double getWalletBalanceUSD() {
        return walletBalanceUSD;
    }

    public void setWalletBalanceUSD(double walletBalanceUSD) {
        this.walletBalanceUSD = walletBalanceUSD;
    }

    public double getWalletBalanceGBP() {
        return walletBalanceGBP;
    }

    public void setWalletBalanceGBP(double walletBalanceGBP) {
        this.walletBalanceGBP = walletBalanceGBP;
    }

    public Wallet createUserWallet(double walletBalance, int userId, String login,
                                           String name, String surname) {
        this.walletBalance = walletBalance;
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.surname = surname;

        return new Wallet(walletBalance, userId, login, name, surname);
    }

    public String toString() {
        return walletBalance + ", " + userId + ", " + login +
                ", " + name + ", " + surname;
    }
}