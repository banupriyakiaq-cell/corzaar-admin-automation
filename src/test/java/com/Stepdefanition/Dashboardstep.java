package com.Stepdefanition;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dashboardstep {

	private Dashboard db=new Dashboard(DriverFactory.getDriver());

@Given("user is on the dashboard page")
public void user_is_on_the_dashboard_page() {
     DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
     Adminlogin log = new Adminlogin(DriverFactory.getDriver());
     log.clicktheadminbutton();
db = log.doLogin(ConstantUtils.EMAILID,ConstantUtils.PASSWORD,ConstantUtils.OTP); 
     }

@When("user verify the pending course cart navigation")
public void user_verify_the_pending_course_cart_navigation() {
     db.clickpecdingcourse();
     String actualURL=db.getcurrentUrl();
	    System.out.println("Actual URL:"+actualURL);
	    Assert.assertTrue(actualURL.contains("courses"));
}

@When("user verify the pending coupons cart navigation")
public void user_verify_the_pending_coupons_cart_navigation() {
	db.navigateBack();
	db.clickpecdingcoupon();
    String actualURL=db.getcurrentUrl();
	    System.out.println("Actual URL:"+actualURL);
	    Assert.assertTrue(actualURL.contains("coupons"));
}

@When("user verify the pending funds")
public void user_verify_the_pending_funds() {
	db.navigateBack();

	db.clickpecdingrefunds();
    String actualURL=db.getcurrentUrl();
	    System.out.println("Actual URL:"+actualURL);
	    Assert.assertTrue(actualURL.contains("refunds"));
}

@Then("user verify the institute approvels")
public void user_verify_the_institute_approvels() {
	db.navigateBack();

    db.clickinstituteapprovel();
    String actualURL=db.getcurrentUrl();
    System.out.println("Actual URL:"+actualURL);
    Assert.assertTrue(actualURL.contains("institutes"));
}

}
