package gun3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;

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
}
