package utils;

public class CantorHelperGUI {

    public CantorHelperGUI () {
    }
}



//package utils;
//
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.io.IOException;
//
//public class CantorHelperGUI extends JFrame{
////    private JFrame frame = new JFrame(("Cantor"));
//
//    private JButton buttonRegister  = new JButton("Register");
//    private JButton buttonLogin  = new JButton("Login");
//    private JButton buttonCheckRates  = new JButton("Check Rates");
//    private JButton buttonTransaction  = new JButton("Transaction");
//    private JButton buttonExit  = new JButton("Exit");
//
//    private JTextField textFieldCurrency1 = new JTextField("EUR");
//    private JTextField textFieldCurrency2 = new JTextField("USD");
//    private JTextField textFieldRate = new JTextField();
//
//    private JLabel labelCurrency1 = new JLabel("Currency1");
//    private JLabel labelCurrency2 = new JLabel("Currency2");
//    private JLabel labelRate = new JLabel("Rate");
//
//    private JPanel mainMenu = new JPanel();
//    private JPanel registerPanel = new JPanel();
//    private JPanel checkRatesPanel = new JPanel();
//
//    public CantorHelperGUI () {
//    setTitle("Cantor");
//    setSize(400,200);
//    setLocation(new Point(300,200));
//    setLayout(null);
//    setResizable(false);
//
//    mainGUI();
//    initEvent();
////    mainGUI();
//    }
//
////    public CantorHelperGUI(){
////        frame.setTitle("Cantor");
////        frame.setSize(400,200);
////        frame.setLocation(new Point(300,200));
////        frame.setLayout(null);
////        frame.setResizable(false);
////        frame.setVisible(true);
////
////        frame.add(mainMenu);
//////        mainGUI();
//////        initEvent();
////    }
//
////    private void mainGUI(){
////        buttonRegister.setBounds(0,0, 110,25);
////        buttonLogin.setBounds(0,30, 110,25);
////        buttonCheckRates.setBounds(0,60, 110,25);
////        buttonTransaction.setBounds(0,90, 110,25);
////        buttonExit.setBounds(0,120, 110,25);
////
////        textFieldCurrency1.setBounds(200,10,100,20);
////        textFieldCurrency2.setBounds(200,35,100,20);
////        textFieldRate.setBounds(200,65,100,20);
////
////        labelCurrency1.setBounds(120,10,100,20);
////        labelCurrency2.setBounds(120,35,100,20);
////        labelRate.setBounds(120,65,100,20);
////
////        mainMenu.add(buttonRegister);
////        mainMenu.add(buttonLogin);
////        mainMenu.add(buttonCheckRates);
////        mainMenu.add(buttonTransaction);
////        mainMenu.add(buttonExit);
////
////        mainMenu.add(labelCurrency1);
////        mainMenu.add(labelCurrency2);
////        mainMenu.add(labelRate);
////
////        mainMenu.add(textFieldCurrency1);
////        mainMenu.add(textFieldCurrency2);
////        mainMenu.add(textFieldRate);
////    }
//
//    private void mainGUI(){
//        buttonRegister.setBounds(0,0, 110,25);
//        buttonLogin.setBounds(0,30, 110,25);
//        buttonCheckRates.setBounds(0,60, 110,25);
//        buttonTransaction.setBounds(0,90, 110,25);
//        buttonExit.setBounds(0,120, 110,25);
//
////        textFieldCurrency1.setBounds(200,10,100,20);
////        textFieldCurrency2.setBounds(200,35,100,20);
////        textFieldRate.setBounds(200,65,100,20);
////
////        labelCurrency1.setBounds(120,10,100,20);
////        labelCurrency2.setBounds(120,35,100,20);
////        labelRate.setBounds(120,65,100,20);
//
//        add(buttonRegister);
//        add(buttonLogin);
//        add(buttonCheckRates);
//        add(buttonTransaction);
//        add(buttonExit);
//
////        add(labelCurrency1);
////        add(labelCurrency2);
////        add(labelRate);
////
////        add(textFieldCurrency1);
////        add(textFieldCurrency2);
////        add(textFieldRate);
//        add(checkRatesPanel);
//    }
//
//    public void checkRatesPanel2(){
//        textFieldCurrency1.setBounds(200,10,100,20);
//        textFieldCurrency2.setBounds(200,35,100,20);
//        textFieldRate.setBounds(200,65,100,20);
//
//        labelCurrency1.setBounds(120,10,100,20);
//        labelCurrency2.setBounds(120,35,100,20);
//        labelRate.setBounds(120,65,100,20);
//
//        checkRatesPanel.add(labelCurrency1);
//        checkRatesPanel.add(labelCurrency2);
//        checkRatesPanel.add(labelRate);
//
////        checkRatesPanel.add((textFieldCurrency1)
////        checkRatesPanel.add((textFieldCurrency2)
////        checkRatesPanel.add((textFieldRate)
//    }
//
//    private void initEvent(){
//        this.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e){
//                System.exit(1);
//            }
//        });
//
//        buttonRegister.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                setButtonRegister(e);
//            }
//        });
//
//        buttonLogin.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                setButtonLogin(e);
//            }
//        });
//
//        buttonCheckRates.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                checkRatesPanel2();
//                setButtonCheckRates(e);
//            }
//        });
//
//        buttonTransaction.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    setButtonTransaction(e);
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//            }
//        });
//
//        buttonExit.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    setButtonExit(e);
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//            }
//        });
//    }
//
//    private void addWindowListener(WindowAdapter windowAdapter) {
//    }
//
//    private void setButtonRegister(ActionEvent evt){
//        System.out.println("Register Button");
//    }
//
//    private void setButtonLogin(ActionEvent evt){
//        System.exit(1);
//    }
//
//    private void setButtonCheckRates(ActionEvent evt){
////        checkRatesPanel2;
//        HttpConnection httpConnection = new HttpConnection();
//        String currency1;
//        String currency2;
//        String rate;
//
//        try{
//            currency1 = textFieldCurrency1.getText();
//            currency2 = textFieldCurrency2.getText();
//            rate = String.valueOf(httpConnection.getRate(currency1, currency2));
//            textFieldRate.setText(rate);
//        } catch(Exception e) {
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null,
//                    e.toString(),
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//    }
//    private void setButtonTransaction(ActionEvent evt) throws IOException {
//        System.exit(1);
//    }
//
//    private void setButtonExit(ActionEvent evt) throws IOException {
//        System.exit(1);
//    }
//}
//
//
//
////public class CantorHelperGUI implements ActionListener {
//////    private JFrame frame = new JFrame(("Cantor"));
//////
//////    JMenuBar menuBar = new JMenuBar();
//////    JMenu menuBarFile = new JMenu("FILE");
//////    JMenu menuBarHelp = new JMenu("Help");
//////    JMenuItem menuBarOpen = new JMenuItem("Open");
//////    JMenuItem menuBarSaveAs = new JMenuItem("Save as");
////
////
////
////    public void buildGUI() {
////        //Creating the Frame
////        JFrame frame = new JFrame(("Cantor"));
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setSize(600,400);
////        frame.setLocationRelativeTo(null);
////
////        //Creating the MenuBar and adding components
////        JMenuBar menuBar = new JMenuBar();
////        JMenu menuFile = new JMenu("FILE");
////        JMenu menuHelp = new JMenu("Help");
////        JMenuItem menuOpen = new JMenuItem("Open");
////        JMenuItem menuSaveAs = new JMenuItem("Save as");
////
////        menuBar.add(menuFile);
////        menuBar.add(menuHelp);
////        menuFile.add(menuOpen);
////        menuFile.add(menuSaveAs);
////
////        //Creating the MainMenu and adding components
////        JPanel mainMenuButtonPanel = new JPanel(); // the panel is not visible in output
////        JButton register = new JButton("Register");
////        JButton login = new JButton("Login");
////        JButton checkRates = new JButton("Check rates");
////        JButton transaction = new JButton("Transaction");
////
////        mainMenuButtonPanel.setLayout(new GridLayout(4,0));
////        mainMenuButtonPanel.add(register);
////        mainMenuButtonPanel.add(login);
////        mainMenuButtonPanel.add(checkRates);
////        mainMenuButtonPanel.add(transaction);
////
////        //Creating the SecondMenu and adding components
////        JPanel panel = new JPanel();
////        JLabel currency1 = new JLabel("Currency1");
////        JTextField currencyField1 = new JTextField(10); // accepts upto 10 characters
////        JLabel currency2 = new JLabel("Currency2");
////        JTextField currencyField2 = new JTextField(10); // accepts upto 10 characters
////        JLabel rate = new JLabel("Rate");
////        JTextField rateField = new JTextField(10); // accepts upto 10 characters
////
//////        panel.setLayout(new GridLayout(4,0));
////        panel.setLayout(new GridLayout(3,0));
////        panel.add(currency1);
////        panel.add(currencyField1);
////        panel.add(currency2);
////        panel.add(currencyField2);
////        panel.add(rate);
////        panel.add(rateField);
////
////
////        //scond panel
//////        JPanel secondPanel = new JPanel(); // the panel is not visible in output
//////        secondPanel.add(resultLabel);
//////        secondPanel.add(resultLabel2);
//////        secondPanel.add(resultLabel2);
////
////        //Adding actions' button to the ActionListener
////        register.addActionListener( this);
////        login.addActionListener(this);
////        checkRates.addActionListener(this);
////        transaction.addActionListener(this);
//////        textField.addActionListener(this);
////
////        //Adding Components to the frame
////        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
////        frame.getContentPane().add(BorderLayout.WEST, mainMenuButtonPanel);
//////        frame.getContentPane().add(BorderLayout.CENTER, secondPanel);
////        frame.getContentPane().add(BorderLayout.CENTER, panel);
//////        frame.getContentPane().add(BorderLayout.EAST, textField);
//////        frame.getContentPane().add(BorderLayout.SOUTH, panel);
////        frame.setVisible(true);
////
////
////
////        //Creating the panel at bottom and adding components
//////        JPanel panel = new JPanel(); // the panel is not visible in output
//////        JLabel label = new JLabel("Enter Text");
//////        JTextField tf = new JTextField(10); // accepts upto 10 characters
//////        JButton send = new JButton("Send");
//////        JButton reset = new JButton("Reset");
//////        panel.add(label); // Components Added using Flow Layout
//////        panel.add(tf);
//////        panel.add(send);
//////        panel.add(reset);
////
////
//////        mainMenuButtonPanel.setLayout(new GridLayout(4,1));
//////        mainMenuButtonPanel.add(register);
//////        mainMenuButtonPanel.add(login);
//////        mainMenuButtonPanel.add(checkRates);
//////        mainMenuButtonPanel.add(transaction);
////
//////        JPanel mainMenuSecondPanel = new JPanel();
////////        mainMenuSecondPanel.setLayout(new GridLayout(1,4));
//////        // tworzymy pole na którym będzie wypisany tekst
//////        resultLabel = new JLabel();
//////        resultLabel.setSize(400,400);
//////        mainMenuSecondPanel.add(resultLabel);
//////        mainMenuButtonPanel.add(textField);
////
////
////
////        //Adding actions' button to the ActionListener
//////        register.addActionListener(this);
//////        login.addActionListener(this);
//////        checkRates.addActionListener(this);
//////        transaction.addActionListener(this);
//////        textField.addActionListener(this);
////
//////        //Adding Components to the frame
////////        frame.add(mainMenuSecondPanel);
//////        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
//////        frame.getContentPane().add(BorderLayout.WEST, mainMenuButtonPanel);
//////        frame.getContentPane().add(BorderLayout.EAST, textField);
////////        frame.getContentPane().add(BorderLayout.SOUTH, panel);
//////        frame.setVisible(true);
////    }
////
////    public void actionPerformed(ActionEvent action) {
////        Display display = new Display();
////        Helper helper = new Helper();
////
////        // metoda obsługująca
//////        if (action.getSource() == register)
//////            resultLabel.setText("regi!");
//////        else if (action.getSource() == login)
//////            resultLabel.setText("log");
//////        else if (action.getSource() == checkRates) {
//////            resultLabel.setText("sss");
//////        }
//////        else if (action.getSource() == transaction){
//////            resultLabel.setText("Enter currency1:");
////////            textField.setText("cos");
////////            resultLabel2
//////        }
//////        else
//////            System.out.println("Cos poszlo nie tak");
////    }
////
////    public String displayCheckRates () {
////        StringBuilder sb = new StringBuilder();
//////        sb.append("\n************************************\n");
////        sb.append("\tCheck Rates");
//////        sb.append("\n************************************\n");
////
////
////        return sb.toString();
////
////////        helper.setTradeDate();
////////        System.out.print("Today is: " + helper.getTradeDate());
//////
//////        System.out.println("\nEnter currency1: ");
////////        helper.setCurrency1();
//////
//////        System.out.println("Enter currency2: ");
////////        helper.setCurrency2();
//////
////////        helper.setRate(helper.getCurrency1(), helper.getCurrency2());
////////        System.out.println("Rate: " + helper.getRate());
//////
//////        String checkRatesPanel = "nic na razie";
//////        return checkRatesPanel;
////    }
////}
