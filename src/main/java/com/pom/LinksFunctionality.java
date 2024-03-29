package com.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class LinksFunctionality extends Testbase{

	@FindBy(xpath = "//div[@class='col-md-3 footer-padding-bottom']//li/a")
	List<WebElement> splWebElements ;
	
	@FindBy(xpath = "//div[@class='col-md-4 footer-padding-bottom']//li/a")
	List<WebElement> AcountWebElements ;
	
	
	@FindBy(xpath = "//div[@class='mt-md-3 mt-0 mb-md-3 text-left']//span/a/i")
	List<WebElement> socialMediaButtons ;
	
	@FindBy(xpath = "//div[@class='col-md-3 footer-web-logo']")
	WebElement Equarzlogo ;
	
	
	public LinksFunctionality(WebDriver driver) {
        PageFactory.initElements(driver, this);
        }
	
	public List<WebElement> getSplWebElements() {
		
		return splWebElements;
		}
	
	public String clickAndGetProperty(WebElement element) {
		String text = element.getText();
		element.click();
		String property = prop.getProperty(text);
		return property;
	}

	public List<WebElement> getAcountWebElements() {
	
		return AcountWebElements;
	}
	

	public List<WebElement> getsocialMediaButtons() {
	
		return socialMediaButtons;
	}
	
	public String clickAndGetSocProperty(WebElement element) {
		String classAttribute = element.getAttribute("class");
		element.click();
		String property = prop.getProperty(classAttribute.replace("fa fa-", ""));
		return property;
	}
	
}	
	
	
	

