package stepdefination;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		dryRun=false,
		monochrome=true,
		features="src/test/resources/features",
		glue={"stepdefination"},
		tags= ("@Scenario4"),
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class Junit_Runner {

}
