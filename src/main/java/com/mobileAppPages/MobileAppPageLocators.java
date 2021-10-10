package com.mobileAppPages;

import org.openqa.selenium.support.PageFactory;
import com.base.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MobileAppPageLocators extends BaseTest {

	public MobileAppPageLocators() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/title")
	@iOSFindBy(id = "Get tickets at a price you’ll brag about.")
	public MobileElement VerifyGetticketsatapriceyoullbragaboutText;

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/next_button")
	@iOSFindBy(id = "Slides.NextButton")
	public MobileElement NextButton;

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/primary_button_1")
	@iOSFindBy(id = "//XCUIElementTypeButton[@name=\"Enable location now\"]")
	public MobileElement EnableLocationButton;

	@AndroidFindBy(accessibility = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	@iOSFindBy(id = "Allow While Using App")
	public MobileElement AllowWhileUsingAppButton;

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/secondary_button")
	@iOSFindBy(accessibility = "Continue without signing up")
	public MobileElement ContinuewithoutsigningupButton;

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/primary_button_1")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Log In\"]")
	public MobileElement LogInButton;

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/primary_button_2")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"OnboardingSlide.Multibutton2\"]")
	public MobileElement SignUpButton;

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/update")
	@iOSFindBy(accessibility = "")
	public MobileElement AppUpdateNowButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[2]/android.view.View[6]/android.widget.Button")
	@iOSFindBy(xpath = "")
	public MobileElement PlayStoreInstallButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.app.Dialog/android.view.View[2]/android.widget.Button[2]")
	@iOSFindBy(accessibility = "")
	public MobileElement PlayStoreSignInButton;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"OPEN IN PLAY STORE APP\"]/android.widget.TextView")
	@iOSFindBy(accessibility = "")
	public MobileElement OpenInPlayStoreAppButton;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(accessibility = "Not now")
	public MobileElement AppUpdateMessageNotNowButton;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Search Shows\"]")
	public MobileElement SearchIcon;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"TodayTix-QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSearchField")
	public MobileElement SearchField;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "(//XCUIElementTypeCell[@name=\"Show\"])[2]")
	public MobileElement MamaMiashow;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next month\"]")
	public MobileElement NextMonthArrow;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeCell[@name=\"CalendarView.DayCell.2021-10-06\"]")
	public MobileElement SelectCalenderDate;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"TodayTix-QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther")
	public MobileElement SelectTime;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get tickets\"]")
	public MobileElement GetTicketsButton;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"nav black back arrow\"]")
	public MobileElement NavigationBackArrow;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.LinearLayout")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"TodayTix-QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
	public MobileElement FirstNameTextField;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.LinearLayout")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"TodayTix-QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
	public MobileElement LastNameTextField;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.LinearLayout")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"TodayTix-QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
	public MobileElement EmailTextField;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.LinearLayout")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"TodayTix-QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
	public MobileElement ConfirmEmailTextField;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.LinearLayout")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"TodayTix-QA\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
	public MobileElement CreatePasswordTextField;

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/secondary_button")
	@iOSFindBy(id = "Select manually")
	public MobileElement SelectmanuallyButton;

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/title")
	@iOSFindBy(id = "")
	public MobileElement SelectLocationTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView")
	@iOSFindBy(id = "London")
	public MobileElement SelectLocationLondon;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\\\"TodayTix-QA\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
	public MobileElement EnterEmailTextField;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\\\"TodayTix-QA\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
	public MobileElement EnterPasswordTextField;

	@AndroidFindBy(accessibility = "com.todaytix.TodayTix:id/action_button")
	@iOSFindBy(id = "Login.LoginButton")
	public MobileElement LoginButtonInLoginScreen;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\\\"Continue to checkout\\\"]")
	public MobileElement ContinuetocheckoutButton;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\\\"Continue to payment\\\"]")
	public MobileElement ContinuetopaymentButton;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\\\"+353\\\"]")
	public MobileElement MobileCountryCode;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(accessibility = "Done")
	public MobileElement DoneButton;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\\\"TodayTix-QA\\\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
	public MobileElement MobileNumberTextField;

	@AndroidFindBy(accessibility = "")
	@iOSFindBy(accessibility = "We will only contact you if we need to speak to you about your order.")
	public MobileElement OrderConfirmationTextPermission;

	@AndroidFindBy(accessibility = "com.android.permissioncontroller:id/permission_allow_one_time_button")
	public MobileElement AllowAppPermissionOnce;

	@AndroidFindBy(accessibility = "com.android.permissioncontroller:id/permission_deny_button")
	public MobileElement DenyAppPermissionWindow;

	public MobileAppPageLocators ClickNext() {

		click(NextButton);
		click(NextButton);
		click(NextButton);

		return this;

	}

	public MobileAppPageLocators ClickEnableLocationButton() {

		click(EnableLocationButton);
		return this;

	}

	public MobileAppPageLocators ClickAllowLocationPermission() {

		click(AllowWhileUsingAppButton);
		return this;

	}

	public MobileAppPageLocators ClickAllowLocationPermissionOnce() {

		click(AllowAppPermissionOnce);
		return this;

	}

	public MobileAppPageLocators ClickDenyLocationPermission() {

		click(DenyAppPermissionWindow);
		return this;

	}

	public MobileAppPageLocators ClickSelectManually() {

		click(SelectmanuallyButton);
		return this;

	}

	public MobileAppPageLocators SelectLocation() {

		click(SelectLocationLondon);
		return this;

	}

	public MobileAppPageLocators ClickLogin() {

		click(LogInButton);
		return this;

	}

	public MobileAppPageLocators ClickSignUp() {

		click(SignUpButton);
		return this;

	}

	public MobileAppPageLocators ClickContinueWithOutSignUp() {

		click(ContinuewithoutsigningupButton);
		return this;

	}

	public MobileAppPageLocators EnterEmail(String email) {

		clear(EnterEmailTextField);
		sendkeys(EnterEmailTextField, email);
		return this;

	}

	public MobileAppPageLocators EnterPassword(String password) {

		clear(EnterPasswordTextField);
		sendkeys(EnterPasswordTextField, password);
		return this;

	}

	public MobileAppPageLocators ClickLoginButton() {

		click(LoginButtonInLoginScreen);
		return this;

	}

}
