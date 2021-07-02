package com.ThirtyBees.Pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ThirtyBees.ObjectRepository.MyAccountPgObjRepo;
import com.ThirtyBees.utility.ExcelUtility;
import com.ThirtyBees.utility.Utility;
import com.ThirtyBees.utility.WaitUtility;

public class MyAccountPage extends MyAccountPgObjRepo
{
	WebDriver driver ;
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	
	//1
	public boolean options() throws Exception
	{
		ArrayList <String> actData = Utility.getListOfElements(options);
		log.info("actData = " + actData);
		
		ArrayList <String> expData = ExcelUtility.getTableColData("TheBees.xlsx", "MyAccountPage", 0, 1);
		log.info("expData = " + expData);
		
		if(actData.equals(expData))
		{
			log.info("Actual and Expected list matched");
			return true ;
		}
		else
		{
			log.info("Actual and Expected list not matched");
			return false ;
		}	
	}
	
	
	public CoffeeAndTeaPage navigateToCoffeeAndTeaPg() 
	{
		Utility.click(coffeeAndTeaMenu);
		WaitUtility.waitForPageLoad(10 , driver);
		WaitUtility.implicitWait(10 , driver);
		return new CoffeeAndTeaPage(driver);
	}

}
