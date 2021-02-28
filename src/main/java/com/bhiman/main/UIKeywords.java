package com.bhiman.main;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords {

	private static Logger LOG = Logger.getLogger(UIKeywords.class);

	/**
	 * Overload Method:
	 * Use to clear text from @WebElement element like text box etc.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static void clearText(WebElement element) {
		WaitsInHelp.webDriverWaitInSeconds(element, Constants.WebDriverWaitTimeOutInSec, Constants.WebDriverWaitSleepInMilli);
		LOG.info("Clearing text from WebElement: " +element);
		element.clear();
	}

	/**
	 * Overload Method:
	 * Use to find the element and clear text on @WebElement element like text box etc. using @By class instance.
	 * 
	 * @param by as {@code By}.
	 */
	public static void clearText(By by) {
		LOG.info("Finding element " +by+ "and clear text on web element using By class instance.");
		Constants.element.clear();
	}

	/**
	 * Overload Method:
	 * Use to click on @WebElement element like Button, Radio Button, Check Box, Link etc.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static void clickOnElement(WebElement element) {
		LOG.info("Clicking on WebElement: " +element);
		WaitsInHelp.webDriverWaitInSeconds(element, Constants.WebDriverWaitTimeOutInSec, Constants.WebDriverWaitSleepInMilli);
		element.click();
	}

	/**
	 * Overload Method:
	 * Use to find the element and click on @WebElement element like Button, Radio Button, Check Box, Link etc. using @By class instance.
	 * 
	 * @param by as {@code By}.
	 */
	public static void clickOnElement(By by) {
		LOG.info("Finding element " +by+ "and click on web element using By class instance.");
		Constants.driver.findElement(by).click();
	}

	/**
	 * Close the current browser window, or last browser window associated with this driver.
	 */
	public static void closeBrowser() {
		LOG.info("Closing current browser window.");
		Constants.driver.close();
	}

	/**
	 * Close all browser window associated with this driver.
	 */
	public static void closeAllBrowser() {
		LOG.info("Closing all browser window.");
		Constants.driver.quit();
	}

	/**
	 * Overload Method:
	 * Use to enter text on @WebElement element  like textbox etc.
	 * 
	 * @param element as {@code WebElement}.
	 * @param textToEnter as {@code String}.
	 */
	public static void enterText(WebElement element, String textToEnter) {
		WaitsInHelp.webDriverWaitInSeconds(element, Constants.WebDriverWaitTimeOutInSec, Constants.WebDriverWaitSleepInMilli);
		LOG.info("Entering text as " +textToEnter+ " in WebElement: " + element);
		element.sendKeys(textToEnter);
	}

	/**
	 * Overload Method:
	 * Use to find element and enter text on @WebElement element like text box etc. using @By class instance.
	 * 
	 * @param by as {@code By}.
	 * @param textToEnter as {@code String}.
	 */
	public static void enterText(By by, String textToEnter) {
		LOG.info("Entering text in " +by+ "using By class instance.");
		Constants.driver.findElement(by).sendKeys(textToEnter);
	}

	/**
	 * Use to check if @WebElement element is displayed.
	 * 
	 * @param element as {@code WebElement}.
	 * 
	 */
	public static Boolean isElementDisplayed(WebElement element) {
		WaitsInHelp.webDriverWaitInSeconds(element, Constants.WebDriverWaitTimeOutInSec, Constants.WebDriverWaitSleepInMilli);
		return element.isDisplayed();
	}
	
	/**
	 * Create a @WebDriver driver instance.
	 * 
	 * @return driver as {@code WebDriver} only when browser is open else return {@code null}.
	 */
	public static WebDriver getDriver() {
		if(Constants.driver.equals(null)) {
			throw new NullPointerException("Driver instance is not initialized.");
		} else {
			LOG.info("Driver instance created.");
			return Constants.driver;			
		}
	}

	/**
	 * Read current page title.
	 */
	public static String getPageTitle() {
		LOG.info("Reading current page title.");
		return Constants.driver.getTitle();
	}

	/**
	 * Read current page URL.
	 */
	public static String getPageUrl() {
		LOG.info("Reading current page URL.");
		return Constants.driver.getCurrentUrl();
	}

	/**
	 * Overload Method:
	 * Use to read text of @Webelement element.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static String getText(WebElement element) {
		WaitsInHelp.webDriverWaitInSeconds(element, Constants.WebDriverWaitTimeOutInSec, Constants.WebDriverWaitSleepInMilli);
		LOG.info("Reading text for element: " +element+ " in page.");
		return element.getText();
	}

	/**
	 * Overload Method:
	 * Use to find @Webelement element and read text using @BY class instance.
	 * 
	 * @param by as {@code By}.
	 */
	public static String getText(By by) {
		LOG.info("Reading text for element: " +by+ " in page.");
		return Constants.element.getText();
	}

	/**
	 * Overload Method:
	 * Use to hover the mouse to @Webelement element.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static void mouseHover(WebElement element) {
		LOG.info("Mouse hover to web element: " +element+ "in page.");
		Constants.actions = new Actions(Constants.driver);
		Constants.actions.moveToElement(element).perform();
	}

	/**
	 * Overload Method:
	 * Use to find element and hover the mouse using @By class instance.
	 * 
	 * @param by as {@code By}.
	 */
	public static void mouseHover(By by) {
		LOG.info("Mouse hover to " +by+ "using By class instance.");
		Constants.element = Constants.driver.findElement(by);
		Constants.actions = new Actions(Constants.driver);
		Constants.actions.moveToElement(Constants.element).perform();
	}

	/**
	 * Maximizes the current browser window, if it is not already maximized using this driver.
	 */
	public static void maximizeWindow() {
		LOG.info("Maximize browser window.");
		Constants.driver.manage().window().maximize();
	}	

	/**
	 * Navigate to back page from current page.
	 */
	public static void navigateBack() {
		LOG.info("Navigate to back page from current page.");
		Constants.driver.navigate().back();
	}

	/**
	 * Navigate to forward page from current page.
	 */
	public static void navigateForward() {
		LOG.info("Navigate to forward page from current page.");
		Constants.driver.navigate().forward();
	}

	/**
	 * Launch specified web browser. Only @browserName as chrome, firefox, edge, ie and opera are allowed.
	 * Others browser not allowed.
	 * 
	 * @param browserName as {@code String}. 
	 */	
	public static void openBrowser(String browserName) {
		browserName = browserName.toUpperCase();
		switch (browserName) {
		case "CHROME":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.chromedriver().setup();
			Constants.driver = new ChromeDriver();
			break;
		case "FIREFOX":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.firefoxdriver().setup();
			Constants.driver = new FirefoxDriver();
			break;
		case "EDGE":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.edgedriver().setup();
			Constants.driver = new EdgeDriver();
			break;
		case "IE":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.iedriver().setup();
			Constants.driver = new InternetExplorerDriver();
			break;
		case "OPERA":
			LOG.info("Opening "+browserName+" browser.");
			WebDriverManager.operadriver().setup();
			Constants.driver = new OperaDriver();
			break;
		default:
			LOG.error("Invalid browser name: "+browserName+".\nExpected: 'chrome','firefox','edge','ie',and 'opera'.");
			break;
		}
	}

	/**
	 * Open the specified url.
	 * 
	 * @param url as {@code String}.
	 */
	public static void openUrl(String url) {
		LOG.info("Launching application URL: "+url);
		Constants.driver.get(url);
	}

	/**
	 * Refresh the current page.
	 */
	public static void refreshPage() {
		LOG.info("Refreshing current page.");
		Constants.driver.navigate().refresh();
	}

	/**
	 * Use to scroll vertically down the page up to view of @Webelement element.
	 * 
	 * @param element as {@code WebElement}.
	 */
	public static void scrollVerticalDown(WebElement element) {
		LOG.info("Scrolling vertically down upto web element: " +element+ " to come view in page.");
		JavascriptExecutor jse = (JavascriptExecutor) Constants.driver;	
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * Overload Method:
	 * Use to select @Webelement element from the drop-down using visible text.
	 * 
	 * @param element as {@code WebElement}.
	 * @param textToSelect as {@code String}.
	 */
	public static void selectByTextFromDropdown(WebElement element, String textToSelect) {
		LOG.info("Selected " +element+ "from dropdown using text: " +textToSelect);
		Constants.select = new Select(element);
		Constants.select.selectByVisibleText(textToSelect);
	}

	/**
	 * Overload Method:
	 * Use to find and select element from the drop-down with visible text using @By class instance.
	 * 
	 * @param element as {@code WebElement}.
	 * @param by as {@code By}.
	 */
	public static void selectByTextFromDropdown(By by, String textToSelect) {
		LOG.info("Selected element" +by+ "from dropdown using text: " +textToSelect);
		Constants.element = Constants.driver.findElement(by);
		Constants.select = new Select(Constants.element);
		Constants.select.selectByVisibleText(textToSelect);
	}	

	/**
	 *  Use to switch driver from parent(main) window to child window. It will also print both window handles.
	 */		
	public static void switchToChildWindow() {		
		String parent = Constants.driver.getWindowHandle();
		LOG.info("Parent window handle: " +parent);
		Set <String> windows = Constants.driver.getWindowHandles();
		Iterator <String> itr = windows.iterator();
		while (itr.hasNext()) {
			String child = itr.next();
			if (!child.equals(parent)) {
				LOG.info("Child window handle: " +child);
				Constants.driver.switchTo().window(child);
			} else {
				LOG.error("Parent(main) and child window hanldles are same.");
			}
		}
	}

	/**
	 *
	 * Returns true if file is downloaded or false if file is not downloaded
	 * 
	 * @param downloadPath as {@code String}.
	 * @param fileName as {@code String}.
	 */
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag=true;
		}

		return flag;
	}

	/**
	 *
	 * Deletes the existing file
	 * 
	 * @param filePath as {@code String}.
	 * @param fileName as {@code String}.
	 */
	public void deleteFile(String filePath, String fileName) {
		File myObj = new File(filePath+"\\"+fileName); 
		if (myObj.delete()) { 
			LOG.info("Deleted the file: " + myObj.getName());
		} else {
			LOG.error("Failed to delete the file.");
		}
		 
	}
	
	/**
	 *
	 * takes screenshot
	 * 
	 * @param filePath as {@code String}.
	 * @param screenshotName as {@code String}.
	 */
	public static void takeScreenshot(String filePath, String screenshotName) {
		//Take the screenshot
        File screenshot = ((TakesScreenshot) Constants.driver).getScreenshotAs(OutputType.FILE);
        
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File(filePath+"\\"+screenshotName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}

}