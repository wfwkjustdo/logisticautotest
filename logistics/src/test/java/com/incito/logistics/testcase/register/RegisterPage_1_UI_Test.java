package com.incito.logistics.testcase.register;
/**
 *@author  xy-incito
 *@Description 注册页面上的文本检查
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;

public class RegisterPage_1_UI_Test extends BaseParpare {
	@Test(description="注册页面上的文本检查")
	public void uiTest(ITestContext context){
		  int timeOut =Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));

			  HomePageHelper.waitHomePageToLoad(timeOut,seleniumUtil);
			  HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_REG);
			  RegisterPageHelper.waitRegisterPageToLoad(timeOut, seleniumUtil);
			  RegisterPageHelper.checkRegisterPageText(seleniumUtil);

	}

}
