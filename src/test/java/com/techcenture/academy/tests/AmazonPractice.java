package com.techcenture.academy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

/**
 * Created by tairovich_jr on 2022-01-18.
 */
public class AmazonPractice {


    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        softAssert = new SoftAssert();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
    }


    @Test
    public void verifyMenuItems(){

        driver.get("https://amazon.com");
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> menuItems = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
        String[] expectedMenuItems = {"Best Sellers","Amazon Basics","New releases","today's Deals","Customer Service",
        "Prime","books","Registry","Gift Cards","Toys & Games","Amazon Home"};

 //       System.out.println(menuItems.size() + " " + expectedMenuItems.length);

        for (int i = 0; i < 10; i++) {
            softAssert.assertEquals(menuItems.get(i).getText(),expectedMenuItems[i]);
        }

        softAssert.assertAll();
        System.out.println("ending");

    }

}
