package com.incito.logistics.testcase.login;
/**
 *@author  xy-incito
 *@Description 测试用例：成功登陆
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class LoginPage_2_Success_Test extends BaseParpare{
	
  @Test
  public void loginSuccessTest(ITestContext context) {
	  String username = context.getCurrentXmlTest().getParameter("username");
	  String passcode = context.getCurrentXmlTest().getParameter("passcode");
	  int timeOut =Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
	  int sleepTime =Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
	  
	  HomePageHelper.waitHomePageToLoad(timeOut,seleniumUtil);
	  HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
	  LoginPageHelper.waitLPageToLoad(timeOut, seleniumUtil);
	  LoginPageHelper.login(seleniumUtil, username, passcode);
	  LoginPageHelper.verifyUserInfo(timeOut, sleepTime, seleniumUtil, username);
  }
  
}
