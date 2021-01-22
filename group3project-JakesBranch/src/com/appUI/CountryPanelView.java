package com.appUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.util.Country;

/**
 * This class is a view component that relates the add/remove country widgets.
 * @author jbuntin4
 */
public class CountryPanelView extends JPanel {
	
	private JLabel addCountryLabel;
	private JComboBox addCountryBox;
	private JButton addCountryButton;
	private JLabel removeCountryLabel;
	private JComboBox removeCountryBox;
	private JButton removeCountryButton;


	public CountryPanelView() {
		
		Country c = new Country();
		List<String> list = c.getCountryList();
		String[] countries = list.toArray(new String[0]);
		
		this.addCountryLabel = new JLabel("Add a country:");
		this.addCountryBox = new JComboBox(countries);
		this.addCountryBox.setEditable(true);
		this.addCountryButton = new JButton("Add");
		
		this.removeCountryLabel = new JLabel("Remove a country:");
		this.removeCountryBox = new JComboBox(countries);
		this.removeCountryBox.setEditable(true);
		this.removeCountryButton = new JButton("Remove");
		
		this.add(addCountryLabel);
		this.add(addCountryBox);
		this.add(addCountryButton);
		this.add(removeCountryLabel);
		this.add(removeCountryBox);
		this.add(removeCountryButton);

	}

	public JComboBox getAddCountryBox() {
		return addCountryBox;
	}

	public void setAddCountryBox(JComboBox addCountryBox) {
		this.addCountryBox = addCountryBox;
	}

	public JButton getAddCountryButton() {
		return addCountryButton;
	}

	public JComboBox getRemoveCountryBox() {
		return removeCountryBox;
	}

	public JButton getRemoveCountryButton() {
		return removeCountryButton;
	}
	
}
