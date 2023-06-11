package org.mir.tests;

import org.testng.annotations.Test;

public class TestClass4 extends RemoteDriver {

    @Test
    public void test4()
    {
        System.out.println("==============================test4================================>>>>>> ");
        driver.get("https://facebook.com");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("==============================test4================================>>>>>> ");

    }
    }



