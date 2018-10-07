package com.fastip.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fastip.appium.AppiumDriverSetup;
import com.fastip.appium.app.pageobjects.LandingPage;
import com.fastip.appium.utility.PropertiesUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Sanity_Test {

	private LandingPage lp = null;
	AppiumDriverSetup appiumSetup = null;
	AppiumDriver<MobileElement> driver = null;
	PropertiesUtil pu= new PropertiesUtil();

	@Parameters({ "appiumServerUrl", "appiumPort", "platform",
			"platformVersion", "deviceName", "appPath" })
	@BeforeTest
	public void setUp(String appiumServerUrl, String appiumPort,
			String platform, String platformVersion, String deviceName,
			String appPath) {
		appiumSetup = new AppiumDriverSetup(appiumServerUrl, new Integer(
				appiumPort), platform, platformVersion, deviceName, appPath);
		appiumSetup.startAppiumServer();
		driver = appiumSetup.getMobileDriver();
		lp = new LandingPage(driver);

	}

	@Test(priority = 1)
	public void setTipPercentage() {
		lp.clickSettings();
		lp.enterTipPercentage();
		lp.saveSettings();
		Assert.assertEquals(lp.getTipPercent(), pu.getTipPercentage()+"%");
		Reporter.log("Tip percentage is saved successfully. Test case passed.");
	}

	@Test(priority = 2, enabled = true)
	public void calculateTipTest() {
		lp.enterBillAmount();
		lp.calculateTip();
		Assert.assertEquals(lp.getTipAmount(), "$20.00");
		Assert.assertEquals(lp.getTotalAmount(), "$120.00");
		Reporter.log("Tip and totam amount is calculated successfully. Test case passed.");
	}

	@AfterTest
	public void tearDown() {
		appiumSetup.stopAppiumDriver();
		appiumSetup.stopAppiumServer();
	}

}
