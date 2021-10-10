package com.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.utils.TestUtils;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {

	protected static AppiumDriver<MobileElement> driver;
	protected static Properties props;
	protected static String platform;
	InputStream inputStream;

	@Parameters({ "emulator", "platformName", "platformVersion", "deviceName" })
	@BeforeTest
	public void beforeTest(String emulator, String platformName, String platformVersion, String deviceName)
			throws Exception {

		platform = platformName;
		URL url;

		try {

			props = new Properties();
			String propFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			props.load(inputStream);

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", platformName);
			caps.setCapability("platformVersion", platformVersion);
			caps.setCapability("deviceName", deviceName);

			switch (platformName) {
			case "Android":

				caps.setCapability("automationName", props.getProperty("androidAutomationName"));
				caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
				caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
				caps.setCapability("noReset", "true");
				caps.setCapability("fullReset", "false");
				caps.setCapability("UDID", "emulator-5554");
				if (emulator.equalsIgnoreCase("true")) {
					caps.setCapability("avd", deviceName);
				}
				String androidappURL = getClass().getResource(props.getProperty("andriodAppLocation")).getFile();
				System.out.println("appURL" + androidappURL);
				caps.setCapability("app", androidappURL);

				url = new URL(props.getProperty("appiumLocalURL"));

				driver = new AndroidDriver<MobileElement>(url, caps);

				break;

			case "iOS":

				caps.setCapability("automationName", props.getProperty("iOSAutomationName"));
				caps.setCapability("UDID", "E7727C06-44CB-459A-AE1F-C233B0FCD116");
				caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
//				caps.setCapability("startIWDP", true);
//				caps.setCapability("instrumentApp", true);
//				caps.setCapability("clearSystemFiles", true);

				String iOSappURL = getClass().getResource(props.getProperty("iOSdotAPPLocation")).getFile();
				System.out.println("appURL" + iOSappURL);
				caps.setCapability("app", iOSappURL);

				url = new URL(props.getProperty("appiumLocalURL"));

				driver = new IOSDriver<MobileElement>(url, caps);
				break;
			default:
				throw new Exception("Invalid platform!-" + platformName);
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

	}

	public void waitForVisibility(MobileElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void click(MobileElement element) {

		waitForVisibility(element);
		element.click();

	}

	public void sendkeys(MobileElement element, String Text) {

		waitForVisibility(element);
		element.sendKeys(Text);

	}

	public void clear(MobileElement element) {

		waitForVisibility(element);
		element.clear();

	}

	public String getAttribute(MobileElement element, String attribute) {

		waitForVisibility(element);
		return element.getAttribute(attribute);

	}

	@AfterTest
	public void afterTest() {

		driver.quit();

	}

}
