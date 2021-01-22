
package com.process;

import com.data.API;
import com.data.CSV;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.util.APIReader;
import com.util.CSVReader;
import com.util.Country;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Result {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Result r = new Result();
        List<Double> list = r.getCountryCases();
        Country myCountry = new Country();
        List<String> listOfCountries = myCountry.getCountryList();
        int i = 0;
        for (double d : list) {
            System.out.println(listOfCountries.get(i) + ": " + d);
            i++;
        }

    }

    public List<Double> getCountryCases() {
        Country myCountry = new Country();
        List<String> listOfCountries = myCountry.getCountryList();
        String anaylsistype = "ConfirmedCases";// data for analysis type
        List<Double> listCases = new ArrayList();
        if (listOfCountries != null) {
            for (String country : listOfCountries) {
                double result = Analysis.performAnalysis(anaylsistype, country);
                listCases.add(result);
            }
        }
        return listCases;
    }

}