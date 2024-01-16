package com.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.pom.LinksFunctionality;
import com.pom.Loginfunctionality;


public class LinksTest extends Testbase{
	  LinksFunctionality links;
	  Loginfunctionality login;
	
	 @BeforeMethod
	    public void setup() {

	        Initialization();
	        login = new Loginfunctionality(driver);
	        links = new LinksFunctionality(driver);
	        login.doLogin();
	        
	    }
      @Test(priority = 1)

	    public void verifySpecialLinks() throws InterruptedException  {
	    List<WebElement> splWebElements = links.getSplWebElements();
	    
		for(WebElement splElement:splWebElements) {
		Thread.sleep(1000);
			String property = links.clickAndGetProperty(splElement);
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(currentUrl, property);
			driver.navigate().back();
			Thread.sleep(1000);
			 }
       }
     @Test(priority = 2)
      

	    public void verifyAccountLinks() throws InterruptedException  {
	    List<WebElement> AcountWebElements = links.getAcountWebElements();
	 
		for(WebElement accElement:AcountWebElements) {
			Thread.sleep(1000);
			String property = links.clickAndGetProperty(accElement);
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(currentUrl, property);
			driver.navigate().back();
			Thread.sleep(1000);
			 }
     }
      
      @Test(priority = 3)

	    public void verifysocialMediaLinks() throws InterruptedException  {
	    List<WebElement> socialButtons = links.getsocialMediaButtons();
	    for(WebElement socbutton:socialButtons) {
	    	Thread.sleep(1000);
	    	Reporter.log(socbutton.getAttribute("class"));
	    	
	    	String property = links.clickAndGetSocProperty(socbutton);
	    	for (String windowHandle : driver.getWindowHandles()) {
	            // Switch to the new window
	            driver.switchTo().window(windowHandle);
	        }
	       String currentUrl = driver.getCurrentUrl();
		   Assert.assertEquals(currentUrl, property);
			driver.close();
			driver.switchTo().window(driver.getWindowHandles().iterator().next());
			Thread.sleep(1000);
			 }
     }

      @AfterMethod

  	public void tearDown() {

  		driver.close();
  	}
}