package gun07.pac1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTestClass {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    @Parameters({"browser"})
    public void beforeTest(String browser) {
        if (driver == null) {
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        }

    }


    @AfterTest
    public void afterTest(){
        if (driver!=null)
        driver.quit();
    }
}
