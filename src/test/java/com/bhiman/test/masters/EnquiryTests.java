package com.bhiman.test.masters;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bhiman.main.Constants;
import com.bhiman.main.masters.Enquiry;
import com.bhiman.test.BaseTest;
import com.bhiman.test.BhimanListeners;


@Listeners(BhimanListeners.class)
public class EnquiryTests extends BaseTest {

	private static final Logger LOG = Logger.getLogger(EnquiryTests.class);
	

	@Test(priority=1, description = "Verify user should be able to navigate to enquiry page through master navigation tab")
	public void tc_01() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		Assert.assertTrue(Constants.driver.getCurrentUrl().contains("enquiry"));

	}
	
	
	@Test(priority=2, description = "Verify user should be able to see Copy, Excel, CSV, PDF and Print buttons on enquiry page")
	public void tc_02() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		Assert.assertTrue(enquiry.isExcelButtonDisplayed());
		Assert.assertTrue(enquiry.isCsvButtonDisplayed());
		Assert.assertTrue(enquiry.isPdfButtonDisplayed());
		Assert.assertTrue(enquiry.isPrintButtonDisplayed());
	}
	
	@Test(priority=3, description = "Verify user should be able to see 'Add Enquiry' button on enquiry page")
	public void tc_03() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		Assert.assertTrue(enquiry.isAddEnquiryButtonDisplayed());
		
	}
	
	@Test(priority=4, description = "Verify user should be able to see existing added enquiries in a table on enquiry page")
	public void tc_04() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		Assert.assertTrue(enquiry.isEnquiryTableDispalyed());
		
	}
	
	@Test(priority=5, description = "Verify user should be able to add enquiry using 'Add Enquiry' button on enquiry page")
	public void tc_05() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		enquiry.clickOnAddEnquiry();


		enquiry.enterName("Fareen");
		enquiry.enterMobileNumber("9234567890");
		enquiry.enterPurpose("Visiting");
		enquiry.enterReference("Testing Shashtra");
		enquiry.submit();
		//Thread.sleep(8000);
		enquiry.clickOnOkButton();
		//Thread.sleep(5000);

		Assert.assertEquals(enquiry.getTableData(1, Enquiry.NAME_COLUMN), "Fareen");
		Assert.assertEquals(enquiry.getTableData(1, Enquiry.MOBILE_NO_COLUMN), "9234567890");
		Assert.assertEquals(enquiry.getTableData(1, Enquiry.PURPOSE_COLUMN), "Visiting");
		Assert.assertEquals(enquiry.getTableData(1, Enquiry.REFERENCE_COLUMN), "Testing Shashtra");
		
	}
	
	@Test(priority=6, description = "Verify user should be able to edit existing enquiry using 'Edit Enquiry' icon on enquiry page")
	public void tc_06() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		//Thread.sleep(5000);
		enquiry.clickOnEditEnquiryIcon(1);
		//Thread.sleep(10000);
		enquiry.enterName("Fareen02");
		enquiry.enterMobileNumber("9876543210");
		enquiry.enterPurpose("Interview");
		enquiry.enterReference("Testing Shashtra Class");
		enquiry.submit();
		//Thread.sleep(8000);
		enquiry.clickOnOkButton();
		//Thread.sleep(5000);

		Assert.assertEquals(enquiry.getTableData(1, Enquiry.NAME_COLUMN), "Fareen02");
		Assert.assertEquals(enquiry.getTableData(1, Enquiry.MOBILE_NO_COLUMN), "9876543210");
		Assert.assertEquals(enquiry.getTableData(1, Enquiry.PURPOSE_COLUMN), "Interview");
		Assert.assertEquals(enquiry.getTableData(1, Enquiry.REFERENCE_COLUMN), "Testing Shashtra Class");
		
	}
	
	@Test(priority=7, description = "Verify user should be able to search data from enquiry table by entering search text into searchTextBox on enquiry page")
	public void tc_07() throws InterruptedException, UnsupportedFlavorException, IOException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		String searchText = "Fareen";
		enquiry.enterTextIntoSearchBox(searchText);
		
		//Thread.sleep(2000);
		
		int tableRows = enquiry.getTableRowCount();
		int tableColumn = enquiry.getTableColumnCount();
	
		for(int row = 1; row <= tableRows; row++) {
			Boolean isTextPresent = false;
			for(int column = 1; column <= tableColumn; column++) {
				if(enquiry.getTableData(row, column).contains(searchText)) {
					System.out.println("Table data for : " + enquiry.getTableData(row, column));
					isTextPresent = true;
					break;
				}
			}
			Assert.assertTrue(isTextPresent);
		}
		
	}
	
	
	@Test(priority=8, description = "Verify user should be able to delete existing enquiry using 'Delete Enquiry' icon on enquiry page")
	public void tc_08() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		enquiry.clickOnDeleteEnquiryIcon(1);
		//Thread.sleep(3000);
		enquiry.acceptDeleteEnquiryAlert();
		//Thread.sleep(8000);
		Assert.assertTrue(enquiry.isRecordDeletedPopUpDislpayed());
		
	}
	
	@Test(priority=9, description = "Verify user should be able to copy table data by clicking on Copy button on enquiry page")
	public void tc_09() throws InterruptedException, UnsupportedFlavorException, IOException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		enquiry.clickOnCopyButton();
		
		// Create a Clipboard object using getSystemClipboard() method
        Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();

        // Get data stored in the clipboard that is in the form of a string (text)
        System.out.println(c.getData(DataFlavor.stringFlavor));
        
        String tableData = (String) c.getData(DataFlavor.stringFlavor);
        
        Assert.assertTrue(tableData.contains("Sr.No."));
        Assert.assertTrue(tableData.contains("Name"));
        Assert.assertTrue(tableData.contains("Mobile No."));
        Assert.assertTrue(tableData.contains("Purpose"));
        Assert.assertTrue(tableData.contains("Reference"));
        Assert.assertTrue(tableData.contains("Action"));
		
	}
	
	@Test(priority=10, description = "Verify user should be able to download table data in excel format by clicking on Excel button on enquiry page")
	public void tc_10() throws InterruptedException, UnsupportedFlavorException, IOException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		String userPath = System.getProperty("user.home"); // "C:\\Users\\fareen"
	    String downloadPath = userPath + "\\Downloads";    // "C:\\Users\\fareen\\Downloads"
	    
		// delete the file if already exists
		deleteFile(downloadPath, "Enquiry.xlsx");
		
		enquiry.clickOnExcelButton();
		
		Thread.sleep(3000);
	    
	    System.out.println(downloadPath);
        
        Assert.assertTrue(isFileDownloaded(downloadPath, "Enquiry.xlsx"));
       
	}
	
	@Test(priority=11, description = "Verify user should be able to download table data in csv format by clicking on CSV button on enquiry page")
	public void tc_11() throws InterruptedException, UnsupportedFlavorException, IOException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		String userPath = System.getProperty("user.home");
	    String downloadPath = userPath + "\\Downloads";
	    
		// delete the file if already exists
		deleteFile(downloadPath, "Enquiry.csv");
		
		enquiry.clickOnCSVButton();
		
		Thread.sleep(3000);
	    
	    System.out.println(downloadPath);
        
        Assert.assertTrue(isFileDownloaded(downloadPath, "Enquiry.csv"));
       
	}
	
	@Test(priority=12, description = "Verify user should be able to download table data in pdf format by clicking on PDF button on enquiry page")
	public void tc_12() throws InterruptedException, UnsupportedFlavorException, IOException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		String userPath = System.getProperty("user.home");
	    String downloadPath = userPath + "\\Downloads";
	    
		// delete the file if already exists
		deleteFile(downloadPath, "Enquiry.pdf");
		
		enquiry.clickOnPDFButton();
		
		Thread.sleep(3000);
	    
	    System.out.println(downloadPath);
        
        Assert.assertTrue(isFileDownloaded(downloadPath, "Enquiry.pdf"));
       
	}
	
	
	
	@Test(priority=13, description = "Verify user should be get validation error message when user clicks on submit button while adding enquiring for invalid data")
	public void tc_13() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		//Thread.sleep(5000);
		enquiry.clickOnAddEnquiry();
		//Thread.sleep(5000);
		enquiry.submit();
		Assert.assertEquals(enquiry.getNameValidationError(), "Please Enter Name");
		Assert.assertEquals(enquiry.getMobileNumberValidationError(), "Please Enter Your Contact Number");
		Assert.assertEquals(enquiry.getPurposeValidationError(), "Please Enter Purpose");
		Assert.assertEquals(enquiry.getReferenceValidationError(), "Please Enter Reference");
		
	}
	
	@Test(priority=14, description = "Verify user should be get validation error message when user enter less than 10 digits for mobile number")
	public void tc_14() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		//Thread.sleep(5000);
		enquiry.clickOnAddEnquiry();
		//Thread.sleep(5000);
		enquiry.enterMobileNumber("12313");
		enquiry.submit();
		//Thread.sleep(2000);
		Assert.assertEquals(enquiry.getMobileNumberValidationError(), "Mobile Number Must Be Of 10 Digits");
		
	}
	
	@Test(priority=15, description = "Verify user should be get error message when user enter invalid mobile number which does not starts with 6,7,8,9")
	public void tc_15() throws InterruptedException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
	//	Thread.sleep(5000);
		enquiry.clickOnAddEnquiry();
	//	Thread.sleep(5000);
		enquiry.enterName("Fareen02");
		enquiry.enterMobileNumber("1876543210");
		enquiry.enterPurpose("Interview");
		enquiry.enterReference("Testing Shashtra Class");
		enquiry.submit();
	//	Thread.sleep(10000);
		Assert.assertEquals(enquiry.getStartsWithMobileNumberError(), "Please enter proper mobile no. Mobile No must be start with 6,7,8,9");
		
	}
	
	@Test(priority=16, description = "Verify user should be able to print table data by clicking on Print button on enquiry page")
	public void tc_16() throws InterruptedException, UnsupportedFlavorException, IOException {
		
		Enquiry enquiry = new Enquiry();
		
		enquiry.goToEnquiryPage();
		
		enquiry.clickOnPrintButton();
		
		Thread.sleep(3000);
        
        Assert.assertEquals(Constants.driver.getWindowHandles().size(), 3);
	}
	


}

