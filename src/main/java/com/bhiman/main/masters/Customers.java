package com.bhiman.main.masters;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhiman.main.Constants;
import com.bhiman.main.UIKeywords;

public class Customers extends UIKeywords{
	private static final Logger LOG = Logger.getLogger(Enquiry.class);
	public static final Integer SRNO_COLUMN = 1;
	public static final Integer CUSTOMER_NAME_COLUMN = 2;
	public static final Integer MOBILE_NO_COLUMN = 3;
	public static final Integer DOB_COLUMN = 4;
	public static final Integer ANNIVERSARY_COLUMN = 5;
	public static final Integer EMAIL_COLUMN = 6;
	public static final Integer ACTION_COLUMN = 7;
	
	public Customers(){
		PageFactory.initElements(Constants.driver, this);
	}
	
	
	//  Locators for Enquire page in Masters 
		
		@FindBy(xpath ="//span[text()='Masters']")			 
		private static WebElement masters;
		
		@FindBy(xpath ="//a[text()='Customers']")
		private static WebElement customers;
		
		   //Locator for  After click on Add Button in Enquire valid page .
		@FindBy(id="add_btn")
		private static WebElement addButton;
		
		@FindBy(id="customer_name")
		private static WebElement nameInputBox;
		
		@FindBy(id="mobile_no")
		private static WebElement mobileNumberInputBox;
		
		@FindBy(id="email")
		private static WebElement emailInputBox;
		
		@FindBy(id="address")
		private static WebElement addressInputBox;
		
		@FindBy(name="state")
		private static WebElement stateInputBox;
		
		@FindBy(id="district")
		private static WebElement districtInputBox;
		
		@FindBy(id="taluka")
		private static WebElement talukaInputBox;
		
		@FindBy(name="city")
		private static WebElement cityInputBox;
		
		@FindBy(name="pincode")
		private static WebElement pincodeInputBox;
		
		@FindBy(id="birth_date")
		private static WebElement dobInputBox;
		
		@FindBy(id="anniversary_date")
		private static WebElement anniversaryDateInputBox;
		
		@FindBy(name="occupation")
		private static WebElement occupationInputBox;
		
		@FindBy(name="add_customer")
		private static WebElement submitCustomerButton;
		
		@FindBy(id="Reset")
		private static WebElement cancelCustomerButton;
		
		@FindBy(xpath="//*[text()='OK']")
		private static WebElement okButton;
		
		@FindBy(xpath = "//*[@id='datatable3']")
		private static WebElement customerTable;
		
		@FindBy(xpath = "//*[@id='datatable3']/tbody/tr")
		private static List<WebElement> customerTableRows;
		
		@FindBy(xpath = "//*[@id='datatable3']/tbody/tr[1]/td")
		private static List<WebElement> customerTableColumns;
		
		@FindBy(css = ".fa-eye")
		private static List<WebElement> viewCustomerIcons;
		
		@FindBy(css = ".fa-pencil")
		private static List<WebElement> editCustomerIcons;
		
		@FindBy(css = ".fa-trash")
		private static List<WebElement> deleteCustomerIcons;
		
//-------------------invalid Mobile number locator-------------------------------------------------------------
		
		@FindBy(id="customer_name-error")
		private static WebElement invalidNameError;
		
		@FindBy(id="mobile_no-error")
		private static WebElement invalidMobileNumberError;
		
		@FindBy(css=".swal2-content")
		private static WebElement invalidStartsWithMobileNumberError;
		
		@FindBy(id="email-error")
		private static WebElement invalidEmailError;
		
		@FindBy(id="address-error")
		private static WebElement invalidAddressError;
		
		@FindBy(id="state-error")
		private static WebElement invalidStateError;
		
		@FindBy(id="district-error")
		private static WebElement invalidDistrictError;
		
		@FindBy(id="taluka-error")
		private static WebElement invalidTalukaError;
		
		@FindBy(id="city-error")
		private static WebElement invalidCityError;
		
		@FindBy(id="birth_date-error")
		private static WebElement invalidDOBError;
		
		@FindBy(id="anniversary_date-error")
		private static WebElement invalidAnniversaryError;
		
		@FindBy(id="occupation-error")
		private static WebElement invalidOccupationError;
		
		
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
		private static WebElement searchInputBox;
		
