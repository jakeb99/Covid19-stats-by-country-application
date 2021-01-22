package com.appUI;

import java.util.ArrayList;

import com.util.*;

/**
 * This is the user model.
 * This class uses the singleton design principle to allow
 * only one User instance is created. It stores information
 * that the views display.
 * @author jbuntin4
 */
public class UserModel {
	private static UserModel instance = null;
	private String analysisType;		// analysisType selected
	private String countrySelection;
	private ArrayList<String> countryStringList;
	private CountryList countryObjList;
	private static ArrayList<Country> globalCountryList;
	private Draw draw;
		
	/**
	 * Creates an User instance only if there are none
	 * already instantiated.
	 * @return instance the single instance of User object 
	 */
	public static UserModel getInstance() {
		if (instance == null) 
			instance = new UserModel();
		return instance;
	}
	
	private UserModel() {
		countryStringList = new ArrayList<String>();
		this.countryObjList = new CountryList();
		this.globalCountryList = countryObjList.getList();
	}
	
	public void drawHotSpots() {
		
		Draw draw = new Draw();	
		for (Country c : globalCountryList) {
			System.out.println(c.getName());
		}
		
		draw.drawMap(globalCountryList);
		
	}
	
	public String getAnalysisType() {
		return analysisType;
	}

	public void setAnalysisType(String analysisType) {
		this.analysisType = analysisType;
//		System.out.println("user set analysis to: " + getAnalysisType());		// test
	}

	public String getCountrySelection() {
		return countrySelection;
	}

	public void setCountrySelection(String countrySelection) {
		this.countrySelection = countrySelection;
	}

	public void addCountryString(String country) {
		this.countryStringList.add(country);
		System.out.println(countryStringList.toString());
	}

	public void removeCountryString(String country) {
		
		this.countryStringList.remove(country);
		System.out.println(countryStringList.toString());
	}

	public ArrayList<String> getCountryStringList() {
		return countryStringList;
	}

	public void setCountryStringList(ArrayList<String> countryStringList) {
		this.countryStringList = countryStringList;
	}
	
	public boolean removeCountryFromList(String country) {
		for (Country c : globalCountryList) {
			boolean contains = c.getName().equalsIgnoreCase(country) ?true :false;
			if (contains) {
				globalCountryList.remove(c);		
				return true;
			}
		}
		return false;
	}
	
	public boolean addCountryToList(String country) {
		
		Country c = new Country();
		c.getCountryList();
		boolean valid = c.verifyCountry(country);
		if (valid) {
			c = this.countryObjList.getCountry(country);
			globalCountryList.add(c);
			return true;
		} else {
			return false;
		}
		
	}
	
	static ArrayList<Country> getGlobalCountryList() {
		return globalCountryList;
	}

	
}
