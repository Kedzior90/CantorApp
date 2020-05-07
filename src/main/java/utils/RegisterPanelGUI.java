package utils;

import model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class RegisterPanelGUI {
    private JFrame registerFrame = new JFrame();

    private JButton saveButton = new JButton("Save");
    private JButton resetButton = new JButton("Reset");
    private JButton exitButton = new JButton("Exit");

    private JPanel registerPanel = new JPanel();
    private JLabel loginLabel = new JLabel("Login");
    private JLabel nameLabel = new JLabel("Name");
    private JLabel surnameLabel = new JLabel("Surname");
    private JLabel passwordLabel = new JLabel("Password");
    private JLabel emailAddressLabel = new JLabel("Email Address");
    private JLabel userIdLabel = new JLabel("User ID");
    private JLabel generatedUserIdLabel = new JLabel();
    private JLabel actionLabel = new JLabel("Status");

    private JTextField loginTextField = new JTextField("JanKowalski90", 30); // accepts upto 10 characters
    private JTextField nameTextField = new JTextField("Jan", 30);
    private JTextField surnameTextField = new JTextField("Kowalski",30);
    private JTextField passwordTextField = new JTextField("password", 30);
    private JTextField emailAddressTextField = new JTextField("jan.kowalski@interia.pl", 30);

    public RegisterPanelGUI() {
        registerPanel.add(loginLabel);
        registerPanel.add(loginTextField);
        registerPanel.add(nameLabel);
        registerPanel.add(nameTextField);
        registerPanel.add(surnameLabel);
        registerPanel.add(surnameTextField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordTextField);
        registerPanel.add(emailAddressLabel);
        registerPanel.add(emailAddressTextField);
        registerPanel.add(userIdLabel);
        registerPanel.add(generatedUserIdLabel);
        registerPanel.add(saveButton);
        registerPanel.add(resetButton);
        registerPanel.add(actionLabel);
        registerPanel.add(exitButton);
        registerPanel.setLayout(new GridLayout(11, 0));

        initEvent();
        registerFrame.add(registerPanel);
        registerFrame.setTitle("Register Panel");
        registerFrame.pack();
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setVisible(true);
    }

    private void initEvent(){
        registerFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(1);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setSaveButton(e);
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

    private void setSaveButton(ActionEvent evt) throws IOException {
        User user = new User();
        Helper helper = new Helper();
        user.setUserLogin(loginTextField.getText());
        user.setUserName(nameTextField.getText());
        user.setUserSurname(surnameTextField.getText());
        user.setUserPassword(passwordTextField.getText());
        user.setEmailAddress(emailAddressTextField.getText());
        user.setUserId();
        generatedUserIdLabel.setText(String.valueOf(user.getUserId()));
        helper.saveUserInDatabase(user);
        actionLabel.setText(user.toString());
    }

    private void setResetButton(ActionEvent evt){
        loginTextField.setText("");
        nameTextField.setText("");
        surnameTextField.setText("");
        passwordTextField.setText("");
        emailAddressTextField.setText("");
        generatedUserIdLabel.setText("");
        actionLabel.setText("Data cleared!");
    }

    private void setExitButton(ActionEvent evt){
        registerFrame.setVisible(false);
    }
}