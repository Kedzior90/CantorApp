package utils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanelGUI {
    private JFrame mainGUI = new JFrame();
//    private JFrame loginPanel = new JFrame();

    private JButton buttonRegister  = new JButton("Register");
    private JButton buttonLogin  = new JButton("Login");
    private JButton buttonCheckRates  = new JButton("Check Rates");
    private JButton buttonTransaction  = new JButton("Transaction");
    private JButton buttonExit  = new JButton("Exit");

    public MainPanelGUI(){
//        super("CANTOR");
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridLayout(5, 1));

        // add components to the panel
        newPanel.add(buttonRegister);
        newPanel.add(buttonLogin);
        newPanel.add(buttonCheckRates);
        newPanel.add(buttonTransaction);
        newPanel.add(buttonExit);

        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Main Panel"));

        // add the panel to this frame
        mainGUI.add(newPanel);
        initEvent();

//        pack();
//        setLocationRelativeTo(null);
        mainGUI.setTitle("CANTOR");
        mainGUI.pack();
        mainGUI.setLocationRelativeTo(null);
        mainGUI.setVisible(true);
    }

    private void initEvent(){
        mainGUI.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(1);
            }
        });


        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonRegister(e);
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonLogin(e);
            }
        });

        buttonCheckRates.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonCheckRates(e);
            }
        });

        buttonTransaction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonTransaction(e);
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonExit(e);
            }
        });
    }

    private void setButtonRegister(ActionEvent evt){
        new RegisterPanelGUI();
    }

    private void setButtonLogin(ActionEvent evt){
//        System.out.println("login");
        new LoginPanelGUI();
    }

    private void setButtonCheckRates(ActionEvent evt){
        System.out.println("rates");
    }

    private void setButtonTransaction(ActionEvent evt) {
        System.out.println("transaction");
    }

    private void setButtonExit(ActionEvent evt) {
        System.exit(1);
    }
}
