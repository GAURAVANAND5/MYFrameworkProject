package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {

	public Contact(WebDriver driver) {

			PageFactory.initElements(driver ,this);
		}
		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement createContactImg;
		
		public WebElement getCreateContactImg() {
			return createContactImg;
		}
		
	}


