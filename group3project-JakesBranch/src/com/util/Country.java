package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Country {
    private String countryName;
    private int population, male, female;
    private double confirmedCases, longitude, latitude;
    private Country myCountry;
    private List<String> list;
    public static List<Country> countryList = new ArrayList<>();

    public Country() {
    }

    public Country(String name) {
        setName(name);
    }

    public Country(String name, int population, double latitude, double longitude) {
        this.countryName = name;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName(){
        return countryName;
    }
    public void setName(String name) {
        this.countryName = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int pop) {
        this.population = pop;
    }

    public double getLat() {
        return latitude;
    }

    public void setLat(double geoLat) {
        this.latitude = geoLat;
    }

    public double getLong() {
        return longitude;
    }

    public void setLong(double geoLong) {
        this.longitude = geoLong;
    }

    public Country getCountry() {
        return myCountry;
    }

    public List<String> getCountryList() { // this method runs through the list of countries and adds them to a list
        List<String> list = new ArrayList<String>();
        list = FileRead.fileToList("res\\CountryList.txt");
        this.list = list;
        return list;
    }

    public boolean verifyCountry(String countryName) { // check if the country entered is a valid country in our list of
        boolean containsSearchStr = this.list.stream().anyMatch(countryName::equalsIgnoreCase);
        return containsSearchStr;
    }

    public void readData() throws IOException {

        FileReader info = new FileReader("res\\Countries.csv");
        BufferedReader reader = new BufferedReader(info);
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            String[] attributes = line.split(",");
            String countryName = attributes[0];
            int population = Integer.parseInt(attributes[1]);
            double latitude = Double.parseDouble(attributes[2]);
            double longitude = Double.parseDouble(attributes[3]);
            countryList.add(new Country(countryName, population, latitude, longitude));
        }
        reader.close();
    }
    public void retrieveData(String country, List<Country> list){ //retrieves population,lng,lat for specified country from list of all countries
        for (Country c : list) {
            if (c.getName().equalsIgnoreCase(country)){
                this.latitude = c.getLat();
                this.longitude = c.getLong();
                this.population = c.getPopulation();
            }
        }
    }
    public List<Country> getList() {
        return countryList;
    }

    public void printInfo(){
        String formattedString = String.format("Country:{name: %s, population %d, latitude: %f, longitude: %f",this.countryName,this.population,this.latitude,this.longitude);
        System.out.println(formattedString);
    }
}
