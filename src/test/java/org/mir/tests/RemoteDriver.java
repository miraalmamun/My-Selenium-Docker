package org.mir.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver {
    protected WebDriver driver;
    String host = "localhost";
    String completeUrl = "http://"+host+":4444";

    @BeforeTest
    public void setUpDriver() throws MalformedURLException {
        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("chrome")) {
			System.out.println("BROWSER----------------->chrome");
            ChromeOptions options = new ChromeOptions();
            this.driver = new RemoteWebDriver(new URL(completeUrl), options);
        } else if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("firefox")) {
			System.out.println("BROWSER-------------------------firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            this.driver = new RemoteWebDriver(new URL(completeUrl), firefoxOptions);
        } else if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equals("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            this.driver = new RemoteWebDriver(new URL(completeUrl), edgeOptions);
        } else {
            ChromeOptions options = new ChromeOptions();
            this.driver = new RemoteWebDriver(new URL(completeUrl), options);
        }
    }

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







