package com.Stepdefanition;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.course_moderation;
import com.Pages.institues_moderation;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dashboardstep {

	private Dashboard db=new Dashboard(DriverFactory.getDriver());
	private institues_moderation inst =new institues_moderation(DriverFactory.getDriver());
	private course_moderation cm = new course_moderation(DriverFactory.getDriver());

@Given("user is on the dashboard page")
public void user_is_on_the_dashboard_page()  {
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
	    Assert.assertTrue(actualURL.contains("admin"));
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
@Then("admin verify the  Accredited Institutes and approve count")
public void admin_verify_the_accredited_institutes_and_approve_count() {
	db.navigateBack();
    int dashboardcount =db.getAccreditedInstitutescount();
	inst.clicktheinstituesmoderation();
	inst.selecttheapproved();
     int approvecount =inst.getapprovedinstitutescount();
    System.out.println("Dashboard Count:"+dashboardcount);
    System.out.println("Approved Count:"+approvecount);

    Assert.assertEquals(approvecount,dashboardcount,"Dashboard Accredited Institutes count and Approved Institutes count mismatch");
}
@Then("admin verify the published courses and displayed count details")
public void admin_verify_the_published_courses_and_displayed_count_details() {
      db.navigateBack();
     int dashboardcount =db.getpublisedcoursescount();
     cm.clickcoursemoderation();
		cm.clickpublishoption();
     int publishedcount = cm.getDisplayedcoursecount();
     System.out.println("Dashboard Count:"+dashboardcount);
     System.out.println(" Published Count:"+publishedcount);

     Assert.assertEquals(publishedcount,dashboardcount,"Dashboard Accredited Institutes count and Approved Institutes count mismatch");
  
}
}
