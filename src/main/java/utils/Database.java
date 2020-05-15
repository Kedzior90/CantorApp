package utils;

import model.Transaction;
import model.User;
import model.Wallet;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
//    przeciazanie metod
    public void saveInDatabase(User user) {
        try {
            String content = user.userId + ", " + user.login + ", " + user.name + ", " +
                                user.surname + ", " + user.password + ", " +user.creationDate + "\n";
            Files.writeString(Paths.get(System.getProperty("user.database")), content, StandardOpenOption.APPEND);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
//        stare w razie czego
//        FileWriter fileWriter = new FileWriter(System.getProperty("user.database"), true);
//        PrintWriter printWriter = new PrintWriter(fileWriter);
//        printWriter.print(user.userId + ", " + user.login + ", " + user.name + ", " +
//                user.surname + ", " + user.password + ", " +user.creationDate + "\n");
//        printWriter.close();
    }

    public void saveInDatabase(User user, Transaction transaction) {
        try {
            String content = transaction.amount + ", " + transaction.currency1 + ", " +
                    transaction.currency2 + ", " + transaction.rate + ", " + transaction.value + ", " +
                    transaction.tradeDate + ", " + user.userId + ", " + user.login + ", " +
                    user.name + ", " + user.surname + "\n";
            Files.writeString(Paths.get(System.getProperty("transaction.database")), content, StandardOpenOption.APPEND);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

//    nie uzywana na razie
    public void saveInDatabase(User user, Wallet wallet) throws IOException {
        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"), true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(wallet.walletBalance + ", " + user.userId + ", " + user.login + ", " + user.name + ", " + user.surname + "\n");
        printWriter.close();
    }

    public void saveNewUserInWalletDatabase(User user) throws IOException {
        FileWriter fileWriter = new FileWriter(System.getProperty("wallet.database"), true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("0.0" + ", " + user.userId + ", " + user.login + ", " + user.name + ", " + user.surname + "\n");
        printWriter.close();
    }

    public List<User> readDatabaseFile(User user) {
        List<User> userList = new ArrayList<>();

        try {
            File myObj = new File(System.getProperty("user.database"));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(", ");
                user = createDatabaseUser(attributes);
                userList.add(user);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return userList;
    }

    public List<Transaction> readDatabaseFile(Transaction transaction) {
        List<Transaction> transactionList = new ArrayList<>();

        try {
            File myObj = new File(System.getProperty("transaction.database"));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(", ");
                transaction = createDatabaseTransaction(attributes);
                transactionList.add(transaction);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return transactionList;
    }

    public List<Wallet> readDatabaseFile(Wallet wallet) {
        List<Wallet> walletList = new ArrayList<>();

        try {
            File myObj = new File(System.getProperty("wallet.database"));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(", ");
                wallet = createWalletDatabase(attributes);
                walletList.add(wallet);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return walletList;
    }

    public boolean loginChecker(String inputLogin, String inputPass) {
        boolean login = false;
        try {
            File myObj = new File(System.getProperty("user.database"));
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] attributes = data.split(", ");
                User user = createDatabaseUser(attributes);
                if (user.login.equals(inputLogin) && user.password.equals(inputPass)) {

                    login = true;
                    break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return login;
    }

    public User createDatabaseUser(String[] metadata) {
        int userId = Integer.parseInt(metadata[0]);
        String login = metadata[1];
        String name = metadata[2];
        String surname = metadata[3];
        String password = metadata[4];
        String creationDate = metadata[5];

        return new User(userId, login, name, surname, password, creationDate); //create and return user of this metadata
    }

    public Transaction createDatabaseTransaction(String[] metadata) {
        double amount = Double.parseDouble(metadata[0]);
        String currency1 = metadata[1];
        String currency2 = metadata[2];
        double rate = Double.parseDouble(metadata[3]);
        double value = Double.parseDouble(metadata[4]);
//        dopasowanie danych z plku do obiektu transaction
        String tradeDate = metadata[5];
        int userId = Integer.parseInt(metadata[6]);
        String login = metadata[7];
        String name = metadata[8];
        String surname = metadata[9];

        return new Transaction(amount, currency1, currency2, rate, value, tradeDate, userId, login, name, surname); // create and return trade of this metadata
    }

    private static Wallet createWalletDatabase(String[] metadata) {
        double wallet = Double.parseDouble(metadata[0]);
        int walletUserId = Integer.parseInt(metadata[1]);
        String walletLogin = metadata[2];
        String walletName = metadata[3];
        String walletSurname = metadata[4];

        return new Wallet(wallet, walletUserId, walletLogin, walletName, walletSurname);
    }
}