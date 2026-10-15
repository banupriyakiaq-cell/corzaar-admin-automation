 package com.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {


	private final WebDriver driver;
	private final WebDriverWait wait;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantUtils.EXPLICIT_WAIT_TIME));

	}
	public WebElement waitForElementToBeClickable(WebElement element) {

		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public WebElement waitForVisibilityOfElement(WebElement element) {

		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> element) {

		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public Alert waitForAlertIsPresent() {

		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public WebElement waitForFrameIsPresent(WebElement element) {
		return (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

	}


	//CLICK
	public void clickElement(WebElement element) {
		WebElement webelement = waitForElementToBeClickable(element);
		webelement.click();

	}

	//SENKEYS
	public void sendKeys(WebElement element, String s) {
		WebElement webelement = waitForVisibilityOfElement(element);
	
		webelement.clear();
		webelement.sendKeys(s);

	}
	//
	public int getElementcount(String xpath)
	{
		return
				driver.findElements(By.xpath(xpath)).size();
	}

	//GETTEXT
	public String getText(WebElement element) {
		WebElement webElement=waitForVisibilityOfElement(element);
 		return element.getText().trim();

	}
	//ATTRIBUTE 
	
	public String getAttributeValue(WebElement element) {
		return element.getAttribute("value");
	}
	
	//LIST
	public List<WebElement>getElements(List<WebElement>elements){
		for(WebElement element:elements)
		waitForVisibilityOfElement(element);
return elements;
	}
	
	//GETTEXTBY XPATH
public  String getTextByXpath(String xpath) {
	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	return element.getText();
	
}
	//IS DISPLAYED
	public boolean isDisplayed(WebElement element) {
		WebElement webelement = waitForVisibilityOfElement(element);
		return webelement.isDisplayed();

	}
	
	public boolean isDisplayed(String xpath) {
		return
				driver.findElements(By.xpath(xpath)).isEmpty();
	}

	//GET TITLE
	public String getTitle() {
		return driver.getTitle();

	}

	// GET CURRENT URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	// DROP DOWN (TEXT)
	public void dropDown(WebElement element, String s) {
		Select select = new Select(element);
		select.selectByVisibleText(s);

	}

	//DROP DOWN (VALUE)
	public void dropdownValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	// DROP DOWN (INDEX)
	private void dropdownIndex(WebElement element, String s) {
		Select select = new Select(element);
		select.selectByValue(s);

	}

	//MOVE TO THE ELEMENT (ACTION CLASS)
	public void moveToTheElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	//CLEAR
	public void clearField(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		el.sendKeys(Keys.DELETE);

	}

	//GET TEXTS
	public List<String> getTexts(List<WebElement> elements) {
		List<WebElement> el = waitForVisibilityOfAllElements(elements);
		List<String> texts = new ArrayList<>();
		for (WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;

	}

	// GET SIZE

	public int getSize(List<WebElement> element) {
		List<WebElement> el = waitForVisibilityOfAllElements(element);
		return el.size();

	}
	// UPLOAD USING ROBOT (WHEN INPUT IS HIDDEN)
		public void uploadUsingRobot(WebElement upload, String filePath) throws AWTException {
			WebElement el = waitForElementToBeClickable(upload);
			el.click();
			StringSelection selection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

			Robot robot = new Robot();
			robot.delay(3000);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		}
	 
	//IS ENABLED

	public boolean isEnabled(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		return el.isEnabled();

	}
	//IS SELECTED

	public boolean isSelected(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		return el.isSelected();

	}
	//IS ELEMENT PRESENT

	public boolean isElementPresent(By element) {
		return driver.findElements(element).size() > 0;

	}
	// READ OTP

	public String readOTPFromConsole() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter OTP: ");
			return sc.nextLine();
		}

	}
	//SELECT CHECK BOX

	public void selectCheckBox(WebElement cb) {
		WebElement el = waitForElementToBeClickable(cb);
		if (!cb.isSelected()) {
			el.click();
		}

	}
	//UNSELECT CHECK BOX

	public void unselectCheckBox(WebElement cb) {
		WebElement el = waitForElementToBeClickable(cb);
		if (cb.isSelected()) {
			el.click();
		}

	}

	public void selectRadiobtn(WebElement radio) {
		WebElement el = waitForElementToBeClickable(radio);
		if (!radio.isSelected()) {
			el.click();
		}

	}
	//  MOUSE HOVER TO ELEMENT

	public void hoverToElement(WebElement element1, WebElement element2) {
		WebElement ele1 = waitForVisibilityOfElement(element1);
		WebElement ele2 = waitForVisibilityOfElement(element2);
		new Actions(driver).moveToElement(ele1).moveToElement(ele2).click().perform();

	}
	//SLIDER

	public void slider(WebElement element, int value1, int value2) {
		WebElement el = waitForVisibilityOfElement(element);
		new Actions(driver).dragAndDropBy(el, value1, value2).perform();

	}
	//DOUBLE CLICK

	public void doubleClick(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		new Actions(driver).doubleClick(element).perform();

	}
	//RIGHT CLICK

	public void rightClick(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		new Actions(driver).contextClick(element).perform();

	}
	//JS CLICK

	public void jsClick(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click", element);

	}
	//JS SVG

	public void jsSVG(WebElement element) {
		WebElement el = waitForVisibilityOfElement(element);
		((JavascriptExecutor) driver)
				.executeScript("argument[0].dispatchEvent(new MouseEvent('click',{bubblers:true}));", element);

	}
	//SCROLL TO ELEMENT

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView({block:'center'});", element);
		

	}
	//SCROLL AND CLICK
	public void scrollAndClick(WebElement element)   {
		WebElement button=waitForVisibilityOfElement(element);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});",button);
 		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		 wait.ignoring(ElementClickInterceptedException.class).until(d->{
			 WebElement clickable = waitForElementToBeClickable(button);
			 clickable.click();
			 return true;
		 });
		 
		 }
 		 		
		  
	 
	
	//ACCEPT ALERT

	public void acceptAlert() {
		Alert al = waitForAlertIsPresent();
		al.accept();

	}
	//DISMISS ALERT

	public void dismissAlert() {
		Alert al = waitForAlertIsPresent();
		al.dismiss();

	}
	//TEXT ALERT

	public void textAlert(String s) {
		Alert al = waitForAlertIsPresent();
		al.sendKeys(s);

	}

	//VERIFY FILE DOWNLOAD
	public boolean verifyFileDownload(String downloadPath, String expectedFileName) {
		File folder = new File(downloadPath);
		File[] files = folder.listFiles();

		if (files == null) {
			return false;
		}
		for (File file : files) {
			if (file.getName().equals(expectedFileName)) {
				return true;
			}
		}
		return false;

	}

	//FRAME
	public void switchToFrame(WebElement element) {
		WebElement el = waitForFrameIsPresent(element);

	}

	//PARENT FRAME
	public void SwitchtoParentFrame() {
		driver.switchTo().parentFrame();

	}
	//CHILD WINDOW SWITCH

	public void childWindow(String pw) {
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(pw)) {
				driver.switchTo().window(window);
				break;
			}

		}

	}
	//PARENT WINDOW SWITCH

	public String parentWindow() {
		return driver.getWindowHandle();

	}
	//CHILD WINDOW SWITCH BY URL

	public void childWindowByUrl(String value) {
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(value)) {
				break;
			}
		}

	}
	//PARENT WINDOW SWITCH

	public void switchToParentWindow(String pw) {
		driver.switchTo().window(pw);

	}
	//CLOSE CURRENT WINDOW AND RETURNS TO PARENT

	public void closeCurrentWindowandReturns(String pw) {
		driver.close();
		driver.switchTo().window(pw);

	}
	//CLOSE ALL CHILD WINDOW

	public void closeAllChildWindow(String pw) {
		for (String window : driver.getWindowHandles()) {
			if (!window.equals(pw)) {
				driver.switchTo().window(pw);
				driver.close();
			}
		}

	}

	//UPLOAD FILES
	public void uploadFile(WebElement element, String filename) {
		WebElement el = waitForVisibilityOfElement(element);
		String filepath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + filename;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println(filepath);
		element.sendKeys(filepath);

	}

	//SCREENSHOTS
	public static String screenShot(WebDriver driver, String screenshotName) {
		String timestamp = new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date());
		String filepath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filepath);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			throw new RuntimeException("Failed to save screenshot", e);
		}
		return filepath;

	}

	 

	//DOWNLOAD AND VERIFY
	public void downloadAndVerify(WebElement element, String path, String fileName) {
		WebElement el = waitForElementToBeClickable(element);
		el.click();

		boolean status = verifyFileDownload(path, fileName);

		if (status) {
			System.out.println("File Downloaded Sucessfully");
		} else {
			System.out.println("File Not Downloaded");

		}

	}

	//AUTO COMPLETE SUGGESTION
	public void autoCompleteSuggestion(List<WebElement> suggestion, String options) {
		List<WebElement> el = waitForVisibilityOfAllElements(suggestion);
		List<WebElement> list = suggestion;
		for (WebElement item : list) {
			if (item.getText().equals(options)) {
				item.click();
				break;
			}
		}

	}
	//SVG GRAPH
	public void clickSvgElement(By locator,int index) {
		List<WebElement> elements=driver.findElements(locator);
		if(index < elements.size()) {
			elements.get(index).click();
		}else {
			throw new RuntimeException("SVG element index not found:"+index);
		}
	}
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	//AFTERVALUELOADED
public String getTextAfterValueLoaded( WebElement element) {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
	 return wait.ignoring(StaleElementReferenceException.class).     until(d-> {
		 String text  =element.getText().trim();
		 if( text .matches(".*TotalCourses:\\s*[1-9]\\d*.*") ) {
			 return text;
		 }
			  return null;
	 });
			  
	      
}
}