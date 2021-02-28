package com.bhiman.test.login;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bhiman.main.Constants;
import com.bhiman.main.WaitsInHelp;
import com.bhiman.main.login.Admin;
import com.bhiman.main.utility.ExcelReader;
import com.bhiman.main.utility.PropertyReader;

public class AdminTest {
	
	private static final Logger LOG = Logger.getLogger(AdminTest.class);

	public AdminTest() {
		PageFactory.initElements(Constants.driver, this);
	}

	@Test(dataProvider = "loginData")
	public void adminLogin(String mobileNo, String password, String expected_Result) throws InterruptedException {

		PageFactory.initElements(Constants.driver, this);
		LOG.info("Refreshing the Login Page");
		Admin.RefershPage();
		LOG.info("Enter input as mobile no as username");
		Admin.enterUsername(mobileNo);
		LOG.info("Enter input as the password");
		Admin.enterPassword(password);
		LOG.info("click on Login button");
		Admin.clickOnLoginButton();

		if (mobileNo.contentEquals("9876543210") && password.contentEquals("admin")) {
			WaitsInHelp.threadSleepInMilliSeconds(2000);
			LOG.info("Username and password is correct");
			Admin.clickOnSignInButton();
			Assert.assertEquals("Login Successfull.", expected_Result);

		} else if (mobileNo.contentEquals("9876543210") && password.contentEquals("ADMIN")) {
			WaitsInHelp.threadSleepInMilliSeconds(2000);
			LOG.info("Username and password is Incorrect");
			Admin.clickOnErrorInButton();
			Assert.assertEquals("Username/Password is wrong. Please try again.", expected_Result);
		}

		else {
			WaitsInHelp.threadSleepInMilliSeconds(2000);
			LOG.info("Username and password is Incorrect");
			Admin.clickOnErrorInButton();
			Assert.assertEquals("Please enter proper mobile no. Mobile No must be start with 6,7,8,9", expected_Result);
		}
	}

	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException {
		LOG.info("Taking xlfile path from property file");
		String path = (PropertyReader.getLocatorValue("testDataPath"));
		LOG.info("Taking row count for login page");
		int rownum = ExcelReader.getRowCount(path, "LoginPage");
		LOG.info("Taking Cell count for login page for one row");
		int colcount = ExcelReader.getCellCount(path, "LoginPage", 1);
		String loginData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum;i++) {
			for (int j = 0; j < colcount; j++) {
				loginData[i - 1][j] = ExcelReader.getCellData(path, "LoginPage", i, j);
				LOG.info("Taking data from cell ");
			}
		}
		return loginData;
	}

}
