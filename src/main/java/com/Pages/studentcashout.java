package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;
 
public class studentcashout {
	private final WebDriver driver;
	private ElementUtils elementUtils;

	public studentcashout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		}
@FindBy(xpath = "//*[text()='Student Cashouts']")
public WebElement studentcashoutmodel;

@FindBy(xpath = " //strong")
public WebElement totalcount;

@FindBy(xpath = "//table/tbody/tr[td and not(td[contains(text(),'No cashout requests found.')])]")
public List<WebElement> displayedmessagElement;

public void clickstudentcashoutpanel() {
	elementUtils.clickElement(studentcashoutmodel);
}
public  String gettotalcount() {
	return elementUtils.getText(totalcount);
}
public  int  gettotaldisplayedmessage() {
	 return displayedmessagElement.size(); 
	 } 
}