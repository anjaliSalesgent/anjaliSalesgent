package com.Salesgent.TCase.ProductList;

import org.testng.annotations.Test;

import com.Salesgent.Base.base;
import com.Salesgent.PageFunctions.ProductListFun;

public class TestCase_79 extends base {
	
	
	@Test
	public static void TC_79() throws Exception {
		
		boolean status;
			
			ProductListFun proList = new ProductListFun(driver);
			Thread.sleep(2000);

			//**Test Case Discription: Verify user can find the product by searching the UPC number
			status= proList.SearchUPC("607152845000");
			if(status) {
				logger.info("Verify user can find the product by searching the UPC number: PASS");
			}
			else {
				logger.error("Verify user can find the product by searching the UPC number: Fail");

			}
		
		}


}
