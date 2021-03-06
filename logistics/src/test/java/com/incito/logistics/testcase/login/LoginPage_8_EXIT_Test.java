package com.incito.logistics.testcase.login;
/**
 *@author  xy-incito
 *@Description 测试用例：退出登陆操作
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class LoginPage_8_EXIT_Test extends BaseParpare{
	
  @Test
  public void exitLoginTest(ITestContext context) {
	  String username = context.getCurrentXmlTest().getParameter("username");
	  String passcode = context.getCurrentXmlTest().getParameter("passcode");
	  int timeOut =Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
	  int sleepTime =Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

	  HomePageHelper.waitHomePageToLoad(timeOut,seleniumUtil);
	  HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
	  LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
	  LoginPageHelper.checkLoginPageText(seleniumUtil);
	  LoginPageHelper.login(seleniumUtil, username, passcode);
	  LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
	  seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_BUTTON_EXIT));
  }
  

}
