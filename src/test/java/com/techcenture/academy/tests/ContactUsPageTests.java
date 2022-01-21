package com.techcenture.academy.tests;

import com.techcenture.academy.pages.ContactUsPage;
import com.techcenture.academy.utils.BrowserDriver;
import com.techcenture.academy.utils.DataGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


/**
 * Created by tairovich_jr on 2022-01-11.
 */
public class ContactUsPageTests {

    private WebDriver driver;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setUp() throws Exception {
        softAssert = new SoftAssert();
        driver = BrowserDriver.getDriver();
    }


    @Test
    public void contactUsPageEndToEndTest() throws InterruptedException {

        ContactUsPage contact = new ContactUsPage(driver, softAssert);
        contact.visitHomePage();
        contact.clickContactUsLink();
        contact.selectSubHeading("Customer service");
        contact.enterEmailAddress(DataGenerator.randomEmail());
        contact.enterOrderReference(DataGenerator.randomMessage(10));
        contact.attachFile("/Users/omonjonyokubov/Downloads/java.png");
        contact.typeMessage(DataGenerator.randomMessage(100));
        contact.sendMessage();

        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUP(){
        BrowserDriver.quitBrowser();
    }
}