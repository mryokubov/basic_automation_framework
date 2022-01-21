package com.techcenture.academy.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/**
 * Created by tairovich_jr on 2022-01-20.
 */
public class BrowserDriver {

    private static WebDriver driver;

    //no one should create an instance of Driver
    private BrowserDriver(){};

    //using Singleton Design Pattern
    public static WebDriver getDriver() throws Exception {
                            //"chrome"
        String browser = ConfigReader.getProperty("browser").toLowerCase();
        int implWaitTime = Integer.parseInt( ConfigReader.getProperty("implicitWait") );
        //     chrome
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
        if (driver != null){
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(implWaitTime));
            driver.manage().deleteAllCookies();
            return driver;
        }
        throw new Exception("No Driver Instance was found");
    }


    public static void quitBrowser(){
        if (driver != null){
            driver.quit();
        }
    }
}
