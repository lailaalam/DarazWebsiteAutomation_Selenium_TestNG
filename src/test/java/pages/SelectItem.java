package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectItem {
    WebDriver driver;
    @FindBy(css = "[alt='3 in 1 Chess Ludu Snake PVC']")
    List<WebElement> imgAltName;
//    Point hoverItem=tagImg.get(12).getLocation();
    @FindBy(className = "pdp-mod-product-badge-title")
    public WebElement txtItemName;
    public void selectItem()
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");//("window.scrollTo(0,"+(hoverItem.getY())+")");//document.body.scrollHeight
        imgAltName.get(0).click();
    }
    public SelectItem(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
