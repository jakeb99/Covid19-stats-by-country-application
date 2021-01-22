package com.appUI;

/**
 *  @author jbuntin4
 */
public interface UserInterface 
{
	/** retrieves the list of countries that the user can select */
	public void getAvailableCountries();
	
	/** add a country to the users country list */
	public void addCountry(String country);
	
	/** removes a country from the users country list */
	public void removeCountry(String country);
	
	/** set user selected analysis type */
	public void setAnalysisType(String analysisType);
}
