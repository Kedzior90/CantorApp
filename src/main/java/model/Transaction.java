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
    public String transactionDate;
    public double amount;
    public double rate;
    public double value;

//    konstruktor do stworzenia obiektu transaction dla ktorego dane zostaly pobrane z bazy danych
    public Transaction(double amount, String currency1, String currency2, double rate, double value, String transactionDate, int userId, String login, String name, String surname) {
        this.amount = amount;
        this.currency1 = currency1;
        this.currency2 = currency2;
        this.rate = rate;
        this.value = value;
        this.transactionDate = transactionDate;
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
        this.currency1 = scan.next().toUpperCase();
    }

    public String getCurrency1() {
        return currency1;
    }

    public void setCurrency2() {
        System.out.print("Enter currency2: ");
        Scanner scan = new Scanner(System.in);
        this.currency2 = scan.next().toUpperCase();
    }

    public String getCurrency2() {
        return currency2;
    }

    public void setAmount() {
        System.out.print("Enter amount: ");
        Scanner scan = new Scanner(System.in);
        this.amount = Double.parseDouble(scan.next());
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
        this.transactionDate = dateFormat.format(date);
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String toString(){
        return "Amount: " + amount + ", Currency1: " + currency1 + ", Currency2: " + currency2 +
                ", Rate: " + rate + ", Value: " + value + ", TradeDate: " + transactionDate +
                ", User ID: " + userId +  ", Login: " + login + ", Name: " + name +
                ", Surname: " + surname;
    }
}