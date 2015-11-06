package com.frankly.test;

import java.io.IOException;

import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frankly.keyword.Keywords;
import com.frankly.page.Feed_Page;

public class VerifyFeedPage extends Keywords {
	Feed_Page feedpage = new Feed_Page();
	@BeforeClass
	public void startappiumserver() throws  IOException, InterruptedException
	{
		feedpage.appiumlaunch();
	}
	// Initialize the OR and Config property
	@Test(enabled = true, priority = 1)
	public void Logging_In() throws InterruptedException, IOException, JSONException{	
		System.out.println("Initinilization of driver and property file");
		feedpage.initilize();
	}
	@Test(enabled = true,priority = 2)
	public void signInandContinue() throws InterruptedException{
		feedpage.signIn("GetStarted_btn_ID","Login_Btn_Xpath","Email_Text_Field_Btn_ID","Login_Username","Login_Nxt_Btn_ID","Pass_Text_Field_Btn_ID","Login_Password");	
	}
	@Test(enabled = true,priority = 3)
	public void feedpage() throws InterruptedException{
		feedpage.VerifyFeedPageheadingandIcon("Feed_Btn_ID","Frankster_Of_Day_ID","Frankster_ofDay_Heading","Feed_Page_Play_Btn_ID","Frankster_of_Day_USer_Btn_ID","Frankster_Open_Page_UserNmae_ID","Frankster_Follower_ID");
	}
	/*@Test(enabled = true,priority = 4)
	public void validatescrolling(){
		System.out.println("executing the scrolling function");
		feedpage.scrollThePageAndValidate("Feed_Dub_This_Text");
	}*/
	@Test(enabled = true,priority = 4)
	public void clikcOnVideoAndVerify(){
		feedpage.verifyvideoPlaying("Feed_Video_ID",
				"Feed_VideoAfterPlaying_ID",
				"Feed_VideoPause_Icon_ID");
	}
	@AfterClass
	public void closingtheserver(){
		feedpage.closeappium();
	}
}
