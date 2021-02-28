package com.bhiman.test.masters;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bhiman.main.Constants;
import com.bhiman.main.masters.Customers;
import com.bhiman.main.masters.Enquiry;
import com.bhiman.test.BaseTest;
import com.bhiman.test.BhimanListeners;


@Listeners(BhimanListeners.class)
public class CustomersTest extends BaseTest {

	private static final Logger LOG = Logger.getLogger(CustomersTest.class);


	@Test(priority=1, description = "Verify user should be able to navigate to customer page through master navigation tab")
	public void tc_01() throws InterruptedException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		Assert.assertTrue(Constants.driver.getCurrentUrl().contains("customer"));

	}


	@Test(priority=2, description = "Verify user should be able to see Copy, Excel, CSV, PDF and Print buttons on customer page")
	public void tc_02() throws InterruptedException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		Assert.assertTrue(customer.isExcelButtonDisplayed());
		Assert.assertTrue(customer.isCsvButtonDisplayed());
		Assert.assertTrue(customer.isPdfButtonDisplayed());
		Assert.assertTrue(customer.isPrintButtonDisplayed());
	}

	@Test(priority=3, description = "Verify user should be able to see 'Add Customer' button on customer page")
	public void tc_03() throws InterruptedException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		Assert.assertTrue(customer.isAddCustomerButtonDisplayed());

	}

	@Test(priority=4, description = "Verify user should be able to see existing added customers in a table on customer page")
	public void tc_04() throws InterruptedException {

		Customers customer = new Customers();

		customer.goToCustomerPage();


		Assert.assertTrue(customer.isCustomerTableDispalyed());

	}

	@Test(priority=5, description = "Verify user should be able to add customer using 'Add Customer' button on customer page")
	public void tc_05() throws InterruptedException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		customer.clickOnAddCustomer();


		customer.enterName("Fareen");
		customer.enterMobileNumber("9234567890");
		customer.enterEmail("fareens1028@gmail.com");
		customer.enterAddress("M G Road");
		customer.enterState("Maharashtra");
		customer.enterDistrict("Pune");
		customer.enterTaluka("Haveli");
		customer.enterCity("Viman Nagar");
		customer.enterPinCode("411014");
		customer.enterOccupation("Engineer");
		customer.selectDob("12-02-1990");
		customer.selectAnniversary("12-02-2019");
		//Thread.sleep(8000);
		customer.submit();
		//Thread.sleep(5000);
		customer.clickOnOkButton();
		Thread.sleep(3000);
		Assert.assertEquals(customer.getTableData(1, Customers.CUSTOMER_NAME_COLUMN), "Fareen");
		Assert.assertEquals(customer.getTableData(1, Customers.MOBILE_NO_COLUMN), "9234567890");
		Assert.assertEquals(customer.getTableData(1, Customers.DOB_COLUMN), "12-02-1990");
		Assert.assertEquals(customer.getTableData(1, Customers.ANNIVERSARY_COLUMN), "12-02-2019");
		Assert.assertEquals(customer.getTableData(1, Customers.EMAIL_COLUMN), "fareens1028@gmail.com");

	}

	@Test(priority=6, description = "Verify user should be able to edit existing customer using 'Edit Customer' icon on customer page")
	public void tc_06() throws InterruptedException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		//Thread.sleep(5000);
		customer.clickOnEditCustomerIcon(1);
		//Thread.sleep(10000);
		customer.enterName("Fareen02");
		customer.enterMobileNumber("9876543210");
		customer.enterEmail("fareens1028_new@gmail.com");
		customer.enterAddress("M G Road");
		customer.enterState("Maharashtra");
		customer.enterDistrict("Pune");
		customer.enterTaluka("Haveli");
		customer.enterCity("Viman Nagar");
		customer.enterPinCode("411014");
		customer.enterOccupation("Engineer");
		customer.selectDob("15-02-1990");
		customer.selectAnniversary("12-12-2019");
		//Thread.sleep(8000);
		customer.submit();
		//Thread.sleep(5000);
		customer.clickOnOkButton();

		Assert.assertEquals(customer.getTableData(1, Customers.CUSTOMER_NAME_COLUMN), "Fareen02");
		Assert.assertEquals(customer.getTableData(1, Customers.MOBILE_NO_COLUMN), "9876543210");
		Assert.assertEquals(customer.getTableData(1, Customers.DOB_COLUMN), "15-02-1990");
		Assert.assertEquals(customer.getTableData(1, Customers.ANNIVERSARY_COLUMN), "12-12-2019");
		Assert.assertEquals(customer.getTableData(1, Customers.EMAIL_COLUMN), "fareens1028_new@gmail.com");


	}

	@Test(priority=7, description = "Verify user should be able to search data from customer table by entering search text into searchTextBox on customer page")
	public void tc_07() throws InterruptedException, UnsupportedFlavorException, IOException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		customer.enterTextIntoSearchBox("Fareen");

		//Thread.sleep(2000);

		int tableRows = customer.getTableRowCount();
		int tableColumn = customer.getTableColumnCount();

		for(int row = 1; row <= tableRows; row++) {
			Boolean isTextPresent = false;
			for(int column = 1; column <= tableColumn; column++) {
				if(customer.getTableData(row, column).contains("Fareen")) {
					System.out.println("Table data for : " + customer.getTableData(row, column));
					isTextPresent = true;
					break;
				}
			}
			Assert.assertTrue(isTextPresent);
		}

	}


	@Test(priority=8, description = "Verify user should be able to delete existing customer using 'Delete customer' icon on customer page")
	public void tc_08() throws InterruptedException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		customer.clickOnDeleteCustomerIcon(1);
		//Thread.sleep(3000);
		customer.acceptDeleteCustomerAlert();
		//Thread.sleep(8000);
		Assert.assertTrue(customer.isRecordDeletedPopUpDislpayed());

	}

	@Test(priority=9, description = "Verify user should be able to copy table data by clicking on Copy button on customer page")
	public void tc_09() throws InterruptedException, UnsupportedFlavorException, IOException {

		Customers customer = new Customers();

		customer.goToCustomerPage();


		customer.clickOnCopyButton();

		// Create a Clipboard object using getSystemClipboard() method
		Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();

		// Get data stored in the clipboard that is in the form of a string (text)
		System.out.println(c.getData(DataFlavor.stringFlavor));

		String tableData = (String) c.getData(DataFlavor.stringFlavor);

		Assert.assertTrue(tableData.contains("Sr.No."));
		Assert.assertTrue(tableData.contains("Customer Name"));
		Assert.assertTrue(tableData.contains("Mobile Number"));
		Assert.assertTrue(tableData.contains("Birth Date"));
		Assert.assertTrue(tableData.contains("Anniversary Date"));
		Assert.assertTrue(tableData.contains("Email"));
		Assert.assertTrue(tableData.contains("Action"));

	}

	@Test(priority=10, description = "Verify user should be able to download table data in excel format by clicking on Excel button on customer page")
	public void tc_10() throws InterruptedException, UnsupportedFlavorException, IOException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		String userPath = System.getProperty("user.home");
		String downloadPath = userPath + "\\Downloads";

		// delete the file if already exists
		deleteFile(downloadPath, "Customers.xlsx");

		customer.clickOnExcelButton();

		Thread.sleep(3000);

		System.out.println(downloadPath);

		Assert.assertTrue(isFileDownloaded(downloadPath, "Customers.xlsx"));

	}

	@Test(priority=11, description = "Verify user should be able to download table data in csv format by clicking on CSV button on customer page")
	public void tc_11() throws InterruptedException, UnsupportedFlavorException, IOException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		String userPath = System.getProperty("user.home");
		String downloadPath = userPath + "\\Downloads";

		// delete the file if already exists
		deleteFile(downloadPath, "Customers.csv");

		customer.clickOnCSVButton();

		Thread.sleep(3000);

		System.out.println(downloadPath);

		Assert.assertTrue(isFileDownloaded(downloadPath, "Customers.csv"));

	}

	@Test(priority=12, description = "Verify user should be able to download table data in pdf format by clicking on PDF button on customer page")
	public void tc_12() throws InterruptedException, UnsupportedFlavorException, IOException {

		Customers customer = new Customers();

		customer.goToCustomerPage();

		String userPath = System.getProperty("user.home");
		String downloadPath = userPath + "\\Downloads";

		// delete the file if already exists
		deleteFile(downloadPath, "Customers.pdf");

		customer.clickOnPDFButton();

		Thread.sleep(3000);

		System.out.println(downloadPath);

		Assert.assertTrue(isFileDownloaded(downloadPath, "Customers.pdf"));

	}



	@Test(priority=13, description = "Verify user should be get validation error message when user clicks on submit button while adding customer with invalid data")
	public void tc_13() throws InterruptedException {

		Customers customer = new Customers();

		customer.goToCustomerPage();
		//Thread.sleep(5000);
		customer.clickOnAddCustomer();
		//Thread.sleep(5000);
		customer.submit();
		
		Assert.assertEquals(customer.getNameValidationError(), "Please Enter Customer Name");
		Assert.assertEquals(customer.getMobileNumberValidationError(), "Please Enter Your Mobile Number");
		Assert.assertEquals(customer.getEmailValidationError(), "Please Enter Email Address");
		Assert.assertEquals(customer.getAddressValidationError(), "Please Enter Address");
		Assert.assertEquals(customer.getStateValidationError(), "Please Enter State");
		Assert.assertEquals(customer.getDistrictValidationError(), "Please Enter District");
		Assert.assertEquals(customer.getTalukaValidationError(), "Please Enter Taluka");
		Assert.assertEquals(customer.getCityValidationError(), "Please Enter City");
		Assert.assertEquals(customer.getDobValidationError(), "Please Enter Birth Date");
		Assert.assertEquals(customer.getAnniversaryValidationError(), "Please Enter Anniversary Date");
		Assert.assertEquals(customer.getOccupationValidationError(), "Please Enter Occupation");

	}

	@Test(priority=14, description = "Verify user should be get validation error message when user enter less than 10 digits for mobile number")
	public void tc_14() throws InterruptedException {

		Customers customer = new Customers();

		customer.goToCustomerPage();
		//Thread.sleep(5000);
		customer.clickOnAddCustomer();
		//Thread.sleep(5000);
		customer.enterMobileNumber("12313");
		customer.submit();
		//Thread.sleep(2000);
		Assert.assertEquals(customer.getMobileNumberValidationError(), "Mobile Number Must Be Of 10 Digits");

	}

	@Test(priority=15, description = "Verify user should be get error message when user enter invalid mobile number which does not starts with 6,7,8,9")
	public void tc_15() throws InterruptedException {
		Customers customer = new Customers();

		customer.goToCustomerPage();
		//	Thread.sleep(5000);
		customer.clickOnAddCustomer();


		customer.enterName("Fareen");
		customer.enterMobileNumber("1234567890");
		customer.enterEmail("fareens1028@gmail.com");
		customer.enterAddress("M G Road");
		customer.enterState("Maharashtra");
		customer.enterDistrict("Pune");
		customer.enterTaluka("Haveli");
		customer.enterCity("Viman Nagar");
		customer.enterPinCode("411014");
		customer.enterOccupation("Engineer");
		customer.selectDob("12-02-1990");
		customer.selectAnniversary("12-02-2019");
		//Thread.sleep(8000);
		customer.submit();
		//	Thread.sleep(10000);
		Assert.assertEquals(customer.getStartsWithMobileNumberError(), "Please enter proper mobile no. Mobile No must be start with 6,7,8,9");

	}

	@Test(priority=16, description = "Verify user should be able to print table data by clicking on Print button on customer page")
	public void tc_16() throws InterruptedException, UnsupportedFlavorException, IOException {

		Customers customer = new Customers();

		customer.goToCustomerPage();
		
		customer.clickOnPrintButton();

		Thread.sleep(3000);

		Assert.assertEquals(Constants.driver.getWindowHandles().size(), 3);

	}



}

