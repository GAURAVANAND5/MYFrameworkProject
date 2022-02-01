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

public class CreateOrganitionsTest {



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
				String conactName = eLib.getDataFromExcel("Contact", 1, 2)+ randomNum;
				
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
		        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		        
		         WebElement header = driver.findElement(By.className("dvHeaderText"));
		         
		         wLib.waitForElementVisibility(driver, header);
		         
		         driver.findElement(By.linkText("Contacts")).click();
		         driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		         driver.findElement(By.name("lastname")).sendKeys(conactName);
		         driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		  
		          wLib.switchToWindow(driver, "Accounts");
		    
		    
		         driver.findElement(By.name("search_text")).sendKeys(orgName);
		         driver.findElement(By.name("search")).click();
		         
		         driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		         wLib.switchToWindow(driver, "Contacts");
		         
		         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		         
		         
		    
		        wLib.mouseOver(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		        driver.findElement(By.linkText("Sign Out")).click();
		        driver.close();		
		

	}

}
