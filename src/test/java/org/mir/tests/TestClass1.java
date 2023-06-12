package org.mir.tests;

import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestClass1 extends RemoteDriver {



        @Test
        public void test1() throws MalformedURLException {
           // openBrowser("chrome");
            System.out.println("=========================chrome===============================browser=====");
            System.out.println("==============================test1================================>>>>>> ");
            driver.get("https://google.com");
            String title = driver.getTitle();
            System.out.println(title);
            System.out.println("==============================test1================================>>>>>> ");

        }

    }



