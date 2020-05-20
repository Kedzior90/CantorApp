package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

//to jest dobre https://www.javappa.com/kurs-java/wlasne-obiekty
//stronka jak odczytac plik https://www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html

public class User {
    public int userId;
    public String login;
    public String name;
    public String surname;
    public String password;
    public String creationDate;

//    konstruktor potrzebny do stworzenia obiektu z UserDatabase
    public User(int userId, String login, String name, String surname, String password, String creationDate) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.creationDate = creationDate;
        this.userId = userId;
    }

//    potrzebny do login
    public User(int userId, String login, String name, String surname) {
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }

    public void setLogin() {
        System.out.print("Enter Login: ");
        Scanner scan = new Scanner(System.in);
        this.login = scan.next();
    }

    public String getLogin(){
        return login;
    }

    public void setName() {
        System.out.print("Enter Name: ");
        Scanner scan = new Scanner(System.in);
        this.name = scan.next();
    }

    public String getName(){
        return name;
    }

    public void setSurname() {
        System.out.print("Enter Surname: ");
        Scanner scan = new Scanner(System.in);
        this.surname = scan.next();
    }

    public String getSurname(){
        return surname;
    }

    public void setPassword() {
        System.out.print("Enter Password: ");
        Scanner scan = new Scanner(System.in);
        this.password = scan.next();
    }

    public String getPassword(){
        return password;
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

//    to jest potrebne do stworzenia uzytkjownika po zalogowaniu
    public User createUser(int userId, String login, String name, String surname) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.userId = userId;

        return new User(userId, login, name, surname);
    }

    public String toString(){
        return "User ID: " + userId + ", Login: " + login +
                ", Name: " + name + ", Surname: " + surname +
                ", Password: " + password + ", Creation Date: " + creationDate;
    }
}