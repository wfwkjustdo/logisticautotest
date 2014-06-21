package com.incito.logistics.pages.pageshelper;

import com.incito.logistics.util.SeleniumUtil;

public class AlertPageHelper {
	
	/**登陆时候用户名和密码都不填写应该弹出，请用此方法验证alert信息*/
	public static void isAlertUsername(SeleniumUtil seleniumUtil,int waitMillisecondsForAlert){
		seleniumUtil.isTextEquals(seleniumUtil.switchToPromptedAlertAfterWait(waitMillisecondsForAlert).getText(),"请输入用户名！");
	}
	
	/**登陆时候只输入用户名，密码都不填写应该弹出，请用此方法验证alert信息*/
	public static void isAlertPassword(SeleniumUtil seleniumUtil,int waitMillisecondsForAlert){
		
		seleniumUtil.isTextEquals(seleniumUtil.switchToPromptedAlertAfterWait(waitMillisecondsForAlert).getText(),"请输入密码！");
	}

	/**登陆时候输入错误用户名，密码填写正确，请用此方法验证alert信息*/
	public static void isAlertNameAndCode(SeleniumUtil seleniumUtil,int waitMillisecondsForAlert){
		seleniumUtil.isTextEquals(seleniumUtil.switchToPromptedAlertAfterWait(waitMillisecondsForAlert).getText(),"用户名或密码错误,请重新登录!");
	}
}
