package com.Salesgent.PageFunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Salesgent.Base.base;
import com.Salesgent.Utilities.ReadLoginXlsxTestData;

public class LoginFun extends base {
	
	public WebDriver driver;
   private static final Logger logger = LogManager.getLogger(LoginFun.class);

	
	public LoginFun(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test(dataProviderClass = ReadLoginXlsxTestData.class, dataProvider = "loginTestData")
	
	public boolean perfomlogIn(String emailid, String pass) throws Exception {
	 
			Thread.sleep(5000);
			
			WebElement email = driver.findElement(By.id(loginloc.getProperty("email_filed")));
			email.sendKeys(emailid); 
			
			WebElement password = driver.findElement(By.id(loginloc.getProperty("password_filed")));
			password.sendKeys(pass); 
			
			WebElement loginbtn = driver.findElement(By.className(loginloc.getProperty("login_btn")));
			loginbtn.click(); 
		
				// **Added Local storage key and value to avoid Authorization verification
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("localStorage.setItem(arguments[0],arguments[1])","DEVICE_LIST","[{\"adminEmail\":null,\"userEmail\":\"anjali.tandel@Salesgent1.onmicrosoft.com\",\"userId\":76,\"name\":null,\"otpCode\":null,\"deviceName\":null,\"deviceOperatingSystem\":null,\"deviceBrowser\":null,\"deviceId\":\"646edc21-c654-4ccd-9420-9ffd133524c5\",\"insertedTimestamp\":null}]");
				
				Thread.sleep(1000);
				
				String verifylogin = driver.getCurrentUrl();
				if(verifylogin.contains("product")) {
					return true;
				}
				else {
					logger.error("User not able to login");
					return false;
					
				}
		
	}
	

	

}
