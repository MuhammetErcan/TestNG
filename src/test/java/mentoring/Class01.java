package mentoring;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BaseTest;
import utils.Driver;
import utils.ParentClass;

import java.util.List;
/* Bu siteye gidin   :     [https://www.hotels.com/](https://www.hotels.com/)

Manhattan ' ı aratın.

Check - in tarihini bugünden 2 gün sonraya seçin.

Check-out tarihini bugünden 5 gün sonraya seçin.

Search butonuna tıklayın.

Mesafe botununda 5. caddeyi seçin.

 Aşağı kaydırın ve en az 50 otelin görüntülendiğinden emin olun

 Tüm otellerin 5. cadde ve Times Meydanı'na 5 mil'den az olduğunu doğrulayın .

 */

/*
public By getXpath(LocalDate date){
        String ay = date.getMonth().toString();
        int gun = date.getDayOfMonth();
        return By.xpath("//div[./h2[contains(text(), '" + ay + "')]]//*[contains(text(),'" + gun +"')]");
    }
 */


public class Class01 extends ParentClass {
    WebDriver driver;

    String URL= "https://www.hotels.com/";
    By search=By.cssSelector("input[type='text']");
    By date1=By.cssSelector("button[class='_1yFrqc _1ZtnNu']");
    String year="2022";
    String month="Mayıs";
    String day="30";
    String monthYear;
    String [] array;
    By nextButton=By.cssSelector("button[aria-label='Sonraki']");
    By ldays=By.cssSelector("td[class='_28Im8o']");
    By ltable=By.cssSelector("div[class='_2U8Hy7']");
    By lmonthTitle=By.cssSelector("h2[class='_3LBdi8']");
    List<WebElement>monthAndYear;

    //td[class='_28Im8o']
    //(//table[@class='HZDuax'])[1]//td/button

    public Class01(){
        driver= Driver.getDriver();
    }

    @Test
    public void loginAndSearch(){
        openSite(URL);
        sendKeysTo(search,"Manhattan" + Keys.ENTER);
        clickTo(date1);

        for (int i = 0; i < 18; i++) {

        monthAndYear=driver.findElements(By.cssSelector("(//h2[@align='top'])[" + i + "]"));
        monthYear=monthAndYear.get(i).getText();

             array=monthYear.split(" ");
             if (array[0].equalsIgnoreCase(month)&&array[1].equalsIgnoreCase(year)) {
                 break;
             }
             else clickTo(nextButton);

        }

        //WebElement eTable=driver.findElement(ltable);
        //WebElement eMonthTitle=driver.findElement(lmonthTitle);

        //if (eMonthTitle.getText().contains(month)){

        for (WebElement emonthAndYear:monthAndYear) {
            if (emonthAndYear.getText().contains(month)){
                List<WebElement>tables=driver.findElements(ltable);
                for (WebElement table:tables) {


                List<WebElement> days=table.findElements(ldays);
                for (WebElement eday:days) {

                    if (eday.getText().equalsIgnoreCase(day)){
                        eday.click();
                        break;
                    }
                }
                }
            }
        }
    }
}
