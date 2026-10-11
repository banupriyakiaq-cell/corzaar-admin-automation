package com.Pages;

import java.util.List;

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
	
	@FindBy (xpath = "//strong")
	public WebElement totalrefundcount;
	
	@FindBy(xpath = "//table/tbody/tr")
	public List<WebElement> totalrefunddisplayeddetails;
	
	@FindBy(xpath = "//*[text()='Approve']")
	public WebElement Approvebutton;
	
	@FindBy(xpath="//*[@class='lucide lucide-x w-5 h-5']")
	public WebElement approvecancelicon;
	
	@FindBy(xpath = " //*[text()='Cancel']")
	public WebElement approvecancelbutton;
	
	@FindBy(id = "resolution-notes")
	public WebElement approveinputnotesfield;
	
	@FindBy(xpath = " //*[text()='Confirm ']")
	public WebElement confirmapprovebutton;
	
	@FindBy(xpath = "//*[text()='Reject']")
	public WebElement rejectbutton;
	
	@FindBy(xpath = " //*[@class='lucide lucide-x w-5 h-5']")
	public WebElement rejectcancelicon;
	
	@FindBy(xpath = " //*[text()='Cancel']")
	public WebElement rejectcancelbutton;
	
	@FindBy(xpath = " //*[text()='Rejection']")
	public WebElement confirmrejectionbutton;
	
	@FindBy(id = "resolution-notes")
	public WebElement rejectinputnotesfield;

	public String getcurrentUrl(){
		return driver.getCurrentUrl();
	}
	public void clickrefundclaim() {
		elementUtils.clickElement(refundclaimmodul);
	}
	public void clickrejectbutton() {
		elementUtils.clickElement(rejectbutton);;
	}
	public void clickApprovebutton() {
		elementUtils.clickElement(Approvebutton);;
	}
	public String gettotalrefundtext() {
		return elementUtils.getText(totalrefundcount).trim();

	}
   public int getDisplayedrefundcount() {
		return elementUtils.getSize(totalrefunddisplayeddetails);
	}
   
   public void enterapprovenotesfield(String Approvenotes) {
	   elementUtils.sendKeys( approveinputnotesfield, Approvenotes);
   }
   public void clickapprovecancelbutton() {
	   elementUtils.clickElement(approvecancelbutton); 
   }
    public void clickapprovecancelicon() {
    	elementUtils.clickElement(approvecancelicon);
    }
   public void clickconfirmapprovebutton() {
	elementUtils.clickElement(confirmapprovebutton);
}
//   public void enterrejectnotesfield(String  ) {
//	   elementUtils.sendKeys(  rejectinputnotesfield,   );
//   }
   public void clickrejectcancelbutton() {
	   elementUtils.clickElement( rejectcancelbutton); 
   }
    public void clickrejectcancelicon() {
    	elementUtils.clickElement( rejectcancelicon);
    }
   public void clickrejectmapprovebutton() {
	elementUtils.clickElement( confirmrejectionbutton);
}	
   public String getapproveinputfieldValue() {
		return
	 elementUtils.getAttributeValue( approveinputnotesfield);
	}
   
   public String getrejectinputfieldValue() {
		return
	 elementUtils.getAttributeValue( rejectinputnotesfield);
	}
   
   public String getApprovalnotesvalidationmessage() {
	   return elementUtils.getText(Approvebutton);
   }
}
