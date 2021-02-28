package com.bhiman.main.setup;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bhiman.main.UIKeywords;


public class Roles extends UIKeywords {
	
private static final Logger LOG = Logger.getLogger(Roles.class);
	
	// Page Object Locators for Roles page in SetUp --> Intialize at runtime
	
	@FindBy(xpath = "//*[@id='respMenu']/li[8]/a/span[1]")			 
	private static WebElement setup;		
	
	@FindBy(css = "a[href='role.php']")
	private static WebElement roles_under_setup;
	
	@FindBy(css="a#add_btn")
	private static WebElement add_roleBtn;

	@FindBy(xpath="//*[text()='Copy']")
	private static WebElement role_copyBtn;
	
	@FindBy(xpath="//*[text()='Excel']")
	private static WebElement role_excelBtn;
	
	@FindBy(xpath="//*[text()='CSV']")
	private static WebElement role_csvBtn;
	
	@FindBy(xpath="//*[text()='PDF']")
	private static WebElement role_pdfBtn;
	
	@FindBy(xpath="//*[text()='Print']")
	private static WebElement role_printBtn;
	
	@FindBy(css="input[type='search']")
	private static WebElement role_searchTxtBx;
	
	@FindBy(xpath = " //*[@id=\"datatable3\"]/tbody/tr[1]/td[3]/button[1]/i")
	private static WebElement role_action_edit_icon;

	@FindBy(xpath = "//*[@id=\"datatable3\"]/tbody/tr[1]/td[3]/button[2]/i")
	private static WebElement role_action_delete_icon;
	
	// Page Object Locators after click on AddRole button in Roles page
	
	@FindBy(css="a#view_btn")
	private static WebElement view_roles;
	
	@FindBy(css="input#role_name")
	private static WebElement role_name;
	
	@FindBy(xpath="//label[@for='dashboard']")
	private static WebElement dashboard;
	
	@FindBy(xpath="//label[@for='banks']")
	private static WebElement banks;
	
	@FindBy(xpath="//label[@for='users']")
	private static WebElement users;
	
	@FindBy(xpath="//label[@for='branches']")
	private static WebElement branches;
	
	@FindBy(xpath="//label[@for='customers']")
	private static WebElement customers;
	
	@FindBy(xpath="//label[@for='brokers']")
	private static WebElement brokers;
	
	@FindBy(xpath="//label[@for='vendors']")
	private static WebElement vendors;
	
	@FindBy(xpath="//label[@for='enquiry']")
	private static WebElement enquiry;
	
	@FindBy(xpath="//label[@for='projects']")
	private static WebElement projects;
	
	@FindBy(xpath="//label[@for='sales']")
	private static WebElement sales;
	
	@FindBy(xpath="//label[@for='plot_registration']")
	private static WebElement plot_registration;
	
	@FindBy(xpath="//label[@for='receipts']")
	private static WebElement receipts;
	
	@FindBy(xpath="//label[@for='expenses']")
	private static WebElement expenses;
	
	@FindBy(xpath="//label[@for='materials']")
	private static WebElement materials;
	
	@FindBy(xpath="//label[@for='pending_transactions']")
	private static WebElement pending_transactions;
	
	@FindBy(xpath="//label[@for='luckydraw']")
	private static WebElement luckydraw;
	
	@FindBy(xpath="//label[@for='sms']")
	private static WebElement sms;
	
	@FindBy(xpath="//label[@for='ledger_report']")
	private static WebElement ledger_report;
	
	@FindBy(xpath="//label[@for='customer_birthday_report']")
	private static WebElement customer_birthday_report;
	
	@FindBy(xpath="//label[@for='customer_anniversary_wishin_report']")
	private static WebElement customer_anniversary_wishin_report;
	
	@FindBy(xpath="//label[@for='customer_payment_status_report']")
	private static WebElement customer_payment_status_report;
	
	@FindBy(xpath="//label[@for='plot_status_report']")
	private static WebElement plot_status_report;
	
	@FindBy(xpath="//label[@for='income_plot_transaction_report']")
	private static WebElement income_plot_transaction_report;
	
	@FindBy(xpath="//label[@for='expense_report']")
	private static WebElement expense_report;
	
	@FindBy(xpath="//label[@for='transaction_report']")
	private static WebElement transaction_report;
	
	@FindBy(xpath="//label[@for='log_report']")
	private static WebElement log_report;
	
