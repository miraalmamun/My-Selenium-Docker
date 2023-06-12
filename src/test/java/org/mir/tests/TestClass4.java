package org.mir.tests;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestClass4 extends RemoteDriver {

    @Test
    public void test4() throws MalformedURLException {
       // openBrowser("firefox");
        System.out.println("==============================test4================================>>>>>> ");
        driver.get("https://facebook.com");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("==============================test4================================>>>>>> ");

    }
    }



