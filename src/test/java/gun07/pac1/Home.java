package gun07.pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ParentClass;

public class Home extends BaseTestClass {

    String url="https://opencart.abstracta.us/index.php?route=account/login";
    By lusername=By.cssSelector("input[name='email']");
    By lpassword=By.cssSelector("input[name='password']");
    By lsubmitButton=By.cssSelector("input[value='Login']");
    By lcontactUs=By.cssSelector("a[href='http://opencart.abstracta.us:80/index.php?route=information/contact']");
    By ltextArea=By.cssSelector("textarea[name='enquiry']");
    By lsubmit2=By.cssSelector("input[class='btn btn-primary']");



    @Test
    @Parameters({"username", "password"})
    public void login(String username, String password){
        driver.get(url);
        driver.findElement(lusername).sendKeys(username);
        driver.findElement(lpassword).sendKeys(password);
        driver.findElement(lsubmitButton).click();
    }

    @Test(priority = 1)
    @Parameters("text")
    public void contact(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lcontactUs));

        driver.findElement(lcontactUs).click();
        driver.findElement(ltextArea).sendKeys(text);

        WebElement sub=driver.findElement(lsubmit2);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",sub);
        driver.findElement(lsubmit2).click();
    }

}
