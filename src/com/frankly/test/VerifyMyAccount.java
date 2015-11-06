package com.frankly.test;

import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.frankly.page.MyAccount;

public class VerifyMyAccount {
	MyAccount myaccount = new MyAccount();
	@BeforeClass
	public void startappiumserver() throws  IOException, InterruptedException
	{
		myaccount.appiumlaunch();
	}
	// Initialize the OR and Config property
	@Test(enabled = true, priority = 1)
	public void Logging_In() throws InterruptedException, IOException, JSONException{	
		System.out.println("Initinilization of driver and property file");
		myaccount.initilize();
	}
/*	// Varify main Screen and navigate to login page 
	@Test(enabled = true, priority = 2)
	public void VerifyMainScreen(){
		myaccount.MainScreen("SkipBtnID",
				"MainScreenHeading_ID",
				"PauseIcon_ID",
				"SmashA_Scene_Btn_ID",
				"HaveA_Account_ID"
				);
	}*/
	
	@Test(enabled = true,priority = 2)
	public void signInandContinue() throws InterruptedException{
		myaccount.signIn(
				"GetStarted_btn_ID",
				"Login_Btn_Xpath",
				"Email_Text_Field_Btn_ID",
				"Login_Username",
				"Login_Nxt_Btn_ID",
				"videoIcon_ID",
				"Pass_Text_Field_Btn_ID",
				"Login_Password");	
	}
	@Test(enabled = true,priority = 3)
	public void NavigateToMyAccount(){
		myaccount.clickOnMyAccountAndValidate("My_Profile_ID",
				"My_profile_UserName_Xpath",
				"userNameOnAccountPage",
				"Three_Dots_ID",
				"Setting_Btn_ID",
				"Edit_Btn_ID",
				"Ask_Followers_Btn_ID",
				"Invite_Friend_Btn_ID");
	}
	@Test(enabled = true,priority = 4)
	public void logoutFunctionality(){
		myaccount.VerifyLogOutFun("Setting_Btn_ID",
				"Account_Tab_Xpath",
				"LogOut_Tab_Xpath",
				"Alert_PopUp_Btn_ID",
				"bottom",
				"HaveA_Account_ID"
				);
	}
	@AfterClass
	public void closingtheserver(){
		myaccount.closeappium();
	}
}
