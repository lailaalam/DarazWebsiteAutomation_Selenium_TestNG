package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddToCart {
    WebDriver driver;
    @FindBy(tagName = "button")
    List<WebElement> btnAddToCart;
    @FindBy(className = "cart-message-text")
    public WebElement textCardValidationMessage;

    public void addToCart()
    {
        btnAddToCart.get(3).click();
    }

    public AddToCart(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

}
