package com.webAPI.tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.webAPICalls.EncoreTicketAPICalls;


public class APICallResponseTest {
	
	public static void main(String[] args) throws MalformedURLException, IOException {

		System.out.println("API Call Responses");
	}
	
	@Test
	  public void APICall1() {
		
		String URL = "https://inventory-service.tixuk.io/api/v4/availability/products/6362/quantity/2/from/20211101/to/20211201";
		String response1 = EncoreTicketAPICalls.callAPI(URL);
		System.out.println(response1);
	  }
	
	@Test
	  public void APICall2basedonAPICall1() {
		
		String URL = "https://inventory-service.tixuk.io/api/v4/availability/products/6362/quantity/2/from/20211101/to/20211201";
		String response1 = EncoreTicketAPICalls.callAPI(URL);
		System.out.println(response1);
		
		if(response1.length()>0) {
			String dateTime[] = EncoreTicketAPICalls.GetDateTimeForURL(EncoreTicketAPICalls.GetValue(response1)).split(":");
			String URL2 = "https://inventory-service.tixuk.io/api/v4/products/6362/areas?date=%s&time=%s&quantity=2";
			String Response2 = EncoreTicketAPICalls.callAPI(String.format(URL2, dateTime[0], dateTime[1]));
			System.out.println(Response2);
		}
		
	  }
	
	@Test
	  public void APICall3() {
		
		String URL3 = "https://inventory-service.tixuk.io/api/v4/products/6362/areas?date=20211118&time=1430&quantity=2&includeSeatsAttributes=true";
		String response3 = EncoreTicketAPICalls.callAPI(URL3);
		System.out.println(response3);
		EncoreTicketAPICalls.isRestrictedView(response3);
		
	  }
	  

}
