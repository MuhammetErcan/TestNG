package gun06.tests;

import org.testng.annotations.Test;

public class TestClass1 {

    @Test(groups = {"TestGrup1"})
    public void test1(){
        System.out.println("Test1");
    }


    @Test(testName = "test2", groups = {"TestGrup1", "TestGrup2"})
    public void test2(){
        System.out.println("Test2");

    }


    @Test(groups = {"TestGrup2"})
    public void test3(){
        System.out.println("Test3");
    }
}
