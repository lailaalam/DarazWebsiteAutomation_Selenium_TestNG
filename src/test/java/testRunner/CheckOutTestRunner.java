package testRunner;

import base.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.Utils;

import java.io.IOException;


public class CheckOutTestRunner extends Setup {

    Login login;
    SearchElement searchElement;
    SelectItem selectItem;
    AddToCart addToCart;
    CheckOut checkOut;

    Utils utils;

    @BeforeTest
    public void doLoginWithSearchSelectAdditem() throws InterruptedException, IOException, ParseException {
        driver.get("https://www.daraz.com.bd/");
        utils=new Utils();
        login=new Login(driver);
        utils.readUserCredentials(0);
        login.doLogin(utils.getUsername(),utils.getPassword());
        searchElement=new SearchElement(driver);
        searchElement.searchValidElement();
        Thread.sleep(1000);
        searchElement.sortByPrice();
        selectItem=new SelectItem(driver);
        Thread.sleep(2000);
        selectItem.selectItem();
        Thread.sleep(1000);
        addToCart=new AddToCart(driver);
        addToCart.addToCart();
        Thread.sleep(1000);
    }
    @Test(priority = 1,description = "User should checkout successfully")
    public void checkOut() throws InterruptedException {
        //driver.get("https://www.daraz.com.bd/");
        //login=new Login(driver);
        //login.doLogin();
        //searchElement=new SearchElement(driver);
        //searchElement.searchValidElement();
        //Thread.sleep(1000);
       // searchElement.sortByPrice();
        //selectItem=new SelectItem(driver);
        //Thread.sleep(2000);
        //selectItem.selectItem();
        //Thread.sleep(1000);
        //addToCart=new AddToCart(driver);
        //addToCart.addToCart();
        checkOut=new CheckOut(driver);
        checkOut.checkOut();
        String msgForCheckoutValidity=checkOut.findBtnPlaceOrder.get(2).getText();
        Assert.assertTrue(msgForCheckoutValidity.contains("Place Order"));
        //checkOut.cartIcon.click();
        //checkOut.selectItemCheckbox.get(0).click();
        //checkOut.deleteIconOFCart.click();
        //checkOut.deleteIconAgreePopup.click();

    }
}
