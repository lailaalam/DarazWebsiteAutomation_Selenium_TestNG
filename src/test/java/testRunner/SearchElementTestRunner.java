package testRunner;

import base.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login;
import pages.SearchElement;
import utils.Utils;

import java.io.IOException;

public class SearchElementTestRunner extends Setup {

    Login login;
    SearchElement searchElement;

    Utils utils;

    @BeforeTest
    public void doLoginWithValidCred() throws InterruptedException, IOException, ParseException {
        driver.get("https://www.daraz.com.bd/");
        utils=new Utils();
        login=new Login(driver);
        utils.readUserCredentials(0);
        login.doLogin(utils.getUsername(), utils.getPassword());
        Thread.sleep(1000);

    }

    @Test(priority = 1, description = "User will find no search result")
    public void searchInvalidElement() throws InterruptedException {
        //driver.get("https://www.daraz.com.bd/");
        //login=new Login(driver);
        //login.doLogin();
        searchElement=new SearchElement(driver);
        searchElement.searchInvalidElement();
        String actual=searchElement.txtFoundItemInvalidity.getText();
        String expected="No Result";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(1000);

    }

    @Test(priority = 2, description ="User should search element successfully")
    public void searchValidElement() throws InterruptedException {
        //login=new Login(driver);
        //login.doLogin();
        searchElement=new SearchElement(driver);
        searchElement.searchValidElement();
        String actual=searchElement.txtFoundItemValidity.getText();
        System.out.println(actual);
        String expected="Chess board";//"items found for";
        Assert.assertTrue(actual.contains(expected));
        Thread.sleep(1000);

    }
    @Test(priority = 3, description = "User should sort element using lower price range")
    public void sortByPrice() throws InterruptedException {
       searchElement.sortByPrice();
       String actualSortText=searchElement.sortValidityText.getText();
        System.out.println(actualSortText);
       Assert.assertTrue(actualSortText.contains("Price low to high"));
    }
}
