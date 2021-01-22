/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.data.CSV;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author misiksa
 */
public class CSVReader {

    public List<CSV>  readfile() {
        BufferedReader br;
       List<CSV> list = new ArrayList();
        try {
            File file = new File("res\\Male_FemaleCases.csv");
            br = new BufferedReader(new FileReader(file));
            br.ready();
            int countlines = countLines(file);
                int k = 0;   
                   while (k < countlines) {
                      
                        String lineValue = br.readLine().trim();
                        if(lineValue.contains(",") && k > 0){
                            String ar[] = lineValue.split(",",8);
                               CSV csv = new CSV();
                               csv.setCountry(ar[0]);
                               csv.setIsCaseBySex(ar[1]);
                               csv.setNoOfCasesForDisaggregated(ar[2]);
                               csv.setMaleCasesByPercentage(ar[3]);
                               csv.setFemaleCasesByPercentage(ar[4]);
                               csv.setMaleCasesCount(ar[5]);
                               csv.setFemaleCasesCount(ar[6]);
                               csv.setNoOfDeathForDisaggregated(ar[7]);
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
