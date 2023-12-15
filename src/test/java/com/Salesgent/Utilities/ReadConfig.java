package com.Salesgent.Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Salesgent.PageFunctions.LoginFun;

public class ReadConfig {
	
	private static final Logger logger = LogManager.getLogger(LoginFun.class);

	public static FileReader frprop ;
	public static Properties prop = new Properties(); 
	
	public ReadConfig() throws IOException {
		try {
		FileReader frprop = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
		prop.load(frprop);
		}catch (Exception e) {
			logger.error("Exception is" +e);
		
		}
		
	}
	
	public String getUrl() {
		String url = prop.getProperty("url");
		return url;
		
	}
	
	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}

}
