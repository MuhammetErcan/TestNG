package gun5;

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.HomePage;

public class Senaryo_5 extends BaseTest {
    HomePage homePage=new HomePage();

    @Test
    public void test01(){
        homePage.goToSite();
        homePage.goToLogin();
        homePage.loginAndCheck();
    }

    @Test
    public void test02(){
        homePage.goToEditAccount();
        homePage.fillTheForm();

    }

    @Test
    public void test03(){

        homePage.goToEditAccount();
        homePage.fillTheFormEski();

    }
}
