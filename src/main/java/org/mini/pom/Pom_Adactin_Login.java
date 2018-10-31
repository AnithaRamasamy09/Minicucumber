package org.mini.pom;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Base;

public class Pom_Adactin_Login extends Base
{

	public Pom_Adactin_Login() {

		PageFactory.initElements(driver, this);
	}

	@FindBy (id="username")
	private List<WebElement> userName;
	
//Liberal - any of the condition 
//	@FindAll({
//		@FindBy (id="usernamdee"),
//		@FindBy (id="passwordd")
//	})
//	
//Strict.. all conditions shoudl satisfy
//	@FindBys({
//		@FindBy (id="usernamdee"),
//		@FindBy (id="passwordd")
//	})
//	

	@FindBy (id="password")
	private WebElement password;

	@FindBy (id="login")
	private WebElement login;

	public List<WebElement> getUserName() {
		return userName;
	}

	public void setUserName(List<WebElement> userName) {
		this.userName = userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}


	public void setPassword(WebElement password) {
		this.password = password;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}
	
	public void EnteringUserName(String username) {
		input(userName.get(0), username);
	}
	
	public void EnteringPassword(String pass) {
		input(password, pass);
	}



}
