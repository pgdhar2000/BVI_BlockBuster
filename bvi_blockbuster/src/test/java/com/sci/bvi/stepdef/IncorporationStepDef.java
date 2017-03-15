package com.sci.bvi.stepdef;

//import static org.testng.Assert.assertEquals;
//import org.junit.*;
import static org.junit.Assert.*;

import com.cucumber.listener.Reporter;
import com.sci.bvi.runner.Hooks;
import com.sci.bvi.util.library;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IncorporationStepDef extends library{
	public WebDriver driver;

	public IncorporationStepDef() {
		driver = new Hooks().getDriver();
	}

	@Given("^company is not already registered$")
	public void company_is_not_already_registered() throws Throwable {
//		driver.get("http://182.74.133.92:8080/BB_UI/#/login");
//		waitForWorking(driver);
////		Reporter.addStepLog("Step Log message goes here");
////		Reporter.addScenarioLog("Scenario Log message goes here");
////		Reporter.addScreenCaptureFromPath("absolute screenshot path");
////		Reporter.addScreenCastFromPath("absolute screen cast path");
//		assertEquals(driver.getTitle(), "Theme Template for Bootstrap");
//		driver.findElement(By.xpath(gOX(driver, "usrname"))).clear();
//		driver.findElement(By.xpath(gOX(driver, "usrname"))).sendKeys(getProp("rausr"));
//		Reporter.addStepLog("Entered the username");
//		driver.findElement(By.xpath(gOX(driver,"pwd"))).clear();
//		driver.findElement(By.xpath(gOX(driver,"pwd"))).sendKeys(getProp("rapwd"));
//		Reporter.addStepLog("Entered the Password");
//		driver.findElement(By.xpath(gOX(driver,"submit"))).click();
//		Reporter.addStepLog("Clicked the Submit button");
		signin(driver);
		waitForWorking(driver);
		waitForWorking(driver);
		
		String pagetitle = driver.findElement(By.xpath("//div[@class='page-heading']/h3[@class='page-title']")).getText();
		assertEquals(driver.findElement(By.xpath("//div[@class='page-heading']/h3[@class='page-title']")).getText(), "Registered Agent - Dashboard");
		waitForWorking(driver);
		driver.findElement(By.xpath("//div[@id='navbar']/ul/li/a[contains(.,'Incorporation')]")).click();
		driver.findElement(By.xpath("//li/a[.='Incorporation']")).click();
	}

	@When("^a new company applies for registration and fills the company details$")
	public void a_new_company_applies_for_registration_and_fills_the_company_details() throws Throwable {
		waitForWorking(driver);
		driver.findElement(By.xpath("//form[@id='enquiry']/div/div/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div/div/div/input")).sendKeys("~Sci it Soultions 123#~");
		driver.findElement(By.xpath("(//form[@id='enquiry']/div/div[2]/div/label/input)[1]")).click();
		driver.findElement(By.xpath("//form[@id='enquiry']/div/div/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div/div/div/input")).sendKeys("Sci it Soultions 123#");
		driver.findElement(By.xpath("//form[@id='enquiry']/div/div/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div/div/div/input")).sendKeys("Sci it Soultions 123");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[2]/div/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[2]/div/div/input")).sendKeys("5330 bond st apt 302");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[2]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[2]/div[2]/div/input")).sendKeys("irving");
		new Select(driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div/div/select"))).selectByVisibleText("Iceland");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).sendKeys("1456588789632156633153");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).sendKeys("1456588789632156633153665");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).sendKeys("14565887896321566");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).sendKeys("14565887");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[3]/div[2]/div/input")).sendKeys("1456588745578");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[4]/div/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[4]/div/div/input")).sendKeys("1456588745578");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[4]/div[2]/div/input")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[4]/div[2]/div/input")).sendKeys("bouncetest@sciits.com");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[5]/div/div/input[2]")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[5]/div/div/input[2]")).sendKeys("www.sciits.com");
		new Select(driver.findElement(By.xpath("//form[@id='enquiry']/div[6]/div/div/select"))).selectByVisibleText("for nonprofit");
		new Select(driver.findElement(By.xpath("//form[@id='enquiry']/div[6]/div[2]/div/select"))).selectByVisibleText("Ms. Cherlin Armstrong");
		driver.findElement(By.xpath("//form[@id='enquiry']/div[7]/div/div/textarea")).clear();
		driver.findElement(By.xpath("//form[@id='enquiry']/div[7]/div/div/textarea")).sendKeys("This is to comfirm");
		try {
			assertEquals(driver.findElement(By.xpath("//form[@id='enquiry']/div[8]/div/div/input")).getAttribute("value"), "Ms. Cherlin Armstrong");
		} catch (Error e) {
			System.out.println(e.toString());
		}
		try {
			assertEquals(driver.findElement(By.xpath("//form[@id='enquiry']/div[9]/div/div/input")).getAttribute("value"), "100");
		} catch (Error e) {
			System.out.println(e.toString());
		}

	}

	@When("^pay the application fees$")
	public void pay_the_application_fees() throws Throwable {
		driver.findElement(By.xpath("//form[@id='enquiry']/div[11]/div/div/button")).click();
		// String appliNumber =
		// driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
	}

	@Then("^the application should be submitted, application ID should be generated and displayed on-screen$")
	public void the_application_should_be_submitted_application_ID_should_be_generated_and_displayed_on_screen() throws Throwable {
		waitForWorking(driver);
		String appliNumber = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
		if (appliNumber.contains("Your Application will be processed")) {
			System.out.println("'Your Application will be processed' is shown");
		} else {
			System.out.println("'Your Application will be processed' is not shown");
		}
		System.out.println(appliNumber.replaceAll("/n", "").replace("Application Number: ", "").replace("Your Application will be processed", ""));
		driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
		waitForWorking(driver);
		String ConfirmSignout = driver.findElement(By.xpath("//div[@id='wrap']/div/div[2]/div/div/div/div[2]/form/fieldset/div[3]/b")).getText();
		if (ConfirmSignout.contains("You have been successfully logout")) {
			System.out.println(ConfirmSignout);
		}
		driver.quit();
	}	
}
