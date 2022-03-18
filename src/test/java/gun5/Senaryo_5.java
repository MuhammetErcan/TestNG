package gun5;

import org.testng.annotations.Test;
import utils.Driver;

public class Senaryo_5 extends Home{
    Home home=new Home();

    @Test
    public void test01(){
        home.gotoSite();
        home.goToLogin();
        home.loginAndCheck();
    }

    @Test
    public void test02(){
        home.goToEditAccount();
        home.fillTheForm();

    }

    @Test
    public void test03(){

        home.goToEditAccount();
        home.fillTheFormEski();

    }
}
