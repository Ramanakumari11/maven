package com.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.pom.Login_userfunctionality;
import com.pom.Loginfunctionality;
import com.utils.Utils;

public class Loginpage extends Testbase {

	Login_userfunctionality login;
	String Excelsheet_name = "Login";
	String Excelsheet_name1 = "invalid";
	 @DataProvider
	
	public String[][] datatest() throws Throwable {
		return Utils.setdata(Excelsheet_name);
	}
	 
	 @DataProvider
		
		public String[][] datatest1() throws Throwable {
			return Utils.setdata(Excelsheet_name1);
		}

	@BeforeMethod

	public void Setup() {

		Initialization();
		login = new Login_userfunctionality(driver);

	}

   @Test(priority = 1 ,dataProvider="datatest",dataProviderClass=Loginpage.class)

	public void verifyLogin(String username, String password) {

		login.login_user(username, password);
		

		String homepageurl = driver.getCurrentUrl();

		Assert.assertEquals("https://e-quarz.com/", homepageurl);
	}

   
   
   @Test(priority = 2 ,dataProvider="datatest1",dataProviderClass=Loginpage.class)

  	public void verifyLogin1(String username, String password) {

  		login.login_user(username, password);
  	
  		String homepageurl = driver.getCurrentUrl();

  		Assert.assertNotEquals("https://e-quarz.com/", homepageurl);
  	}

	@AfterMethod

	public void tearDown() {

		driver.close();
	}

}
