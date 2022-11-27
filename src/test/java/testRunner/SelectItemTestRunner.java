package testRunner;

import base.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login;
import pages.SearchElement;
import pages.SelectItem;
import utils.Utils;

import java.io.IOException;

public class SelectItemTestRunner extends Setup {
    Login login;
    SearchElement searchElement;
    SelectItem selectItem;

    Utils utils;
    @BeforeTest
    public void doLoginWithElmentSearch() throws InterruptedException, IOException, ParseException {
        driver.get("https://www.daraz.com.bd/");
        login=new Login(driver);
        utils=new Utils();
        utils.readUserCredentials(0);
        login.doLogin(utils.getUsername(),utils.getPassword());
        searchElement=new SearchElement(driver);
        searchElement.searchValidElement();
        Thread.sleep(1000);
        searchElement.sortByPrice();
        Thread.sleep(1000);
    }
    @Test(priority = 1, description = "User should select the correct item")
    public void selectItem()  {
        selectItem=new SelectItem(driver);
        selectItem.selectItem();
        String txtSelectActual=selectItem.txtItemName.getText();
        Assert.assertEquals(txtSelectActual,"3 in 1 Chess Ludu Snake PVC");
    }
}
