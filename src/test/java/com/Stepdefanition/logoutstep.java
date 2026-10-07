package com.Stepdefanition;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.logout;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logoutstep {

private logout lt = new logout(DriverFactory.getDriver());
@Given("admin in dashboard page")
public void admin_in_dashboard_page() {
	DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	Adminlogin log = new Adminlogin(DriverFactory.getDriver());
	log.clicktheadminbutton();
	Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);
    
}

@When("admin click the logout button")
public void admin_click_the_logout_button() {
	
      String actualURL=lt.getcurrentUrl();
	    System.out.println("Actual URL:"+actualURL);
	    Assert.assertTrue(actualURL.contains("courses"));
}

@Then("admin navigate to login page")
public void admin_navigate_to_login_page() {
    
}


}
