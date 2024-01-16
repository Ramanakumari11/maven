package com.pom;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchFunctionality {

    @FindBy(xpath = "//input[@class='form-control appended-form-control search-bar-input']")
    WebElement searchBar;

    @FindBy(xpath = "//div[@class='input-group-overlay d-none d-md-block mx-4']//li/a")
    List<WebElement> listItems;

    @FindBy(xpath = "//div[@class='text-left pl-3']/a")
    WebElement product;


    public SearchFunctionality(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void searchProduct(String text) throws InterruptedException{
        
    	for(int i=0;i<text.length();i++) {
			searchBar.sendKeys(""+text.charAt(i));
	}
      
    Thread.sleep(1000);
    }
    public List<WebElement> getautosuggestedproducts() {
   
     return  listItems;  
        }
    
		

    public List<String> getInvalidProducts(List<WebElement> products, String textToSearch) {
        List<String> invalidProducts = new ArrayList<>();
        for(WebElement product:products){
            if(!product.getText().contains(textToSearch)){
                invalidProducts.add(product.getText());
            }
        }
        return invalidProducts;
    }

    
    public WebElement getproduct()
      {
    	return product ;
      }

	

	public String getSelectedProductName(List<WebElement> list) {
		 WebElement webElement = list.get(0);
		 String text = webElement.getText();
	        webElement.click();
	        return text;   
	}

}
	
	
	
	
	
	
	
	
	
	
