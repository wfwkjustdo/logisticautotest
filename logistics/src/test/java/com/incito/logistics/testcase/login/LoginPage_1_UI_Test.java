package com.incito.logistics.testcase.login;
/**
 *@author  xy-incito
 *@Description 测试用例：登陆界面UI测试
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class LoginPage_1_UI_Test extends BaseParpare {
	@Test
	public void uiTest(ITestContext context){
		  int timeOut =Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));

			  HomePageHelper.waitHomePageToLoad(timeOut,seleniumUtil);
			  seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_BUTTON_LOGIN));
			  LoginPageHelper.waitLPageToLoad(timeOut, seleniumUtil);
			  LoginPageHelper.checkLoginPageText(seleniumUtil);
			  LoginPageHelper.isInputCorrect(seleniumUtil);

	}

}
