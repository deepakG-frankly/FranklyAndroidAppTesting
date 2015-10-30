package com.frankly.page;

import java.io.IOException;
import org.apache.commons.exec.ExecuteException;
import org.json.JSONException;
import org.junit.Assert;

import com.frankly.keyword.Constants;
import com.frankly.keyword.Keywords;

public class Feed_Page extends Keywords {
	Keywords keyword = new Keywords();
	public void appiumlaunch() throws ExecuteException, IOException, InterruptedException{
		launchappium();
	}
	public void closeappium(){
		quitDriver();
	}
	public void initilize() throws IOException, JSONException{
		InitializePropertiesFile();
	}
	public void signIn(String GetStarted_btn_ID,String Login_Btn_Xpath,String Email_Text_Field_Btn_ID,String Login_Username,String Login_Nxt_Btn_ID,String Pass_Text_Field_Btn_ID,String Login_Password) throws InterruptedException{
		timeOut();
		clickID(GetStarted_btn_ID);
		timeOut();
		clickXPath(Login_Btn_Xpath);
		timeOut();
		writeTextByID(Email_Text_Field_Btn_ID,Login_Username);
		timeOut();
		clickID(Login_Nxt_Btn_ID);
		timeOut();
		writeTextByID(Pass_Text_Field_Btn_ID,Login_Password);
		timeOut();
		clickID(Login_Nxt_Btn_ID);
	}
	public void VerifyFeedPageheadingandIcon(String Feed_Btn_ID,String Frankster_Of_Day_ID,String Frankster_ofDay_Heading,String Feed_Page_Play_Btn_ID,String Frankster_of_Day_USer_Btn_ID,String Frankster_Open_Page_UserNmae_ID,String Frankster_Follower_ID) throws InterruptedException{
		timeOut();
		clickID(Feed_Btn_ID);
		timeOut();
		VerifyPageHeading(Frankster_Of_Day_ID,Frankster_ofDay_Heading);
		timeOut();
		clickID(Feed_Page_Play_Btn_ID);
		timeOut();
		verifyElementNotDisplayedByID(Feed_Page_Play_Btn_ID);
		timeOut();
		String Expected_Value = addGlobalVarintoArrayList(Frankster_of_Day_USer_Btn_ID);
		timeOut();
		clickID(Frankster_of_Day_USer_Btn_ID);
		timeOut();
		VerifyStoredGlobalVariableByID(Frankster_Open_Page_UserNmae_ID,Expected_Value);
		timeOut();
		NaviagtetoBack();
		timeOut();
		clickID(Frankster_Follower_ID);
		NaviagtetoBack();
		Thread.sleep(5000L);
	}
	public void verifyvideoPlaying(String Feed_Video_ID,
			String Feed_VideoAfterPlaying_ID,
			String Feed_VideoPause_Icon_ID
			){
		for(int i=0;i<=Constants.videoplaytimes;i++)
		{
			clickID(Feed_Video_ID);
			clickID(Feed_VideoAfterPlaying_ID);
			Assert.assertTrue(visibleElementByID(Feed_VideoPause_Icon_ID));
	}
		
	}
	// Scrolling functionality is not working
	public void scrollThePageAndValidate(String Feed_Dub_This_Text){
		System.out.println("scroll to the page");
		scrollthepagetoText(Feed_Dub_This_Text);
		
	}
	
}
