package stepDefinitions;
import java.util.List;

import org.mini.pom.Pom_Adactin_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Verify_Login_Page extends Base {
	@Given("^user launches adactin page$")
	public void user_launches_adactin_page() throws Throwable {
		getDriver("http://www.adactin.com/HotelApp/");
		WebElement welcome = driver.findElement(By.xpath("//p[text()='Welcome to AdactIn Group of Hotels']"));
//		Assert.assertEquals("Welcome to AdactIn Group of Hotels", welcome.getText());
	}
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
		Pom_Adactin_Login login=new Pom_Adactin_Login();

		if(login.getUserName().size()==0) {
			System.out.println("No such element boss");}

		else {
			login.EnteringUserName(username);
			login.EnteringPassword(password);
		}
	}
	@Then("^user clicks login button$")
	public void user_clicks_login_button() throws Throwable {

		driver.findElement(By.id("login")).click();
		List<WebElement>login = driver.findElements(By.xpath("//a[text()='Logout']"));
//		Assert.assertEquals("http://www.adactin.com/HotelApp/SearchHotel.php", driver.getCurrentUrl());


	}


}
