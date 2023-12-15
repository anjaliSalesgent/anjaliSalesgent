package com.Salesgent.TCase.ProductList;

import org.testng.annotations.Test;

import com.Salesgent.Base.base;
import com.Salesgent.PageFunctions.ProductListFun;

public class TestCase_78 extends base {
	
	@Test
	public static void TC_78() throws Exception {
		
		boolean status;

			ProductListFun proList = new ProductListFun(driver);
			Thread.sleep(2000);
			
			//**Test Case Description: Verify that Edit product /Product List page is loaded properly 
			status = proList.VerifyProductListPage();
			Thread.sleep(10000);
			if(status) {
				logger.info("Verify that Edit product /Product List page is loaded properly : PASS");
			}
			else {
				logger.error("Verify that Edit product /Product List page is loaded properly : FAIL");
			}

		}


}
