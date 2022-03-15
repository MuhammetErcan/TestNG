package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

public class ParentClass {

   protected    WebDriver driver;
   protected    WebDriverWait wait;

   public ParentClass(){
       driver=Driver.getDriver();
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


}
