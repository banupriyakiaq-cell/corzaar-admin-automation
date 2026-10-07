package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class logout {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public logout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
}
	@FindBy(xpath = " //*[@class='lucide lucide-log-out w-4 h-4']")
	public WebElement logoutbutton;
	
	public String getcurrentUrl(){
		return driver.getCurrentUrl();
	}
	public void clicklogoutbutton() {
		elementUtils.clickElement(logoutbutton);
	}
}