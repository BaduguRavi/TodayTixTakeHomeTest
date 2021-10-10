package com.webAppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EncoreTicketsWebAppPageLocators {
	
	By searchField = By.xpath("//input[@type='search']");
	By showName = By.xpath("//span[text()='TINA - The Tina Turner Musical']");
	By findTicketButton = By.xpath("//span[text()='Find Tickets']/parent::span/parent::button");
	By chooseDate = By.xpath("//span[@aria-label='October 16, 2021']");
	By chooseTime = By.xpath("//*[@id='inventory-app']/div/div/div/div/div[1]/div[2]/div[3]/div[2]/label");
	By pickYourSeatsButton = By.xpath("(//span[text()='Pick your seats']/parent::span/parent::button)[1]");
	By seatSelectionArea = By.xpath("//iframe[@scrolling='no']");
	By addToBasketButton = By.xpath("//button//span[text()='Add to Basket']");
	By creditCardRadioButton = By.xpath("(//input[@name='mui-5783'])[1]");
	By paypalRadioButton = By.xpath("(//input[@name='mui-5783'])[2]");
	By continueToCheckout = By.xpath("//button//span[text()='Continue to checkout']");

	public void Click(WebDriver driver, By Locator) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
		driver.findElement(Locator).click();

	}

	public void Sendkeys(WebDriver driver, By Locator, String Text) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
		driver.findElement(Locator).clear();
		driver.findElement(Locator).sendKeys(Text);

	}

	public void scrollToElement(WebDriver driver, By Locator) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguements[0].scrollIntoView(true);", driver.findElement(Locator));

	}

	public WebDriver LaunchURL(WebDriver driver, String URL) {

		driver.get(URL);
		return driver;

	}

	public void EnterShowname(WebDriver driver, String ShowName) throws InterruptedException {

		Thread.sleep(3000);
		Sendkeys(driver, searchField, ShowName);
		// scrollToElement(driver, showName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		Click(driver, showName);
		Click(driver, findTicketButton);

	}

	public void SelectDate(WebDriver driver) throws InterruptedException {

		Thread.sleep(10000);
		Click(driver, chooseDate);

	}

	public void SelectTime(WebDriver driver) throws InterruptedException {

		Thread.sleep(6000);
		Click(driver, chooseTime);
		Thread.sleep(6000);
		Click(driver, pickYourSeatsButton);

	}

	public void SelectSeats(WebDriver driver) {

		WebElement element = driver.findElement(seatSelectionArea);
		Point point = element.getLocation();
		System.out.println(point.getX() + "," + point.getY());

	}

	public void AddToBasket(WebDriver driver) throws InterruptedException {

		Thread.sleep(6000);
		Click(driver, addToBasketButton);

	}

	public void SelectPaymentMethod(WebDriver driver) throws InterruptedException {

		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(6000);
		Click(driver, creditCardRadioButton);

	}

	public void ContinueToCheckout(WebDriver driver) throws InterruptedException {

		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(6000);
		Click(driver, continueToCheckout);

	}


}
