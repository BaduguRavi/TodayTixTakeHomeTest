package com.webApp.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webAppPages.EncoreTicketsWebAppPageLocators;

public class WebAppUserJourney {
	
	WebDriver driver;
	EncoreTicketsWebAppPageLocators encoreticketswebapppagelocators;
	
	@BeforeClass
	public void SetUp() {

		driver = new ChromeDriver();
		encoreticketswebapppagelocators = new EncoreTicketsWebAppPageLocators();
		System.setProperty("webdriver.chrome.driver", "/Users/ravibadugu/eclipse-workspace/TakeHomeTest/src/main/resources/Apps/chromedriver.exe");
		driver = encoreticketswebapppagelocators.LaunchURL(driver, "https://www.encoretickets.co.uk");
		driver.manage().window().maximize();

	}

	@Test
	public void EncoreTicketsUserCheckoutJourney() throws InterruptedException {
		
		encoreticketswebapppagelocators.EnterShowname(driver, "TINA-The Tina Turner Musical");
		encoreticketswebapppagelocators.SelectDate(driver);
		encoreticketswebapppagelocators.SelectTime(driver);
		encoreticketswebapppagelocators.SelectSeats(driver);
		encoreticketswebapppagelocators.AddToBasket(driver);
		encoreticketswebapppagelocators.SelectPaymentMethod(driver);
		encoreticketswebapppagelocators.ContinueToCheckout(driver);
	
	}
	
	@AfterClass
	public void CloseWindow() {
		
		driver.quit();
		
	}

}
