package com.Stepdefanition;

import java.util.List;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Audittrial;
import com.Pages.Dashboard;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Audittrialstep {

private Audittrial ap = new  Audittrial(DriverFactory.getDriver());
@Given("user is on the dashboard page againa")
public void user_is_on_the_dashboard_page_againa() {
	DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	Adminlogin log = new Adminlogin(DriverFactory.getDriver());
	log.clicktheadminbutton();
	Dashboard dashboard = log.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD, ConstantUtils.OTP);
  
}

@When("admin select the audit trail module")
public void admin_select_the_audit_trail_module() {
    ap.clickaudittrail();
    String actualURL=ap.getcurrentUrl();
    System.out.println("Actual URL:"+actualURL);
    Assert.assertTrue(actualURL.contains("courses"));
}

@When("admin use searchfield and find the details {string}")
public void admin_use_searchfield_and_find_the_details(String SecurityAction) {
    ap.enterdetails(SecurityAction);
}

@When("verify the result {string} with message {string}")
public void verify_the_result_with_message(String Status, String expectedmessage) {
     
     if(Status.equalsIgnoreCase("invalid"))
     {
    	 String actualMessage  = ap.getinvalidmessage();
    	Assert.assertEquals(actualMessage , expectedmessage ); 
     }
}
@When("admin clear the search field")
public void admin_clear_the_search_field() {
     ap.clearsearchfield();
}

@When("admin use the filter option")
public void admin_use_the_filter_option() {
    Assert.assertTrue(ap.isdispalyedfillterbuttton());

}

@When("admin select the course option")
public void admin_select_the_course_option() {
		ap.clickcoursseoption();
}

@When("verify the displayed result detils")
public void verify_the_displayed_result_detils() {
	List<String>actualvalue=ap.statusmessagedisplayed();
	for(String actual:actualvalue) {
		System.out.println("Status:"+actual);
		Assert.assertEquals(actual.trim(),"Courses");
}
 }

@When("admin select the  payouts option")
public void admin_select_the_payouts_option() {
	ap.clickpayoutoption();
 }

@When("verify  payout details displayed correctly")
public void verify_payout_details_displayed_correctly() {
	List<String>actualvalue=ap.statusmessagedisplayed();
	for(String actual:actualvalue) {
		System.out.println("Status:"+actual);
		Assert.assertEquals(actual.trim(),"Payouts");
	}
 }

 

@When("admin select the  batches option")
public void admin_select_the_batches_option() {
	ap.clickbatchesoption();
 }

@When("verify  batches details displayed correctly")
public void verify_batches_details_displayed_correctly() {
	List<String>actualvalue=ap.statusmessagedisplayed();
	for(String actual:actualvalue) {
		System.out.println("Status:"+actual);
		Assert.assertEquals(actual.trim(),"Batches");
	}
 }
  

@When("admin select the  institute option")
public void admin_select_the_institute_option() {
	ap.clickInstitutesoption();
 }

@When("verify  institute details displayed correctly")
public void verify_institute_details_displayed_correctly() {
	List<String>actualvalue=ap.statusmessagedisplayed();
	for(String actual:actualvalue) {
		System.out.println("Status:"+actual);
		Assert.assertEquals(actual.trim(),"Institutes");
	}
 }

@When("admin select the coupons option")
public void admin_select_the_coupons_option() {
	ap.clickcouponsoption();
 }

@When("verify  coupons details displayed correctly")
public void verify_coupons_details_displayed_correctly() { 
	List<String>actualvalue=ap.statusmessagedisplayed();
	for(String actual:actualvalue) {
		System.out.println("Status:"+actual);
		Assert.assertEquals(actual.trim(),"Coupons");
	}
 }



@When("admin select the Certificates option")
public void admin_select_the_certificates_option() {
	ap.clickcertificatesoption();
 }

@Then("verify  Certificates details displayed correctly")
public void verify_certificates_details_displayed_correctly() {
	List<String>actualvalue=ap.statusmessagedisplayed();
	for(String actual:actualvalue) {
		System.out.println("Status:"+actual);
		Assert.assertEquals(actual.trim(),"Certificates");
	}
 }


}
