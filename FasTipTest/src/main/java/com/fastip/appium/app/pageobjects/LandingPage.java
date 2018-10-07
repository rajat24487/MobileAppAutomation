package com.fastip.appium.app.pageobjects;

import org.openqa.selenium.WebElement;

import com.fastip.appium.utility.PropertiesUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LandingPage extends AbstractPage {
	 
	PropertiesUtil pu= new PropertiesUtil();
	/*
	 * Constructor
	 */
	public LandingPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		 this.driver = driver;
	}

	/*
	 * Page Elements
	 */
	@AndroidFindBy(id = "org.traeg.fastip:id/menu_settings")
	public WebElement eleSettings;

	@AndroidFindBy(id = "org.traeg.fastip:id/tipPercentageEditText")
	public WebElement editTipPercentage;

	@AndroidFindBy(id = "org.traeg.fastip:id/saveSettingsButton")
	public WebElement btnSave;

	@AndroidFindBy(id = "org.traeg.fastip:id/tipPctTextView")
	public WebElement eleTipView;

	@AndroidFindBy(id = "org.traeg.fastip:id/tipAmtTextView")
	public WebElement eleTipAmtView;

	@AndroidFindBy(id = "org.traeg.fastip:id/totalAmtTextView")
	public WebElement eleTotalAmtView;

	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement editBillAmount;

	@AndroidFindBy(className = "android.widget.Button")
	public WebElement btnCalculateTip;

	/*
	 * Actions on page elements
	 */
	public void enterBillAmount() {
		editBillAmount.sendKeys(pu.getAmount());

	}

	public void enterTipPercentage() {
		editTipPercentage.clear();
		editTipPercentage.sendKeys(pu.getTipPercentage());

	}

	public void saveSettings() {
		btnSave.click();
	}

	public void clickSettings() {
		eleSettings.click();
	}

	public void calculateTip() {
		btnCalculateTip.click();
	}

	public String getTipPercent() {
		return eleTipView.getText();

	}

	public String getTipAmount() {
		return eleTipAmtView.getText();

	}

	public String getTotalAmount() {
		return eleTotalAmtView.getText();

	}
	
}
