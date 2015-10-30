package com.frankly.test;

import java.io.IOException;
import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.frankly.page.CreateCategoryAndVerify;

public class VerifyCreatedCategory {
	CreateCategoryAndVerify verifycreatedcategory = new CreateCategoryAndVerify();
	/**
	 * @description- Launch the application in device
	 */
	@BeforeClass
	public void startappiumserver() throws  IOException, InterruptedException
	{
		verifycreatedcategory.appiumlaunch();
	}
	/**
	 * @description- Initialize config and OR property file
	 */
	@Test(enabled = true, priority = 1)
	public void Logging_In() throws InterruptedException, IOException, JSONException{	
		System.out.println("Initinilization of driver and property file");
		verifycreatedcategory.initilize();
	}
	/**
	 * @description- Login with existing username and password
	 */
	@Test(enabled = true,priority = 2)
	public void signInandContinue() throws InterruptedException{
		verifycreatedcategory.signIn("GetStarted_btn_ID","Login_Btn_Xpath","Email_Text_Field_Btn_ID","Login_Username","Login_Nxt_Btn_ID","Pass_Text_Field_Btn_ID","Login_Password");
		
	}
	/**
	 * @description- Create a category and verify
	 */
	@Test(enabled = true,priority = 3)
	public void verifycategory() throws InterruptedException{
		verifycreatedcategory.verifycategory("Smash_a_Scene_Xpath","Bring_It_On_Xpath","Create_Category_Xpath","Category_Title_ID","Create_Category_Btn_ID","Created_Category_Name_ID");	
	}
	
	/**
	 * @description- upload a video from phone memory
	 *//*
	@Test(enabled = true,priority = 4)
	public void uploadvideo(){
		verifycreatedcategory.vploadvideofromphone("Smash_a_Scene_Xpath",
				"MyUpload_Folder_Xpath",
				"Upload_Btn_Xpath",
				"videoUploadPath");
	}*/
	/**
	 * @description- quit driver
	 */
	@AfterClass
	public void closingtheserver(){
		verifycreatedcategory.closeappium();
	}
}
