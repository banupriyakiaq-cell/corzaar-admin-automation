package com.Pages;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.security.PublicKey;

import javax.swing.JScrollBar;

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
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//*[text()='Admin']")
	public WebElement adminbutton;

	@FindBy(id = "super-admin-email")
	public WebElement emailfield;

	@FindBy(xpath = "//*[@type='password']")
	public WebElement passwordfield;

	@FindBy(xpath = "//button[.//span[normalize-space()='Authenticate Super-Admin']]")
	public WebElement authenticatebuttonElement;

	@FindBy(id = "enter-admin-2fa-code")
	public WebElement otpfield;

	@FindBy(xpath = "//button[normalize-space()='Authorize Administrative Session']")
	public WebElement submitbutton;

	@FindBy(xpath = "//*[@class='lucide lucide-log-out w-4 h-4']")
	public WebElement adminlogout;

	@FindBy(xpath = "//*[normalize-space()='Invalid admin credentials']")
	public WebElement invalidemailmessag;

	@FindBy(xpath = "//span[contains(text(),'Invalid admin OTP')]")
	public WebElement invalidotp;

	@FindBy(xpath = "//*[@class='text-xs font-bold text-indigo-950 dark:text-indigo-200']")
	public WebElement FAPagetext;

	public String getAdminPageTitle() {
		return driver.getTitle();

	}

	public String getcurrentUrl() {
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
		elementUtils.sendKeys(otpfield, otp);
	}

	public void clicksubmitbutton() {
		elementUtils.scrollAndClick(submitbutton);
	}

	public String getvalidationMessage() {
		return elementUtils.getTextByXpath("//*[normalize-space()='Invalid admin credentials']");
	}

	public String getvalidationMessageotp() {
		String message = elementUtils.getText(invalidotp);
		return message;
	}

	public void dipalyedfapage() {
		elementUtils.isDisplayed(FAPagetext);
	}

	public Dashboard doLogin(String email, String password, String otp) {
		elementUtils.clearField(emailfield);
		elementUtils.sendKeys(emailfield, email);
		elementUtils.sendKeys(passwordfield, password);
		elementUtils.scrollAndClick(authenticatebuttonElement);
		elementUtils.sendKeys(otpfield, otp);
		elementUtils.clickElement(submitbutton);

		return new Dashboard(driver);

	}

	public String getEmailValidationMessage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		System.out.println("Email Value:"+emailfield.getAttribute("value"));
		System.out.println("Email Required:" + js.executeScript("return arguments[0].required;", emailfield));
		System.out.println("Email validity:" + js.executeScript("return arguments[0].validity.valid;", emailfield));
		return (String) js.executeScript("return arguments[0].validationMessage;", emailfield);
	}

	public String getpasswordValidationMessage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		return (String) js.executeScript("return arguments[0].validationMessage;", passwordfield);
	}

	public String getotpValidationMessage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		return (String) js.executeScript("return arguments[0].validationMessage;", otpfield);
	}
	public void clickauthendicateWithEmptyEmail() {
		elementUtils.clearField(emailfield);
		elementUtils.scrollAndClick(authenticatebuttonElement);
		
	}
	public void clickauthendicateWithEmptyPassword() {
		elementUtils.clearField(passwordfield);
		elementUtils.scrollAndClick(authenticatebuttonElement);
		
	}
}
