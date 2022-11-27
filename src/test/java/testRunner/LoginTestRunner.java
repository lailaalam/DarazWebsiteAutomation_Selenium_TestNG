package testRunner;

import base.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login;
import utils.Utils;

import java.io.IOException;


@Test
public class LoginTestRunner extends Setup {


    Login login;
    Utils utils;

    @BeforeTest
    public void goToUrl() throws InterruptedException {
        driver.get("https://www.daraz.com.bd/");
        Thread.sleep(1000);
    }
   @Test(priority = 1, description ="User giving the userId lower than the given range should fail to login")
    public void doLoginWithInvalidUserIdLowerRange() throws InterruptedException, IOException, ParseException {
        //driver.get("https://www.daraz.com.bd/");
        utils=new Utils();
        utils.readUserCredentials(0);
        login=new Login(driver);
        login.doLoginWithInvalidUserIdLowerRange(utils.getPassword());
        Assert.assertTrue(login.txtValidationMsgForUsername.getText().contains("The length of the Phone or Email should be 6-60 characters."));
        Thread.sleep(1000);
    }
    /*@Test(priority = 2)
    public void doLoginWithInvalidUserIdUpperRange()
    {
       // driver.get("https://www.daraz.com.bd/");
        login=new Login(driver);
        login.doLoginWithInvalidUserIdUpperRange();
        Assert.assertTrue(login.txtValidationMsgForUsername.getText().contains("The length of the Phone or Email should be 6-60 characters."));
    }
*/

   /* public void doLoginWithInvalidUserID()
    {
        driver.get("https://www.daraz.com.bd/");
        login=new Login(driver);
        login.doLogin();
        Assert.assertTrue(login.loginValidationText.getText().contains("TRACK MY ORDER"));

    }
    /*public void doLoginWithInvalidPassword()
    {
        driver.get("https://www.daraz.com.bd/");
        login=new Login(driver);
        login.doLogin();
        Assert.assertTrue(login.loginValidationText.getText().contains("TRACK MY ORDER"));

    }*/
   @Test(priority = 2, description ="User should login successfully")
    public void doLoginWithValidCred() throws IOException, ParseException {
        //driver.get("https://www.daraz.com.bd/");
        login=new Login(driver);
        utils=new Utils();
        utils.readUserCredentials(0);
        login.doLogin(utils.getUsername(), utils.getPassword());
        //System.out.println(login.loginValidationText.getText());
        //Assert.assertTrue(login.loginValidationText.isDisplayed());

    }


}
