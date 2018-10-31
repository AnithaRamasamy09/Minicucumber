package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	protected static WebDriver driver;
	public static WebDriver getDriver(String url) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Anitha\\MiniCucumberProject\\drivers\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(url);
		return driver;	
	}

	public static void input(WebElement element, String name)
	{
		element.sendKeys(name);

	}
	public static void btnclick(WebElement element) 
	{
		element.click();
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

	public static void switchToDefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	public static void switchTochild(WebDriver driver) {


		Set<String> allWindows = driver.getWindowHandles();

		String currWindow = driver.getWindowHandle();
		{
			for (String x : allWindows) {

				if(!currWindow.equalsIgnoreCase(x))
				{
					driver.switchTo().window(x);
				}
			}

		}
		System.out.println(currWindow);
	}

	public static void dropDown(WebElement dd, int index)
	{
		Select s=new Select(dd);
		s.selectByIndex(index);
	}

	public static void dropDown(WebElement dd, String value)
	{
		Select s=new Select(dd);
		s.selectByValue(value);
	}
	public static void dropDown(String value, WebElement dd)
	{
		Select s=new Select(dd);
		s.deselectByVisibleText(value);
	}

	public static File screenShot(WebDriver driver, String sname) throws IOException
	{
		TakesScreenshot tk=(TakesScreenshot)driver;
		File srcFile=tk.getScreenshotAs(OutputType.FILE);
		File destFile=new File("C:\\Users\\Lenovo\\Desktop\\Screenshots\\Screenshot"+sname+".jpg");
		FileUtils.copyFile(srcFile, destFile);
		return destFile;
	}

	public static void findElement(WebDriver driver, String locator)
	{
		driver.findElement(By.xpath(locator));
	}

	public static String getAttribute(WebElement element, String name)
	{
		String text = element.getAttribute(name);
		System.out.println(text);
		return text;
	}

	public static String getText(WebElement element)
	{

		String text = element.getText();
		System.out.println(text);
		return text;
	}

	public static void scrollDown(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}

	public static void jsClick(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
	}

	public static void switchFrame(WebDriver driver, String switchto)
	{
		driver.switchTo().frame(switchto);
	}

	public static void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	public static void acceptAlert()
	{
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	public static void declineAlert()
	{
		Alert al=driver.switchTo().alert();
		al.dismiss();
	}

	public static void impWait(WebDriver driver, int seconds)
	{
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}


	public static String ReadExcel(int rowNum, String columnName) throws IOException 
	{

		File fileLoc=new File("C:\\Selenium_Anitha\\Adactin_Complete_Booking\\Excel\\Adactin_TestData.xlsx");
		List<LinkedHashMap<String, String>> MapDataList=new ArrayList<LinkedHashMap<String,String>>();
		FileInputStream f=new FileInputStream(fileLoc);
		Workbook w=new XSSFWorkbook(f);
		Sheet s=w.getSheetAt(0);
		Row hRow=s.getRow(0);

		for (int i = 1; i < s.getPhysicalNumberOfRows()-1; i++)
		{
			Row currentRow=s.getRow(i);
			LinkedHashMap<String, String> mapData=new LinkedHashMap<String, String>();
			for (int j=0; j <hRow.getPhysicalNumberOfCells(); j++)
			{

				String column = hRow.getCell(j).getStringCellValue();
				Cell currentCell = currentRow.getCell(j);
				int type=currentCell.getCellType();

				if (type==1)
				{
					mapData.put(column, currentCell.getStringCellValue());
				}
				else if (type==0)
				{
					double d = currentCell.getNumericCellValue();
					long l=(long)d;
					mapData.put(column, String.valueOf(l));
				}
			}
			MapDataList.add(mapData);
		}
		return((MapDataList.get(rowNum).get(columnName)));
		

	}

	public static void WriteExcel(int row, int cell,String value) throws IOException {

		File fileLoc=new File("C:\\Selenium_Anitha\\Adactin_Complete_Booking\\Excel\\Adactin_TestData.xlsx");
		FileInputStream f=new FileInputStream(fileLoc);
		Workbook w=new XSSFWorkbook(f);
		w.getSheetAt(0).getRow(row).createCell(cell).setCellValue(value);
		FileOutputStream o=new FileOutputStream(fileLoc);
		w.write(o);
		o.close();
	}
	
}



