
package com.util;

import com.data.API;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APIReader {

	public API[] fetchFromAPI(String country) {
		try {
			Gson gson = new Gson();
			String resp = retrieveData(country);

			API[] list = gson.fromJson(resp, API[].class);
			return list;
		} catch (Exception ex) {
			System.out.println(" Error reading json string " + ex.toString());
			return null;
		}
	}

	private String retrieveData(String country) {
		String urlString = String.format("https://api.covid19api.com/total/dayone/country/%s/status/confirmed", country);

		// System.out.println(urlString);
		int cases = 0;
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();

			if (conn.getResponseCode() != 200) {
				// log.error("Failed : HTTP error code : " +
				// con.getResponseCode()+"~"+con.getResponseMessage());
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
					StringBuffer response = new StringBuffer();
					String inputLine = "";
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					String output = response.toString();
					System.out.println(" Error response from the API " + output);
					return conn.getResponseCode() + "~" + output;
				} catch (Exception ex) {
					// log.error(" Error reading Spectranet error response "+ex.toString());
				}
				return conn.getResponseCode() + "~" + conn.getResponseMessage();
				// throw new ServerException("Failed : HTTP error code : " + responseCode);
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);

			StringBuffer response = new StringBuffer();

			String output;
			while ((output = br.readLine()) != null) {
				response.append(output);
			}
			conn.disconnect();
			output = response.toString();
			// System.out.println("output "+output);
			return output;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {

		APIReader api = new APIReader();
		// api.GetRequest("australia");
		api.fetchFromAPI("australia");
		// System.out.println(response);
	}
}
