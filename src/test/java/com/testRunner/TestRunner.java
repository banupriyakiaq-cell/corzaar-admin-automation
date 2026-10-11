package com.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
			features = {"src\\test\\resources\\com.Feature\\Dashboard.feature"},
			glue = {"com.Stepdefanition","com.hooksClass"},
			//tags="@otp",
			plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
			)
	public class TestRunner extends AbstractTestNGCucumberTests {
	 
	}
