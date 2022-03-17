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

   public void openSite(String url){
       driver.get(url);
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

   @AfterSuite
   public void afterSuite(){
       Driver.quitDriver();
   }

   public void clickTo(By locater){
       wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
   }

   public void sendKeysTo(By locater, String text){
       wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).sendKeys(text);
   }

   public void hoverMenu(By locater){
       List<WebElement>list=driver.findElements(locater);
       Actions builder=new Actions(driver);
       for (WebElement element:list) {
           builder.moveToElement(element).build().perform();
       }
   }

    public void hover(WebElement element){
        hover(element, 10);
    }

    public void hover(WebElement element, long milis){
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

   public void scrollElement(WebElement element){
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();",element);

   }




}
