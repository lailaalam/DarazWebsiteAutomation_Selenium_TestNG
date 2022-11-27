package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {

   public WebDriver driver;


   @BeforeTest
   public void setup()
    {
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    }

    @AfterTest
    public void quitBrowser()
    {
        try
        {
           driver.close();
        }
        catch (Exception e)
        {
            driver.quit();
        }
    }
}

