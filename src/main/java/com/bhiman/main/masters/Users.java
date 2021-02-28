package com.bhiman.main.masters;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhiman.main.Constants;
import com.bhiman.main.UIKeywords;
import com.bhiman.main.WaitsInHelp;

public class Users extends UIKeywords {
	private static final Logger LOG = Logger.getLogger(Banks.class);

	// Page Object Locators for Users page in Masters ******************Initialize
	// at runtime*****************

	@FindBy(xpath = "//i[@class='fa fa-database']")
	private static WebElement mastersforuser;

	@FindBy(xpath = "//a[normalize-space(text())='Users']")
	private static WebElement users;

	@FindBy(css = "#add_btn")
	private static WebElement add_users;

	@FindBy(css = "#view_btn")
	private static WebElement view_users;
	
	@FindBy(xpath="//span[text()='Copy']")
	private static WebElement U_copyBtn;
	
	@FindBy(xpath="//span[text()='Excel']")
	private static WebElement U_excelBtn;
	
	@FindBy(xpath="//span[text()='CSV']")
	private static WebElement U_csvBtn;
	
	@FindBy(xpath="//span[text()='PDF'")
	private static WebElement U_pdfBtn;
	
	@FindBy(xpath="//span[text()='Print']")
	private static WebElement U_printBtn;
	
	@FindBy(xpath="//input[@type='search']")
	private static WebElement U_searchBox;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollBody']")
	private static WebElement User_scrollVerticalTableBody;
	
	@FindBy(css = "#datatable3_info")
	private static WebElement U_datatableInfo_showing_entries;
	
	@FindBy(xpath = "//td[text() = 'No matching records found']")
	private static WebElement U_table_noRecords;

	@FindBy()
	private static WebElement action_view_icon;

	@FindBy()
	private static WebElement action_edit_icon;

	@FindBy()
	private static WebElement action_delete_icon;

	// ******************Page Object Locators after click on AddUsers button in
	// Users page******************
	@FindBy(css = "user_name")
	private static WebElement U_name;

	@FindBy(css = "#mobile_no")
	private static WebElement U_mobile_no;

	@FindBy(css = "#email")
	private static WebElement U_email;

	@FindBy(css = "#role_id")
	private static WebElement U_role;


	@FindBy(css = "#joining_date")
	private static WebElement U_joining_date;

	@FindBy(css = "#blood_group")
	private static WebElement U_blood_group;


	@FindBy(css = "#bank_name")
	private static WebElement U_bank_name;

	@FindBy(css = "#account_no")
	private static WebElement U_account_no;

	@FindBy(css = "#ifsc_code")
	private static WebElement U_ifsc_code;

	@FindBy(xpath = "//input[@placeholder='Upload Resume']")
	private static WebElement U_resume;

	@FindBy(xpath = "//input[@placeholder='Upload Agreement']")
	private static WebElement U_agreement;

	@FindBy(xpath = "//input[@placeholder='Upload KYC']")
	private static WebElement U_kyc;

	@FindBy(css = "#father_name")
	private static WebElement U_father_name;

	@FindBy(css = "#father_mobile_no")
	private static WebElement U_father_mobile_no;

	@FindBy(css = "#father_occupation")
	private static WebElement U_father_occupation;

	@FindBy(css = "#status")
	private static WebElement U_status;

	@FindBy(xpath = "//select[@id='status']//option[text()='Active']")
	private static WebElement U_status_active;

	@FindBy(xpath = "//select[@id='status']//option[text()='In-Active']")
	private static WebElement U_status_in_active;

	@FindBy(css = "#password")
	private static WebElement U_password;

	@FindBy(css = "#confirm_password")
	private static WebElement U_confirm_password;

	@FindBy(xpath = "//input[@value='Submit']")
	private static WebElement U_submit;

	@FindBy(xpath = "//input[@value='Cancel']")
	private static WebElement U_cancel;

	// constructor

	public Users() {
		PageFactory.initElements(Constants.driver, this);
	}
	// ***********Page Object Methods for Users page in Masters******************
	public static void clickOnUserCopyButton() {
		LOG.info("Click on Copy button of User page");
		WaitsInHelp.implicitWaitInSeconds(10);
		UIKeywords.clickOnElement(U_copyBtn);
	}
	
	public static void clickOnExcelButton() {
		LOG.info("Click on Excel button of User page");
		UIKeywords.clickOnElement(U_excelBtn);
	}

	public static void clickOnCSVButton() {
		LOG.info("Click on CSV button of User page");
		UIKeywords.clickOnElement(U_csvBtn);
	}

	public static void clickOnPDFButton() {
		LOG.info("Click on PDF button of User page");
		UIKeywords.clickOnElement(U_pdfBtn);
	}

	public static void clickOnPrintButton() {
		LOG.info("Click on Print button of User page");
		UIKeywords.clickOnElement(U_printBtn);
	}
	
