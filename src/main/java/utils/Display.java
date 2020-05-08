package utils;

import model.User;
import java.io.IOException;
import java.util.List;

public class Display {
    public static Helper helper = new Helper();
    public static User user = new User();
    public static Database database = new Database();

    public void displayMainMenu() {
        System.out.print("\n************************************\n");
        System.out.print("************   Cantor   ************");
        System.out.print("\n************************************\n");
        System.out.print("1. Register\n");
        System.out.print("2. Login\n");
        System.out.print("3. Check rates\n");
        System.out.print("4. Transaction\n");
        System.out.print("0. Exit");
        System.out.print("\n************************************\n");
    }

    public void displayUserRegister() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tRegister User");
        System.out.print("\n************************************\n");

        System.out.print("Enter User Login: ");
        user.setUserLogin();

        System.out.print("Enter User Name: ");
        user.setUserName();

        System.out.print("Enter User Surname: ");
        user.setUserSurname();

        System.out.print("Enter User Password: ");
        user.setUserPassword();

        System.out.print("Enter Email Address: ");
        user.setEmailAddress();

        user.setUserId();
        user.setDataCreation();
        database.saveUserInDatabase(user);

        System.out.print("\n*********** Created User ***********\n");
        System.out.print("User ID:\t\t" + user.getUserId() +
                "\nLogin:\t\t\t" + user.getUserLogin() +
                "\nUser Name:\t\t" + user.getUserName() +
                "\nUser Surname:\t" + user.getUserSurname() +
                "\nEmail Address:\t" + user.getEmailAddress() +
                "\nCreation Date:\t" + user.getCreationDate());
        System.out.print("\n************************************\n");
    }

    public boolean displayLogin() {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tLogin");
        System.out.print("\n************************************\n");

        System.out.print("Enter User Login: ");
        user.setUserLogin();

        System.out.print("Enter User Password: ");
        user.setUserPassword();

        if (database.loginChecker(user.login, user.password) == true) {
            System.out.println("Login accepted");
        } else {
            System.out.println("Wrong login/password");
        }

        return database.loginChecker(user.login, user.password);
    }

    public void displayCheckRates () throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tCheck Rates");
        System.out.print("\n************************************\n");
        helper.setTradeDate();
        System.out.print("Today is: " + helper.getTradeDate());

        System.out.println("\nEnter currency1: ");
        helper.setCurrency1();

        System.out.println("Enter currency2: ");
        helper.setCurrency2();

        helper.setRate(helper.getCurrency1(), helper.getCurrency2());
        System.out.println("Rate: " + helper.getRate());
    }

    public void displayTransaction() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\t\tTransaction");
        System.out.print("\n************************************\n");

        System.out.print("Enter currency1: ");
        helper.setCurrency1();

        System.out.print("Enter currency2: ");
        helper.setCurrency2();

        System.out.print("Enter amount: ");
        helper.setAmount();

        helper.setRate(helper.getCurrency1(), helper.getCurrency2());
        helper.setCalculate(helper.getRate(), helper.getAmount());
        helper.setTradeDate();
        helper.saveTransaction();

        System.out.print("\n********* Transaction data *********\n");
        System.out.print("TradeDate: " + helper.getTradeDate() +
                        "\nCurrency1:\t" + helper.getCurrency1() +
                        "\nCurrency2:\t" + helper.getCurrency2() +
                        "\nAmount:\t" + helper.getAmount() +
                        "\nRate:\t" + helper.getRate() +
                        "\nValue:\t" + helper.getCalculate());
        System.out.print("\n************************************\n");
    }

    public void displayUserMenu() {
            System.out.print("\n************************************\n");
            System.out.print("\t\t\tUser Menu");
            System.out.print("\n************************************\n");
            System.out.print("\t\tWelcome: " + user.login);
            System.out.print("\n1. Transaction");
            System.out.print("\n2. Display Transaction's Database");
            System.out.print("\n3. Display Users' Database");
            System.out.print("\n4. Display Users' sorted by ID");
            System.out.print("\n5. Display Users' sorted by Login");
            System.out.print("\n6. Display Users' sorted by Name");
            System.out.print("\n7. Display Users' sorted by Surname");
            System.out.print("\n8. Display Users' sorted by Email Address");
            System.out.print("\n9. Display Users' sorted by Creation date");
            System.out.print("\n10. <- Back Menu");
            System.out.print("\n************************************\n");
    }

    public void displayTransactionFile () {
        System.out.print("\n************************************\n");
        System.out.print("\t\tTransaction Database file");
        System.out.print("\n************************************\n");
        helper.readData();
    }

    public void displayUserDatabaseFile() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers Database file");
        System.out.print("\n************************************\n");
        List<User> usersList = database.readUserDatabaseFile();

        int k = 1;
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println("ID: " + k + ", " + usersList.get(i));
            k++;
        }
    }

    public void displayUserListSortedById() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by User ID");
        System.out.print("\n************************************\n");
        database.userListSortedById();
    }

    public void displayUserListSortedByLogin() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Login");
        System.out.print("\n************************************\n");
        database.userListSortedByLogin();
    }

    public void displayUserListSortedByName() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Name");
        System.out.print("\n************************************\n");
        database.userListSortedByName();
    }

    public void displayUserListSortedBySurname() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Surname");
        System.out.print("\n************************************\n");
        database.userListSortedBySurname();
    }

    public void displayUserListSortedByEmailAddress() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Email Address");
        System.out.print("\n************************************\n");
        database.userListSortedByEmailAddress();
    }

    public void displayUserListSortedByCreationDate() {
        System.out.print("\n************************************\n");
        System.out.print("\t\tUsers List Sorted by Creation Date");
        System.out.print("\n************************************\n");
        database.userListSortedByCreationDate();
    }

    public void displayTest() throws IOException {
        System.out.print("\n************************************\n");
        System.out.print("\t\tTest");
        System.out.print("\n************************************\n");
        helper.test();
    }
}