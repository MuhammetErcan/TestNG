package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Browser;
import utils.Driver;

public class TestClass1 {
    WebDriver driver;
    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(String browser){
        if (browser.equalsIgnoreCase("firefox"))
        driver= Driver.getDriver(Browser.FIREFOX);
        else if (browser.equalsIgnoreCase("edge"))
            driver=Driver.getDriver(Browser.EDGE);
        else
            driver=Driver.getDriver(Browser.CHROME);
    }

    @Test
    public void test1(){
        driver.get("https://opencart.abstracta.us/index");
        driver.findElement(By.cssSelector("input[name='search']")).sendKeys("mac" + Keys.ENTER);
    }

    @AfterTest
    public void aferTest(){
        Driver.quitDriver();
    }
}
