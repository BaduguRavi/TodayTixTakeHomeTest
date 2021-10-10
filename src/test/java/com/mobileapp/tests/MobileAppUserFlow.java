package com.mobileapp.tests;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.mobileAppPages.MobileAppPageLocators;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class MobileAppUserFlow extends BaseTest{
	
	MobileAppPageLocators mobileapppagelocators;
 
  
  @BeforeClass
  public void beforeClass() {
	  
  }

  @AfterClass
  public void afterClass() {
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  mobileapppagelocators = new MobileAppPageLocators();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  
	  
  }

  
  @Test
	public void MobileUserFlowWithSigningIn() {
		
		mobileapppagelocators.ClickNext();
//		mobileapppagelocators.ClickSelectManually();
//		mobileapppagelocators.SelectLocation();
//		mobileapppagelocators.ClickLogin();
//		mobileapppagelocators.EnterEmail("ravibadugu@outlook.com");
//		mobileapppagelocators.EnterPassword("Lakshmi9298");
//		mobileapppagelocators.ClickLoginButton();
		
	}
	
	@Test
	public void MobileUserFlowTestWithoutSigningIn() {
		
		
	
//		mobileapppagelocators.ClickNext();
//		mobileapppagelocators.ClickSelectManually();
//		mobileapppagelocators.SelectLocation();
//		mobileapppagelocators.ClickContinueWithOutSignUp();
		
	}

}
