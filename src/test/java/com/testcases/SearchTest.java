package com.testcases;

import com.base.Testbase; 
import com.pom.SearchFunctionality;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class SearchTest extends Testbase {
    private SearchFunctionality search;
    private String textToSearch = "iPhone";

    @BeforeMethod
    public void setup() {

        Initialization();
        search = new SearchFunctionality(driver);

    }

    @Test(priority = 1)

    public void verify_AutoSuggestionList() throws InterruptedException {
        search.searchProduct(textToSearch);
        Thread.sleep(1000);
        List<WebElement> products = search.getautosuggestedproducts();
        List<String> invalidProducts = search.getInvalidProducts(products,textToSearch);
        Assert.assertTrue(invalidProducts.isEmpty(),"Invalid products doesn't contain the searched text: "+invalidProducts.toString());
    }

    @Test(priority = 2)

    public void verify_SelectedProductAndOpenedProductMatches() throws InterruptedException {
        search.searchProduct(textToSearch);
        Thread.sleep(1000);
       List<WebElement> list= search.getautosuggestedproducts();
       if (!list.isEmpty())  {
         String selectedProductName = search.getSelectedProductName(list);
         Thread.sleep(1000);
         String productText =  search.getproduct().getText();
         String searchText=productText.replace("...","");
        Assert.assertTrue(selectedProductName.contains(searchText),selectedProductName+"notcontains"+searchText);
       }
    }
    
    
  
    @AfterMethod
    public void teardown()  {

        driver.close();

    }

}
