package com.techcenture.academy.temp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

/**
 * Created by tairovich_jr on 2022-01-13.
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
//
//        driver.get("http://automationpractice.com");
//
//        WebElement womenTab = driver.findElement(By.xpath("//li/a[text()='Women']"));
//
//        Actions actions = new Actions(driver);
//
//        actions.moveToElement(womenTab).build().perform();
//
//        Thread.sleep(2000);
//        WebElement tShirtsInner = driver.findElement(By.xpath("//ul[starts-with(@class,'submenu-container')]//a[text()='T-shirts']"));
//
//        tShirtsInner.click();

//        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
//
//        Actions actions = new Actions(driver);
//
//        WebElement colA = driver.findElement(By.id("column-a"));
//        WebElement colB = driver.findElement(By.id("column-b"));
//
//        int x = colB.getLocation().x;
//        int y = colB.getLocation().y;
//
//        actions.moveToElement(colA)
//                .pause(Duration.ofSeconds(1))
//                .clickAndHold(colA)
//                .pause(Duration.ofSeconds(1))
//                .moveByOffset(x, y)
//                .moveToElement(colB)
//                .moveByOffset(x,y)
//                .pause(Duration.ofSeconds(1))
//                .release().build().perform();



//        driver.get("http://automationpractice.com");
//        Actions actions = new Actions(driver);
//
//        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='homefeatured']/li"));
//
////        for (int i = 0; i < elements.size(); i++) {
////            actions.moveToElement(elements.get(i) ).perform();
////            Thread.sleep(1000);
////        }
//        for (WebElement element : elements) {
//            actions.moveToElement(element).perform();
//            Thread.sleep(500);
//        }

        driver.get("https://etsy.com");
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("keyboard" + Keys.ENTER);
        Actions actions = new Actions(driver);


        while (driver.findElement(By.xpath("(//li[@class='wt-action-group__item-container']//span[text()='Next'])[2]")).isEnabled()){
            List<WebElement> etsyItems = driver.findElements(By.xpath("//li//h3"));
            for (int i = 0; i < etsyItems.size(); i++) {
                WebElement each = etsyItems.get(i);
                actions.moveToElement(each).perform();
                System.out.println(each.getText());
                Thread.sleep(10);
            }
            driver.findElement(By.xpath("(//li[@class='wt-action-group__item-container'])[13]")).click();
            Thread.sleep(1000);
            driver.navigate().refresh();
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollTo(0, -document.body.scrollHeight)");

        }


    }


}
