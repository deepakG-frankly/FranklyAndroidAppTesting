package com.frankly.test;

import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frankly.keyword.Keywords;
import com.frankly.page.DubADialogue;

public class DubADialogueVerify extends Keywords {
	DubADialogue dubAdialogue = new DubADialogue();
	/**
	 * @description- Launch the application in device
	 */
	@BeforeClass
	public void startappiumserver() throws  IOException, InterruptedException
	{
		APP_LOGS.info("launching the application in device");
		dubAdialogue.appiumlaunch();
	}
	/**
	 * @description- Initialize OR and config property file
	 */
	@Test(enabled = true, priority = 1)
	public void Logging_In() throws InterruptedException, IOException, JSONException{	
		APP_LOGS.info("initilizing the config and OR property file");
		dubAdialogue.initilize();
	}
	/**
	 * @description- Verify main screen and go to login page
	 */
	@Test(enabled = true, priority = 2)
	public void VerifyMainScreen(){
		APP_LOGS.info("Add onboarding process for login methods");
		dubAdialogue.MainScreen("SkipBtnID",
				"MainScreenHeading_ID",
				"PauseIcon_ID",
				"SmashA_Scene_Btn_ID",
				"HaveA_Account_ID"
				);
	}
	/**
	 * @description- Sign In to the application using existence user name and password
	 */
	@Test(enabled = true,priority = 3)
	public void signInandContinue() throws InterruptedException{
		APP_LOGS.info("Do login with existing user name and password");
		dubAdialogue.signIn("Email_Text_Field_Btn_ID",
				"Login_Username",
				"Login_Nxt_Btn_ID",
				"Pass_Text_Field_Btn_ID",
				"Login_Password");	
	}
	@Test(enabled = true,priority = 4)
	public void DubADialogue() throws InterruptedException{
		APP_LOGS.info("Dub a dialog and verify it on my account page");
		dubAdialogue.ClickOnDubADialogue("DubA_Dialogue_xpath",
				"DubA_Dialogue_PageHeading_Xpath",
				"Poltics_Dub_Xpath",
				"Poltics_firstSong_dub_ID",
				"DubRecordingBtn_Screen_Xpath",
				"DubNxt_Btn_ID",
				"video_heading",
				"DubDone_Btn_ID",
				"Add_Title_ID",
				"Upload_video_Btn_ID");
		dubAdialogue.verifyuploadedvideo("Account_Btn_ID",
				"Uploaded_Video_section_ID",
				"Video_Heading_ID",
				"video_heading");
	}
	/**
	 * @description- Quit the driver
	 */
	@AfterClass
	public void closingtheserver(){
		dubAdialogue.closeappium();
	}
}
