package com.bhiman.main.masters;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhiman.main.Constants;
import com.bhiman.main.UIAlerts;
import com.bhiman.main.UIKeywords;

public class Enquiry extends UIKeywords{
	private static final Logger LOG = Logger.getLogger(Enquiry.class);
	public static final Integer SRNO_COLUMN = 1;
	public static final Integer NAME_COLUMN = 2;
	public static final Integer MOBILE_NO_COLUMN = 3;
	public static final Integer PURPOSE_COLUMN = 4;
	public static final Integer REFERENCE_COLUMN = 5;
	public static final Integer ACTION_COLUMN = 6;
	
	public Enquiry(){
		PageFactory.initElements(Constants.driver, this);
	}
	
	
	//  Locators for Enquire page in Masters 
		
		@FindBy(xpath ="//span[text()='Masters']")			 
		private static WebElement masters;
		
		@FindBy(xpath ="//a[text()='Enquiry']")
		private static WebElement enquiry;
		
		   //Locator for  After click on Add Button in Enquire valid page .
		@FindBy(id="add_btn")
		private static WebElement addButton;
		
		@FindBy(id="name")
		private static WebElement name;
		
		@FindBy(id="mobile_no")
		private static WebElement mobileNumber;
		
		@FindBy(id="purpose")
		private static WebElement purpose;
		
		@FindBy(id="reference")
		private static WebElement reference;
		
		@FindBy(name="enquiry_add")
		private static WebElement submitEnquiryButton;
		
		@FindBy(name="//input[@value='Cancel']")
		private static WebElement cancelEnquiryButton;
		
		@FindBy(xpath="//*[text()='OK']")
		private static WebElement okButton;
		
		@FindBy(xpath = "//*[@id='datatable3']")
		private static WebElement enquiryTable;
		
		@FindBy(xpath = "//*[@id='datatable3']/tbody/tr")
		private static List<WebElement> enquiryTableRows;
		
		@FindBy(xpath = "//*[@id='datatable3']/tbody/tr[1]/td")
		private static List<WebElement> enquiryTableColumns;
		
		@FindBy(css = ".fa-pencil")
		private static List<WebElement> editEnquiryIcons;
		
		@FindBy(css = ".fa-trash")
		private static List<WebElement> deleteEnquiryIcons;
		
//-------------------invalid error locator-------------------------------------------------------------
		
		@FindBy(id="name-error")
		private static WebElement invalidNameError;
		
		@FindBy(id="mobile_no-error")
		private static WebElement invalidMobileNumberError;
		
		@FindBy(css=".swal2-content")
		private static WebElement invalidStartsWithMobileNumberError;
		
		@FindBy(id="purpose-error")
		private static WebElement invalidPurposeError;
		
		@FindBy(id="reference-error")
		private static WebElement invalidReferenceError;
		
//--------------------------------------------------------------------------------------		
		//Locator for enquire homePage on button(Copy,Excel,Csv,Pdf,Print)
		@FindBy(xpath = "//span[text()='Copy']")
		private static WebElement copyButton;

		@FindBy(xpath = "//span[text()='Excel']")
		private static WebElement excelButton;

		@FindBy(xpath = "//span[text()='CSV']")
		private static WebElement csvButton;

		@FindBy(xpath = "//span[text()='PDF']")
		private static WebElement pdfButton;

		@FindBy(xpath = "//span[text()='Print']")
		private static WebElement printButton;
		
		
//----------------Search button-------------------------------------------------------------------
		@FindBy(xpath = "//input[@type='search']")
		private static WebElement searchTextBox;
		
		@FindBy(xpath = "//*[text()='Record Deleted.']")
		private static WebElement recordDeletedLabel;
		
		
		
//---------------Method for Enquire page in Masters----------------------------
		
		public void goToEnquiryPage(){
			mouseHover(masters);
			clickOnElement(enquiry);
		}
		
		//When click on addButton Method
		public void clickOnAddEnquiry(){
			clickOnElement(addButton);
		}
		
		public void enterName(String username){
			clearText(name);
			enterText(name, username);
		}
		
		public void enterMobileNumber(String mobileNo){
			clearText(mobileNumber);
			enterText(mobileNumber, mobileNo);
		}
		
		public void enterPurpose(String purposeText){
			clearText(purpose);
			enterText(purpose, purposeText);
		}
		
		public void enterReference(String referenceText){
			clearText(reference);
			enterText(reference, referenceText);
		}
		
		public void submit(){
			clickOnElement(submitEnquiryButton);
		}
		
		public void clickOnOkButton(){
			clickOnElement(okButton);
		}
		
		public void clickOnCancelButton(){
			clickOnElement(okButton);
		}
		
		public void clickOnCopyButton(){
			clickOnElement(copyButton);
		}
		
		public Boolean isCopyButtonDisplayed(){
			return isElementDisplayed(copyButton);
		}
		
		public void clickOnExcelButton(){
			clickOnElement(excelButton);
		}
		
		
		public Boolean isExcelButtonDisplayed(){
			return isElementDisplayed(excelButton);
		}
		
		public void clickOnCSVButton(){
			clickOnElement(csvButton);
		}
		
		public Boolean isCsvButtonDisplayed(){
			return isElementDisplayed(csvButton);
		}
		
		public void clickOnPDFButton(){
			clickOnElement(pdfButton);
		}
		
		public Boolean isPdfButtonDisplayed(){
			return isElementDisplayed(pdfButton);
		}
		
		public void clickOnPrintButton(){
			clickOnElement(printButton);
		}
		
		public Boolean isPrintButtonDisplayed(){
			return isElementDisplayed(printButton);
		}

		public boolean isAddEnquiryButtonDisplayed() {
			return isElementDisplayed(addButton);
		}

		public boolean isEnquiryTableDispalyed() {
			return isElementDisplayed(enquiryTable);
		}

		public void clickOnEditEnquiryIcon(int tableSrNo) {
			// list starts with 0 and table sr no starts with 1, hence decrementing sr.no by 1
			clickOnElement(editEnquiryIcons.get(--tableSrNo));
		}

		public void clickOnDeleteEnquiryIcon(int tableSrNo) {
			// list starts with 0 and table sr no starts with 1, hence decrementing sr.no by 1
			clickOnElement(deleteEnquiryIcons.get(--tableSrNo));
		}

		public void acceptDeleteEnquiryAlert() {
			UIAlerts.acceptAlert();
		}

		public boolean isRecordDeletedPopUpDislpayed() {
			return (isElementDisplayed(recordDeletedLabel) && isElementDisplayed(okButton));
		}
		
		public void enterTextIntoSearchBox(String searchText) {
			clearText(searchTextBox);
			enterText(searchTextBox, searchText);
		}
		
		public Integer getTableRowCount() {
			return enquiryTableRows.size();
		}
		
		public Integer getTableColumnCount() {
			return enquiryTableColumns.size();
		}
		
		public String getTableData(int row, int column) {
			return Constants.driver.findElement(By.xpath("//*[@id='datatable3']/tbody/tr["+row+"]/td["+column+"]")).getText();
		}
		
		public String getNameValidationError() {
			return getText(invalidNameError).trim();
		}
		
		public String getMobileNumberValidationError() {
			return getText(invalidMobileNumberError).trim();
		}
		
		public String getStartsWithMobileNumberError() {
			return getText(invalidStartsWithMobileNumberError).trim();
		}
		
		public String getPurposeValidationError() {
			return getText(invalidPurposeError).trim();
		}
		
		public String getReferenceValidationError() {
			return getText(invalidReferenceError).trim();
		}

}
