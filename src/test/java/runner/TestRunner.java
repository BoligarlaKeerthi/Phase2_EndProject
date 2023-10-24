package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features ="C:\\Users\\HP\\eclipse-workspace\\2022\\Phase2_EndprojectCucumber\\src\\test\\java\\features\\starhealth.feature",
	glue = {"steps"},
	dryRun = false,
	plugin = {"pretty",
			  "html:target/myreport.html",
			  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			  "timeline:test-output-thread/"	
			
	
	}, 
	
	monochrome = true 
	
		
		)


public class TestRunner {

}
