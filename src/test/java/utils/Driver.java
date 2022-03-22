package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

    private static WebDriver driver;
    public static WebDriver getDriver(){
        getDriver(Browser.CHROME);
        return driver;
    }



    public static WebDriver getDriver(String browser){
        if (driver == null) {
            switch (browser.toLowerCase()){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
        }
        return driver;
    }

    public static WebDriver getDriver(Browser browser){
        if(driver==null){
            switch (browser){
                case CHROME :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case OPERA:
                    WebDriverManager.operadriver().setup();
                    driver=new OperaDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;

            }

        }
        return driver;

    }

    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