		@FindBy(xpath = "//*[text()='Customer Deleted.']")
		private static WebElement recordDeletedLabel;
		
		
		
//---------------Method for Customer page in Masters----------------------------
		
		public void goToCustomerPage(){
			mouseHover(masters);
			clickOnElement(customers);
		}
		
		//When click on addButton Method
		public void clickOnAddCustomer(){
			clickOnElement(addButton);
		}
		
		public void enterName(String customerName){
			clearText(nameInputBox);
			enterText(nameInputBox, customerName);
		}
		
		public void enterMobileNumber(String mobileNo){
			clearText(mobileNumberInputBox);
			enterText(mobileNumberInputBox, mobileNo);
		}
		
		public void enterEmail(String emailId){
			clearText(emailInputBox);
			enterText(emailInputBox, emailId);
		}
		
		public void enterAddress(String address){
			clearText(addressInputBox);
			enterText(addressInputBox, address);
		}
		
		public void enterState(String state){
			clearText(stateInputBox);
			enterText(stateInputBox, state);
		}
		
		public void enterDistrict(String district){
			clearText(districtInputBox);
			enterText(districtInputBox, district);
		}
		
		public void enterTaluka(String taluka){
			clearText(talukaInputBox);
			enterText(talukaInputBox, taluka);
		}
		
		public void enterCity(String city){
			clearText(cityInputBox);
			enterText(cityInputBox, city);
		}
		
		public void enterPinCode(String pinCode){
			clearText(pincodeInputBox);
			enterText(pincodeInputBox, pinCode);
		}
		
		public void selectDob(String dob) {
			clearText(dobInputBox);
			enterText(dobInputBox, dob);
		}
		
		public void selectAnniversary(String anniversary) {
			clearText(anniversaryDateInputBox);
			enterText(anniversaryDateInputBox, anniversary);
		}
		
		public void enterOccupation(String occupation){
			clearText(occupationInputBox);
			enterText(occupationInputBox, occupation);
		}
		
		
		public void submit(){
			scrollVerticalDown(submitCustomerButton);
			clickOnElement(submitCustomerButton);
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

		public boolean isAddCustomerButtonDisplayed() {
			return isElementDisplayed(addButton);
		}

		public boolean isCustomerTableDispalyed() {
			return isElementDisplayed(customerTable);
		}

		public void clickOnEditCustomerIcon(int tableSrNo) {
			// list starts with 0 and table sr no starts with 1, hence decrementing sr.no by 1
			clickOnElement(editCustomerIcons.get(--tableSrNo));
		}

		public void clickOnDeleteCustomerIcon(int tableSrNo) {
			// list starts with 0 and table sr no starts with 1, hence decrementing sr.no by 1
			clickOnElement(deleteCustomerIcons.get(--tableSrNo));
		}

		public void acceptDeleteCustomerAlert() {
			Constants.driver.switchTo().alert().accept();
			
		}

		public boolean isRecordDeletedPopUpDislpayed() {
			return (isElementDisplayed(recordDeletedLabel) && isElementDisplayed(okButton));
		}
		
		public void enterTextIntoSearchBox(String searchText) {
			clearText(searchInputBox);
			enterText(searchInputBox, searchText);
		}
		
		public Integer getTableRowCount() {
			return customerTableRows.size();
		}
		
		public Integer getTableColumnCount() {
			return customerTableColumns.size();
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
		
		public String getEmailValidationError() {
			return getText(invalidEmailError).trim();
		}
		
		public String getAddressValidationError() {
			return getText(invalidAddressError).trim();
		}
		
		
		public String getStateValidationError() {
			return getText(invalidStateError).trim();
		}
		
		public String getDistrictValidationError() {
			return getText(invalidDistrictError).trim();
		}
		
		public String getTalukaValidationError() {
			return getText(invalidTalukaError).trim();
		}
		
		public String getCityValidationError() {
			return getText(invalidCityError).trim();
		}
		
		public String getDobValidationError() {
			return getText(invalidDOBError).trim();
		}
		
		public String getAnniversaryValidationError() {
			return getText(invalidAnniversaryError).trim();
		}
		
		public String getOccupationValidationError() {
			return getText(invalidOccupationError).trim();
		}


}
