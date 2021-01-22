package com.util;

import com.util.Country;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Draw {
	private int ovalDimension;
	private int mapWidth;
	private int mapHeight;
	private double lat;
	private double lng;
	private BufferedImage myPicture;
	private Graphics2D editableImage;

	public Draw() {
	}

	private Point getXY(double lat, double lng, int mapWidth, int mapHeight) {
		this.lat = lat;
		this.lng = lng;
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		int screenX = (int) Math.round((((lng + 180) / 360) * mapWidth));
		int screenY = (int) Math.round(((((lat * -1) + 90) / 180) * mapHeight));
		return new Point(screenX, screenY);
	}

	private int ovalDimension(int max) {
		int maxOvalDimension;
		double percentage = 0.9;
		if (max < 10000)
			maxOvalDimension = 20;
		else if (max < 50000)
			maxOvalDimension = 30;
		else if (max < 100000)
			maxOvalDimension = 50;
		else
			maxOvalDimension = 70;

		int minOvalDimension = 15;
		int ovalDimension = (int) Math.round(((maxOvalDimension - minOvalDimension) * percentage) + minOvalDimension);
		this.ovalDimension = ovalDimension;
		return ovalDimension;
	}

	private void render() {
		try {
			Point2D coords = new Point2D.Double(this.lng, this.lat);
			System.out.println("Coordinates: " + coords.getX() + ", " + coords.getY());
			Point testPoint = getXY(coords.getX(), coords.getY(), this.mapWidth, this.mapHeight);
			// Add the circle to the image
			Graphics2D editableImage = (Graphics2D) this.myPicture.getGraphics();
			editableImage.setColor(Color.RED);
			editableImage.setStroke(new BasicStroke(3));
			editableImage.fillOval(testPoint.x - (this.ovalDimension / 2), testPoint.y - (this.ovalDimension / 2),
					this.ovalDimension, this.ovalDimension);
			editableImage.dispose();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void drawMap(List<Country> countryList) {

		try {
			File file = new File("res\\map.jpg");
			BufferedImage myPicture = ImageIO.read(file);
			this.myPicture = myPicture;
			mapWidth = myPicture.getWidth();
			mapHeight = myPicture.getHeight();
			int max = getMax(countryList);
			for (Country c : countryList) { // list of countries to render from verified country list
				this.lat = c.getLat();
				this.lng = c.getLong();
				ovalDimension(c.getPopulation());// need to get the max value of the added countries
				c.printInfo();
				render();
			}

			ImageIO.write(this.myPicture, "jpg", new File("res\\new.jpg"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int getMax(List<Country> countryList) {
		double max = 0;
		for (Country c : countryList) {
			if (max < c.getPopulation()) {
				max = c.getPopulation();
			}
		}
		int adjusted = (int) (max * 0.05); // 5% of population approximates confirmed cases
		return adjusted;
	}

}
