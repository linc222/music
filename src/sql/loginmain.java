package sql;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginmain extends JFrame {
    JPanel mainPanel;
    JPanel loginPanel;
    JPanel loginsouthPanel;
    JPanel registerPanel;
    JPanel registerSouthPanel;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JLabel registerUsernameLabel;
    JLabel registerPasswordLabel;
    JTextField usernameField;
    JTextField passwordField;
    JTextField registerUsernameField;
    JTextField registerPasswordField;
    JButton loginButton;
    JButton registerButton;
    JButton registerPanelButton;
    public loginListen loginmainlisten;
    CardLayout cardLayout;

    public loginmain() {
        this.initLogin();
        this.initView();
    }

    private void initLogin() {
        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(this.cardLayout);
        this.loginView();
        this.registerPanel = new JPanel(new BorderLayout());
        JPanel registercenterPanel = new JPanel(new GridBagLayout());
        this.registerPanelButton = new JButton("注册");
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = 2;
        gbc2.insets = new Insets(5, 5, 5, 5);
        this.registerUsernameLabel = new JLabel("用户名:");
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        registercenterPanel.add(this.registerUsernameLabel, gbc2);
        this.registerUsernameField = new JTextField(20);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        registercenterPanel.add(this.registerUsernameField, gbc2);
        this.registerPasswordLabel = new JLabel("密码:");
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        registercenterPanel.add(this.registerPasswordLabel, gbc2);
        this.registerPasswordField = new JPasswordField(20);
        gbc2.gridx = 1;
        gbc2.gridy = 1;
        registercenterPanel.add(this.registerPasswordField, gbc2);
        this.registerPanelButton.addActionListener(this.loginmainlisten);
        this.registerPanel.add(registercenterPanel, "Center");
        this.registerPanel.add(this.registerPanelButton, "South");
        this.mainPanel.add(this.loginPanel, "loginPanel");
        this.mainPanel.add(this.registerPanel, "registerPanel");
        Container container = this.getContentPane();
        container.add(this.mainPanel, "Center");
    }

    private void registerView() {
    }

    private void loginView() {
        this.loginPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel(new GridBagLayout());
        this.loginButton = new JButton("登录");
        this.registerButton = new JButton("注册");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        this.usernameLabel = new JLabel("用户名:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(this.usernameLabel, gbc);
        this.usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(this.usernameField, gbc);
        this.passwordLabel = new JLabel("密码:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(this.passwordLabel, gbc);
        this.passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        centerPanel.add(this.passwordField, gbc);
        this.loginsouthPanel = new JPanel(new FlowLayout(1));
        this.loginsouthPanel.add(this.loginButton);
        this.loginsouthPanel.add(this.registerButton);
        this.loginPanel.add(this.loginsouthPanel, "South");
        this.loginPanel.add(centerPanel, "Center");
        this.loginmainlisten = new loginListen();
        this.loginmainlisten.setLoginmain(this);
        this.registerButton.addActionListener(this.loginmainlisten);
        this.loginButton.addActionListener(this.loginmainlisten);
    }

    private void initView() {
        this.setTitle("登录");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo((Component)null);
        this.setVisible(true);
    }
}