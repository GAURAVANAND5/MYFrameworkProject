package com.vtiger.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateContactTC_31 {
	
	WebDriver driver=null;
	String Url;
	String Browser;
	String Username;
	String Password;
	String Firstname;
	String Lastname;
	String Email;

	@Test(priority=1)
	public void readPropertiesFile() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("./data/commondata1.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		Browser = pobj.getProperty("browser");
		Url = pobj.getProperty("url");
		Username = pobj.getProperty("username");
		Password = pobj.getProperty("password");
	}
	@Test(priority=2)
	public void navapp() {
		
		driver=new ChromeDriver();
		driver.get(Url);	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualpage = driver.getTitle();
		String expectedpage="vtiger CRM 5 - Commercial Open Source CRM";
        Assert.assertEquals(actualpage, expectedpage);
		Reporter.log("login page displayed",true);
	}
		@Test(priority=3)
		public void login() {
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();	
	    	String actualhome = driver.findElement(By.partialLinkText("Home")).getText();
	    	String expectedhome="Home";
	    	Assert.assertEquals(actualhome, expectedhome);
	    	Reporter.log("Home page displayed",true);
		}
		
		@Test(priority=4)
		public void contactpage()
		{
		
		driver.findElement(By.linkText("Contacts")).click();
		String expectedContact="Contacts";
		String actualContact = driver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[2]")).getText();
		Assert.assertEquals(actualContact, expectedContact);
		Reporter.log("Contact page  displayed",true);
		}
	@Test(priority=5)
	public void creatingContact()
	{
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		String expectedNewContact="Creating New Contact";
		String actualNewContact = driver.findElement(By.xpath("//span[text()='Creating New Contact']")).getText();
		Assert.assertEquals(expectedNewContact, actualNewContact);
		Reporter.log("Creating New Contact page displayed",true);
	}
	@Test(priority=6)
	public void readingexceledata() throws EncryptedDocumentException, IOException {
		
		FileInputStream fisexcel=new FileInputStream("./data/TestScriptTc.xlsx");
		Workbook wb=WorkbookFactory.create(fisexcel);
		Firstname=wb.getSheet("CreateContact").getRow(1).getCell(1).getStringCellValue();
		Lastname=wb.getSheet("CreateContact").getRow(1).getCell(2).getStringCellValue();
		Email=wb.getSheet("CreateContact").getRow(1).getCell(4).getStringCellValue();
	}
	@Test(priority=7)
	public void fillcreatepage()
	{
		
		WebElement list = driver.findElement(By.name("salutationtype"));
		Select s=new Select(list);
		s.selectByValue("Mr.");
		driver.findElement(By.name("firstname")).sendKeys(Firstname);
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();	
		
		String expectedname="singh raj- Contact Information   Updated today";
		String actualname = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
		if(actualname.contains(expectedname))
		{
		Reporter.log("Contacts created successfully",true);
		}
		else
		{
			Reporter.log("Contacts is not creatd",true);
		}
		
	}
	@AfterClass
	public void logout() {
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}


