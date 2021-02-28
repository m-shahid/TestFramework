package com.bhiman.test.masters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bhiman.main.Constants;
import com.bhiman.main.UIKeywords;
import com.bhiman.main.masters.Banks;
import com.bhiman.main.masters.Users;
import com.bhiman.main.utility.PropertyReader;
import com.bhiman.test.BaseTest;

public class UsersTest extends BaseTest {

	private static final Logger LOG = Logger.getLogger(UsersTest.class);

	@Test(description = "To verify and validate 'Users' option in 'Masters'.")
	private void verifyUsersInMasters() {
		LOG.info("userPageTest_01");
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		String Users_expectedUrl = "http://103.50.162.196/testing/user.php";
		String Users_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(Users_actualUrl, Users_expectedUrl);
	}

	@Test(description = "To verify and validate after click on 'Users' option in 'Masters'")
	private void verifyaddUserinUsers() {
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnAddUsers();
		String Users_expectedUrl = "http://103.50.162.196/testing/user.php#";
		String Users_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(Users_actualUrl, Users_expectedUrl);
	}

	@Test(description = "To verify and validate click on 'Copy' button on User page.")
	private void verifyClickOnCopyButton() {
		Users users = new Users();
		LOG.info("Verifying click on 'Copy' button in user page.");
		String user_expectedUrl = "http://103.50.162.196/testing/user.php";
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnUserCopyButton();
		String user_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(user_actualUrl, user_expectedUrl);
	}

	@Test(description = "To verify and validate click on 'Excel' button on User page.")
	private void verifyClickOnExcelButton() {
		Users users = new Users();
		LOG.info("Verifying click on ''Excel' button in user page.");
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnExcelButton();
		Constants.actual = "Users.xlsx";
		String filePath = "C:\\Users\\ingalkar\\Downloads\\Users.xlsx";
		File file = new File(filePath);
		Constants.flag = file.exists();
		assertTrue(Constants.flag, "File name: " + Constants.actual + " is not downloaded at location: " + filePath);

	}

	@Test(description = "To verify and validate click on 'CSV' button in User page.")
	public static void verifyClickOnCSVButton() {
		LOG.info("Verifying click on 'CSV' button in User page.");
		Users users = new Users();
		Constants.actual = "Users.csv";
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnCSVButton();
		Constants.actual = "Users.csv";
		String filePath = "C:\\Users\\ingalkar\\Downloads\\Users.csv";
		File file = new File(filePath);
		Constants.flag = file.exists();
		assertTrue(Constants.flag, "File name: " + Constants.actual + " is not downloaded at location: " + filePath);
	}

	@Test(description = "To verify and validate click on 'PDF' button in User page.")
	public static void verifyClickOnPDFButton() {
		LOG.info("Verifying click on 'CSV' button in User page.");
		Users users = new Users();
		Constants.actual = "Users.pdf";
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnPDFButton();
		Constants.actual = "Users.pdf";
		String filePath = "C:\\Users\\ingalkar\\Downloads\\Users.pdf";
		File file = new File(filePath);
		Constants.flag = file.exists();
		assertTrue(Constants.flag, "File name: " + Constants.actual + " is not downloaded at location: " + filePath);
	}

	@Test(description = "To verify and validate click on 'Print' button in User page")
	public static void verifyPrintButton() {
		LOG.info("Verifying click on 'Print' button in User page.");
		Users users = new Users();
		//Constants.actual = "Users.pdf";
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnPrintButton();
		//users.switchToWindow(1);
//work in progress
	}

	@Test (description = "To verify and validate search box field with In-valid input (text).")
	public void verifySearchBoxWithInValidText() {
		LOG.info("Entering invalid text on 'Search' textbox in User page.");
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.sarchonUsersSearchBox(PropertyReader.getLocatorValue("Users_search_invalid_text"));		
		Constants.expected = "No matching records found";
		Constants.actual = users.getTextOFUserDataTableForInvalidSearch();
		Assert.assertEquals(Constants.actual, Constants.expected);
	}
	
	@Test(description = "To verify and validate search box field with valid input (text).")
	public void verifySearchBoxWithValidText() {
		LOG.info("Entering valid text on 'Search' textbox in Users page.");
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.sarchonUsersSearchBox(PropertyReader.getLocatorValue("Users_search_valid_text"));
// To Do write code to assert				
	}
	
	@Test (description = "To verify save button. when all field is blank.")
	public void toVerifySavebtnWhenAlltheFieldAreBlank() {
		
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnAddUsers();
		users.clickOnUserSubmit();
		// To Do write code to assert		
	}
	
	@Test (description = "To verify and validate Save button. when enter a Valid entry.")
	public void endToendTestforUserenterALLValidData() {
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnAddUsers();
		users.clickOnUserSubmit();
		users.enterUserName("Mangesh");
		users.enterMobileNo("9970579149");
		users.enterEmailId("mingalkar@gmail.com");
		users.selectRoleforUser("Admin");
		// To Do write code to assert		
	}
	
	@Test (description = "To verify and validate Save button. when enter a In-Valid user Name entry.")
	public void toverifySavebtnWhenEnterInvaldUsername() {
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnAddUsers();
		users.clickOnUserSubmit();
		users.enterUserName("@$%*&^%#MANGO_Gold#$");
		users.enterMobileNo("9970579149");
		users.enterEmailId("mingalkar@gmail.com");
		users.selectRoleforUser("Admin");
		// To Do write code to assert	

	}
	@Test (description = "To verify and validate Save button. when enter a In-Valid mobile no .")
	public void toverifySavebtnWhenEnterInvaldMobileNo() {
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnAddUsers();
		users.clickOnUserSubmit();
		users.enterUserName("@$%*&^%#MANGO_Gold#$");
		users.enterMobileNo("9970579149");
		users.enterEmailId("mingalkar@gmail.com");
		users.selectRoleforUser("Admin");
		// To Do write code to assert	

	}
	@Test (description = "To verify and validate Save button. when enter a In-Valid Email_id .")
	public void toverifySavebtnWhenEnterInvaldEmailId() {
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnAddUsers();
		users.clickOnUserSubmit();
		users.enterUserName("@$%*&^%#MANGO_Gold#$");
		users.enterMobileNo("9970579149");
		users.enterEmailId("mingalkar@gmail.com");
		users.selectRoleforUser("Admin");
		// To Do write code to assert	

	}
	@Test (description = "To verify and validate Save button. when not select RoleforUser.")
	public void toverifySavbtnwhenNotselectRoleforUser() {
		Users users = new Users();
		users.mouseHoverToMastersforuser();
		users.clickOnUsers();
		users.clickOnAddUsers();
		users.clickOnUserSubmit();
		users.enterUserName("@$%*&^%#MANGO_Gold#$");
		users.enterMobileNo("9970579149");
		users.enterEmailId("mingalkar@gmail.com");
		users.selectRoleforUser("Admin");
		// To Do write code to assert

	}
	
}
