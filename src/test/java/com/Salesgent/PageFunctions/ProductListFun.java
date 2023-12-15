package com.Salesgent.PageFunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Salesgent.Base.base;

public class ProductListFun extends base {
	
	public WebDriver driver;
	
    private static final Logger logger = LogManager.getLogger(ProductListFun.class);

	public ProductListFun(WebDriver driver) {
		this.driver=driver;		
	}
	
	
	
	public boolean VerifyProductListPage () throws InterruptedException{
		int count = 0;
		Thread.sleep(3000);		
		String currectUrl = driver.getCurrentUrl();		
		if(currectUrl.contains("product")){
			List<WebElement> products = driver.findElements(By.xpath(ProdListLoc.getProperty("all_products_name")));
			Thread.sleep(3000);		
			for (int i = 0; i < products.size(); i++) {
				//WebElement Prod = products.get(i);
				count++;
			}
			logger.info("Products dispay in a Page are: " + count);
			return true;
			
			
			}else{			
				logger.error("Product list page not found :" + currectUrl);
				return false;
			}
		//return true;
	}
	
	
	public void clickOnList() {
		
	}
	
	
	public boolean SearchUPC(String UPC) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//locate search icon
		WebElement serchIcon = driver.findElement(By.xpath(ProdListLoc.getProperty("search_icon")));
			if (serchIcon.isEnabled()) {
				serchIcon.click(); 
				Thread.sleep(2000);
				
				//locate SearchBox 
				WebElement UPCSerchBox = driver.findElement(By.xpath(ProdListLoc.getProperty("UPC_searchBox")));
					if(UPCSerchBox.isEnabled()) {
						UPCSerchBox.sendKeys(UPC);
						Thread.sleep(2000);
					}else{
						return false;
					} 
					
				//locate Search button
				WebElement SerchBtn = driver.findElement(By.xpath(ProdListLoc.getProperty("search_btn")));	
					if(SerchBtn.isEnabled()) {
						SerchBtn.click();
						Thread.sleep(2000);
						this.VerifySerchUPC(UPC);
					}else {
						return false;
					}
			
			}else{
				return false;
			}
			return true;
	}

	
	
	public boolean VerifySerchUPC(String EnteredUPC){
		//boolean status=true;
		List<WebElement> allUPCRows =  driver.findElements(By.xpath(ProdListLoc.getProperty("all_UPC_rows")));
		for(WebElement ListUPC : allUPCRows){
			if(ListUPC.getText().equals(EnteredUPC)){
				logger.info( "Entered UPC" + EnteredUPC + "\n" + "List of serched UPC" + ListUPC.getText());
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	
	public boolean ResetUPC() {
		
		return false;
		
	}

}
