package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_userFunctionality {

	@FindBy(xpath = "//a[@class='btn btn-outline-primary']")
	WebElement signuppage;

	@FindBy(name = "f_name")
	WebElement firstname;

	@FindBy(name = "l_name")
	WebElement lastname;

	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "phone")
	WebElement phonenumber;
	
	
	@FindBy (id="si-password")
	WebElement password;
	
	@FindBy (name="con_password")
	WebElement confirmpassword;
	
	
	@FindBy (id="inputCheckd")
	WebElement checkbox;
	
	@FindBy (id="sign-up")
	WebElement signupbutton;
	
	
	
	public Register_userFunctionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void Register_user(String fname,String lname,String mail,String phnumber,String pass,String conpass) {
		
		signuppage.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(mail);
		phonenumber.sendKeys(phnumber);
		password.sendKeys(pass);
		confirmpassword.sendKeys(conpass);
		
		checkbox.click();
		signupbutton.click();
		
		
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

