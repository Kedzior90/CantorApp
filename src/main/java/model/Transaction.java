package model;

import utils.HttpConnection;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Transaction extends User {
    public String currency1;
    public String currency2;
    public String tradeDate;
    public double amount;
    public double rate;
    public double value;

//    konstruktor do stworzenia obiektu transaction dla ktorego dane zostaly pobrane z bazy danych
    public Transaction(double amount, String currency1, String currency2, double rate, double value, String tradeDate, int userId, String login, String name, String surname) {
        this.amount = amount;
        this.currency1 = currency1;
        this.currency2 = currency2;
        this.rate = rate;
        this.value = value;
        this.tradeDate = tradeDate;
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    public Transaction() {

    }

    public void setCurrency1() {
        System.out.print("Enter currency1: ");
        Scanner scan = new Scanner(System.in);
        this.currency1 = scan.nextLine().toUpperCase();
    }

    public String getCurrency1() {
        return currency1;
    }

    public void setCurrency2() {
        System.out.print("Enter currency2: ");
        Scanner scan = new Scanner(System.in);
        this.currency2 = scan.nextLine().toUpperCase();
    }

    public String getCurrency2() {
        return currency2;
    }

    public void setAmount() {
        System.out.print("Enter amount: ");
        Scanner scan = new Scanner(System.in);
        this.amount = Double.parseDouble(scan.nextLine());
    }

    public double getAmount() {
        return amount;
    }

    public void setRate(String currency1, String currency2) throws IOException {
        HttpConnection http = new HttpConnection();
        this.rate = http.getHttpRate(currency1, currency2);
    }

    public double getRate() {
        return rate;
    }

    public void setValue(double rate, double amount) {
        this.value = rate * amount;
    }

    public double getValue() {
        return value;
    }

    public void setTradeDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.tradeDate = dateFormat.format(date);
    }

    public String getTradeDate() {
        return tradeDate;
    }

//    nie wiem czy dziala do sprawdzenia
//    @Override
//    public int getUserId() {
//        return super.getUserId();
//    }
//
//    @Override
//    public String getLogin() {
//        return super.getLogin();
//    }
//
//    @Override
//    public String getName() {
//        return super.getName();
//    }
//
//    @Override
//    public String getSurname() {
//        return super.getSurname();
//    }

    public String toString(){
        return "Amount: " + amount + ", Currency1: " + currency1 + ", Currency2: " + currency2 +
                ", Rate: " + rate + ", Value: " + value + ", TradeDate: " + tradeDate +
                ", User ID: " + userId +  ", Login: " + login + ", Name: " + name +
                ", Surname: " + surname;
    }
}