	public void sarchonUsersSearchBox(String enter_text ) {
		LOG.info("Search an user Entery on user page");
		UIKeywords.enterText(U_searchBox, enter_text);
	}
	public static void clickonMaster() {
		UIKeywords.clickOnElement(mastersforuser);

	}

	public static void mouseHoverToMastersforuser() {
		LOG.info("Mouse Hover to mastersforuser");
		UIKeywords.mouseHover(mastersforuser);
	}

	public static void clickOnUsers() {
		LOG.info("Click on users option under Masters");
		UIKeywords.clickOnElement(users);
	}

	public static void clickOnAddUsers() {
		LOG.info("Click on Add users button of Users page");
		WaitsInHelp.implicitWaitInSeconds(10);
		UIKeywords.clickOnElement(add_users);
	}

	public static void clickOnViewUsers() {
		LOG.info("Click on View users button of Add Users page.");
		UIKeywords.clickOnElement(view_users);
	}

	public static void enterUserName(String UserNamr) {
		LOG.info("Enter User name.");
		UIKeywords.enterText(U_name, UserNamr);
	}

	public static void enterMobileNo(String UserMobileNo) {
		LOG.info("Enter User Mobile no.");
		UIKeywords.enterText(U_mobile_no, UserMobileNo);
	}

	public static void enterEmailId(String UserEmailId) {
		LOG.info("Enter user mail-id");
		UIKeywords.enterText(U_email, UserEmailId);
	}

	public static void selectRoleforUser(String selectUserRole) {
		LOG.info("Click on Role and select");
		UIKeywords.selectByTextFromDropdown(U_role, selectUserRole);
	}

	public static void enterJoiningDate(String enterJoiningDate) {
		LOG.info("Enter joining Date");
		UIKeywords.enterText(U_joining_date, enterJoiningDate);
	}

	public static void selectBloodGroup(String selectBloodGroup) {
		LOG.info("Click on Bloodgroup and select ");
		UIKeywords.selectByTextFromDropdown(U_blood_group, selectBloodGroup);
	}

	public static void enterBankName(String enterBankName) {
		LOG.info("Enter Bank Name");
		UIKeywords.enterText(U_bank_name, enterBankName);
	}

	public static void enterAccountNo(String enterAccountNo) {
		LOG.info("Enter Bank Account Name");
		UIKeywords.enterText(U_account_no, enterAccountNo);
	}

	public static void enterIFSCcode(String enterIFSCcoad) {
		LOG.info("Enter Bank IFSC coad");
		UIKeywords.enterText(U_ifsc_code, enterIFSCcoad);
	}

	public static void uploadUserResumeDoc(String filepathforUploadResume) {
		LOG.info("Scroll vertically down upto the visibility of other element.");
		UIKeywords.scrollVerticalDown(U_resume);
		LOG.info("define the File path to upload a Resume doc.");
		UIKeywords.enterText(U_resume, filepathforUploadResume);
	}

	public static void uploadUserAgreementDoc(String filepathforUploadAgreement) {
		LOG.info("Upload user Agreement");
		UIKeywords.enterText(U_agreement, filepathforUploadAgreement);
	}

	public static void uploaduserKYCDoc(String filepathforUploadKYCDoc) {
		LOG.info("Upload user KYC");
		UIKeywords.enterText(U_kyc, filepathforUploadKYCDoc);
	}

	public static void enterFatherName(String enterFatherName) {
		LOG.info("Enter father name");
		UIKeywords.enterText(U_father_name, enterFatherName);
	}
	public static void enterFatherMobileNo(String entrFatherMobileNo) {
		LOG.info("Enter Father mobile No");
		UIKeywords.enterText(U_father_mobile_no, entrFatherMobileNo);
	}
	public static void enterFatherOccupation(String enterFatherOccupition) {
		LOG.info("Enter Father occupation");
		UIKeywords.enterText(U_father_occupation, "Worker");
	}
	public static void selectUserStatus(String selectUserStatus) {
		LOG.info("select user status");
		UIKeywords.selectByTextFromDropdown(U_status, selectUserStatus);
	}
	public static void enterPassword(String enterPassword) {
		LOG.info("enter password");
		UIKeywords.enterText(U_password, enterPassword);
	}
	public static void enterConfirmPassword(String enterConfirmPassword) {
		UIKeywords.enterText(U_confirm_password, enterConfirmPassword);
	}

	public static void clickOnUserSubmit() {
		LOG.info("Click on Submit button of Add Users page.");
		UIKeywords.clickOnElement(U_submit);
	}
	public String getTextOFUserDataTableForInvalidSearch() {
		LOG.info("Reading text from Users data table for invalid search of Users page");
		return UIKeywords.getText(U_table_noRecords);
	}


	public static void clickOnUserCancel() {
		LOG.info("Click on Cancel button of Add Users page.");
		UIKeywords.clickOnElement(U_cancel);
	}

}
