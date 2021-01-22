package com.appUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;		// TODO replace with specific imports

/**
 * Main UI frame that contains various sub panel views.
 * @author jbuntin4  
 */
public class MainWindowView extends JFrame {
	
	private static final int FRAME_WIDTH = 1920;
	private static final int FRAME_HEIGHT = 1080;
	private static MainWindowView instance = null;
	private UserModel user;
	private MainWindowView mainAppFrame;
	private CountryPanelView countryPanel;
	private OutputPanelView outputPanel;
	private MapPanelView mapPanel;
	
	public static MainWindowView getInstance() {
		if (instance == null)
			instance = new MainWindowView();
		return instance;
	}
	
	/** Class constructor */
	private MainWindowView() {
		super("COVID-19 Analysis Model");		// window title
		this.setLayout(new BorderLayout());
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createCountryPanel();		// create add/remove country panel
		createMapPanel();
		createOutputPanel();		// create output panel that displays selected countries, analysis output and recalculate button
		this.setVisible(true);
		
		this.user = UserModel.getInstance();
	}
	
	// helper to create map panel
	private void createMapPanel() {
		this.mapPanel = new MapPanelView();
		this.add(mapPanel, BorderLayout.CENTER);
	}

	// helper method to create output panel
	private void createOutputPanel() {
		this.outputPanel = new OutputPanelView();
		this.outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
		this.add(outputPanel, BorderLayout.EAST);
	}

	// helper to create country panel
	private void createCountryPanel() {
		this.countryPanel = new CountryPanelView();
		this.countryPanel.setLayout(new FlowLayout());
		this.add(countryPanel, BorderLayout.NORTH);
	}

	public MainWindowView getMainAppFrame() {
		return mainAppFrame;
	}

	public void setMainAppFrame(MainWindowView mainAppFrame) {
		this.mainAppFrame = mainAppFrame;
	}

	public CountryPanelView getCountryPanel() {
		return countryPanel;
	}

	public void setCountryPanel(CountryPanelView countryPanel) {
		this.countryPanel = countryPanel;
	}

	public OutputPanelView getOutputPanel() {
		return outputPanel;
	}

	public void setOutputPanel(OutputPanelView outputPanel) {
		this.outputPanel = outputPanel;
	}

	public MapPanelView getMapPanel() {
		return mapPanel;
	}

	public void setMapPanel(MapPanelView mapPanel) {
		this.mapPanel = mapPanel;
	}
	
}
