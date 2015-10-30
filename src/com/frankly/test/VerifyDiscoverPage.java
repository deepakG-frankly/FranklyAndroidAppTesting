package com.frankly.test;

import java.io.IOException;


import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frankly.keyword.Keywords;
import com.frankly.page.DiscoverPage;

public class VerifyDiscoverPage extends Keywords{
	DiscoverPage verifypage = new DiscoverPage();
	/**
	 * @description- Launch the application in device
	 */
	@BeforeClass
	public void startappiumserver() throws  IOException, InterruptedException
	{
		verifypage.appiumlaunch();
	}
	/**
	 * @description- Initialize the OR and Config property
	 */
	@Test(enabled = true, priority = 1)
	public void Logging_In() throws InterruptedException, IOException, JSONException{	
		System.out.println("Initinilization of driver and property file");
		verifypage.initilize();
	}
	/**
	 * @description- Login with existing user name and password
	 */
	@Test(enabled = true,priority = 2)
	public void signInandContinue() throws InterruptedException{
		verifypage.signIn("GetStarted_btn_ID","Login_Btn_Xpath","Email_Text_Field_Btn_ID","Login_Username","Login_Nxt_Btn_ID","Pass_Text_Field_Btn_ID","Login_Password");
	}
	/**
	 * @description- Verify existing element
	 */
	@Test(enabled = true,priority = 3)
	public void verifyDiscoverpage(){
		verifypage.verifyDiscoverPage("Discover_Btn_ID",
				"Discover_Featured_ID",
				"Discover_Featured_Text",
				"Discover_Trending_ID",
				"Discover_Trending_Text",
				"Discover_Search_logo_ID",
				"Discover_Smash_card_Xpath",
				"Smash_Page_Heading_Xpath",
				"Smash_follow_Btn_ID",
				"Smash_following_Btn_Xpath",
				"Smash_SmashThis_Btn_Xpath",
				"Smash_SmashThis_Btn_ID",
				"Smash_Recording_Btn_Xpath");
	}
	/**
	 * @description- Verify page heading
	 */
	@Test(enabled =true,priority = 4)
	public void verifyTrandingheading(){
		verifypage.verifySmashTrandingHeading("Discover_Trending_ID", "Discover_Trending_Text");
	}
	/**
	 * @description- Verify search logo
	 */
	@Test(enabled = true,priority = 5)
	public void verifySearchlogo(){
		verifypage.verifysearchlogo("Discover_Search_logo_ID");
	}
	/**
	 * @description- Click on Smash page and verify heading
	 */
	@Test(enabled = true,priority = 6)
	public void verifySmashPageHeading(){
		verifypage.verifypageheading("Smash_Page_Heading_Xpath","Smash_Page_Heading");
	}
	
	@Test(enabled = true,priority = 7)
	public void scrollandClickOnSmash(){
		verifypage.scrollandVerify("Discover_Smash_card_Xpath","Smash_SmashThis_Btn_Text","Smash_SmashThis_Btn_Xpath");
	}
	/**
	 * @description- verify smash page heading and smash page element
	 */
	@Test(enabled = true,priority = 8)
	public void SmashUserProfile(){
		verifypage.verifyuserprofile("Smash_UserName_ID","Smash_UserName_PageHeading_Xpath","Smash_Back_btn_Xpath");
	}
	/**
	 * @description- verify dots option
	 */
	@Test(enabled = true,priority = 9)
	public void verifydotsOptions(){
		verifypage.verifyPopUp("Smash_three_dots_Xpath",
				"Smash_three_dots_popup_Share_Xpath",
				"Smash_three_dots_popup_Share",
				"Smash_three_dots_popup_comment_Xpath",
				"Smash_three_dots_popup_comment",
				"Smash_three_dots_popup_Hide_Xpath",
				"Smash_three_dots_popup_Hide",
				"Smash_three_dots_popup_cancel_Xpath",
				"Smash_three_dots_popup_cancel");
	}
	/**
	 * @description- verify hide functionality
	 */
	@Test(enabled = true,priority = 10)
	public void verifyhideFunctionality() throws InterruptedException{
		System.out.println("execute hide functionality");
		verifypage.verifyhidefunctionality("Smash_firstUser_ID",
				"Smash_three_dots_Xpath",
				 "Smash_three_dots_popup_Hide_Xpath");
	}
	@Test(enabled = true,priority =11)
	public void SmashCommentVerification(){
		verifypage.verifyAddedComment("Smash_three_dots_Xpath",
				"Smash_three_dots_popup_comment_Xpath",
				"Smash_Comment_textfield_Xpath",
				"Smash_Comment_Submit_Btn_ID",
				"Smash_Commented_Time_Xpath",
				"Smash_Comment_Time",
				"Smash_Comment_Back_Btn_Xpath"
				);
		
	}
	/**
	 * @description- verify video is playing
	 */
	@Test(enabled = true,priority = 12)
	public void verifyPlayVideoFunctionality() throws InterruptedException{
		verifypage.playandVerifyVideoFunc("Smash_Video_Play_ID");
	}
	/**
	 * @description- Quit driver
	 */
	@AfterClass
	public void closingtheserver(){
		verifypage.closeappium();
	}
}
