package model;

import java.util.Scanner;

public class Wallet {
    public String provideAmount;
    public String databaseAmount;
    public String countAmount;

    public Wallet(String provideAmount, String databaseAmount, String countAmount) {
        this.provideAmount = provideAmount;
        this.databaseAmount = databaseAmount;
        this.countAmount = countAmount;
    }

    public Wallet() {
    }

    public void setProvideAmount () {
        System.out.println("Enter amount: ");
        Scanner scan = new Scanner(System.in);
        this.provideAmount = scan.nextLine();
    }

    public String getProvideAmount(){
        return provideAmount;
    }

    public void setDatabaseAmount () {
       //dodac pobieranie z bazy
        this.databaseAmount = "100";
    }

    public String getDatabaseAmount(){
        return databaseAmount;
    }

    public void setCountAmount () {
        //dodac pobieranie z bazy
        this.countAmount = getProvideAmount() + getDatabaseAmount();
    }

    public String getCountAmount(){
        return countAmount;
    }

}
