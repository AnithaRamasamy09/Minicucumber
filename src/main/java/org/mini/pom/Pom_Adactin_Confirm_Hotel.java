package org.mini.pom;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Base;

public class Pom_Adactin_Confirm_Hotel extends Base {
	
	public Pom_Adactin_Confirm_Hotel()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="order_no")
	private WebElement orderNo;
	
	@FindBy (id="logout")
	private WebElement logout;

	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getLogout() {
		return logout;
	}
	

}
