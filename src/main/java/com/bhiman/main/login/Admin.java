package com.bhiman.main.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhiman.main.Constants;
import com.bhiman.main.UIKeywords;

public class Admin {
	
	private static final Logger LOG = Logger.getLogger(Admin.class);

	public Admin(){
		PageFactory.initElements(Constants.driver, this);
	}
	
	@FindBy(name = "username")
	private static WebElement mobile_no;

	@FindBy(name = "password")
	private static WebElement password;

	@FindBy(css = "button[type='submit']")
	private static WebElement login_Btn;

	@FindBy(xpath = "//button[text()='OK']")
	public static WebElement loginSignInBtn;
	
	@FindBy(xpath = "//button[text()='OK']")
	private static WebElement loginErrorInBtn;

	
	@FindBy(xpath="//div[contains(text(),'Login Successfull.')]")
	private static WebElement getSignInMessage;
	
	@FindBy(xpath="//div[contains(text(),'start with 6,7,8,9')]")
	private static WebElement getErrorInMessage;

//	----------------------Methods------------------------
	
	public static void enterUsername(String mob_no) {
		mobile_no.clear();
		mobile_no.sendKeys(mob_no);
	}
	
	public static void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
		
	}
	public static void clickOnLoginButton() {
		UIKeywords.clickOnElement(login_Btn);
	}
	
	public static void clickOnSignInButton() {
		UIKeywords.clickOnElement(loginSignInBtn);
	}
	
	public static void clickOnErrorInButton() {
		UIKeywords.clickOnElement(loginErrorInBtn);
	}
	
	public String getSignInMessage() {
		 return getSignInMessage.getText();
	}

	public static void RefershPage() {
		UIKeywords.refreshPage();
	}
	
	public String getErrorInMessage() {
		 return getErrorInMessage.getText();
	}

}
