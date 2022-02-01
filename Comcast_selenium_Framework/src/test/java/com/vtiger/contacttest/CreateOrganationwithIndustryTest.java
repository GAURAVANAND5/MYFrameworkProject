package com.vtiger.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GenericLibaray.ExcelUtility;
import com.crm.GenericLibaray.FileUtility;
import com.crm.GenericLibaray.JavaUtility;
import com.crm.GenericLibaray.WebDriverUtility;

public class CreateOrganationwithIndustryTest {



	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		int randomNum=jLib.getRandomNumber();
		
		String BROWSER = fLib.getFileProperty("browser");
		String URL = fLib.getFileProperty("url");
		String USERNAME = fLib.getFileProperty("username");
		String PASSWORD = fLib.getFileProperty("password");
		
		        String orgName=eLib.getDataFromExcel("Contact", 1, 3)+randomNum;
		        String industryName = eLib.getDataFromExcel("Contact", 1, 5);
		
				
				WebDriver driver=null;
				if(BROWSER.equalsIgnoreCase("Chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}
				else
				{
					System.out.println("invalid Browser");
				}
				
				wLib.waitUntilPageLoad(driver);
				driver.get(URL);
				wLib.windowMaximize(driver);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();	
				
				driver.findElement(By.linkText("Organizations")).click();
				
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				
				WebElement Industrylist = driver.findElement(By.name("industry"));
				
				wLib.select(Industrylist, industryName);
				
				 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 driver.findElement(By.linkText("Organizations")).click();
		         
				    
			        wLib.mouseOver(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
			        driver.findElement(By.linkText("Sign Out")).click();
			        driver.close();		
	}

}
