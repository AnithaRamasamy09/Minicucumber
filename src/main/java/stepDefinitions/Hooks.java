package stepDefinitions;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.it.Date;

public class Hooks extends Base{

	@Before	public void beforeScenario() {

		System.out.println("You are in before scenario");
		long threadId = Thread.currentThread().getId();
	    String processName = ManagementFactory.getRuntimeMXBean().getName();
	    System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
	}

	@After public void afterScenario(Scenario scenario) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		if(scenario.isFailed())
		{
			File f=screenShot(driver,"Screen"+timeStamp);
			Reporter.addScreenCaptureFromPath(f.toString());
			System.out.println(f.toString());
		}
		quitBrowser(driver);
	}

}
