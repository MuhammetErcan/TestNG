package gun09.pagemodels.m8;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class PageModel extends ParentPM {


    @Test
    public void Test_Login(){
        driver.get("https://opencart.abstracta.us/index.php");
        clickTo(lMyAccount);
        click(lLogin);
        sendkeys(lUsername, "testngkurs@gmail.com");
        sendkeys(lPassword, "testngkurs");
        click(lLoginButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(lLogout));
    }



}