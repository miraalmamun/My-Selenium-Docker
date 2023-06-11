package org.mir.tests;

import org.testng.annotations.Test;

public class TestClass2 extends RemoteDriver {
    @Test
    public void test2()
    {
        System.out.println("==============================test2================================>>>>>> ");
        driver.get("https://google.com");
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println("==============================test2================================>>>>>> ");


    }}



