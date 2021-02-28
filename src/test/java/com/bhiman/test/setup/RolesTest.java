package com.bhiman.test.setup;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bhiman.main.Constants;
import com.bhiman.main.UIKeywords;
import com.bhiman.main.setup.Roles;
import com.bhiman.test.BaseTest;


public class RolesTest extends BaseTest {
	
	private static final Logger LOG = Logger.getLogger(RolesTest.class);
	
	Roles role = PageFactory.initElements(Constants.driver, Roles.class);
	
	@Test(groups = {"Regression","Sanity","Smoke"},description = "Add new role with permissions and click on submit button")
	public void addNewRole() {
		
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		Roles.clickOnRolesUnderSetup();
		LOG.info("Click on Add Role Button on Roles Page");
		Roles.clickOnAddRole();
		String addRole_expectedUrl = "http://103.50.162.196/testing/role.php#";
		String addRole_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(addRole_actualUrl, addRole_expectedUrl);
		LOG.info("Enter new Role in Role Name");
		Roles.enterTextInRoleName();
		LOG.info("Set all permission to Role");
		Roles.permissions();
		LOG.info("Click on submit button After setting permissions to Role");
		Roles.clickOnSubmitInRoles();
		String submitRole_expectedUrl = "http://103.50.162.196/testing/role.php";
		String submitRole_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(submitRole_actualUrl, submitRole_expectedUrl);
		
	}
	
	
	@Test(groups = {"Regression","Sanity","Smoke"},description = "verify click on cancle button it will reset the upadted data ")
	public void verifyCancelButtonInAddRole() {
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		role.clickOnRolesUnderSetup();
		LOG.info("Click on Add Role Button on Roles Page");
		Roles.clickOnAddRole();
		LOG.info("Enter new Role in Role Name");
		Roles.enterTextInRoleName();
		LOG.info("Set all permission to Role");
		Roles.permissions();
		LOG.info("Click on Cancle button After setting permissions to Role");
		Roles.clickOnCancleInRoles();
		LOG.info("Click on View Role Button on view Role page");
		Roles.clickOnViewRole();
		String viewRole_expectedUrl = "http://103.50.162.196/testing/role.php";
		String viewRole_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(viewRole_actualUrl, viewRole_expectedUrl);
		
	}
	
	
	@Test(groups = {"Regression","Sanity","Smoke"},description ="To verify copy button on roles page")
	public void verifyCopyButtonOnRoles() {
		String index_expectedUrl = "http://103.50.162.196/testing/index.php";
		String index_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(index_actualUrl, index_expectedUrl);
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		Roles.clickOnRolesUnderSetup();
		String roles_expectedUrl = "http://103.50.162.196/testing/role.php";
		String roles_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(roles_actualUrl, roles_expectedUrl);
		LOG.info("Performed click operation on copy button on Role page" );
		Roles.clickOnCopyInRoles();
	}
	
	
	@Test(groups = {"Regression","Sanity","Smoke"},description = "To verify Excel button on roles page")
	public void verifyExcelButtonOnRoles() {
		String index_expectedUrl = "http://103.50.162.196/testing/index.php";
		String index_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(index_actualUrl, index_expectedUrl);
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		Roles.clickOnRolesUnderSetup();
		String roles_expectedUrl = "http://103.50.162.196/testing/role.php";
		String roles_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(roles_actualUrl, roles_expectedUrl);
		LOG.info("Performed click operation on copy button on Role page" );
		Roles.clickOnExcelInRoles();
	}
	
	@Test(groups = {"Regression","Sanity","Smoke"},description ="To verify CSV button on roles page")
	public void verifyCSVButtonOnRoles() {
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		Roles.clickOnRolesUnderSetup();
		Roles.clickOnCSVInRoles();
	}
	
	
	@Test(groups = {"Regression","Sanity","Smoke"},description = "To verify PDF button on roles page")
	public void verifyPDFButtonOnRoles() {
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		Roles.clickOnRolesUnderSetup();
		LOG.info("Performed click operation on copy button on Role page" );
		Roles.clickOnPDFInRoles();
	}
	
	
	@Test(groups = {"Regression","Sanity","Smoke"},description = "To verify Print button on roles page")
	public void verifyPrintButtonOnRoles() {
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		Roles.clickOnRolesUnderSetup();
		LOG.info("Performed click operation on copy button on Role page" );
		Roles.clickOnPrintInRoles();
	}
	
	
	@Test(groups = {"Regression","Sanity","Smoke"},description = "To verify Search box on Roles Page")
	public void verifySearchBoxOnRoles() {
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		Roles.clickOnRolesUnderSetup();
		LOG.info("Searching role in Roles page");
		Roles.enterTextInSearchBoxInRole();
		
	}
	
	@Test(groups = {"Regression","Sanity","Smoke"},description = "To verify Edit icon in Actions on Roles Page")
	public void verifyEditIconInActionsOnRoles() {
		
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		Roles.clickOnRolesUnderSetup();
		LOG.info("Click on edit icon in roles page");
		Roles.clickOnEditIconInRole();
		LOG.info("Re-enter new Role in Role Name");
		Roles.enterTextInRoleName();
		LOG.info("Set new permission to Re-enter Role");
		Roles.permissions();
		LOG.info("Click on submit button After setting permissions to Role");
		Roles.clickOnSubmitInRoles();
		String edit_submit_expectedUrl = "http://103.50.162.196/testing/role.php";
		String edit_submit_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(edit_submit_actualUrl, edit_submit_expectedUrl);
		
	}
	
	@Test(groups = {"Regression","Sanity","Smoke"},description = "To verify delete icon in Actions on Roles Page")
	public void verifyDeleteIconInActionsOnRoles() {
		LOG.info("Home Page -- Performing Mouse hover to setUp");
		Roles.mouseHoverToSetUp();
		LOG.info("Click on Roles under Setup");
		Roles.clickOnRolesUnderSetup();
		LOG.info("Click on delete icon in roles page");
		Roles.clickOnDeleteIconInRole();
		LOG.info("Role get deleted");
		
	}
}

	

