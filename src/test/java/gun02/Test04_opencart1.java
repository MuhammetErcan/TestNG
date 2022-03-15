package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LocatorsInterface;
import utils.ParentClass;

import java.util.LinkedList;
import java.util.List;

import static utils.LocatorClass.*;

public class Test04_opencart1 extends ParentClass implements LocatorsInterface {

    String url="http://opencart.abstracta.us/index.php?route=common/home";
    By lSearchInput=By.cssSelector("input[name='search']");
    By lSearchButton=By.cssSelector("#search button");

    @Test
    public void MenuList(){
       openSite(url_static_Class);
       sendKeysTo(lSearchInput_Interface,"mac");
       //waitFor(lSearchButton, clickable);
       clickTo(lSearchButton);
       List<String>menuString=new LinkedList<>(){{
           add("Desktops");
           add("Laptops & Notebooks");
           add("Components");
           add("Tablets");
           add("Software");
           add("Phones & PDAs");
           add("Cameras");
           add("MP3 Players");
       }};

        List<WebElement>menuWebElement=driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));
        for (int i = 0; i < menuWebElement.size(); i++) {
            Assert.assertEquals(menuWebElement.get(i).getText(),menuString.get(i));
        }

       //driver.findElement(By.cssSelector("input[name='search']")).sendKeys("mac");
       //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search button"))).click();
       //driver.findElement(By.cssSelector("#search button")).click();

        //sendKeysTo(By.cssSelector("input[name='search']"),"mac");
        //clickTo(By.cssSelector("#search button"));

    }


}
