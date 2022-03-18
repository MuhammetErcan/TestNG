package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LocatorsInterface;
import utils.ParentClass;
import static utils.LocatorsInterface.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static utils.LocatorClass.*;

public class Test04_opencart1 extends ParentClass implements LocatorsInterface {

    String url="http://opencart.abstracta.us/index.php?route=common/home";
    By lSearchInput=By.cssSelector("input[name='search']");
    By lSearchButton=By.cssSelector("#search button");
    By lMenuList=By.cssSelector("ul[class='nav navbar-nav']>li");
    By ldesktopElement=By.linkText("Desktops");
    By ldesktopAltElements=By.xpath("(//li[@class='dropdown'])[2]//li");
    By llaptopsElement=By.linkText("Laptops & Notebooks");
    By lLapotopAltElements=By.xpath("(//li[@class='dropdown'])[3]//li");
    By lcomponentElement= By.xpath("(//li[@class='dropdown'])[4]");
    By lcomponentAltList=By.xpath("(//li[@class='dropdown'])[4]//li");
    By lmp3PlayerElement=By.xpath("(//li[@class='dropdown'])[5]");
    By lmp3PlayerAltElements=By.xpath("(//li[@class='dropdown'])[5]//li");

    @Test(testName = "MenuList")
    public void test01() {
        //driver.findElement(By.cssSelector("input[name='search']")).sendKeys("mac");
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search button"))).click();
        //driver.findElement(By.cssSelector("#search button")).click();

        //sendKeysTo(By.cssSelector("input[name='search']"),"mac");
        //clickTo(By.cssSelector("#search button"));

        openSite(url_static_Class);
        sendKeysTo(lSearchInput_Interface, "mac");
        //waitFor(lSearchButton, clickable);
        clickTo(lSearchButton);

        List<String> menuString = new LinkedList<>() {{
            add("Desktops");
            add("Laptops & Notebooks");
            add("Components");
            add("Tablets");
            add("Software");
            add("Phones & PDAs");
            add("Cameras");
            add("MP3 Players");
        }};

        List<WebElement> menuWebElement = driver.findElements(lMenuList);
        for (int i = 0; i < menuWebElement.size(); i++) {
            Assert.assertEquals(menuWebElement.get(i).getText(), menuString.get(i));
            }
        }

        @Test(testName = "desktopTest")
        public void test02() {


            hoverWithLocator(lMenuList);


            List<String> desktopStringList = new LinkedList<>() {{
                add("PC (0)");
                add("Mac (1)");
            }};

            WebElement desktopElement = driver.findElement(ldesktopElement);

            hoverWithLocator(ldesktopElement);

            List<WebElement> dstktopAltList = driver.findElements(ldesktopAltElements);

            for (int i = 0; i < dstktopAltList.size(); i++) {
                Assert.assertEquals(desktopStringList.get(i), dstktopAltList.get(i).getText());
            }

        }

        @Test(testName = "laptop_Notebook")
        public void test03() {
            List<String> laptopStringList = new LinkedList<>() {{
                add("Macs (0)");
                add("Windows (0)");
            }};

            hoverWithLocator(llaptopsElement);

            List<WebElement> laptopsAltList = driver.findElements(lLapotopAltElements);
            for (int i = 0; i < laptopsAltList.size(); i++) {

                Assert.assertEquals(laptopStringList.get(i), laptopsAltList.get(i).getText());

            }

        }

        @Test(testName = "components")
        public void test04(){

        WebElement componentsElement=driver.findElement(lcomponentElement);

        List<String>componentsStringList=new LinkedList<>(){{
            add("Mice and Trackballs (0)");
            add("Monitors (2)");
            add("Printers (0)");
            add("Scanners (0)");
            add("Web Cameras (0)");
        }};

            hoverWithLocator(lcomponentElement);

        List<WebElement>componentAltList=driver.findElements(lcomponentAltList);

            for (int i = 0; i < componentAltList.size(); i++) {
                Assert.assertEquals(componentsStringList.get(i),componentAltList.get(i).getText());

            }

        }

        @Test(testName = "MP3 Players")
        public void test5(){
        WebElement mp3PlayerElement=driver.findElement(lmp3PlayerElement);

        List<String>mp3PlayerStringList=new LinkedList<>(){{
            add("test 11 (0)");
            add("test 12 (0)");
            add("test 15 (0)");
            add("test 16 (0)");
            add("test 17 (0)");
            add("test 18 (0)");
            add("test 19 (0)");
            add("test 20 (0)");
            add("test 21 (0)");
            add("test 22 (0)");
            add("test 23 (0)");
            add("test 24 (0)");
            add("test 4 (0)");
            add("test 5 (0)");
            add("test 6 (0)");
            add("test 7 (0)");
            add("test 8 (0)");
            add("test 9 (0)");
        }};

            hoverWithLocator(lmp3PlayerElement);

        List<WebElement>mp3PlayerAltList=driver.findElements(lmp3PlayerAltElements);

            for (int i = 0; i < mp3PlayerAltList.size(); i++) {

                Assert.assertEquals(mp3PlayerStringList.get(i),mp3PlayerAltList.get(i).getText());

            }
        }

    }



