#### Mobile Application Automation Framework Setup

##Getting Started:

Follow the step by step process to get started

##Software Required:

	•	Eclipse IDE
	•	Java
	•	Maven
	•	TestNG
	•	Appium Java-Client
	•	Selenium-Java

##Framework Setup:

	1.	Create a new maven project in eclipse
	2.	Add the TestNG, Appium java-client, Selenium-java libraries.
	3.	Created a folder called apps in src/main/resources where i kept chromedriver.exe and .app, .ipa and .apk files.
	3. 	Created four different packages in src/main/java within them created classes where i kept all the pageobjects and methods inside.
	4.  Created four different packages in src/test/java within them created classes where i kept all the tests to execute.

##Test Execution:

	1.	If you want to run test individually then go to the test classes and run as TestNG Tests
	2. 	If you want to execute the tests as a whole then go to TestNG.XML and run as TestNG Suite
	3. 	For test execution either iOS Real Device/Simulator or Android Real Device/Emulator just need to change the platform name, platform version and device name in parameters
		<test name="AndroidTest">
  		<parameter name="emulator" value="true"/>
  		<parameter name="platformName" value="Android"/>
  		<parameter name="deviceName" value="Nexus_6P_Edited_API_30"/>
  		<parameter name="platformVersion" value="11.0"/>
    	<classes>
      	<class name="com.mobileapp.tests.MobileAppUserFlow"/>
    	</classes>
  		</test> <!-- UserFlowsTest -->
  	4.  For Android UDID of a device is not mandatory but for iOS it is so need to change the UDID in the BaseTest.java class only.

##Test Reports:

	1.	Under Test-Output folder you will find the reports.


	
