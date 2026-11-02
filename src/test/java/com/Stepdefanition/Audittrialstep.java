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
@Given("user is on the dashboard page again in")
public void user_is_on_the_dashboard_page_again_in()  {
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
    Assert.assertTrue(actualURL.contains("audit-logs"));
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
@When("admin verify the search field data details {string}")
public void admin_verify_the_search_field_data_details(String SecurityAction) {
	String actualValue = ap.getSearchfieldValue();
	System.out.println("Expected Value:" + SecurityAction);
	System.out.println("Actual Value:" + actualValue);
	Assert.assertEquals(actualValue, SecurityAction);
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

@When("verify the displayed result detils {string}")
public void verify_the_displayed_result_detils(String courses)  {
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

@When("verify  payout details displayed correctly {string}")
public void verify_payout_details_displayed_correctly(String payouts) {
	List<String>actualvalue=ap.statusmessagedisplayed();
	for(String actual:actualvalue) {
		System.out.println("Status:"+actual);
		Assert.assertEquals(actual.trim(),"Payouts");
	}
}

@When("admin select the  batches option")
public void admin_select_the_batches_option(){
	ap.clickbatchesoption();
 }

@When("verify  batches details displayed correctly {string}")
public void verify_batches_details_displayed_correctly(String string) {
	List<String>actualvalue=ap.statusmessagedisplayed();
	for(String actual:actualvalue) {
		System.out.println("Status:"+actual);
		Assert.assertEquals(actual.trim(),"Batches");
	}
	 

 }
  

@When("admin select the  institute option")
public void admin_select_the_institute_option() {
	//ap.clickInstitutesoption();
 }

@When("verify  institute details displayed correctly {string}")
public void verify_institute_details_displayed_correctly(String string){
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
@When("verify  coupons details displayed correctly {string}")
public void verify_coupons_details_displayed_correctly(String string)  { 
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

@Then("verify  Certificates details displayed correctly {string}")
public void verify_certificates_details_displayed_correctly(String Certificates)  {
	List<String>actualvalue=ap.statusmessagedisplayed();
	for(String actual:actualvalue) {
		System.out.println("Status:"+actual);
		Assert.assertEquals(actual.trim(),"Certificates");
	}
	 

 }
@Given("user is on the dashboard page again in auditmodule")
public void user_is_on_the_dashboard_page_again_in_auditmodule() {
    
}
@Then("admin verify the total auditcount and coutdetails displayed")
public void admin_verify_the_total_auditcount_and_coutdetails_displayed() {
	String title = ap.gettotalaudittext();
	System.out.println("Total Course text:" + title);
	int totalcount = Integer.parseInt(title.replaceAll("[^0-9]", ""));
	int displayedcount = ap.getDisplayedauditcount();
	System.out.println("TOTAL COURSE COUNT:" + totalcount);
	System.out.println("DISPLAYED COURSE COUNT :" + displayedcount);
	Assert.assertTrue(totalcount >= displayedcount, "Dispalyed courses count exceeds total course count");

}

}
