package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_userfunctionality {

	@FindBy (id="si-email")
	WebElement email;
	
	@FindBy (id="si-password")
	WebElement passwd;
	
	@FindBy (xpath="//button[text()='Sign in']")
	WebElement submit;
	
		//constructor
		
		public Login_userfunctionality(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		public void login_user(String username,String password) {
			email.sendKeys(username);
			passwd.sendKeys(password);
			submit.click();
					
			
			
		}
		
		

	}


