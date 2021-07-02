package com.ThirtyBees.StepDefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ThirtyBees.Pages.LoginPage;
import com.ThirtyBees.Pages.TinCupPage;
import com.ThirtyBees.testBase.TestBase;
import com.ThirtyBees.utility.Utility;
import com.ThirtyBees.utility.WaitUtility;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TinCupPgStepDef extends TestBase
{
	WebDriver driver;
	LoginPage lp = null;
	TinCupPage tcp = null;
	
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
	
	@Given("^user should be on Tin Cup Page$")
	public void user_should_be_on_Tin_Cup_Page() throws Throwable 
	{
	   tcp = lp.navigateMyAccountPg().navigateToCoffeeAndTeaPg().navigateToTinCupPage();
	}

	@When("^user selects black colour$")
	public void user_selects_black_colour() throws Throwable 
	{
		Utility.click(tcp.blackColour);
		WaitUtility.sleep(2000);
	}

	@When("^go to add to cart page$")
	public void go_to_add_to_cart_page() throws Throwable 
	{
		Utility.click(tcp.addToCart);
		WaitUtility.sleep(2000);
		
		Utility.click(tcp.proceedToCheckout);
		WaitUtility.sleep(2000);
	}

	@Then("^user should able to see the black colour tin cup in cart$")
	public void user_should_able_to_see_the_black_colour_tin_cup_in_cart() throws Throwable 
	{
	    Assert.assertTrue(tcp.selectingColour());
	}
	
	@When("^user enters particular quantity in quantity box$")
	public void user_enters_particular_quantity_in_quantity_box() throws Throwable 
	{
		Utility.click(tcp.quantity);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		WaitUtility.sleep(2000);
		
		Utility.sendkeys(tcp.quantity, "10");
		WaitUtility.sleep(2000);
	}

	@When("^clicks on 'add to cart' button$")
	public void clicks_on_add_to_cart_button() throws Throwable 
	{
		Utility.click(tcp.addToCart);
		WaitUtility.sleep(2000);
		
		Utility.click(tcp.closeTheFrame);
		WaitUtility.sleep(2000);
	}

	@Then("^user should able to see the particular quantity in cart$")
	public void user_should_able_to_see_the_particular_quantity_in_cart() throws Throwable 
	{
	    Assert.assertTrue(tcp.selectingQuantityByInsertVal());
	}

	@When("^user selects particular quantity by using Increase Decrease button$")
	public void user_selects_particular_quantity_by_using_Increase_Decrease_button() throws Throwable 
	{
		int i ;
		
		for(i=1 ; i<10 ; i++)
		{
			Utility.click(tcp.incQuantity);
		}
	}

	@Then("^user should able to see that particular quantity in cart$")
	public void user_should_able_to_see_that_particular_quantity_in_cart() throws Throwable 
	{
	    Assert.assertTrue(tcp.selectingQuantityByIncButton());
	}
}