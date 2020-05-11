package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

//ciekawy projekt do podpatrzenia https://www.journaldev.com/2315/java-json-example
//listy artyhul https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
//stronka jak odczytac plik https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html

public class User {
    public String login;
    public String name;
    public String surname;
    public String emailAddress;
    public String password;
    public String creationDate;
    public int userId;

    public User(int userId, String login, String name, String surname, String password, String emailAddress, String creationDate) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.emailAddress = emailAddress;
        this.creationDate = creationDate;
        this.userId = userId;
    }

    public User(int userId, String login, String name, String surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.userId = userId;
    }

    public User() {
    }

    public void setUserLogin () {
        System.out.print("Enter Login: ");
        Scanner scan = new Scanner(System.in);
        this.login = scan.nextLine();
    }

    public String getLogin(){
        return login;
    }

    public void setName() {
        System.out.print("Enter Name: ");
        Scanner scan = new Scanner(System.in);
        this.name = scan.nextLine();
    }

    public String getName(){
        return name;
    }

    public void setSurname() {
        System.out.print("Enter Surname: ");
        Scanner scan = new Scanner(System.in);
        this.surname = scan.nextLine();
    }

    public String getSurname(){
        return surname;
    }

    public void setPassword() {
        System.out.print("Enter Password: ");
        Scanner scan = new Scanner(System.in);
        this.password = scan.nextLine();
    }

    public String getPassword(){
        return password;
    }

    public void setEmailAddress (){
        System.out.print("Enter Email Address: ");
        Scanner scan = new Scanner(System.in);
        this.emailAddress = scan.nextLine();
    }

    public String getEmailAddress () {
        return emailAddress;
    }

    public void setDataCreation (){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.creationDate = dateFormat.format(date);
    }

    public String getCreationDate(){
        return creationDate;
    }

    public void setUserId (){
        Random rand = new Random();
        int userIdGenerated = rand.nextInt(10000);
        this.userId = userIdGenerated;
    }

    public int getUserId (){
        return userId;
    }

    public String toString(){
        return "User ID: " + userId + ", Login: " + login +
                ", Name: " + name + ", Surname: " + surname +
                ", Password: " + password + ", Email Address: " + emailAddress +
                ", Creation Date: " + creationDate;
    }
}