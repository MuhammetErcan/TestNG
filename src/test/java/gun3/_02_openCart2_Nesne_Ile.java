package gun3;

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.HomePage;

public class _02_openCart2_Nesne_Ile extends BaseTest {

    HomePage homePage=new HomePage();
    @Test
    public void test01(){

        homePage.goToSite();
        homePage.goToLogin();
        homePage.loginAndCheck();
    }

    @Test
    public void test02(){
        homePage.clickToNewsletter();
        homePage.subscribeYesAndCheck();
    }

    @Test
    public void test03(){
        homePage.clickToNewsletter();
        homePage.newsletterNoAndCheck();
    }

    @Test(testName = "senaryo 2")
    public void test04(){
        homePage.goToSite();
        homePage.searchMac();
        homePage.macListCheck();
    }

    @Test(testName = "senaryo 3")
    public void test05(){

        homePage.clickMonitor();
        homePage.monitorChoose();

    }


}
