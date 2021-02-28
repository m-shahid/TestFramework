package com.bhiman.main.masters;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.bhiman.main.Constants;
import com.bhiman.main.UIKeywords;

public class Brokers extends UIKeywords{
	private static final Logger LOG = Logger.getLogger(Brokers.class);
	// Page Object Locators for Banks page in Masters --> Intialize at runtime
	
	public Brokers() {
		PageFactory.initElements(Constants.driver, this);
	}

	@FindBy(xpath = "//span[text()='Masters']")
	private static WebElement masters;

	@FindBy(xpath = "//a[text()='Brokers']")
	private static WebElement brokers;

	@FindBy(css = "#add_btn")
	private static WebElement brokersAdd_broker;

	@FindBy(xpath = "//span[text()='Copy']")
	private static WebElement brokersCopy;

	@FindBy(xpath = "//span[text()='Excel']")
	private static WebElement brokersExcel;

	@FindBy(xpath = "//span[text()='CSV']")
	private static WebElement brokersCSV;

	@FindBy(xpath = "//span[text()='PDF']")
	private static WebElement brokersPDF;

	@FindBy(xpath = "//span[text()='Print']")
	private static WebElement brokersPrint;

	@FindBy(xpath = "//input[@type='search']")
	private static WebElement brokersSearchbox;
	
	@FindBy(xpath = "//td[text() = 'No matching records found']")
	private static WebElement brokersNoRecords;

	@FindBy(xpath = "//div[@class='dataTables_scrollBody']")
	private static WebElement brokersTableScroll;

	//Needs to edit XPATH as it works for 1st entry only.
	@FindBy(xpath="//button[@data-brokerid='1']")  
	private static WebElement brokesIdView;

	//Needs to edit XPATH as it works for 1st entry only.
	@FindBy(xpath = "//button[@class='btn btn-success btn-border btn-rounded btn-xs editBtn']")
	private static WebElement brokersIdEdit;
	
	//Needs to edit XPATH as it works for 1st entry only.
	@FindBy(xpath= "//button[@class='btn btn-danger btn-border btn-rounded btn-xs deleteBtn']") 
	private static WebElement brokersIdDelet;

	// Page Object Locators after click on Add Broker button in Brokers page

	@FindBy(xpath = "//a[text()='View Broker']")
	private static WebElement brokersView_brokers;

	@FindBy(name="broker_name")
	private static WebElement brokersBroker_name;
	
	@FindBy(name="mobile_no")
	private static WebElement brokersMobile_no;
	
	@FindBy(xpath="//input[@id='broker_address']")
	private static WebElement brokersBroker_address;
	
	@FindBy(xpath="//input[@id='joining_date']")
	private static WebElement brokersJoining_date;
	
	@FindBy(xpath="//select[@id='blood_group']")
	private static WebElement brokersBlood_group;
	
	@FindBy(name="//select[@id='status']")
	private static WebElement brokersStatus;
	
	@FindBy(name = "bank_name")
	private static WebElement brokersBank_name;

	@FindBy(name = "account_no")
	private static WebElement brokersAccount_no;

	@FindBy(xpath = "//input[@id='ifsc_code']")
	private static WebElement BrokersIFSC_code;
	
	@FindBy(xpath="//input[@id='resume']")
	private static WebElement brokersResume;
	
	@FindBy(name="agreement")
	private static WebElement brokersAgreement;
	
	@FindBy(name="kyc")
	private static WebElement brokersKYC;
	
	@FindBy(xpath = "//input[@value = 'Submit']")
	private static WebElement brokersSubmit;

	@FindBy(xpath = "//input[@value = 'Cancel']")
	private static WebElement brokersCancel;

	// Page Object Methods for Brokers page in Masters
	
	
	
		public void mouseHoverToMastersForBrokersPage() throws InterruptedException {
			LOG.info("Master->Brokers: Mouse Hover to Masters");
			UIKeywords.mouseHover(masters);
			Thread.sleep(1000);
			//UIKeywords.clickOnElement(brokers);
		}
		
		public void clickOnBrokers() {
			LOG.info("Master->Brokers: Click on Brokers option under Masters");
			clickOnElement(brokers);
		}
		
		public void clickOnCopyAtBrokersPage() {
			LOG.info("Master->Brokers: Click on Copy Button");
			clickOnElement(brokersCopy);
		}
		
		public void clickOnExcelBtnAtBrokersPage() {
			LOG.info("Master->Brokers: Click on EXCEL Button");
			clickOnElement(brokersExcel);
		}
		
		public void clickOnCSVBtnAtBrokersPage() {
			LOG.info("Master->Brokers: Click on CSV Button");
			clickOnElement(brokersCSV);
		}
		
		public void clickOnPDFBtnAtBrokersPage() {
			LOG.info("Master->Brokers: Click on PDF Button");
			clickOnElement(brokersPDF);
		}
		
		public void clickOnPrintBtnAtBrokersPage() {
			LOG.info("Master->Brokers: Click on Print Button");
			clickOnElement(brokersPrint);
		}
		
		public void enterTextInSearchBox(String enterText) {
			LOG.info("Entering text on search box of Banks page");
			UIKeywords.enterText(brokersSearchbox, enterText);
		}
		
		public String getTextForInvalidBrokersSearch() {
			LOG.info("Reading text from bank data table for invalid search of Banks page");
			return UIKeywords.getText(brokersNoRecords);
		}
		public void clickOnAddBroker() {
			LOG.info("Master->Brokers: Clicking on Add Broker button of Brokers page");
			clickOnElement(brokersAdd_broker);
		}
		
		public void clickOnViewBrokers() {
			LOG.info("Master->Brokers: Click on View Brokers button of Add Broker page.");
			clickOnElement(brokersView_brokers);
		}
		
		public void attachResume() {
			LOG.info("Attaching Resume to Add Broker form");
			brokersResume.sendKeys("F:\\Bhiman Requirements\\RESUME.docx");
		}
		
		public void attachAgreement() {
			LOG.info("Attaching Resume to Add Broker form");
			brokersAgreement.sendKeys("F:\\Bhiman Requirements\\Agreement.docx");
		}
		
		public void attachKYC() {
			LOG.info("Attaching KYC to Add Broker form");
			brokersKYC.sendKeys("F:\\Bhiman Requirements\\KYC.docx");
		}
		public void fillAddBrokerForm() {
			LOG.info("Adding values to Add Broker form");
			UIKeywords.enterText(brokersBroker_name, "Abhay");
			UIKeywords.enterText(brokersMobile_no, "8765432109");
			UIKeywords.enterText(brokersBroker_address, "Amravati");
			UIKeywords.enterText(brokersJoining_date,"24-02-2021");
			UIKeywords.enterText(brokersBlood_group, "B positive");
			UIKeywords.enterText(brokersStatus, "Active");
			attachResume();
			attachAgreement();
			attachKYC();
			LOG.info("Values added to Add Broker form");
		}
		
		public void clickOnSubmit() {
			LOG.info("Master->Brokers: Click on Submit button of Add Broker page.");
			UIKeywords.clickOnElement(brokersSubmit);
		}
		
		
		
		public void clickOnCancel() {
			LOG.info("Master->Brokers: Click on Cancel button of Add Broker page.");
			UIKeywords.clickOnElement(brokersCancel);
		}
		
}