package com.pom;

		//Webelements address and initiate this by using pagefactory class 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;


public class Loginfunctionality extends Testbase {

	
	//Webelements address and initiate this by using pagefactory class 
	
	@FindBy (id="si-email")
	WebElement user;
	
	@FindBy (id="si-password")
	WebElement password;
	
	@FindBy (xpath="//button[text()='Sign in']")
	WebElement submit;
	
	
	public Loginfunctionality(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
    public Homepage doLogin() {
		
		user.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		submit.click();
		
		return new Homepage();
		
	}
		
	
}	
		
	


