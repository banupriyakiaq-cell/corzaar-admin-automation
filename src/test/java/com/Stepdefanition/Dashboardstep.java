package com.Stepdefanition;

import org.testng.Assert;

import com.Pages.Adminlogin;
import com.Pages.Dashboard;
import com.Pages.coupon_approval;
import com.Pages.course_moderation;
import com.Pages.institues_moderation;
import com.Pages.refundclaim;
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
	private coupon_approval ca =new coupon_approval(DriverFactory.getDriver());
	private refundclaim rc = new refundclaim(DriverFactory.getDriver());

@Given("user is on the dashboard page")
public void user_is_on_the_dashboard_page()  {
     DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
     Adminlogin log = new Adminlogin(DriverFactory.getDriver());
     log.clicktheadminbutton();
db = log.doLogin(ConstantUtils.EMAILID,ConstantUtils.PASSWORD,ConstantUtils.OTP); 
     }

@When("user verify the pending course cart navigation")
public void user_verify_the_pending_course_cart_navigation() {
	String dashboardcount =db.getpendingcoursecount();
      db.clickpedingcourse();
     String actualURL=db.getcurrentUrl();
	    System.out.println("Actual URL:"+actualURL);
	    Assert.assertTrue(actualURL.contains("admin"));
	    cm.clickunderreview();
	    int pendingcourse = cm.gettotalcoursedetails();
	    System.out.println("Dashboard Count:"+dashboardcount);
	    System.out.println("PendingCourse Count:"+ pendingcourse);
Assert.assertEquals(pendingcourse,Integer.parseInt(dashboardcount.trim()),"Dashboard Count and pending Course count Mismatch"); 	
}

@When("user verify the pending coupons cart navigation")
public void user_verify_the_pending_coupons_cart_navigation() {
	db.navigateBack();
	 String dashboardcount =db.getpendingcouponcount();
	db.clickpecdingcoupon();
    String actualURL=db.getcurrentUrl();
	    System.out.println("Actual URL:"+actualURL);
	    Assert.assertTrue(actualURL.contains("coupons"));
	    ca.clickpendingoption();
	   int pendingcoupon = ca.getDisplayedcouponcount();
	    System.out.println("Dashboard Count:"+dashboardcount);
	    System.out.println("PendingCoupon Count:"+ pendingcoupon );
	     Assert.assertEquals(pendingcoupon, dashboardcount.trim(),"Dashboard Pendingcoupon count and pendigcount displayed count mismatch");
}

@When("user verify the pending funds")
public void user_verify_the_pending_funds() {
	db.navigateBack();
String dashboardcount =db.getpendingrefundcount();
	db.clickpecdingrefunds();
    String actualURL=db.getcurrentUrl();
	    System.out.println("Actual URL:"+actualURL);
	    Assert.assertTrue(actualURL.contains("refunds"));
	    
	  int pendingrefuntcount =rc.getpendingstatuscount();  
	  System.out.println("Dashboard Count:"+dashboardcount);
	    System.out.println("PendingRefund Count:"+ pendingrefuntcount );
	    Assert.assertEquals(pendingrefuntcount, dashboardcount.trim(),"Dashboard PendingRefund count and pendigrefuntcount displayed count mismatch");

}

@Then("user verify the institute approvels")
public void user_verify_the_institute_approvels() {
	db.navigateBack();
	String dashboardcount =db.getinstitutesapprovalcount();
    db.clickinstituteapprovel();
    String actualURL=db.getcurrentUrl();
    System.out.println("Actual URL:"+actualURL);
    Assert.assertTrue(actualURL.contains("institutes"));
    inst.selectthepending();
    int instituteapprovalcount = inst.getPendingInstituteCount();
    System.out.println("Dashboard Count:"+dashboardcount);
    System.out.println(" Institutesapproval Count:"+instituteapprovalcount );
   Assert.assertEquals(instituteapprovalcount, dashboardcount.trim(),"Dashboard institutesapproval count and  Approval institutes displayed count mismatch");
    
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
@Then("admin verify the register learner card count and displated details")
public void admin_verify_the_register_learner_card_count_and_displated_details() {
     db.navigateBack();
     int dashboardcount = db.getinstitutelearnercount();
     inst.clicktheinstituesmoderation();
     int RegisteredLearners = inst.getDisplayedinstitutecount();
     System.out.println("Dashboard Count:"+dashboardcount);
     System.out.println("Total institues count:"+RegisteredLearners);
     Assert.assertEquals( RegisteredLearners,dashboardcount,"Dashboard Registered Learners count and total learners count mismatch");
}
@Then("admin verify the onboarding learner card count and displayed details")
public void admin_verify_the_onboarding_learner_card_count_and_displayed_details() {
     
	db.navigateBack();
	String dashboardcount=db.getpendingonboardingcount();
	inst.clicktheinstituesmoderation();
	inst.selectthepending();
	int pendingonboarding =inst.getPendingInstituteCount();
	System.out.println("Dashboard Count:"+dashboardcount);
	System.out.println("Pending Institute Count"+pendingonboarding);
	 Assert.assertEquals(pendingonboarding,dashboardcount,"Dashboard count and Pending Institute count mismatch");
}

@Then("admin verify the reviwe queue and displayed details")
public void admin_verify_the_reviwe_queue_and_displayed_details() {
    db.navigateBack();
    String dashboardcount = db.getReviewQueueCount();
    cm.clickcoursemoderation();
    cm.clickunderreview();
     int underreviewcount = cm.getDisplayedcoursecount();
 	System.out.println("Dashboard Count:"+dashboardcount);
 	System.out.println("Under Review Queue:"+underreviewcount);
 	 Assert.assertEquals(underreviewcount,  dashboardcount,"Dashboard count and underreviewcount count mismatch");
}


}
