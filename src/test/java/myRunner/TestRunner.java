package myRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="FeatureFiles/login.feature",
		glue="stepDefinitions",
//				dryRun=true,
		//		strict=true,
		snippets=SnippetType.UNDERSCORE,
		tags= {"@test"},
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"
		})//"rerun:target/rerun.txt"

public class TestRunner {


}
