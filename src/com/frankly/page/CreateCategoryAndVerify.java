package com.frankly.page;

import java.io.IOException;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;

import com.frankly.keyword.Keywords;

public class CreateCategoryAndVerify extends Keywords {
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
	public void verifycategory(String Smash_a_Scene_Xpath,String Bring_It_On_Xpath,String Create_Category_Xpath,String Category_Title_ID,String Create_Category_Btn_ID,String Created_Category_Name_ID) throws InterruptedException{
		Thread.sleep(5000L);
		clickXPath(Smash_a_Scene_Xpath);
		if(elementisvisibleByXpath(Bring_It_On_Xpath)){
			clickXPath(Bring_It_On_Xpath);
			verifyCreatedcategory(Create_Category_Xpath,Category_Title_ID,Create_Category_Btn_ID,Created_Category_Name_ID);
		}
		else{
			verifyCreatedcategory(Create_Category_Xpath,Category_Title_ID,Create_Category_Btn_ID,Created_Category_Name_ID);
		}
	}
	public void verifyCreatedcategory(String Create_Category_Xpath,String Category_Title_ID,String Create_Category_Btn_ID,String Created_Category_Name_ID) throws InterruptedException{
		String Expected_Value = generaterendomNumber(10);
		
		timeOut();
		clickXPath(Create_Category_Xpath);
		timeOut();
		writeRendomvalueByID(Category_Title_ID,Expected_Value);
		timeOut();
		clickID(Create_Category_Btn_ID);
		timeOut();
		VerifyRandomHeadingID(Created_Category_Name_ID,Expected_Value);
	}
	
	public String generaterendomNumber(int number){
		String generatedString = RandomStringUtils.randomAlphabetic(number);
		return   generatedString;
    }
	
	public void vploadvideofromphone(String Smash_a_Scene_Xpath,
			String MyUpload_Folder_Xpath,
			String Upload_Btn_Xpath,
			String videoUploadPath){
		timeOut();
		clickXPath(Smash_a_Scene_Xpath);
		timeOut();
		clickXPath(MyUpload_Folder_Xpath);
		timeOut();
		uploadAVideoByXpath(Upload_Btn_Xpath,videoUploadPath);	
	}
	

}
