package com.incito.logistics.testcase.login;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.AlertPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
/**
 *@author  xy-incito
 *@Description 登陆失败-输入正确用户名，密码输入错误,提示“用户名或密码错误,请重新登录!”
 * */
public class LoginPage_7_Fail_Incorrect_Password_Test extends BaseParpare{
    
  @Test
  public void loginFailTest_incorrectPassword(ITestContext context) {
	  String username = context.getCurrentXmlTest().getParameter("username");
	  String password = context.getCurrentXmlTest().getParameter("incorrectpasscode");
	  int timeOut =Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
	  int waitMillisecondsForAlert =Integer.valueOf(context.getCurrentXmlTest().getParameter("waitMillisecondsForAlert"));
	  
	  HomePageHelper.waitHomePageToLoad(timeOut,seleniumUtil);
	  seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_BUTTON_LOGIN));
	  LoginPageHelper.waitLPageToLoad(timeOut, seleniumUtil);
	  seleniumUtil.clear(seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME));
	  seleniumUtil.sendKeys(seleniumUtil.findElementBy(LoginPage.LP_INPUT_USERNAME), username);
	  seleniumUtil.clear(seleniumUtil.findElementBy(LoginPage.LP_INPUT_PASSCODE));
	  seleniumUtil.sendKeys(seleniumUtil.findElementBy(LoginPage.LP_INPUT_PASSCODE), password);
	  seleniumUtil.click(seleniumUtil.findElementBy(LoginPage.LP_BUTTON_LOGIN));
	  AlertPageHelper.isAlertNameAndCode(seleniumUtil, waitMillisecondsForAlert);
  }


}
