package gun06.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Browser;
import utils.Driver;

import java.util.Locale;

public class TestClass4 {
    WebDriver driver;
    @BeforeTest
    @Parameters("browserName")
    public void beforeTest(String browser){
        driver=Driver.getDriver(browser);
        //driver= Driver.getDriver(Browser.valueOf(browser));
        // getDriver() methodu Browser enum"i aliyor ise
        // gelen string Browser.valueOf(browser) ile enuma dönüstürülür
        /*
        switch (browser.toLowerCase(Locale.ROOT)){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
        }

         */
    }

    @Test
    public void goToUrl(){
        driver.get("https:/opencart.abstracta.us/");
    }

    @Test(dependsOnMethods = {"goToUrl"})
    @Parameters("searchText")
    public void searc(String text){
        driver.findElement(By.cssSelector("#search input")).sendKeys(text+ Keys.ENTER);
    }

    @AfterTest
    public void afterTest(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
