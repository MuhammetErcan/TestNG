package gun09.softAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _02SoftAssert {

    /*
    soft assert, tüm assertleri tamamladıktan sonra sonıucu verir ve
    hatalarda kesmez
     */

    SoftAssert sa=new SoftAssert();


    @Test
    public void Test1(){
        sa.assertTrue(true);
        System.out.println("test1");
        sa.assertTrue(false); // asserti değerlemdirir işleme koymaz
        System.out.println("test2");
        sa.assertAll();// bu satırla üstteki tüm assetler işletilir
    }

    @Test
    public void Test2(){
        Assert.assertTrue(true);
        System.out.println("test1");
        Assert.assertTrue(false);
        System.out.println("test2");

    }




}
