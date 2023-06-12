package org.mir.tests;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestClass3 extends RemoteDriver {

    @Test
    public void test3() throws MalformedURLException {
       // openBrowser("chrome");
        System.out.println("============firefox======================================================");
        System.out.println("==============================test3================================>>>>>> ");
        driver.get("https://google.com");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("==============================test3================================>>>>>> ");

    }
    }



