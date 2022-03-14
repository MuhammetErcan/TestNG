package gun01;

import org.testng.annotations.Test;

public class _05Attributes {

    /*
        priority : test önceliğini verir.
        -5000, +5000 küçük değerli olan önceliklidir
        priority yazılmazsa default her testin prioritysi sıfırdır
        priority'si eşit olanları testNG method ismine göre çalıştırır.
     */

    @Test(testName = "5  nolu test ",priority = 1)
    public void test5(){
        System.out.println("Test5");
    }

    @Test(testName = "1 Nolu test",priority = 0)
    public void test1(){
        System.out.println("Test1");
    }

    //enable attribute'u methodun çalıştırılıp çalıştırılmayacağını belirler
    @Test(testName = "3 No'lu Test",priority = 2, enabled = false)
    public void test3(){
        System.out.println("Test3");
    }

    //timeOut testin ne kadar süreceğini sınırlar
    @Test(testName = "4 No'lu Test",timeOut = 2000)
    public void test4(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test4");
    }

    //invocationCount bu methodun kaç derfa tekrarlanacağını belirtir
    @Test(testName = "6 No'lu Test",priority = 1,invocationCount = 5)
    public void test6(){
        System.out.println("Test6");
    }

    //dependsOnMethods = "test1" --> test1 e bağlı demek


}
