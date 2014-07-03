package com.incito.appium.testcase;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.incito.appium.util.SetIME;

public class AndroidContactsTest {
    private AppiumDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "./apps/");
        File app = new File(appDir, "ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","TrueDevices");
        capabilities.setCapability("platformVersion", "4.2.2");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void tearDown() throws Exception {
    	String setSAMSUNGIME =  "cmd.exe /c adb shell ime set com.samsung.inputmethod/.SamsungIME";
      	new SetIME().setIMEByCMD(setSAMSUNGIME);
        driver.quit();
    }

    @Test
    public void addContact(){
    	//设置输入法
    	String setUTF7IME =  "cmd.exe /c adb shell ime set jp.jun_nama.test.utf7ime/.Utf7ImeService";
    	new SetIME().setIMEByCMD(setUTF7IME);
    	
        WebElement el = driver.findElement(By.name("Add Contact"));
        el.click();
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("王阳");
        textFieldsList.get(1).sendKeys("18872573204");
        textFieldsList.get(2).sendKeys("398733146@qq.com");
        //driver.swipe(100, 500, 100, 100, 2);
        driver.findElementByName("Save").click();
    }

}
