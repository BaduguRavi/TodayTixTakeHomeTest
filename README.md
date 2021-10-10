#What you can find this solution

Framework design Page Object Model
Framework used TestNG

Folder structure
 . Under src/main/java
    . com.base package is created in this package BaseTest.java class created where mobile app capabilities set to work across the platform based on the parameters set in testng.xml file
    . com.mobileAppPages is created in this package MobileAppPageLocators.java class created where all the page elements/locators and respective methods been added.
    . com.utils package is created in this TestUtils.java class created where all the utils required should be placed.
    . com.webAPICalls package is created in this package EncoreTicketsAPICalls.java class is created where all the required methods been added to call the APIs to get responses.
    . com.webAppPages package is created in this package EncoreTicketsWebAppPageLocators.java class is created where all the web app page locators been stored.
    
 . Under src/main/resources
    . config.properties file is created where all the required data of the application is stored and calling these in the basetest.java
    
 . Under src/test/java
    . com.mobileapp.tests pacakge is created in this MobileAppUserFlow.java class is created where there is two tests added one user with signup and one wothout.
    . com.webAPI.tests package is created in this APICallResponseTest.java class is created where there are 3 tests as APICall1, APICall2basedonAPICall1, APICall3 where to get the responses from these calls and printing them on console.
    . com.webApp.Tests package is created in this WebAppUserJourney.java class is created where there is one test EncoreTicketsUserCheckoutJourney.
    
 . Under src/test/resources 
    .Apps Folder is created in this all the .app / .ipa and .apk and chrome driver.exe files stored.
    
 . Frameworksetup.md where you will find how to setup this framework in detail.
 . pom.xml where all the dependencies used for this framework
 . testng.xml where you can change the device/platform parameters to run your tests based on your requirements.
 
 

