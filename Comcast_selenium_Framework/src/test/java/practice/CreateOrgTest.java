package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String Browser = pobj.getProperty("browser");
		String Url = pobj.getProperty("url");
		String Username = pobj.getProperty("username");
		String Password = pobj.getProperty("password");
		
		
		FileInputStream fisexcel=new FileInputStream("./data/testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fisexcel);
		String orgName=wb.getSheet("CreateOrg").getRow(3).getCell(2).getStringCellValue();
		String websitename = wb.getSheet("CreateOrg").getRow(3).getCell(3).getStringCellValue();
	    String phno = wb.getSheet("CreateOrg").getRow(3).getCell(4).getStringCellValue();
		String email= wb.getSheet("CreateOrg").getRow(3).getCell(5).getStringCellValue();
		
		WebDriver driver=null;
		
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();	
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.name("website")).sendKeys(websitename);
		driver.findElement(By.name("phone")).sendKeys(phno);
		driver.findElement(By.id("email1")).sendKeys(email);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String actualText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actualText.contains(orgName))
		{
			System.out.println("Org successfully ceated and pass");
		}
		else
		{
			System.out.println("Org  is not ceated and fail");
		}
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		

	}

}
