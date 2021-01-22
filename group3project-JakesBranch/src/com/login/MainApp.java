package com.login;

import com.appUI.*;

/**
 * main app to initiate system.
 * i.e., initiates login system
 * @author jbuntin4 
 */
public class MainApp {

	public static void main(String[] args) {
		
		LoginView loginView = new LoginView();
		LoginClient loginClient= new LoginClient(loginView);

	}

}