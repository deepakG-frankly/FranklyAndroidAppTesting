package com.frankly.page;
import java.io.IOException;
import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.Logger;
import org.json.JSONException;

import com.frankly.keyword.Keywords;



public class recordAVlog extends Keywords {
	
	
	Keywords keyword = new Keywords();
	public void appiumlaunch() throws ExecuteException, IOException, InterruptedException{
		APP_LOGS.info("Launch the App in device");
		launchappium();
	}
	public void closeappium(){
		APP_LOGS.info("Quiting the driver and stopping the server");
		quitDriver();
	}
	public void initilize() throws IOException, JSONException{
		InitializePropertiesFile();
	}
	
	/*// Click on getstarted button
	public void SignInandNavigateHomeScreen(String btnID,String UserName_ID,String userName,String NxtBtn,String PageHeadingID,String actual_text,String SkipBtn,String RecordA_Vlog_Xpath) throws InterruptedException{
		timeOut();
		elementisvisibleByID(btnID);
		timeOut();
		clickID(btnID);
		timeOut();
		writeTextByID(UserName_ID,userName);
		clickID(NxtBtn);
		VerifyPageHeading(PageHeadingID,actual_text);
		timeOut();
		clickID(SkipBtn);
	}*/
	public void signIn(String GetStarted_btn_ID,
			String Login_Btn_Xpath,
			String Email_Text_Field_Btn_ID,
			String Login_Username,
			String Login_Nxt_Btn_ID,
			String Pass_Text_Field_Btn_ID,
			String Login_Password) throws InterruptedException{
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
	public void navigateToHomeScreen(String RecordA_Vlog_Xpath) throws InterruptedException{
		timeOut();
		clickXPath(RecordA_Vlog_Xpath);
	}
	public void clickOnRecordingBtn(String Recording_Btn_Xpath) throws InterruptedException{
		timeOut();
		clickXPath(Recording_Btn_Xpath);
		Thread.sleep(15000L);
	}
	// Click on recording button and upload in respective account
	public void uploadvideo(String Recording_Btn_Xpath,String Recording_Next_Btn_Xpath,String Recording_cancle_Btn_ID,String Recording_Filter_Nxt_Btn_ID,String Add_Title_ID,String video_heading,String Upload_video_Btn_ID) throws InterruptedException{
		timeOut();
		clickXPath(Recording_Btn_Xpath);
		timeOut();
		elementisvisibleByID(Recording_cancle_Btn_ID);
		timeOut();
		clickXPath(Recording_Next_Btn_Xpath);
		timeOut();
		clickID(Recording_Filter_Nxt_Btn_ID);
		timeOut();
		writeTextByID(Add_Title_ID,video_heading);
		timeOut();
		clickID(Recording_Filter_Nxt_Btn_ID);
		timeOut();
		clickID(Upload_video_Btn_ID);
	}
	// Navigate to My account page and validate to uploaded video
	public void verifyuploadedvideo(String Account_Btn_ID,String Uploaded_Video_section_ID,String Video_Heading_ID,String video_heading) throws InterruptedException{
		timeOut();
		clickID(Account_Btn_ID);
		timeOut();
		Thread.sleep(10000L);
		VerifytextByID(Video_Heading_ID,video_heading);
	}
	public void navigateToMainScreen(String videoIcon_ID){
		timeOut();
		clickID(videoIcon_ID);
	}
	
	}



