package com.Stepdefanition;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.studentcashout;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class studentcashoutstep {
private studentcashout sc=new studentcashout(DriverFactory.getDriver());
	@Given("admin is on the dashboard screen")
	public void admin_is_on_the_dashboard_screen() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		Adminlogin log = new Adminlogin(DriverFactory.getDriver());
		log.clicktheadminbutton();
		Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);
	}

	@When("admin click the student cashout module")
	public void admin_click_the_student_cashout_module() {
	    sc.clickstudentcashoutpanel();
	    System.out.println("successfully click student cashout panel");
	}

	@When("verify the todal count and displayed count")
	public void verify_the_todal_count_and_displayed_count() {
	     int expectedcount = Integer.parseInt(sc.gettotalcount().replaceAll("[^0-9]",""));
	     int actualcount =sc.gettotaldisplayedmessage();
	     System.out.println("ExpectedCount:"+expectedcount);
	     System.out.println("ActualCount:"+actualcount);
	     Assert.assertEquals(actualcount, expectedcount,"Student Cashout Mismatch");
	}

	@Then("logout the application")
	public void logout_the_application() {
	     
	}



}
