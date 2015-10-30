package com.frankly.page;

import java.io.IOException;

import org.apache.commons.exec.ExecuteException;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;

import com.frankly.keyword.Keywords;

public class DiscoverPage extends Keywords{
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
	public void verifyDiscoverPage(String Discover_Btn_ID,
			String Discover_Featured_ID,
			String Discover_Featured_Text,
			String Discover_Trending_ID,
			String Discover_Trending_Text,
			String Discover_Search_logo_ID,
			String Discover_Smash_card_Xpath,
			String Smash_Page_Heading_Xpath,
			String Smash_follow_Btn_ID,
			String Smash_following_Btn_Xpath,
			String Smash_SmashThis_Btn_Xpath,
			String Smash_SmashThis_Btn_ID,
			String Smash_Recording_Btn_Xpath){
		timeOut();
		clickID(Discover_Btn_ID);
		timeOut();
		VerifytextByID(Discover_Featured_ID,Discover_Featured_Text);
	}
	public void verifySmashTrandingHeading(String Discover_Trending_ID,
				String Discover_Trending_Text){
		timeOut();
		VerifytextByID(Discover_Trending_ID, Discover_Trending_Text);
	}
	public void verifysearchlogo(String Discover_Search_logo_ID){
		timeOut();
		elementisvisibleByID(Discover_Search_logo_ID);
	}
	public void verifypageheading(String Smash_Page_Heading_Xpath,String Smash_Page_Heading ){
		VerifyPageHeadingbyXpath(Smash_Page_Heading_Xpath,Smash_Page_Heading);
	}
	public void navigateToSmashPage(String Discover_Smash_card_Xpath){
		timeOut();
		clickID(Discover_Smash_card_Xpath);
	}
	public void scrollandVerify(String Discover_Smash_card_Xpath,String Smash_SmashThis_Btn_Text,String Smash_SmashThis_Btn_Xpath){
		timeOut();
		clickXPath(Discover_Smash_card_Xpath);
		
		// Scrolling method is not functioning
		/*timeOut();
		System.out.println(OR.getProperty(Smash_SmashThis_Btn_Xpath));
		scrollthepagetoText(Smash_SmashThis_Btn_Text,Smash_SmashThis_Btn_Xpath);
		clickXPath(Smash_SmashThis_Btn_Xpath)*/;
	}
	public void verifyuserprofile(String Smash_UserName_ID,String Smash_UserName_PageHeading_Xpath,String Smash_Back_btn_Xpath){
		String Expected_Value=addGlobalVarintoArrayList(Smash_UserName_ID);
		timeOut();
		clickID(Smash_UserName_ID);
		timeOut();
		VerifyStoredGlobalVariableByID(Smash_UserName_PageHeading_Xpath,Expected_Value);
		clickXPath(Smash_Back_btn_Xpath);
	}
	public void verifyPopUp(String Smash_three_dots_Xpath,
			String Smash_three_dots_popup_Share_Xpath,
			String Smash_three_dots_popup_Share,
			String Smash_three_dots_popup_comment_Xpath,
			String Smash_three_dots_popup_comment,
			String Smash_three_dots_popup_Hide_Xpath,
			String Smash_three_dots_popup_Hide,
			String Smash_three_dots_popup_cancel_Xpath,
			String Smash_three_dots_popup_cancel){
		timeOut();
		clickXPath(Smash_three_dots_Xpath);
		timeOut();
		VerifyPageHeadingbyXpath(Smash_three_dots_popup_Share_Xpath,Smash_three_dots_popup_Share);
		timeOut();
		VerifyPageHeadingbyXpath(Smash_three_dots_popup_comment_Xpath,Smash_three_dots_popup_comment);
		timeOut();
		VerifyPageHeadingbyXpath(Smash_three_dots_popup_Hide_Xpath,Smash_three_dots_popup_Hide);
		timeOut();
		VerifyPageHeadingbyXpath(Smash_three_dots_popup_cancel_Xpath,Smash_three_dots_popup_cancel);
		timeOut();
		clickXPath(Smash_three_dots_popup_cancel_Xpath);
	}
	public void verifyAddedComment(String Smash_three_dots_Xpath,
			String Smash_three_dots_popup_comment_Xpath,
			String Smash_Comment_textfield_Xpath,
			String Smash_Comment_Submit_Btn_ID,
			String Smash_Commented_Time_Xpath,
			String Smash_Comment_Time,
			String Smash_Comment_Back_Btn_Xpath
			){
		timeOut();
		clickXPath(Smash_three_dots_Xpath);
		timeOut();
		clickXPath(Smash_three_dots_popup_comment_Xpath);
		timeOut();
		clickXPath(Smash_Comment_textfield_Xpath);
		timeOut();
		String Comment = generaterendomNumber(20);
		writeRendomvalueByXpath(Smash_Comment_textfield_Xpath,Comment);
		timeOut();
		clickID(Smash_Comment_Submit_Btn_ID);
		timeOut();
		verifytext(Smash_Commented_Time_Xpath,Smash_Comment_Time);
		timeOut();
		clickXPath(Smash_Comment_Back_Btn_Xpath);
		
	}
	public String generaterendomNumber(int number){
		String generatedString = RandomStringUtils.randomAlphabetic(number);
		return   generatedString;
    }
	
	public void verifyhidefunctionality(
			String Smash_firstUser_ID,
			String Smash_three_dots_Xpath,
			String Smash_three_dots_popup_Hide_Xpath
			) throws InterruptedException{
		timeOut();
		String Actual_User_Name =returntextByID(Smash_firstUser_ID);
		timeOut();
		Thread.sleep(5000L);
		clickXPath(Smash_three_dots_Xpath);
		timeOut();
		clickXPath(Smash_three_dots_popup_Hide_Xpath);
		timeOut();
		VerifyRandomHeadingNotVisibleByID(Smash_firstUser_ID,Actual_User_Name);
	}
	public void playandVerifyVideoFunc(
			String Smash_Video_Play_ID) throws InterruptedException{
		timeOut();
		timeOut();
		verifyElementNotDisplayedByID(Smash_Video_Play_ID);
	}
	
	

}
