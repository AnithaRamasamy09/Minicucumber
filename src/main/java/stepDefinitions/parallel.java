package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class parallel {

	@Given("^user login$")
	public void user_login() throws Throwable {
		
		System.out.println("hi");
	}

	@When("^user cicks$")
	public void user_cicks() throws Throwable {
		System.out.println("hi");
	}

	@Then("^user logouts$")
	public void user_logouts() throws Throwable {
		System.out.println("hi");
	}
}
