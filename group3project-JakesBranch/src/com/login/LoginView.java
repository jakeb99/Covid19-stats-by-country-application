package com.login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Displays the login GUI to the user
 * @author jbuntin4
 */
public class LoginView extends JFrame {
	
	private final int FRAME_WIDTH = 300;
	private final int FRAME_HEIGHT = 180;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPanel loginPanel;						
	private JLabel userNameLabel;		
	private JLabel passwordLabel;				
	private JButton loginButton;
	
	/**
	 * Constructor to display the login GUI 
	 */
	public LoginView() {
		super("Login");		// window name
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.loginPanel = new JPanel();
		this.userNameLabel = new JLabel("UserName:");
		this.passwordLabel = new JLabel("Password:");
		this.userNameField = new JTextField();
		this.passwordField = new JPasswordField();
		this.loginButton = new JButton("Login");
		
		loginPanel.setLayout(null);
		
		userNameLabel.setBounds(10, 20, 100, 25);
		passwordLabel.setBounds(10, 60, 100, 25);
		
		userNameField.setBounds(80,  20, 165, 25);
		passwordField.setBounds(80,  60, 165, 25);
		
		loginButton.setBounds(110, 90, 80, 25);
		
		// add elements to the panel
		this.add(loginPanel);				
		loginPanel.add(userNameLabel);
		loginPanel.add(userNameField);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordField);
		loginPanel.add(loginButton);
		
		this.setVisible(true);
		
	}
	
	/** 
	 * @return userNameField component storing username input
	 */
	JTextField getUserNameField() {
		return userNameField;
	}
	
	/** 
	 * @return passwordField component storing password input
	 */
	JPasswordField getPasswordField() {
		return passwordField;
	}
	
	/**
	 *  @return loginButton component to initiate login
	 */
	JButton getLoginButton() {
		return loginButton;
	}

}
