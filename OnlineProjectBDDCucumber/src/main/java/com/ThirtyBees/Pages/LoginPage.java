package com.ThirtyBees.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ThirtyBees.ObjectRepository.LoginPgObjRepo;
import com.ThirtyBees.utility.Utility;
import com.ThirtyBees.utility.WaitUtility;

public class LoginPage extends LoginPgObjRepo
{
	WebDriver driver ;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	
	//1
	public void validLogin ()
	{
		Utility.sendkeys(emailAddr, prop.getProperty("uname"));
		Utility.sendkeys(pass, prop.getProperty("password"));
		Utility.click(signInButton);
		WaitUtility.waitForPageLoad(5 , driver);
		WaitUtility.implicitWait(5 , driver);
	}
	
	public boolean verifyValidLogin()
	{	
		String actUrl = Utility.getCurrentUrl(driver);
		log.info("actual Url = " + actUrl);
		
		String expUrl = "http://javabykiran.in/Other/thbees/my-account";
		log.info("Expected Url = " + expUrl);
		
		if(actUrl.equals(expUrl))
		{
			log.info("Actual and expected Url matched");
			return true ;
		}
		else
		{
			log.info("Actual and expected Url not matched");
			return false ;
		}
	}
	
	
	
	public MyAccountPage navigateMyAccountPg() 
	{
		Utility.click(signIn);
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		
		Utility.sendkeys(emailAddr, "asjain3031@gmail.com");
		Utility.sendkeys(pass, "425114");
		Utility.click(signInButton);
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		
		return new MyAccountPage(driver);
	}
}
