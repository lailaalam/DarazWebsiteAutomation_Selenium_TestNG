package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchElement {
    WebDriver driver;

    @FindBy(id="q")
    WebElement txtSearch;
    @FindBy(className ="search-box__button--1oH7")
    WebElement clickEnter;
    @FindBy(xpath = "//span[contains(text(),'Chess board')]")//(xpath = "//span[contains(text(),'4661 items found for')]")
    public WebElement txtFoundItemValidity;
    @FindBy(className = "ant-select-selection-selected-value")
    WebElement dropdownSortValue;
    @FindBy(xpath = "//div[contains(text(),'Price low to high')]")
    public WebElement sortValidityText;
    @FindBy(className = "title--sUZjQ")
    public WebElement txtFoundItemInvalidity;


    public void searchInvalidElement() throws InterruptedException {

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0]. click()",txtSearch);
        Thread.sleep(1000);
        txtSearch.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaa");
        clickEnter.click();
        //Thread.sleep(3000);

    }
    public void searchValidElement() throws InterruptedException {

      //  selectInterest.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0]. click()",txtSearch);
        Thread.sleep(1000);
        Actions actions=new Actions(driver);
        actions.doubleClick(txtSearch).sendKeys(Keys.BACK_SPACE).perform();
        txtSearch.sendKeys("Chess board");
        clickEnter.click();


    }

    public void sortByPrice() throws InterruptedException {
        Thread.sleep(1000);
        Actions key=new Actions(driver);
        key.click(dropdownSortValue).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

    }
    public SearchElement(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
