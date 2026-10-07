package com.Pages;

import java.security.PublicKey;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class Adminlogin {

	private final WebDriver driver;
	private ElementUtils elementUtils;
	public Adminlogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	@FindBy(xpath = "//*[text()='Admin']")
	public WebElement adminbutton;
	
	@FindBy(id="super-admin-email")
	public WebElement emailfield;
	
	@FindBy(xpath = "//*[@type='password']")
	public WebElement passwordfield;
	
	@FindBy(xpath = "//button[normalize-space()='Authenticate Super-Admin']")
	public WebElement authenticatebuttonElement;
	
	@FindBy(id="enter-admin-2fa-code")
	public WebElement authorizefield;
	
	@FindBy(xpath = "//button[normalize-space()='Authorize Administrative Session']")
	public WebElement submitbutton;
	
	@FindBy(xpath = "//*[@class='lucide lucide-log-out w-4 h-4']")
	public WebElement adminlogout;
	
	@FindBy(xpath = "//*[normalize-space()='Invalid admin credentials']")
	public WebElement invalidemailmessag;
	
	@FindBy(xpath = "//span[contains(text(),'Invalid admin OTP')]")
	public WebElement invalidotp;
	
	@FindBy(xpath="//*[@class='text-xs font-bold text-indigo-950 dark:text-indigo-200']")
	public WebElement FAPagetext;
	
	public String getAdminPageTitle() { 
		return driver.getTitle();

	}
	public String getcurrentUrl(){
		return driver.getCurrentUrl();
	}
	public void clicktheadminbutton() {
		elementUtils.clickElement(adminbutton);
	}
	public void enterEmailid(String email) {
		elementUtils.sendKeys(emailfield, email);  
	}
	public void enterPassword(String password) {
		elementUtils.sendKeys(passwordfield, password);
	}
	public void clickauthendicatebutton() {
    elementUtils.scrollAndClick(authenticatebuttonElement);		
	}
	public void enterpasscode(String otp) {
		elementUtils.sendKeys(authorizefield, otp);
	}
	public void clicksubmitbutton() {
		elementUtils.scrollAndClick(submitbutton);
	}
	public String getvalidationMessage() {
		 return  elementUtils.getTextByXpath("//*[normalize-space()='Invalid admin credentials']");
	}
	public String getvalidationMessageotp() {
		String message=elementUtils.getText(invalidotp);
		return message;
	}
	public void dipalyedfapage() {
		elementUtils.isDisplayed(FAPagetext);
	}
	public Dashboard doLogin(String  email, String password,String otp) {
		elementUtils.sendKeys(emailfield,email);
		elementUtils.sendKeys(passwordfield, password);
		elementUtils.scrollAndClick(authenticatebuttonElement);
		elementUtils.sendKeys(authorizefield,otp);
		elementUtils.clickElement(submitbutton);
		 
		return new Dashboard(driver);
		
	}
}
