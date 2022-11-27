package pages;

import base.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login {

    WebDriver driver;

    @FindBy(xpath="//a[contains(text(),\"Signup / Login\")]")
    WebElement linkLogin;
    @FindBy(tagName="input")
    List<WebElement> txtUsername;
    @FindBy(css="[type=password]")
    WebElement txtPassword;
    @FindBy(css="[type=submit]")
    WebElement btnSubmit;
    @FindBy(id = "myAccountTrigger")
    public WebElement loginValidationText;

    @FindBy(xpath="//span[contains(text(),\'The length of the Phone or Email should be 6-60 characters.\')]")
    public WebElement txtValidationMsgForUsername;
    public void doLogin(String username,String password)
    {
        linkLogin.click();
        txtUsername.get(7).sendKeys(username);
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }
    public void doLoginWithInvalidUserIdLowerRange(String password)
    {
        linkLogin.click();
        txtUsername.get(7).sendKeys("abcde");
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }
    public void doLoginWithInvalidUserIdUpperRange()
    {
        linkLogin.click();
        txtUsername.get(7).sendKeys("abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde");
        txtPassword.sendKeys("asdfghjoiuytr");
        btnSubmit.click();
    }

    public void doLoginWithInvalidId()
    {
        linkLogin.click();
        txtUsername.get(7).sendKeys("&*(*&&*(");
        txtPassword.sendKeys("");
        btnSubmit.click();
    }
    public void doLoginWithInvalidPassword()
    {
        linkLogin.click();
        txtUsername.get(7).sendKeys("");
        txtPassword.sendKeys("");
        btnSubmit.click();
    }

    public Login(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
