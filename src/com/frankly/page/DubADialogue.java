package com.frankly.page;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.json.JSONException;
import org.testng.Assert;

import com.frankly.keyword.Keywords;

public class DubADialogue extends Keywords {
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
	public void signIn(String Email_Text_Field_Btn_ID,String Login_Username,String Login_Nxt_Btn_ID,String Pass_Text_Field_Btn_ID,String Login_Password) throws InterruptedException{
		writeTextByID(Email_Text_Field_Btn_ID,Login_Username);
		timeOut();
		clickID(Login_Nxt_Btn_ID);
		timeOut();
		writeTextByID(Pass_Text_Field_Btn_ID,Login_Password);
		timeOut();
		clickID(Login_Nxt_Btn_ID);
	}
	public void ClickOnDubADialogue(String DubA_Dialogue_xpath,
			String DubA_Dialogue_PageHeading_Xpath,
			String Poltics_Dub_Xpath,
			String Poltics_firstSong_dub_ID,
			String DubRecordingBtn_Screen_Xpath,
			String DubNxt_Btn_ID,
			String video_heading,
			String DubDone_Btn_ID,
			String Add_Title_ID,
			String Upload_video_Btn_ID) throws InterruptedException
	{
		timeOut();
		clickXPath(DubA_Dialogue_xpath);
		timeOut();
		elementisvisibleByXpath(DubA_Dialogue_PageHeading_Xpath);
		timeOut();
		clickXPath(Poltics_Dub_Xpath);
		timeOut();
		clickID(Poltics_firstSong_dub_ID);
		timeOut();
		clickXPath(DubRecordingBtn_Screen_Xpath);
		Thread.sleep(5000L);
		clickXPath(DubRecordingBtn_Screen_Xpath);
		timeOut();
		clickID(DubNxt_Btn_ID);
		timeOut();
		clickID(DubDone_Btn_ID);
		timeOut();
		writeTextByID(Add_Title_ID,video_heading);
		timeOut();
		clickID(Upload_video_Btn_ID);	
	}
	// Navigate to My account page and validate to uploaded video
		public void verifyuploadedvideo(String Account_Btn_ID,String Uploaded_Video_section_ID,String Video_Heading_ID,String video_heading) throws InterruptedException{
			timeOut();
			clickID(Account_Btn_ID);
			timeOut();
			VerifytextByID(Video_Heading_ID,video_heading);
		}
	public void MainScreen(String SkipBtnID,
			String MainScreenHeading_ID,
			String PauseIcon_ID,
			String SmashA_Scene_Btn_ID,
			String HaveA_Account_ID){
		timeOut();
		Assert.assertTrue(visibleElementByID(SkipBtnID));
		timeOut();
		Assert.assertTrue(visibleElementByID(MainScreenHeading_ID));
		timeOut();
		Assert.assertTrue(visibleElementByID(SmashA_Scene_Btn_ID));
		timeOut();
		Assert.assertTrue(visibleElementByID(HaveA_Account_ID));
		timeOut();
		clickID(HaveA_Account_ID);
	}
}
