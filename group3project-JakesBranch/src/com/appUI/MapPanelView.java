package com.appUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Map panel displayed in main UI.
 * @author jbuntin4 
 */
public class MapPanelView extends JPanel {
	
	private BufferedImage mapImage;
	private JLabel map;

	public MapPanelView() {
		try {
			this.mapImage = ImageIO.read(new File("res\\map.jpg"));
			this.map = new JLabel( new ImageIcon(mapImage));
			this.add(map);
		} catch (IOException e) {
			System.out.println("Could not find image file.");
			e.printStackTrace();
		}
	}

	public JLabel getMap() {
		return map;
	}

	public void setMap(JLabel map) {
		this.map = map;
	}

}
