package com.bhiman.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bhiman.main.Constants;
import com.bhiman.main.UIKeywords;
import com.bhiman.main.WaitsInHelp;
import com.bhiman.main.utility.PropertyReader;

/**
 * Contains setup {@BeforeMethod} and tearDown {@AfterMethod} annotated methods compulsorily required 
 * to run before & after every @Test annotated Test cases.
 */

public class BaseTest extends UIKeywords {

	private static final Logger LOG = Logger.getLogger(BaseTest.class);

	@FindBy(name = "username")
	private static WebElement mobile_no;

	@FindBy(name = "password")
	private static WebElement password;

	@FindBy(css = "button[type='submit']")
	private static WebElement login_Btn;

	@FindBy(xpath = "//button[normalize-space()='OK']")
	private static WebElement click_ok;

	@BeforeMethod
	public void setUp() {
		LOG.info("Before (setUp) method started.");
		UIKeywords.openBrowser(PropertyReader.getLocatorValue("browserName"));
		UIKeywords.openUrl(PropertyReader.getLocatorValue("url"));
		PageFactory.initElements(Constants.driver, BaseTest.class);
		UIKeywords.maximizeWindow();
		UIKeywords.enterText(mobile_no, PropertyReader.getLocatorValue("admin_mobile_no"));
		UIKeywords.enterText(password, PropertyReader.getLocatorValue("admin_password"));
		UIKeywords.clickOnElement(login_Btn);
		UIKeywords.clickOnElement(click_ok);
		String expectedURL = "http://103.50.162.196/testing/index.php";
		String actualURL = UIKeywords.getPageUrl();
		Assert.assertEquals(expectedURL, actualURL, "Login to application failed.");
		LOG.info("Login to application successfully.");
	}

	@AfterMethod	// Post-condition
	public void tearDown() {
		LOG.info("After (tearDown) method started.");
		UIKeywords.closeAllBrowser();
		LOG.info("All Browser closed successfully.");
	}
}