package com.frankly.page;

import java.io.IOException;
import org.apache.commons.exec.ExecuteException;
import org.json.JSONException;

import com.frankly.keyword.Keywords;

public class MyAccount extends Keywords {
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
	public void clickOnMyAccountAndValidate(String My_Profile_ID,String My_profile_UserName_Xpath,
			String userNameOnAccountPage,
			String Three_Dots_ID,
			String Setting_Btn_ID,
			String Edit_Btn_ID,
			String Ask_Followers_Btn_ID,
			String Invite_Friend_Btn_ID
			
			){
		timeOut();
		clickID(My_Profile_ID);
		timeOut();
		verifytext(My_profile_UserName_Xpath,userNameOnAccountPage);
		timeOut();
		elementisvisibleByID(Three_Dots_ID);
		timeOut();
		elementisvisibleByID(Setting_Btn_ID);
		timeOut();
		elementisvisibleByID(Edit_Btn_ID);
		timeOut();
		elementisvisibleByID(Ask_Followers_Btn_ID);
		timeOut();
		elementisvisibleByID(Invite_Friend_Btn_ID);
	}
	public void VerifyLogOutFun(String Setting_Btn_ID,
			String Account_Tab_Xpath,
			String LogOut_Tab_Xpath,
			String Alert_PopUp_Btn_ID,
			String Login_Btn_Xpath,
			String bottom
			){
		timeOut();
		clickID(Setting_Btn_ID);
		timeOut();
		clickXPath(Account_Tab_Xpath);
		timeOut();
		scrolltobottom(bottom);
		timeOut();
		clickXPath(LogOut_Tab_Xpath);
		timeOut();
		clickID(Alert_PopUp_Btn_ID);
		timeOut();
		elementisvisibleByXpath(Login_Btn_Xpath);	
	}
	
}
