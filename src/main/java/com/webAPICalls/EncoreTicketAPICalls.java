package com.webAPICalls;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class EncoreTicketAPICalls {
	
public static String callAPI(String URLEndPoint) {
		
		String responseString = "";
		
	try {
		
		HttpURLConnection conn=
			      (HttpURLConnection)new URL(URLEndPoint).openConnection();
			      // set the HEAD request with setRequestMethod
			      conn.setRequestMethod("GET");
			      // connection started and get response code
			      conn.connect();
			      BufferedReader br = null;
			      if (conn.getResponseCode() == 200) {
			          br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			          String strCurrentLine;
			              while ((strCurrentLine = br.readLine()) != null) {
			                     responseString = responseString+strCurrentLine;
			              }
			              
			      } else {
			          br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			          String strCurrentLine;
			          System.err.println(conn.getResponseCode());
			              while ((strCurrentLine = br.readLine()) != null) {
			                     System.err.println(strCurrentLine);
			              }
			      }
		
		
	}catch(Exception e) {
		
		System.err.println(e.getMessage());
	}
	
	return responseString ;
		
	}
	
	public static String GetValue(String response) {
		Random rand = new Random();
		JSONObject jsonobject = new JSONObject(response);
		JSONArray array = jsonobject.getJSONArray("response");
		return array.getJSONObject(rand.nextInt(array.length()-1)).getString("datetime");
		
	}
	
	public static String GetDateTimeForURL(String datetime) {
		
		datetime = datetime.replaceAll("[-T:]", "");
		System.out.println(datetime);
		String date, time = "";
		date = datetime.substring(0,8);
		time = datetime.substring(8,12);
		System.out.println("date - "+ date);
		System.out.println("time - "+ time);
		return date +":"+time;
	}
	
	public static void isRestrictedView(String responseStr) {

		JSONObject jsonobject = new JSONObject(responseStr);

		JSONObject response = jsonobject.getJSONObject("response");
		JSONArray areas = response.getJSONArray("areas");
		for (int i = 0; i <= areas.length() - 1; i++) {

			// JSONArray groupings = areas.getJSONObject(i).getJSONArray("groupings");
			JSONArray groupings = areas.getJSONObject(i).getJSONArray("groupings");
			for (int j = 0; j <= groupings.length() - 1; j++) {

				JSONArray seats = groupings.getJSONObject(j).getJSONArray("seats");

				for (int k = 0; k <= seats.length() - 1; k++) {

					boolean sv = seats.getJSONObject(k).getBoolean("isRestrictedView");

					if (sv) {

						String row = seats.getJSONObject(k).getString("row");
						int number = seats.getJSONObject(k).getInt("number");
						System.out.println(i + "" + sv);
						System.out.println("row: " + row + ",number: " + number);

					}

				}

			}

		}

	}

}