	@FindBy(xpath="//label[@for='roles']")
	private static WebElement roles;
	
	@FindBy(css = "input[type='submit']")
	private static WebElement submit;
	
	@FindBy(css = "input[type='reset']")
	private static WebElement cancel;
	

	// Page Object Methods for Roles page in Setup
	
	public static void mouseHoverToSetUp() {
		LOG.info("Mouse Hover to Masters");
		UIKeywords.mouseHover(setup);
	}
	
	public static void clickOnRolesUnderSetup() {
		LOG.info("Click on Roles under SetUp");
		UIKeywords.clickOnElement(roles_under_setup);
	}
	
	public static void clickOnAddRole() {
		LOG.info("Click on Add Role on Roles Page");
		UIKeywords.clickOnElement(add_roleBtn);
	}
	
	public static void clickOnViewRole() {
		LOG.info("Click on View Role on Add Roles Page");
		UIKeywords.clickOnElement(roles_under_setup);
	}
	
	public static void enterTextInRoleName() {
		LOG.info("Enter the new Role in Role Name");
		UIKeywords.enterText(role_name, "Admin");
	}
	
	public static void permissions() {
		LOG.info("Set all permissions for Admin");
		UIKeywords.clickOnElement(dashboard);
		UIKeywords.clickOnElement(banks);
		UIKeywords.clickOnElement(users);
		UIKeywords.clickOnElement(branches);
		UIKeywords.clickOnElement(customers);
		UIKeywords.clickOnElement(brokers);
		UIKeywords.clickOnElement(vendors);
		UIKeywords.clickOnElement(enquiry);
		UIKeywords.clickOnElement(projects);
		UIKeywords.clickOnElement(sales);
		UIKeywords.clickOnElement(plot_registration);
		UIKeywords.clickOnElement(receipts);
		UIKeywords.clickOnElement(expenses);
		UIKeywords.clickOnElement(materials);
		UIKeywords.clickOnElement(pending_transactions);
		UIKeywords.clickOnElement(luckydraw);
		UIKeywords.clickOnElement(sms);
		UIKeywords.clickOnElement(customer_birthday_report);
		UIKeywords.clickOnElement(customer_anniversary_wishin_report);
		UIKeywords.clickOnElement(customer_payment_status_report);
		UIKeywords.clickOnElement(plot_status_report);
		UIKeywords.clickOnElement(income_plot_transaction_report);
		UIKeywords.clickOnElement(expense_report);
		UIKeywords.clickOnElement(transaction_report);
		UIKeywords.clickOnElement(log_report);
		UIKeywords.clickOnElement(roles);
	}
	
	public static void clickOnSubmitInRoles() {
		LOG.info("Click on View Role on Add Roles Page");
		UIKeywords.clickOnElement(submit);
	}
	
	public static void clickOnCancleInRoles() {
		LOG.info("Click on View Role on Add Roles Page");
		UIKeywords.clickOnElement(cancel);
	}
	
	public static void clickOnCopyInRoles() {
		LOG.info("Click on copy button on Roles page");
		UIKeywords.clickOnElement(role_copyBtn);
	}
	
	public static void clickOnExcelInRoles() {
		LOG.info("Click on Excel button on Roles page");
		UIKeywords.clickOnElement(role_excelBtn);
	}
	
	public static void clickOnCSVInRoles() {
		LOG.info("Click on CSV button on Roles page");
		UIKeywords.clickOnElement(role_csvBtn);
	}
	
	public static void clickOnPDFInRoles() {
		LOG.info("Click on PDF button on Roles page");
		UIKeywords.clickOnElement(role_pdfBtn);
	}
	
	public static void clickOnPrintInRoles() {
		LOG.info("Click on Print button on Roles page");
		UIKeywords.clickOnElement(role_printBtn);
	}
	
	public static void enterTextInSearchBoxInRole() {
		LOG.info("Enter the input in search box on Role page");
		UIKeywords.enterText(role_searchTxtBx, "Admin");
	}
	
	public static void clickOnEditIconInRole() {
		LOG.info("Editing the existing role");
		UIKeywords.clearText(role_action_edit_icon);
	}
	
	public static void clickOnDeleteIconInRole() {
		LOG.info("Deleting the existing role");
		UIKeywords.clearText(role_action_delete_icon);
	}
}


