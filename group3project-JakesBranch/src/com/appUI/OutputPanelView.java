package com.appUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Panel that displays analysis output and the list of the selected countries.
 * @author jbuntin4 
 */
public class OutputPanelView extends JPanel {
	
	private String[] analysisTypes = {"", "FemaleCases", "MaleCases", "ConfirmedCases", "ConfirmedDeaths"};
	private JLabel analysisChoicesLabel;
	private JComboBox analysisChoicesBox;
	private JLabel selectedCountriesLabel;
	private JTextArea selectedCountriesTextArea;
	private JButton recalculateButton;
	private JLabel analysisOutputLabel;
	private JTextArea analysisOutputTextArea;

	public OutputPanelView() {
		
		this.selectedCountriesLabel = new JLabel("List of selected countries:");
		this.selectedCountriesTextArea = new JTextArea();
		this.selectedCountriesTextArea.setPreferredSize(new Dimension(10, 200));
		this.analysisChoicesLabel = new JLabel("Choose analysis method:");
		this.analysisChoicesBox = new JComboBox(analysisTypes);
		this.selectedCountriesTextArea.setEditable(false);
		
		this.recalculateButton = new JButton("Recalculate");
		
		this.analysisOutputLabel = new JLabel("Output:");
		this.analysisOutputTextArea = new JTextArea();
		this.analysisOutputTextArea.setPreferredSize(new Dimension(10, 100));
		this.analysisOutputTextArea.setEditable(false);
		
		this.add(selectedCountriesLabel);
		this.add(selectedCountriesTextArea);
		this.add(analysisChoicesLabel);
		this.add(analysisChoicesBox);
		this.add(recalculateButton);
		this.add(analysisOutputLabel);
		this.add(analysisOutputTextArea);

	}
	
	/** getter for analysis choice box */
	public JComboBox getAnalysisChoicesBox() {
		return analysisChoicesBox;
	}
	/** getter for selected countries text area */
	public JTextArea getSelectedCountriesTextArea() {
		return selectedCountriesTextArea;
	}
	/** getter for recalculate button */
	public JButton getRecalculateButton() {
		return recalculateButton;
	}
	/** getter for analysis output text area */
	public JTextArea getAnalysisOutputTextArea() {
		return analysisOutputTextArea;
	}

}
