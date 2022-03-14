package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _06Ornek {
    /*
    https://opensource-demo.orangehrmlive.com/index.php/auth/login

    @beforeClass da
        driver tanımlayın

    @test
        siteye gidini title ı assert edin

    @test
        login olun, login olduğunuzu assert edin

    @AfterClass da
        driveri kapatın
     */
    static WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @Test(testName = "siteye git")
    public void test1(){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        String expectedTitle="OrangeHRM";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test(testName = "login", dependsOnMethods = "test1") //dependsOnMethods = "test1" --> test1 e bağlı demek,
                                                        // bağımlı olduğu method çalışmadan çalışmaz
    public void test2(){
        WebElement username=driver.findElement(By.cssSelector("#txtUsername"));
        username.sendKeys("Admin ");

        WebElement password=driver.findElement(By.cssSelector("#txtPassword"));
        password.sendKeys("admin123");

        WebElement login =driver.findElement(By.cssSelector("input[name='Submit']"));
        login.click();

        WebElement welcome=driver.findElement(By.cssSelector("a[id='welcome']"));

        String expected="Welcome";

        Assert.assertTrue(welcome.getText().contains(expected));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
