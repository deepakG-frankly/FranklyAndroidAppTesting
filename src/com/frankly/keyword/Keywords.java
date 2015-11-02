
package com.frankly.keyword;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
public class Keywords {
	private static final String PASS = "pass";
	public String Expected_Value = null;
	public String Actual_Value = null;
	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static SoftAssert softAssert=new SoftAssert();
	private AndroidDriver driver;
	public static String appLocation = "C:\\Users\\Deepak\\Documents\\Frankly_Appium_Test\\franklymeTest\\frankly-android-release_02_11_15.apk";
	public static String deviceName = "ZX1B33WKR7";
	public JSONObject userdata;
	public static Logger APP_LOGS = Logger.getLogger(Keywords.class);;
	
	/**
	 * @description- Method is Initializing the Testdata property file
	 * @param object - Optional variable
	 */
	public void InitializePropertiesFile() throws IOException, JSONException {
				CONFIG=new Properties();
				OR= new Properties();
				APP_LOGS.debug("Initilize config file to read data");
				FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//com//frankly//config//config.properties");
				CONFIG.load(fs);	
				APP_LOGS.debug("Initilize OR file to read data");
					 fs=new FileInputStream(System.getProperty("user.dir")+"//src//com//frankly//config//OR.properties");
					OR.load(fs);
	  }
	/**
	 * @description- Method is launch the app in device
	 */
	public void launchappium() throws ExecuteException, IOException, InterruptedException{
		System.out.println("Launching Application...");
		APP_LOGS.debug("Initilize config file to read data");
		File file =new File(System.getProperty("user.dir")+"\\frankly-android-release_02_11_15.apk");
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("app", file.getAbsolutePath());
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0.1");
		capabilities.setCapability("appPackage", "me.frankly");
	    capabilities.setCapability("appActivity ", "me.frankly.view.activity.SplashActivity");
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	/**
	 * @description- Method is quieting the drive 
	 */
	public void quitDriver(){
		 try{
				driver.quit();
		 }
		 catch(Exception e){
		 Assert.fail("exception:"+e.getMessage());
		 }
	}
	/**
	 * @description- Method is click a element by ID
	 * @param keyID - Element ID
	 */
	public void clickID(String keyID){
		try{
			timeOut();
			driver.findElement(By.id(OR.getProperty(keyID))).click();
		}catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is click a element by Xpath
	 * @param keyXpath - Element Xpath
	 */
	public void clickXPath(String keyXpath){
		try{
			driver.findElement(By.xpath(OR.getProperty(keyXpath))).click();
		}catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is click a element by Xpath
	 * @param keyClass - Element ClassName
	 */
	public void clickClass(String keyClass){
		try{
			timeOut();
			driver.findElement(By.className(OR.getProperty(keyClass))).click();
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is click a element by Name
	 * @param keyName - Element Name
	 */
	public void clickName(String keyName){
		try{
			driver.findElement(By.name(OR.getProperty(keyName))).click();
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is Scroll the page to the bottom
	 * @param bottom - "R" to the bottom scrolling
	 */
	public void scrolltobottom(String bottom){
		try{
			driver.scrollTo(Constants.bottom);
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is verify the expected text which is passed in OR property file
	 * @param keyXpath - keyXpath
	 * @param expected_text - Pass in OR property file
	 */
	public void verifytext(String keyXpath,String expected_text){
		try{
			timeOut();
			String ExpectedData=OR.getProperty(expected_text);
			timeOut();
			String actual_text = driver.findElement(By.xpath(OR.getProperty(keyXpath))).getText();
			Assert.assertEquals(actual_text, ExpectedData);
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is for wait for element visible for 30 Second
	 * @param- By - Element Selector
	 */
	public void waittillelementvisible(By by){
		try{
			
			WebDriverWait wait= new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is for generic time out that is decided in Constant file 
	 */
	public void timeOut(){
		try{
			driver.manage().timeouts().implicitlyWait(Constants.TIME_OUT, TimeUnit.SECONDS);
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is for scroll the page to the Top
	 * @param Pass "Top" an argument
	 */
	public void scrollToTop(){
		try{
			driver.scrollTo("Top");
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}	
	}
	/**
	 * @description- Method is write text in a textfield
	 * @param TextFieldID - Id of element
	 * @param Value - Pass value to write
	 */
	public void writeTextByID(String TextFieldID,String Value){
		try{
			driver.findElement(By.id(OR.getProperty(TextFieldID))).click();
			driver.findElement(By.id(OR.getProperty(TextFieldID))).sendKeys(OR.getProperty(Value));
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is verify the text
	 * @param textID - Id of element
	 * @param expected_text - Pass value to match
	 */
	public void VerifyPageHeading(String textID,String expected_text){
		try{
			String actual_text=driver.findElement(By.id(OR.getProperty(textID))).getText();
			if(actual_text.contains(OR.getProperty(expected_text))){	
			}
			else{
				Assert.fail("not able to match text");
			}
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Method is return a string
	 * @param textID - Id of element
	 * @return expected_text
	 */
	public String returntextByID(String textID){
		String expected_text = null;
		try{
			expected_text = driver.findElement(By.id(OR.getProperty(textID))).getText();
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
		return expected_text;
	}
	/**
	 * @description- Match the text using ID
	 * @param keyID - Element ID
	 */
		public void VerifytextByID(String textID, String expected_text){
			
			try{
				String actual_text=driver.findElement(By.id(OR.getProperty(textID))).getText();
				if(actual_text.contains(OR.getProperty(expected_text))){
				}
				else{
					Assert.fail("not able to match text");
				}
			}catch(Exception e){
				Assert.fail(e.getMessage());
				
				Assert.fail();
				
			}
		}
		/**
		 * @description- Method is verify page heading by xpath
		 * @param textID - Id of element
		 * @param expected_text - Pass value to match
		 */
		public void VerifyPageHeadingbyXpath(String textXpath,String expected_text){
			try{
				String actual_text=driver.findElement(By.xpath(OR.getProperty(textXpath))).getText();
				if(actual_text.contains(OR.getProperty(expected_text))){	
				}
				else{
					Assert.fail("not able to match text");
				}
			}catch(Exception e){
				Assert.fail(e.getMessage());
			}
		}
		/**
		 * @description- Verify the rendom heading/text
		 * @param keyID - Element ID
		 */
				public void VerifyRandomHeadingID(String textID, String expected_text){
					try{
						String actual_text=driver.findElement(By.id(OR.getProperty(textID))).getText();
						if(actual_text.contains(expected_text)){	
						}
						else{
							Assert.fail("not able to match text");
						}
					}catch(Exception e){
						Assert.fail(e.getMessage());
					}
				}
				/**
				 * @description- rendom heading should not be visible 
				 * @param keyID - Element ID
				 */
				public void VerifyRandomHeadingNotVisibleByID(String textID, String expected_text){
					try{
						String actual_text=driver.findElement(By.id(OR.getProperty(textID))).getText();
						if(!actual_text.contains(expected_text)){	
						}
						else{
							Assert.fail("not able to match text");
						}
					}catch(Exception e){
						Assert.fail(e.getMessage());
					}
				}
				/**
				 * @description- Element is present
				 * @param keyID - Element ID
				 */
	public String elementisvisibleByID(String elementID){
		try{
			if(driver.findElement(By.id(OR.getProperty(elementID)))!=null){

				 return PASS;
			}
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
		return PASS;
	}
	/**
	 * @description- Element is present and return boolean value
	 * @param keyID - Element ID
	 */
public boolean visibleElementByID(String elementID){
try{
	if(driver.findElement(By.id(OR.getProperty(elementID)))!=null){
	 return true;
	}
}catch(Exception e){
	Assert.fail(e.getMessage());
}
return false;
}
/**
 * @description- Element is present by Xpath and return boolean value
 * @param keyID - Element Xpath
 */
public boolean visibleElementByXpath(String elementXpath){
try{
if(driver.findElement(By.id(OR.getProperty(elementXpath)))!=null){
 return true;
}
}catch(Exception e){
Assert.fail(e.getMessage());
}
return false;
}
	
	/**
	 * @description- Verify the element is not visible on the screen
	 * @param keyID - Element ID
	 */
	public boolean verifyElementNotDisplayedByID(String elementID) {
		try {
			if (!(driver.findElement(By.id(OR.getProperty(elementID))).isDisplayed())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		return true;
	}
	/**
	 * @description- Method is saving current date into global var
	 * @param object - Optional variable
	 * @return - Execution Result
	 */
	public String addGlobalVarintoArrayList(String elelmentID) {
	try{
		Expected_Value = driver.findElement(By.id(OR.getProperty(elelmentID))).getText();
	}catch(Exception e){
		Assert.fail(e.getMessage());
	}
	return Expected_Value;
	}
	/**
	 * @description- Method is saving current date into global var
	 * @param object - Optional variable
	 * @return - Actual Result
	 */
	public void VerifyStoredGlobalVariableByXpath(String elelmentID,String Expected_Value ) {
	try{
		Actual_Value = driver.findElement(By.xpath(OR.getProperty(elelmentID))).getText();
		if(Actual_Value.contains(Expected_Value)){
		}else{
			Assert.fail("Not able to match text");
		}
	}catch(Exception e){
		Assert.fail(e.getMessage());
	}
	}
	/**
	 * @description- Method is saving current date into global var
	 * @param object - Optional variable
	 * @return - Actual Result
	 */
	public void VerifyStoredGlobalVariableByID(String elelmentID,String Expected_Value ) {
	try{
		Actual_Value = driver.findElement(By.id(OR.getProperty(elelmentID))).getText();		
		if(Actual_Value.contains(Expected_Value)){
		}else{
			Assert.fail("Not able to match text");
		}
	}catch(Exception e){
		Assert.fail(e.getMessage());
	}
	}
	/**
	 * @description- Method is navigating back to the previous page
	 * @param object - Optional variable
	 * @return - Actual Result
	 */
	public void NaviagtetoBack() {
	try{
		driver.navigate().back();
	}catch(Exception e){
		Assert.fail(e.getMessage());
	}
	}

	/**
	 * @description- Method is validating the existence of element y xpath
	 * @param elementXpath - xpath of element
	 * @return - Actual Result
	 */
	public boolean elementisvisibleByXpath(String elementXpath){
		try{
			timeOut();
			if(driver.findElement(By.xpath(OR.getProperty(elementXpath)))!=null){
				 return true;
			}
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
		return false;
	}
	/**
	 * @description- upload a video using ID
	 * @param keyID - Element ID
	 */
	public void uploadAVideo(String keyID,String filePath){
		try{
			WebElement element= driver.findElement(By.id(OR.getProperty(keyID)));
			element.sendKeys(filePath);
		}catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- upload a video using Xpath
	 * @param keyID - Element ID
	 */
	public void uploadAVideoByXpath(String KeyXpath,String filePath){
		try{
			WebElement element= driver.findElement(By.xpath(OR.getProperty(KeyXpath)));
			element.sendKeys(OR.getProperty(filePath));
		}catch (Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/*@Scrolling function is not working on this app because it is not a native app
	*/
	// Scroll the page to the using ID
	public void scrollthepagetoText(String KeyXpath){
		try{
			timeOut();
			if(driver.scrollToExact(OR.getProperty(KeyXpath)) != null){
				
			}
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Write rendom value in textfield 
	 * @param keyID - Element ID
	 */
	public void writeRendomvalueByID(String KeyID,String Expected_Value){
		try{
			driver.findElement(By.id(OR.getProperty(KeyID))).click();
			driver.findElement(By.id(OR.getProperty(KeyID))).sendKeys(Expected_Value);
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}
	/**
	 * @description- Write rendom value in respective textfield 
	 * @param keyID - Element Xpath
	 */
		public void writeRendomvalueByXpath(String KeyID,String Expected_Value){
			try{
				driver.findElement(By.xpath(OR.getProperty(KeyID))).click();
				driver.findElement(By.xpath(OR.getProperty(KeyID))).sendKeys(Expected_Value);
			}catch(Exception e){
				Assert.fail(e.getMessage());
			}
		}
		
	// Read value from json file
	public JSONObject getCompanyConfig(String jsonFile) {
        JSONObject object = null;
       try {
           InputStream input = this.getClass().getClassLoader()
                   .getResourceAsStream("com/optimusapp/config/"+jsonFile);
           object = new JSONObject(new JSONTokener(
                   new InputStreamReader(input)));
       } catch (Exception exception) {
           exception.printStackTrace();
       }
       return object;
   }
	
}

