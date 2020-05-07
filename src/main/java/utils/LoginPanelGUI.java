package utils;

import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class LoginPanelGUI {
    private JFrame loginFrame = new JFrame();

    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JButton exitButton = new JButton("Exit");

    private JPanel loginPanel = new JPanel();
    private JLabel loginLabel = new JLabel("Login");
    private JLabel passwordLabel = new JLabel("Password");
    private JLabel actionLabel = new JLabel("Status");

    private JTextField loginTextField = new JTextField(30); // accepts upto 10 characters
    private JTextField passwordTextField = new JTextField(30);

    public LoginPanelGUI(){
        loginPanel.add(loginLabel);
        loginPanel.add(loginTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
        loginPanel.add(loginButton);
        loginPanel.add(resetButton);
        loginPanel.add(actionLabel);
        loginPanel.add(exitButton);
        loginPanel.setLayout(new GridLayout(8, 0));

        initEvent();
        loginFrame.add(loginPanel);
        loginFrame.setTitle("Login Panel");
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    private void initEvent(){
        loginFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(1);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setLoginButton(e);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setResetButton(e);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setExitButton(e);
            }
        });
    }

    private void setLoginButton(ActionEvent evt) throws IOException {
        User user = new User();
        Helper helper = new Helper();
        user.setUserLogin(loginTextField.getText());
        user.setUserPassword(passwordTextField.getText());

        if (helper.loginChecker(user.login, user.password) == true) {
            actionLabel.setText("Login accepted");
        } else {
            actionLabel.setText("Wrong login/password");
        }
//        loginChecker
    }

    private void setResetButton(ActionEvent evt){
        loginTextField.setText("");
        passwordTextField.setText("");
        actionLabel.setText("Data cleared!");
    }

    private void setExitButton(ActionEvent evt){
        loginFrame.setVisible(false);
    }
}
