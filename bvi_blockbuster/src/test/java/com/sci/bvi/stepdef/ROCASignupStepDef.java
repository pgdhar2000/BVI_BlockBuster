package com.sci.bvi.stepdef;

import static org.junit.Assert.*;

import org.junit.Test;
import com.cucumber.listener.Reporter;
import com.sci.bvi.runner.Hooks;
import com.sci.bvi.util.library;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class ROCASignupStepDef extends library{

	public RemoteWebDriver driver;

	public ROCASignupStepDef() {
		driver = new Hooks().getDriver();
	}
	@Given("^That the ROCA is not already registered$")
	public void that_the_ROCA_is_not_already_registered() throws Throwable {
		driver.findElement(By.id("signin_btn")).click();
	    driver.findElement(By.id("admin")).click();
	    driver.findElement(By.id("login_roca")).click();
	    driver.findElement(By.id("reg_ra")).click();

	   

	    
	    throw new PendingException();
	}

	@When("^Fills the all details correctly in the Authentication Details$")
	public void fills_the_all_details_correctly_in_the_Authentication_Details() throws Throwable {
	    driver.findElement(By.id("username_tb")).clear();
	    driver.findElement(By.id("username_tb")).sendKeys("ROcausername");
	    driver.findElement(By.id("password_tb")).clear();
	    driver.findElement(By.id("password_tb")).sendKeys("rocapwd");
	    driver.findElement(By.id("conf_password_tb")).clear();
	    driver.findElement(By.id("conf_password_tb")).sendKeys("rocaconfirm");
	    driver.findElement(By.id("pass_ques_tb")).clear();
	    driver.findElement(By.id("pass_ques_tb")).sendKeys("password question");
	    driver.findElement(By.id("pass_answ_tb")).clear();
	    driver.findElement(By.id("pass_answ_tb")).sendKeys("password answer");
	    
	}

	@When("^Fills the all details correctly in the Organization Details$")
	public void fills_the_all_details_correctly_in_the_Organization_Details() throws Throwable {
		driver.findElement(By.id("org_name_tb")).clear();
		driver.findElement(By.id("org_name_tb")).sendKeys("orgname");
	}

	@When("^Fills the all details correctly in the Personal Details$")
	public void fills_the_all_details_correctly_in_the_Personal_Details() throws Throwable {
	    driver.findElement(By.id("fname_tb")).clear();
	    driver.findElement(By.id("fname_tb")).sendKeys("first name");
	    driver.findElement(By.id("mname_tb")).clear();
	    driver.findElement(By.id("mname_tb")).sendKeys("middle name");
	    driver.findElement(By.id("lname_tb")).clear();
	    driver.findElement(By.id("lname_tb")).sendKeys("lastnme");
	}

	@When("^Fills the all details correctly in the Contact Details$")
	public void fills_the_all_details_correctly_in_the_Contact_Details() throws Throwable {
		driver.findElement(By.id("email_tb")).clear();
	    driver.findElement(By.id("email_tb")).sendKeys("email@address.com");
	    driver.findElement(By.id("phn_number_tb")).clear();
	    driver.findElement(By.id("phn_number_tb")).sendKeys("12457896378");
	    driver.findElement(By.id("fax_tb")).clear();
	    driver.findElement(By.id("fax_tb")).sendKeys("14567893214");
	}

	@When("^Fills the all details correctly in the Address Details$")
	public void fills_the_all_details_correctly_in_the_Address_Details() throws Throwable {
		driver.findElement(By.id("email_tb")).clear();
	    driver.findElement(By.id("email_tb")).sendKeys("email@address.com");
	    driver.findElement(By.id("phn_number_tb")).clear();
	    driver.findElement(By.id("phn_number_tb")).sendKeys("12457896378");
	    driver.findElement(By.id("fax_tb")).clear();
	    driver.findElement(By.id("fax_tb")).sendKeys("14567893214");
	    driver.findElement(By.id("addr_line1_tb")).clear();
	    driver.findElement(By.id("addr_line1_tb")).sendKeys("addressline1");
	    driver.findElement(By.id("addr_line2_tb")).clear();
	    driver.findElement(By.id("addr_line2_tb")).sendKeys("addresslin2");
	    driver.findElement(By.id("city_tb")).clear();
	    driver.findElement(By.id("city_tb")).sendKeys("city");
	    driver.findElement(By.id("state_tb")).clear();
	    driver.findElement(By.id("state_tb")).sendKeys("state");
	    new Select(driver.findElement(By.id("country"))).selectByVisibleText("uda");
	    driver.findElement(By.id("zip_code_tb")).clear();
	    driver.findElement(By.id("zip_code_tb")).sendKeys("4578965566");
	    throw new PendingException();
	}

	@Then("^click on the save button$")
	public void click_on_the_save_button() throws Throwable {
		driver.findElement(By.id("save_button")).click();
	    throw new PendingException();
	}

	@Then("^check if it exist in the super user dashboard for approval$")
	public void check_if_it_exist_in_the_super_user_dashboard_for_approval() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
