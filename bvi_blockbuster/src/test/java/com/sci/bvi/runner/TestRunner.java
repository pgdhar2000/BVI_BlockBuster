package com.sci.bvi.runner;

import java.io.IOException;
import java.util.ResourceBundle;


//import com.sci.testamigo.pqt.report.FeatureDetails;
//import com.sci.testamigo.pqt.report.ScenarioDetails;
//import com.sci.testamigo.pqt.report.StepDetails;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;

public class TestRunner {

	// ResourceBundle resourceBundle = null;
	public Runtime runtime;
	// FeatureDetails featureDeatils = new FeatureDetails();
	// ScenarioDetails scenarioDeatils = new ScenarioDetails();
	// ScenarioDetails scenarioDetails = null;
	// StepDetails stepDetails = null;

	public void BIrunnerOptions(String featureName) throws Throwable {

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			ResourceLoader resourceLoader = new MultiLoader(classLoader);
			RuntimeOptionsFactory roFactory = new RuntimeOptionsFactory(getClass());
			RuntimeOptions cucumberrun = roFactory.create();
			cucumberrun.getGlue().clear();
			// cucumberrun.addPlugin("com.cucumber.listener.ExtentCucumberFormatter");

			/*
			 * Gets the corresponding feature file, step definition and
			 * the @execute tag scenarios for execution
			 */
			// resourceBundle =
			// ResourceBundle.getBundle("ApplicationResources");
			//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
			cucumberrun.getGlue().add("com.sci.bvi.stepdef");
			cucumberrun.getFeaturePaths().clear();
			cucumberrun.getFeaturePaths().add("target//generated-test-sources//cucumber//" + featureName);
			cucumberrun.getFilters().add("@Developed");
			//cucumberrun.addPlugin({"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"});
			cucumberrun.getJunitOptions().add("com.cucumber.listener.ExtentCucumberFormatter:output/report.html");
			ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
			Runtime runtime = new cucumber.runtime.Runtime(resourceLoader, classFinder, classLoader, cucumberrun);
			runtime.run();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void BIstoprunner() {
		runtime.exitStatus();
	}

}
