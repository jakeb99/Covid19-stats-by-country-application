package com.util;

import java.util.ArrayList;
import java.util.List;

public class CountryList {
    private ArrayList<Country> list;

    public CountryList() {
        list = new ArrayList<Country>();
    }

    public void addCountry(Country c) {
        list.add(c);
    }

    public void removeCountry(Country c){
        list.remove(c);
    }

    public Country getCountry(String countryName) {
        Country country = new Country(countryName);
        try {
            country.readData();
            List<Country> mylist = country.getList();
            country.retrieveData(countryName, mylist);
        } catch (Exception e) {
            System.out.println(e);
        }
        return country;

    }

    public int size() {
        return list.size();
    }
    
    public ArrayList<Country> getList() {
        return list;
    }
}