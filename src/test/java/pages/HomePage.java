package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import utils.Driver;
import utils.ParentClass;
import utils.WaitConditions;

import java.util.List;

public class HomePage extends ParentClass {

    String url="http://opencart.abstracta.us/index.php?route=common/home";
    By lmyAccount=By.cssSelector("a[title='My Account']");
    By llogin =By.xpath("(//ul[@class='dropdown-menu dropdown-menu-right'])/li[2]");
    By lEmail=By.cssSelector("input[name='email']");
    By lPassword=By.cssSelector("input[name='password']");
    By submitButton=By.cssSelector("input[type='submit']");
    By lMyAccount2=By.cssSelector("i[class='fa fa-user']");
    By ldropdowns=By.xpath("(//ul[@class='dropdown-menu dropdown-menu-right'])/li");
    By llogOut=By.cssSelector("(//ul[@class='dropdown-menu dropdown-menu-right'])/li[5]");
    By lNewsLetter=By.xpath("(((//div[@class='col-sm-3'])/ul)[4])/li[4]/a");
    By lButtonYes=By.xpath("(//label[@class='radio-inline'])[1]/input");
    By lButtonContinue=By.cssSelector("div[class='pull-right']");
    By lText=By.cssSelector("div[class='alert alert-success alert-dismissible']");
    By lButtonNo=By.cssSelector("input[value='0']");
    By lSearchInput=By.cssSelector("input[name='search']");
    By lSearchButton=By.cssSelector("#search button");
    By lMacList=By.cssSelector("div[class='caption'] a");
    By lComponents=By.linkText("Components");
    By lMonitorButton=By.partialLinkText("Monitors");
    By lMonitorList=By.cssSelector("div[class='product-thumb']");
    By lAddToWish=By.cssSelector("button[data-toggle='tooltip'] i[class='fa fa-heart']");
    By lFavori=By.cssSelector("a[id='wishlist-total']");
    By lFavoriElemani=By.cssSelector("table[class='table table-bordered table-hover'] td[class='text-left'] a");
    By leditAccount=By.linkText("Edit Account");
    By lname=By.cssSelector("input[name='firstname']");
    By lLastname=By.cssSelector("input[name='lastname']");
    By lEmailSecond=By.cssSelector("input[name='email']");
    By lphone=By.cssSelector("input[name='telephone']");
    By lContinueButton=By.cssSelector("input[value='Continue']");
    By ltext=By.cssSelector("div[class='alert alert-success alert-dismissible']");
    By lLogout = By.xpath("//div[@id='top-links']//a[text()='Logout']");
    By lNotification = By.cssSelector("div.alert.alert-success");

    public void goToSite(){
        openSite(url);
    }

    public void goToLogin(){
        clickTo(lmyAccount);
        clickTo(llogin);
    }

    public void loginAndCheck(){
        sendKeysTo(lEmail,"ali@gmail.com");
        sendKeysTo(lPassword,"123456");
        clickTo(submitButton);
        clickTo(lMyAccount2);

        List<WebElement> dropdownList=driver.findElements(ldropdowns);

        Assert.assertEquals(dropdownList.size(),5);
    }

    public void loginAs(String username, String password){
        sendKeysTo(lEmail,username);
        sendKeysTo(lPassword, password);
        clickTo(submitButton);
        waitFor(lLogout, WaitConditions.exist);
    }

    public void verifyNotification(String str){
        verifyTextIn(lNotification, str);
    }

    public void clickLinkText(String str){
        clickTo(By.partialLinkText(str));
    }

    public void clickToNewsletter(){
        WebElement newsletter=driver.findElement(lNewsLetter);
        scrollElement(newsletter);
        clickTo(lNewsLetter);
    }

    public void subscribeYesAndCheck(){
        clickTo(lButtonYes);
        clickTo(lButtonContinue);

        WebElement textElement =driver.findElement(lText);

        Assert.assertTrue(textElement.getText().contains("Success"));
    }

    public void newsletterNoAndCheck(){
        clickTo(lButtonNo);
        clickTo(lButtonContinue);
        WebElement textElement =driver.findElement(lText);

        Assert.assertTrue(textElement.getText().contains("Success"));
    }

    public void searchMac(){
        sendKeysTo(lSearchInput,"Mac");
        clickTo(lSearchButton);
    }

    public void macListCheck(){
        List<WebElement>macList=driver.findElements(lMacList);
        for (WebElement element: macList) {
            Assert.assertTrue(element.getText().contains("Mac"));
        }

    }

    public void clickMonitor(){
        hoverWithLocator(lComponents);
        clickTo(lMonitorButton);
    }

    public void monitorChoose(){
        List<WebElement> monitors=driver.findElements(lMonitorList);
        int randomSayi=(int) (Math.random()*2);
        String choosenUrunName=monitors.get(randomSayi).getText();

        clickTo(monitors.get(randomSayi));
        WebElement aa=driver.findElement(By.cssSelector("div[class='col-sm-4']>h1"));
        String bb=aa.getText();
        clickTo(lAddToWish);
        clickTo(lFavori);
        WebElement favoriUrun=driver.findElement(lFavoriElemani);
        System.out.println(favoriUrun.getText());
        Assert.assertEquals(favoriUrun.getText(),bb);
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

    public void updateAccount(String firstname, String lastname, String telephone){
        sendKeysTo(lname, firstname, true);
        sendKeysTo(lLastname, lastname, true);
        sendKeysTo(lphone, telephone, true);
        clickTo(lContinueButton);
    }

}
