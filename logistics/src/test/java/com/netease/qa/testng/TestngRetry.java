package com.netease.qa.testng;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.netease.qa.testng.utils.ConfigReader;

/**
 * TestNG retry Analyzer.
 * @author kevinkong
 *
 */
public class TestngRetry implements IRetryAnalyzer {
	private static Logger logger = Logger.getLogger(TestngRetry.class);
	private int retryCount = 1;
	private static int maxRetryCount;

	static {
		ConfigReader config = ConfigReader.getInstance();
		maxRetryCount = config.getRetryCount();
		logger.info("测试重试次数=" + maxRetryCount);
		logger.info("测试代码目录=" + config.getSourceCodeDir());
		logger.info("测试代码编码=" + config.getSrouceCodeEncoding());
	}

	public boolean retry(ITestResult result) {
		if (retryCount <= maxRetryCount) {
			String message = "重跑： [" + result.getName() + "] on class [" + result.getTestClass().getName() + "] 重跑 "
					+ retryCount + " 次";
			logger.info(message);
			Reporter.setCurrentTestResult(result);
			Reporter.log("RunCount=" + (retryCount + 1));
			retryCount++;
			return true;
		}
		return false;
	}

	public static int getMaxRetryCount() {
		return maxRetryCount;
	}
	
	public int getRetryCount() {
		return retryCount;
	}
	
}
