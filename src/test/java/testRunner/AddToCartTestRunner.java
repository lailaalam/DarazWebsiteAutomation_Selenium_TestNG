package testRunner;

import base.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddToCart;
import pages.Login;
import pages.SearchElement;
import pages.SelectItem;
import utils.Utils;

import java.io.IOException;

public class AddToCartTestRunner extends Setup {

    Login login;
    SearchElement searchElement;
    SelectItem selectItem;
    AddToCart addToCart;

    Utils utils;

    @BeforeTest
    public void doLoginWithSearchSelectElement() throws InterruptedException, IOException, ParseException {
        driver.get("https://www.daraz.com.bd/");
        login=new Login(driver);
        utils=new Utils();
        utils.readUserCredentials(0);
        login.doLogin(utils.getUsername(), utils.getPassword());
        searchElement=new SearchElement(driver);
        searchElement.searchValidElement();
        Thread.sleep(1000);
        searchElement.sortByPrice();
        selectItem=new SelectItem(driver);
        Thread.sleep(1000);
        selectItem.selectItem();
        Thread.sleep(1000);
    }
    @Test(priority = 1,description = "User Should add a product to cart successfully")
    public void addToCart() throws InterruptedException {
        //driver.get("https://www.daraz.com.bd/");
        //login=new Login(driver);
        //login.doLogin();
        //searchElement=new SearchElement(driver);
        //searchElement.searchValidElement();
        //Thread.sleep(1000);
        //searchElement.sortByPrice();
        //selectItem=new SelectItem(driver);
        //Thread.sleep(1000);
        //selectItem.selectItem();
        //Thread.sleep(1000);
        addToCart=new AddToCart(driver);
        addToCart.addToCart();
        String validationMsg=addToCart.textCardValidationMessage.getText();
        Assert.assertTrue(validationMsg.contains("have been added to your cart"));


    }


}
