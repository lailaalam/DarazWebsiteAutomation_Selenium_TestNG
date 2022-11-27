package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOut {
    WebDriver driver;
    @FindBy(xpath = "//button[contains(text(),\'CHECK OUT\')]")
    WebElement btnCheckOut;
    @FindBy(tagName = "button")
    public List<WebElement> findBtnPlaceOrder;

    @FindBy(className = "cart-icon")
    public WebElement cartIcon;

    @FindBy(css = "[type = 'checkbox']")
    public List<WebElement> selectItemCheckbox;

    @FindBy(className = "ok")
    public WebElement deleteIconAgreePopup;

    @FindBy(className = "list-header-operation-text")
    public WebElement deleteIconOFCart;

    public void checkOut()
    {
      btnCheckOut.click();
    }
    public CheckOut(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
}
