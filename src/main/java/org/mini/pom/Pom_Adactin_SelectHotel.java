package org.mini.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Base;

public class Pom_Adactin_SelectHotel extends Base {
	
	public Pom_Adactin_SelectHotel()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="radiobutton_4")
	private WebElement radio;
	
	@FindBy (id="continue")
	private WebElement continuehotel;

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getContinuehotel() {
		return continuehotel;
	}

	}

