package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class refundclaim {
	private final WebDriver driver;
	private ElementUtils elementUtils;

	public refundclaim(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

}
	
	@FindBy (xpath = "//*[text()='Refund Claims']")
	public WebElement refundclaimmodul;

	public String getcurrentUrl(){
		return driver.getCurrentUrl();
	}
	public void clickrefundclaim() {
		elementUtils.clickElement(refundclaimmodul);
	}
}
