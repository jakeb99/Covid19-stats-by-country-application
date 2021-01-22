package com.login;

import com.appUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * i.e., login controller
 * This class handles the actions the user performs while interacting with the login view.
 * It also handles the loginc for validating the user and logging the user into the main application.
 * 
 * @author jbuntin4
 */
public class LoginClient {

	private LoginView loginView;
	private String userName;
	private String password;
	private boolean isValid;
	
	/**
	 * LoginClient Constructor.
	 * @param loginView login window that login client recieves input from. 
	 */
	public LoginClient(LoginView loginView) {
		this.loginView = loginView;
		initController();
	}
	
	/** add action listener to get login view events */
	private void initController() {
		loginView.getLoginButton().addActionListener(e -> initLogin());
	}
	
	/** initiates login. Calls to validation function,
	 * if user enters valid credentials then they are logged in,
	 * else, an error message is displayed and the program exits. */
	@SuppressWarnings("deprecation")
	private void initLogin() {
		this.userName = loginView.getUserNameField().getText();
		this.password = loginView.getPasswordField().getText();
		this.isValid = validateUserCredentials();

		if (!this.isValid) {
			System.out.println("Invalid credentials, terminating program...");
			JOptionPane.showMessageDialog(null, "Invalid credentials, click \"OK\" to exit.");
			loginView.dispatchEvent(new WindowEvent(loginView, WindowEvent.WINDOW_CLOSING));
		} else {
			System.out.println("Loggin in...");
			loginView.dispose();
			UserModel userModel = UserModel.getInstance();						// create UserModel instance
			MainWindowView mainView = MainWindowView.getInstance();				// create main app view
			UIController controller = new UIController(userModel, mainView);	// create UIcontroller
		}

	}
	
	/** Validates username and password against the user credential DB.
	 * @return true if credentials found in DB, false otherwise. */
	private boolean validateUserCredentials() {
		boolean valid = false;
		String row;
		String[] items = null;
		try {
			File userDB = new File("res\\userCredentialDB.csv");
			Scanner reader = new Scanner(userDB);
			reader.nextLine(); // ignore header line of csv file
			while (reader.hasNextLine()) {
				row = reader.nextLine();
				items = row.split(",");

				if (items[0].equals(this.userName) && items[1].equals(this.password)) {
					valid = true;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return valid;

	}

}
