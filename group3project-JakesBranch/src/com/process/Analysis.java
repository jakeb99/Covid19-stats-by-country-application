package com.process;

import com.process.AnalysisFemaleCases;
import com.util.Country;
import com.util.CountryList;

public class Analysis {

	public static double performAnalysis(String type, String country) {

		if (type.equalsIgnoreCase("FemaleCases")) {
			return AnalysisFemaleCases.getFemaleCasesByCountry(country);
			
		} else if (type.equalsIgnoreCase("MaleCases")) {
			return AnalysisMaleCases.getMaleCasesByCountry(country);
			
		} else if (type.equalsIgnoreCase("ConfirmedCases")) {
			return AnalysisConfirmedCases.getConfirmedCasesByCountry(country);
			
		} else if (type.equalsIgnoreCase("ConfirmedDeaths")) {
			return AnalysisDeathCases.getDeathCasesByCountry(country);
			
		} else {
			return 0;
		}

	}

}
