package com.appUI;

import javax.swing.JOptionPane;

import com.process.Analysis;
import com.util.Country;
import com.util.CountryList;
import com.util.Draw;

/**
 * Controller for UI.
 * implements the logic to manipulate user model and update the UI views 
 * @author jbuntin4 
 */
public class UIController {
	
	private UserModel userModel;
	private MainWindowView mainView;
	private CountryPanelView cpView;
	private OutputPanelView opView;
	private MapPanelView mapView;
	private Draw draw;
	
	public UIController(UserModel userModel, MainWindowView mainView) {

		this.userModel = userModel;
		this.mainView = mainView;
		this.cpView = mainView.getCountryPanel();
		this.opView = mainView.getOutputPanel();
		this.mapView = mainView.getMapPanel();
		initViews();
		initController();
	}
	
	private void initViews() {
		MainWindowView.getInstance();
	}
	
	/** adds listeners to handle view actions */
	private void initController() {	
		cpView.getAddCountryButton().addActionListener(e -> addCountry());
		cpView.getRemoveCountryButton().addActionListener(e -> removeCountry());
		opView.getAnalysisChoicesBox().addActionListener(e -> setAnalysisType());
		opView.getRecalculateButton().addActionListener(e -> initPerformAnalysis());
	}

	private void initPerformAnalysis() {
//		draw = new Draw();
		String type = userModel.getAnalysisType();
		if (type != null) {
			for (String c : userModel.getCountryStringList()) {
				double out = Analysis.performAnalysis(type, c);
				opView.getAnalysisOutputTextArea().append(c + ": " + String.valueOf(out) + "\n");
			}
			
			userModel.drawHotSpots();
			
		} else {
			JOptionPane.showMessageDialog(null, "Please select an analysis type.");
		}
	}

	private void setAnalysisType() {
		String analysisChoice = (String) opView.getAnalysisChoicesBox().getEditor().getItem();
		userModel.setAnalysisType(analysisChoice);
	}

	private void addCountry() {
		String country = (String) cpView.getAddCountryBox().getEditor().getItem();
		boolean succ = userModel.addCountryToList(country);
		
		if (succ) {
			userModel.addCountryString(country.toLowerCase());
			
			// display in output panel
			opView.getSelectedCountriesTextArea().setText(null); // clear output first
			for (String c : userModel.getCountryStringList()) {
				this.opView.getSelectedCountriesTextArea().append(c + "\n");	
			}
		} else {
			JOptionPane.showMessageDialog(null, "Invalid country");
		}
		
	}
	
	private void removeCountry() {
		String country = (String) cpView.getRemoveCountryBox().getEditor().getItem();
		boolean succ = userModel.removeCountryFromList(country);
		
		if (succ) {
			userModel.removeCountryString(country.toLowerCase());
			
			opView.getSelectedCountriesTextArea().setText(null); 
			for (String c : userModel.getCountryStringList())
				opView.getSelectedCountriesTextArea().append(c + "\n");
		} else {
			JOptionPane.showMessageDialog(null, country + " was not in the list of selected countries.");
		}
	}
	
	
	
	
	
}
