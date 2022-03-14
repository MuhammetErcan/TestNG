package gun01;

import org.testng.annotations.Test;

//@Test annotation'i olan classlar TestNG class larıdır
//@Test annotation'i olan metot ve classlar çalıştırılabilir.
// bir test çalıştırıdığında o classdan bir nesne oluşturarak çalıştırır.
//@Test annotation'i olan her bir metod ayri ayri çalıştırılabilir.

public class _01Giris {
    /*
    public static void main(String[] args) {
        System.out.println("main");
    }
     */

    int number=10;
    //Instance initializer. Nesne oluştuğunda constructor dan önce çalışır.
    {
        System.out.println("instance initializer");
    }

    public _01Giris(){
        System.out.println("constructor");
        System.out.println(number);
    }

    @Test
    void test1(){
        System.out.println("testNG-1");
    }

    @Test
    void test2(){
        System.out.println("testNG-2");
    }


    /*
    Functional testlerin yapılması için bir tool
    Assertion
    Testleri organize

    TestNG - JUnit
    Annotations
    @Test
    @BeforeClass
    @AfterTest
    ...
     */
}
