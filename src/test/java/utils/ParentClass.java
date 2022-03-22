package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import java.time.Duration;
import java.util.List;

public class ParentClass {

   protected    WebDriver driver;
   protected    WebDriverWait wait;

   public ParentClass(){
       driver=Driver.getDriver();
       driver.manage().window().maximize();
       wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   }

    /**
     * aldigi url"e driver.get eden method
     * @param url string
     */
   public void openSite(String url){
       driver.get(url);
   }

    /**
     * aldigi By class"indan locatora click eden method
     * @param locater By
     */
   public void clickTo(By locater){
       wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
   }

    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

   public void sendKeysTo(By locater, String text){
       //wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).clear();
       wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).sendKeys(text);
   }

    public void sendKeysTo(By locator, String text, boolean clear){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (clear)
            element.clear();
        element.sendKeys(text);
    }

    public void waitFor(By locater, WaitConditions waitConditions){
        switch (waitConditions){
            case exist:
                wait.until(ExpectedConditions.presenceOfElementLocated(locater));
                break;
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locater));
                break;
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
                break;
        }
    }



   public void hoverWithLocator(By locater){
       List<WebElement>list=driver.findElements(locater);
       Actions builder=new Actions(driver);
       for (WebElement element:list) {
           builder.moveToElement(element).build().perform();
       }
   }

    public void hoverWithElement(WebElement element){
        hoverWithElement(element, 10);
    }

    public void hoverWithElement(WebElement element, long milis){
        new Actions(driver).moveToElement(element).pause(milis).build().perform();
    }

    public boolean isExist(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Bu lokasyondaki elementte bu string ifade var mı
     */
    public void verifyTextIn(By locator, String str){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(notification.getText().toLowerCase().contains(str.toLowerCase()));
    }

   public void scrollElement(WebElement element){
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();",element);
   }




}
