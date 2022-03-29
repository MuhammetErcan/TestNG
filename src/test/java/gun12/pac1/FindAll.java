package gun12.pac1;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ParentClass;

import java.util.Locale;

public class FindAll extends ParentClass {

    FindAllPO po;
    String searchText="mac";

    @Test
    public void test1(){
        po=new FindAllPO(driver);
        driver.get("https://opencart.abstracta.us/index");

        po.getSearchText().sendKeys(searchText);
        po.getSearchButton().click();
        Assert.assertTrue(po.getSiteMap().getText().contains("Search"));
    }

    @Test
    public void test2(){

        for (WebElement productname:po.getProduct()) {
            System.out.println(productname.getText());
            Assert.assertTrue(productname.getText().toLowerCase(Locale.ROOT).contains(searchText));
        }
    }

    @Test
    public void test3(){
        for (WebElement element:po.getIsimVeFiyat()) {
            System.out.println(element.getText());

        }
    }

    @Test
    public void test4(){
        System.out.println(po.findBys.getText());
    }


}
