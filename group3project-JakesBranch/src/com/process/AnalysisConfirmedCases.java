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
public class AnalysisConfirmedCases {

	public static double getConfirmedCasesByCountry(String country) {

		try {
			// read from the api
			APIReader apireader = new APIReader();
			API[] apiRecords = apireader.fetchFromAPI(country);
			int size = apiRecords.length;
			// System.out.println("Country: "+country+", Confirmed Cases: "+apiRecords[size
			// - 1].getCases());
			return apiRecords[size - 1].getCases();

		} catch (Exception e) {
			System.out.println("Error getting confirmed cases " + e.toString());
			return 0;
		}

	}
}
