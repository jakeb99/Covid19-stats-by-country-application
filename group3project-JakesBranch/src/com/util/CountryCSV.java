/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.util.Country;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author driberop
 */
public class CountryCSV {

    public List<Country>  readfile() {
        BufferedReader br;
       List<Country> list = new ArrayList();
        try {
            File file = new File("res\\Countries.csv");
            br = new BufferedReader(new FileReader(file));
            br.ready();
            int countlines = countLines(file);
                int k = 0;   
                   while (k < countlines) {
                      
                        String lineValue = br.readLine().trim();
                        if(lineValue.contains(",") && k >= 0){
                            String ar[] = lineValue.split(",",4);
                               Country csv = new Country();
                               csv.setName(ar[0]);
                               csv.setPopulation(Integer.parseInt(ar[1]));
                               csv.setLat(Double.parseDouble(ar[2]));
                               csv.setLong(Double.parseDouble(ar[3]));
                               list.add(csv);
                        }   
                          k++;
                    }
            
        } catch (Exception ex) {
            System.out.println("Error reading csv file "+ex.toString());
        }
        return list;
    }
    

   public static int countLines(File afile){
           LineNumberReader read = null;
             try{
              read = new LineNumberReader(new FileReader(afile));
              while((read.readLine())!= null);
              return read.getLineNumber();
             }catch(Exception e){
             return -1;
             }
             finally{
             if(read != null){
                 try{
                 read.close();
                 }catch(Exception ex){}
             }
             }
       } 

}
