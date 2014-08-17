package com.incito.logistics.util;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;

public class SelectExplorer {
	static Logger logger = Logger.getLogger(SelectExplorer.class.getName());
	
	public WebDriver  selectExplorerByName(String browser,ITestContext context,String platform ){
		/**声明好驱动的路径*/
		 String chromedriver_win= context.getCurrentXmlTest().getParameter("chromedriver_win");
		 String chromedriver_linux= context.getCurrentXmlTest().getParameter("chromedriver_linux");
		 String chromedriver_mac= context.getCurrentXmlTest().getParameter("chromedriver_mac");
		 String iedriver= context.getCurrentXmlTest().getParameter("iedriver");

		 Properties props=System.getProperties(); //获得系统属性集  
		 String osName = props.getProperty("os.name"); //操作系统名称  
		 
		
		 switch (platform.toLowerCase()) {

		 case "win":
		 if(browser.equalsIgnoreCase("ie")){
			  System.setProperty("webdriver.ie.driver", iedriver);
			     DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			     ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			    return  new InternetExplorerDriver(ieCapabilities);
		 }else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver",	 chromedriver_win);
				return  new ChromeDriver();
		 }else if(browser.equalsIgnoreCase("firefox")){
			 return new FirefoxDriver();
			 
		 } else{
			 
			logger.error("["+browser+"]"+" 浏览器不适用于 "+ osName+"操作系统");
			 
		 }
		 break;
		 
		 case "linux":
	if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver",	 chromedriver_linux);
		return  new ChromeDriver();
		
	}else if(browser.equalsIgnoreCase("firefox")){
		 return new FirefoxDriver();
	 }
	else{
		logger.error("["+browser+"]"+" 浏览器不适用于 "+ osName+"操作系统");
	}
		 break;
		 
		 case "mac":
		 if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver",	 chromedriver_mac);
				return  new ChromeDriver();
		 }else if(browser.equalsIgnoreCase("firefox")){
			 return new FirefoxDriver();
			 
		 }else{
			 logger.error("["+browser+"]"+" 浏览器不适用于 "+ osName+"操作系统");
		 }
		 break;
		 
		 default:
			 logger.error("你所选择的平台："+" ["+platform+"] "+"不被支持！");
			break;
		 }
		 
		 
		return null;
		 
		
	}

}
