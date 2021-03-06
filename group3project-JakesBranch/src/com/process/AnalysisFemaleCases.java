/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.process;

import com.data.API;
import com.data.CSV;
import com.util.APIReader;
import com.util.CSVReader;
import java.util.List;

/**
 *
 * @author misiksa
 */
public class AnalysisFemaleCases {
    
    public static double getFemaleCasesByCountry(String country){
        double count = 0;
        try{
              //read from the csv file
        CSVReader csvReader = new CSVReader();
        List<CSV> csvRecords = csvReader.readfile();
        
        for(CSV csv: csvRecords){
               if(country.equalsIgnoreCase(csv.getCountry())){
                  //  System.out.println("Country: "+country+", Female Cases: "+csv.getFemaleCasesCount());
                   return Double.parseDouble(csv.getFemaleCasesCount());
               }
           
            //read from the api
//            APIReader apireader = new APIReader();
//            List<API> api = apireader.fetchFromAPI(country);
        }
         return 0;   
        }catch(Exception e){
            System.out.println("Error getting female cases "+e.toString());
            return 0;
        }
      
    }
}
