package gun3;

import org.testng.annotations.Test;

public class _02_openCart2_Nesne_Ile {

    @Test
    public void test01(){
        HomePage homePage=new HomePage();
        homePage.goToSite();
        homePage.goToLogin();
        homePage.loginAndCheck();

    }
}
