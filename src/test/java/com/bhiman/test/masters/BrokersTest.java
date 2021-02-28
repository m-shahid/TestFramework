package com.bhiman.test.masters;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.log4j.Logger;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.bhiman.main.Constants;
import com.bhiman.main.UIKeywords;

import com.bhiman.main.masters.Brokers;
import com.bhiman.main.utility.PropertyReader;
import com.bhiman.test.BaseTest;



public class BrokersTest extends BaseTest {
	private static final Logger LOG = Logger.getLogger(BanksTest.class);

	//Brokers broker=PageFactory.initElements(Constants.driver, Brokers.class);
	//TC-01
	@Test(priority=-1, description="To verify whether 'Brokers' option is visible and clickable in Masters Tab or not.")
	public void toCheckBrokersOption() throws InterruptedException {
		LOG.info("Checking for Brokers option in Masters Tab After MouseHover");
		Brokers brokers=new Brokers();
		Thread.sleep(2000);
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(2000);
		//Constants.driver.close();	
	}
	
	//TC-02
	@Test( description="To verify functionality of Add Broker option. ", alwaysRun=true)
	public void clickingOnBrokersPageFromMasters() throws InterruptedException {
		LOG.info("Clicking on Add Broker from Masters Broker");
		Brokers brokers=new Brokers();
		String brokers_expectedUrl = "http://103.50.162.196/testing/broker.php#";
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(2000);
		brokers.clickOnBrokers();
		Thread.sleep(2000);
		brokers.clickOnAddBroker();
		Thread.sleep(2000);
		String brokers_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(brokers_actualUrl, brokers_expectedUrl);
		//Constants.driver.close();		
	}
	
	//TC-03
	@Test( description="Clicking on View Broker Button after clicked on Add Broker")
	public void clickOnViewBrokers() throws InterruptedException {
		LOG.info("Clicking on View Broker after clicked on Add Broker from Masters Broker");
		Brokers brokers=new Brokers();
		String brokers_expectedUrl = "http://103.50.162.196/testing/broker.php#";
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(2000);
		brokers.clickOnBrokers();
		Thread.sleep(2000);
		brokers.clickOnAddBroker();
		Thread.sleep(2000);
		brokers.clickOnViewBrokers();
		String brokers_actualUrl = UIKeywords.getPageUrl();
		Assert.assertEquals(brokers_actualUrl, brokers_expectedUrl);
	}
	
	//TC-04
	@Test( description="Clicking on Copy Button")
	public void clickOnCopyBtnOnBroker() throws InterruptedException {
		LOG.info("Clicking on Copy Button");
		Brokers brokers=new Brokers();
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(2000);
		brokers.clickOnBrokers();
		Thread.sleep(2000);
		brokers.clickOnCopyAtBrokersPage();
		Thread.sleep(2000);
	}
	
	//TC-05
	@Test(description="Clicking on Excel Button")
	public void clickOnExcelBtn() throws InterruptedException {
		LOG.info("Clicking on Excel Button");
		Brokers brokers=new Brokers();
		Thread.sleep(2000);
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(2000);
		brokers.clickOnBrokers();
		Thread.sleep(2000);
		brokers.clickOnExcelBtnAtBrokersPage();
		Thread.sleep(2000);
		Constants.actual = "Brokers.xlsx";
		String brokersFilePath = "C:\\Users\\VINITA\\Downloads\\Brokers.xlsx";
		File file = new File(brokersFilePath);
		Constants.flag = file.exists();
		assertTrue(Constants.flag, "File name: " +Constants.actual+ " is not downloaded at location: " +brokersFilePath);
	}
	
	//TC-06
	@Test( description="Clicking on CSV Button")
	public void clickOnCSVBtn() throws InterruptedException {
		LOG.info("Clicking on CSV Button");
		Brokers brokers=new Brokers();
		Thread.sleep(1000);
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(1000);
		brokers.clickOnBrokers();
		Thread.sleep(1000);
		brokers.clickOnCSVBtnAtBrokersPage();
		Thread.sleep(1000);
		Constants.actual = "Brokers.csv";
		String brokersFilePath = "C:\\Users\\VINITA\\Downloads\\Brokers.csv";
		File file = new File(brokersFilePath);
		Constants.flag = file.exists();
		assertTrue(Constants.flag, "File name: " +Constants.actual+ " is not downloaded at location: " +brokersFilePath);
	}
	
	//TC-07
	@Test( description="Clicking on PDF Button")
	public void clickOnPDFBtn() throws InterruptedException {
		LOG.info("Clicking on PDF Button");
		Brokers brokers=new Brokers();
		Thread.sleep(1000);
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(1000);
		brokers.clickOnBrokers();
		Thread.sleep(1000);
		brokers.clickOnPDFBtnAtBrokersPage();
		Thread.sleep(1000);
		Constants.actual = "Brokers.pdf";
		String brokersFilePath = "C:\\Users\\VINITA\\Downloads\\Brokers.pdf";
		File file = new File(brokersFilePath);
		Constants.flag = file.exists();
		assertTrue(Constants.flag, "File name: " +Constants.actual+ " is not downloaded at location: " +brokersFilePath);
	}
	
	//TC-08
	@Test( description="Clicking on Print Button")
	public void clickOnPrintBtn() throws InterruptedException {
		LOG.info("Clicking on PDF Button");
		Brokers brokers=new Brokers();
		Thread.sleep(2000);
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(2000);
		brokers.clickOnBrokers();
		Thread.sleep(2000);
		brokers.clickOnPrintBtnAtBrokersPage();
		
		Thread.sleep(2000);
	}
	
	//TC-09
	@Test(description = "To verify/validate functionality of search box with valid input.")
	public void searchBoxWithValidText() throws InterruptedException {
		LOG.info("Masters-->Brokers: Entering invalid text in Search box ");
		Brokers brokers=new Brokers();
		Thread.sleep(2000);
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(2000);
		brokers.clickOnBrokers();
		Thread.sleep(2000);
		brokers.enterTextInSearchBox(PropertyReader.getLocatorValue("brokers_search_valid_text"));
		
	}
		
	//TC-10
	@Test(description = "To verify/validate functionality of search box with invalid input.")
	public void searchBoxWithInvalidText() throws InterruptedException {
		LOG.info("Masters-->Brokers: Entering invalid text in Search box ");
		Brokers brokers=new Brokers();
		Thread.sleep(2000);
		brokers.mouseHoverToMastersForBrokersPage();
		Thread.sleep(2000);
		brokers.clickOnBrokers();
		Thread.sleep(2000);
		brokers.enterTextInSearchBox(PropertyReader.getLocatorValue("brokers_search_invalid_text"));
		Constants.expected = "No matching records found";
		Constants.actual = brokers.getTextForInvalidBrokersSearch();
		Assert.assertEquals(Constants.actual, Constants.expected);	
	}
}
