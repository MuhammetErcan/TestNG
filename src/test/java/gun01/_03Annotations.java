package gun01;

import org.testng.annotations.*;

public class _03Annotations {

    @Test
    void Test1(){
        System.out.println("test1");
    }
    @Test           // methodun bir test metodu olduğunu belirtir.
    void Test2(){
        System.out.println("test2");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest      //Test, TestNG xml'de belirtilen tanımlamadır
    void afterTest(){
        System.out.println("AfterTest");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    void AfterMethod(){
        System.out.println("AfterMethod");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    protected void afterClass(){
        System.out.println("AfterClass");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }

    @BeforeGroups
    void beforeGroups(){
        System.out.println("BeforeGroups");
    }

    @AfterGroups
    void AfterGroups(){
        System.out.println("BeforeGroups");
    }

}
