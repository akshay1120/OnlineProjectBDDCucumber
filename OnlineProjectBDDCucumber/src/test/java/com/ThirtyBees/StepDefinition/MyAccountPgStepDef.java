package com.ThirtyBees.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ThirtyBees.Pages.LoginPage;
import com.ThirtyBees.Pages.MyAccountPage;
import com.ThirtyBees.testBase.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MyAccountPgStepDef extends TestBase
{
	WebDriver driver;
	LoginPage lp = null;
	MyAccountPage map = null;
	
	@Before
	public void setup() throws Throwable
	{
		driver = initialization();
		lp = new LoginPage(driver);
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}
	
	@Given("^user should be on My Account Page$")
	public void user_should_be_on_My_Account_Page() throws Throwable 
	{
	    map = lp.navigateMyAccountPg();
	}

	@Then("^actual and expected options should match$")
	public void actual_and_expected_options_should_match() throws Throwable 
	{
	   Assert.assertTrue(map.options());
	}
}
