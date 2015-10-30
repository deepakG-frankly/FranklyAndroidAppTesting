package com.frankly.page;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.json.JSONException;

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
	public void signIn(String GetStarted_btn_ID,String Login_Btn_Xpath,String Email_Text_Field_Btn_ID,String Login_Username,String Login_Nxt_Btn_ID,String Pass_Text_Field_Btn_ID,String Login_Password) throws InterruptedException{
		timeOut();
		clickID(GetStarted_btn_ID);
		timeOut();
		clickXPath(Login_Btn_Xpath);
		writeTextByID(Email_Text_Field_Btn_ID,Login_Username);
		timeOut();
		clickID(Login_Nxt_Btn_ID);
		timeOut();
		writeTextByID(Pass_Text_Field_Btn_ID,Login_Password);
		timeOut();
		clickID(Login_Nxt_Btn_ID);
	}
	public void ClickOnDubADialogue(String DubA_Dialogue_xpath,String DubA_Dialogue_PageHeading_Xpath,String DubA_Dialogue_upload_Btn_xpath,String DubA_Dialogue_MyUpload_Xpath,String DubA_Dialogue_ScrollTo_Text,String DubA_Dialogue_NarendraModi_Xpath) throws InterruptedException
	{
		timeOut();
		clickXPath(DubA_Dialogue_xpath);
		timeOut();
		elementisvisibleByXpath(DubA_Dialogue_PageHeading_Xpath);
		timeOut();
		elementisvisibleByXpath(DubA_Dialogue_upload_Btn_xpath);
		timeOut();
		elementisvisibleByXpath(DubA_Dialogue_MyUpload_Xpath);
		timeOut();
//		scrollthepagetoText(DubA_Dialogue_ScrollTo_Text);
		timeOut();
		clickXPath(DubA_Dialogue_NarendraModi_Xpath);
	}
}
