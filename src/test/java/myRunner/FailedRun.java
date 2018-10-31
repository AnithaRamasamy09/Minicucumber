package myRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "@target/rerun.txt",
		glue= "stepDefinitions",
		plugin= "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
		)
public class FailedRun {

}
