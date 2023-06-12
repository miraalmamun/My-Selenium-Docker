package org.mir.tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver {
    protected WebDriver driver;
    String host = "54.87.166.122";
    String completeUrl = "http://"+host+":4444";


    public void openBrowser(String browserName) throws MalformedURLException {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.out.println("BROWSER----------------->chrome");
            ChromeOptions options = new ChromeOptions();
            this.driver = new RemoteWebDriver(new URL(completeUrl), options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("BROWSER-------------------------firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            this.driver = new RemoteWebDriver(new URL(completeUrl), firefoxOptions);
        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            this.driver = new RemoteWebDriver(new URL(completeUrl), edgeOptions);
        } else {
            ChromeOptions options = new ChromeOptions();
            this.driver = new RemoteWebDriver(new URL(completeUrl), options);
        }
    }
    @BeforeTest
    public void setUpDriver(ITestContext ctx) throws MalformedURLException {

        String testName = ctx.getCurrentXmlTest().getName();
        String GRID = "Yes";

        if(GRID.equalsIgnoreCase("Yes"))
        {
            if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("chrome")) {
                System.out.println("BROWSER----------------->chrome");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("name", testName);
                this.driver = new RemoteWebDriver(new URL(completeUrl), options);
            } else if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("firefox")) {
                System.out.println("BROWSER-------------------------firefox");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("name", testName);
                this.driver = new RemoteWebDriver(new URL(completeUrl), firefoxOptions);
            } else if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("name", testName);
                this.driver = new RemoteWebDriver(new URL(completeUrl), edgeOptions);
            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("name", testName);
                this.driver = new RemoteWebDriver(new URL(completeUrl), options);
            }
            if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
            }
        }
        else
        {
            if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("chrome")) {
                System.out.println("BROWSER----------------->chrome");
                this.driver = new ChromeDriver();
            } else if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("firefox")) {
                System.out.println("BROWSER-------------------------firefox");
               this.driver=new FirefoxDriver();
            } else if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("edge")) {
                this.driver=new EdgeDriver();
            } else {
                this.driver = new ChromeDriver();
            }
        }
    }

//    @BeforeTest
//    public void setupDriver(ITestContext ctx) throws MalformedURLException {
//        // BROWSER => chrome / firefox
//        // HUB_HOST => localhost / 10.0.1.3 / hostname
//
//        String host = "localhost";
//        MutableCapabilities dc;
//
//        if(System.getProperty("BROWSER") != null &&
//                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
//            dc = new FirefoxOptions();
//        }else{
//            dc = new ChromeOptions();
//        }
//
//        if(System.getProperty("HUB_HOST") != null){
//            host = System.getProperty("HUB_HOST");
//        }
//
//        String testName = ctx.getCurrentXmlTest().getName();
//
//        String completeUrl = "http://" + host + ":4444/wd/hub";
//        dc.setCapability("name", testName);
//        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
//    }

    @AfterTest
    public void quit()
    {
        if(driver != null)
        {
            driver.quit();
        }
        else
        {
            System.out.println("No driver");
        }

    }
}







