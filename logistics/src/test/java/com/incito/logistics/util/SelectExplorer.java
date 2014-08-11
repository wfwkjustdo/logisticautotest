package com.incito.logistics.util;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
public class SelectExplorer {
	
	public WebDriver  selectExplorerByName(String browser,ITestContext context,String platform ){
		/**声明好驱动的路径*/
		 String chromedriver_win32= context.getCurrentXmlTest().getParameter("chromedriver_win32");
		 String iedriver_win32= context.getCurrentXmlTest().getParameter("iedriver_win32");
		 String iedriver_win64= context.getCurrentXmlTest().getParameter("iedriver_win64");
		 String chromedriver_linux32= context.getCurrentXmlTest().getParameter("chromedriver_linux32");
		 String chromedriver_linux64= context.getCurrentXmlTest().getParameter("chromedriver_linux64");
		 String chromedriver_mac32= context.getCurrentXmlTest().getParameter("chromedriver_mac32");
		 Properties props=System.getProperties(); //获得系统属性集  
		 String osName = props.getProperty("os.name"); //操作系统名称  
		 
		
		 switch (platform.toLowerCase()) {

		 case "win":
		 if(browser.equalsIgnoreCase("ie32")){
			  System.setProperty("webdriver.ie.driver", iedriver_win32);
//			     DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//			     ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			    return  new InternetExplorerDriver();
		 }else if(browser.equalsIgnoreCase("ie64")){
			  System.setProperty("webdriver.ie.driver", iedriver_win64);
			     DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			     ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			    return  new InternetExplorerDriver();
		 }else if(browser.equalsIgnoreCase("chrome32")){
				System.setProperty("webdriver.chrome.driver",	 chromedriver_win32);
				return  new ChromeDriver();
		 }else{
			 
			 System.out.println(browser+" is not applicate for "+ osName);
			 
		 }
		 break;
		 
		 case "linux":
	if(browser.equalsIgnoreCase("chrome32")){
		System.setProperty("webdriver.chrome.driver",	 chromedriver_linux32);
		return  new ChromeDriver();
		
	}else if(browser.equalsIgnoreCase("chrome64")){
		System.setProperty("webdriver.chrome.driver",	 chromedriver_linux64);
		return  new ChromeDriver();
	}else{
		 System.out.println(browser+" is not applicate for "+ osName);
	}
		 break;
		 
		 case "mac":
		 if(browser.equalsIgnoreCase("mac32")){
				System.setProperty("webdriver.chrome.driver",	 chromedriver_mac32);
				return  new ChromeDriver();
		 }else{
			 System.out.println("no information for mac!");
		 }
		 break;
		 
		 default:
			 System.out.println("你所选择的平台："+platform+"不被支持！");
			break;
		 }
		 
		 
		return null;
		 
		
	}

}
