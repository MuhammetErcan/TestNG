package gun5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;
import utils.WaitConditions;

public class Home extends ParentClass {

    String url="http://opencart.abstracta.us/index.php?route=common/home";
    By lmyAccount=By.cssSelector("a[title='My Account']");
    By llogin =By.xpath("(//ul[@class='dropdown-menu dropdown-menu-right'])/li[2]");
    By lEmail=By.cssSelector("input[name='email']");
    By lPassword=By.cssSelector("input[name='password']");
    By submitButton=By.cssSelector("input[type='submit']");
    By leditAccount=By.linkText("Edit Account");
    By lname=By.cssSelector("input[name='firstname']");
    By lLastname=By.cssSelector("input[name='lastname']");
    By lEmailSecond=By.cssSelector("input[name='email']");
    By lphone=By.cssSelector("input[name='telephone']");
    By lContinueButton=By.cssSelector("input[value='Continue']");
    By ltext=By.cssSelector("div[class='alert alert-success alert-dismissible']");



    public void gotoSite(){
        driver.get(url);
    }

    public void goToLogin(){
        clickTo(lmyAccount);
        clickTo(llogin);
    }

    public void loginAndCheck() {
        sendKeysTo(lEmail, "ali@gmail.com");
        sendKeysTo(lPassword, "123456");
        clickTo(submitButton);
    }

    public void goToEditAccount(){
        clickTo(leditAccount);
    }

    public void fillTheForm(){
        sendKeysTo(lname,"veli");
        sendKeysTo(lLastname,"veli");
        //sendKeysTo(lEmailSecond,"veli@gmail.com");
        sendKeysTo(lphone,"123456789");
        clickTo(lContinueButton);
        waitFor(ltext, WaitConditions.visible);
        WebElement textElement=driver.findElement(ltext);
        Assert.assertTrue(textElement.getText().contains("Success"));
    }

    public void fillTheFormEski(){
        sendKeysTo(lname,"ali");
        sendKeysTo(lLastname,"ali");
        //sendKeysTo(lEmailSecond,"veli@gmail.com");
        sendKeysTo(lphone,"123456789");
        clickTo(lContinueButton);
        waitFor(ltext, WaitConditions.visible);
        WebElement textElement=driver.findElement(ltext);
        Assert.assertTrue(textElement.getText().contains("Success"));
    }

}
