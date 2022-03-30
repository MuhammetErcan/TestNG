package gun12.pac2;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utils.DriverSingleton;
import utils.ParentClass;

import java.util.List;

public class Cinema extends ParentClass {
    WebDriver driver;
    String url = "https://opencart.abstracta.us/index";
    By lSearchInput = By.cssSelector("input[name='search']");
    By lComputer = By.cssSelector("img.img-responsive");
    By lDate = By.xpath("(//i[@class='fa fa-calendar'])[3]");
    ////div[@class='datepicker' and .//parent::li]
    String year = "2022";
    String month = "june";
    String dayString = "29";
    By lmonthAndYears = By.xpath("(//th[@class='picker-switch'])[4]");
    List<WebElement> monthAndYear;
    String monthYearString;
    String[] array;
    By lNext = By.xpath("(//th[@class='picker-switch'])[4]/following-sibling::th[@class='next']");
    By ldays = By.xpath("(//table[@class='table-condensed'])[4]//td");
    //tbody//td

    // (//table[@class='table-condensed'])[4]//td


    public Cinema() {
        driver = DriverSingleton.getDriver();
    }
    @Test
    public void goToCinema() {
        openSite(url);
        sendKeysTo(lSearchInput, "cinema" + Keys.ENTER);
        clickTo(lComputer);
        clickTo(lDate);
    }

    @Test(priority = 1)
    public void chooseDate() {
        monthAndYear = driver.findElements(lmonthAndYears);
        for (WebElement element : monthAndYear) {
            monthYearString = element.getText();
            //array = monthYearString.split(" ");


            while (true) {
                if (element.getText().equals("June 2022")) break;
                else clickTo(lNext);

            }
        }
        /*
        List<WebElement> days = driver.findElements(ldays);
        for (WebElement day : days) {
            if (day.getText().contains(dayString)) {
                day.click();
            }
        }
         */
        driver.findElement(By.xpath("((//table[@class='table-condensed'])[4]//td)[31]")).click();
    }


}


