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
	
	@FindBy(xpath="//a[text()[normalize-space()='Forgot password?']]")
	public WebElement forgotPassword;
	
	@FindBy(id="remember")
	public WebElement rememberMe;
	
	@FindBy(xpath="//a[@class=\"btn btn-outline-primary\"]")
	public WebElement signupbutton;
	
	@FindBy(xpath="//i[@class='czi-eye password-toggle-indicator']")
	public WebElement showPassword;
	
	
		//constructor
		
		public Login_userfunctionality(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		public void login_user(String username,String password) {
			email.sendKeys(username);
			passwd.sendKeys(password);
			submit.click();
		}
		
		public void forgotPass() {
			forgotPassword.click();
	}
	
	public void remember_me() {
		rememberMe.click();
		
	}
	
	public void signup_button() {
		signupbutton.click();
	}
	
	public void show_password() {
		showPassword.click();
	}


			
			
		}
		
		

	


