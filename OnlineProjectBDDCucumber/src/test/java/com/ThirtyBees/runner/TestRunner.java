package com.ThirtyBees.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src/test/java/com/ThirtyBees/feature", tags = "@run",        
		glue = "com.ThirtyBees.StepDefinition",                      				
		format = {"pretty","html:test-output"},    					
		monochrome = true,                          				
		dryRun = false                          				
)

public class TestRunner 
{
	
}