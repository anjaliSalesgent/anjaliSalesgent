package com.Salesgent.Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Salesgent.PageFunctions.LoginFun;
import com.Salesgent.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class base {
	
    public static final Logger logger = LogManager.getLogger(base.class);

	public static WebDriver driver;

	public static FileReader frloginloc ;
	public static Properties loginloc = new Properties(); 
	
	public static FileReader frProdListLoc ;
	public static Properties ProdListLoc = new Properties(); 

	
  
	
	
	@BeforeMethod
	public Boolean setUp() throws Exception {
		
		ReadConfig readConfig = new ReadConfig();
		
		boolean status;
		if(driver == null) {

			FileReader frloginloc = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\LoginLocators.properties");
			loginloc.load(frloginloc);
			
			FileReader frProdListLoc = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\ProductListLocators.properties");
			ProdListLoc.load(frProdListLoc);
			
					  
		}
		
			if(readConfig.getBrowser().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(readConfig.getUrl());

			LoginFun login = new LoginFun(driver);
			status = login.perfomlogIn("anjali.tandel@Salesgent1.onmicrosoft.com" , "123456"); 
			Thread.sleep(1000);

			if(!status) {
				logger.error("Verifing user perfom login " + status);
				return false;
			}
			else {
				logger.info(" User login successfully in chrome browser " + status);
			}
			
		}else if(readConfig.getBrowser().equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(readConfig.getUrl());
			
			LoginFun login = new LoginFun(driver);
			status = login.perfomlogIn("anjali.tandel@Salesgent1.onmicrosoft.com" , "123456"); 
			Thread.sleep(1000);

			if(!status) {
				logger.error("Verifing user perfom login " + status);
				return false;
			}
			else { 
				logger.info(" User login successfully in firefox browser " + status);
			}

		}
		
		return true;
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}
}
