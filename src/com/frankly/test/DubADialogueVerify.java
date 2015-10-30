package com.frankly.test;

import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frankly.page.DubADialogue;

public class DubADialogueVerify {
	DubADialogue dubAdialogue = new DubADialogue();
	/**
	 * @description- Launch the application in device
	 */
	@BeforeClass
	public void startappiumserver() throws  IOException, InterruptedException
	{
		dubAdialogue.appiumlaunch();
	}
	/**
	 * @description- Initialize OR and config property file
	 */
	@Test(enabled = true, priority = 1)
	public void Logging_In() throws InterruptedException, IOException, JSONException{	
		System.out.println("Initinilization of driver and property file");
		dubAdialogue.initilize();
	}
	/**
	 * @description- Sign In to the application using existence user name and password
	 */
	@Test(enabled = true,priority = 2)
	public void signInandContinue() throws InterruptedException{
		dubAdialogue.signIn("GetStarted_btn_ID","Login_Btn_Xpath","Email_Text_Field_Btn_ID","Login_Username","Login_Nxt_Btn_ID","Pass_Text_Field_Btn_ID","Login_Password");	
	}
	@Test(enabled = true,priority = 3)
	public void DubADialogue() throws InterruptedException{
		dubAdialogue.ClickOnDubADialogue("DubA_Dialogue_xpath","DubA_Dialogue_PageHeading_Xpath","DubA_Dialogue_upload_Btn_xpath","DubA_Dialogue_MyUpload_Xpath","DubA_Dialogue_ScrollTo_Text","DubA_Dialogue_NarendraModi_Xpath");
	}
	/**
	 * @description- Quit the driver
	 */
	@AfterClass
	public void closingtheserver(){
		dubAdialogue.closeappium();
	}
}
