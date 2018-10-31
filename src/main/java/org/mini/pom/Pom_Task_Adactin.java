package org.mini.pom;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import stepDefinitions.Base;

public class Pom_Task_Adactin extends Base {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver=getDriver("http://www.adactin.com/HotelApp/index.php");

		Pom_Adactin_Login login=new Pom_Adactin_Login();
//		input(login.getUserName(), "AnithaTest");
		input(login.getPassword(), "Work2win!");
		btnclick(login.getLogin());

		Pom_Adactin_SearchHotel searchHotel=new Pom_Adactin_SearchHotel();
		dropDown(searchHotel.getLocation(), 2);
		btnclick(searchHotel.getSubmit());

		Pom_Adactin_SelectHotel selectHotel=new Pom_Adactin_SelectHotel();
		btnclick(selectHotel.getRadio());
		btnclick(selectHotel.getContinuehotel());

		Pom_Adactin_BookHotel bookHotel=new Pom_Adactin_BookHotel();
		input(bookHotel.getFirstName(), "Anitha");
		input(bookHotel.getLastName(), "Ramasamy");
		input(bookHotel.getAddress(), "Chennai");
		input(bookHotel.getCcNum(), "1234567890123456");
		dropDown(bookHotel.getCcType(), "VISA");
		dropDown(bookHotel.getCcExpMonth(), 2);
		dropDown(bookHotel.getCcExpYear(), 10);
		input(bookHotel.getCcCvv(), "123");
		btnclick(bookHotel.getBookNow());
		
		Pom_Adactin_Confirm_Hotel confirmhotel=new Pom_Adactin_Confirm_Hotel();	
//		impWait(driver, 10);
		Thread.sleep(5000);
		getAttribute(confirmhotel.getOrderNo(), "value");
		screenShot(driver, "Confirm_Hotel");
		btnclick(confirmhotel.getLogout());
		quitBrowser(driver);
}
}
