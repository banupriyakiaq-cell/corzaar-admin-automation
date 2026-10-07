package com.Stepdefanition;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.refundclaim;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class refundclaimstep {
private refundclaim rc = new refundclaim(DriverFactory.getDriver());
	@Given("user is on the admin dashboard page")
	public void user_is_on_the_admin_dashboard_page() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		Adminlogin log = new Adminlogin(DriverFactory.getDriver());
		log.clicktheadminbutton();
		Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);
	   
	}

	@When("admin click the refund claim module")
	public void admin_click_the_refund_claim_module() {
	     rc.clickrefundclaim();
	     String actualURL=rc.getcurrentUrl();
		    System.out.println("Actual URL:"+actualURL);
		    Assert.assertTrue(actualURL.contains("courses"));
	}

}
