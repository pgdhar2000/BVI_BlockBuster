package com.sci.bvi.testsuites;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.sci.bvi.runner.TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"target/generated-test-sources/cucumber"},
    glue = {"com.sci.bvi.stepdef"},
    plugin = {"com.cucumber.listener.ExtentCucumberFormatter:test-output/report.html"}
)
public class Incorpo_Suite {

	@Test
	public void IncorpoSuiteRunner() {

		TestRunner a = new TestRunner();
		try {
			a.BIrunnerOptions("2-incorporation.feature");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	 @AfterClass
	    public static void setup() {
	        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	        Reporter.setSystemInfo("user", System.getProperty("user.name"));
	        Reporter.setSystemInfo("OS", "windows10");
	        Reporter.setTestRunnerOutput("Sample test runner output message");
	    }
}
