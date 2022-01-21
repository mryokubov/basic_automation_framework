package com.techcenture.academy.pages;

import com.techcenture.academy.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

import static org.testng.Assert.*;


/**
 * Created by tairovich_jr on 2022-01-11.
 */
public class ContactUsPage {

    private WebDriver driver;
    private SoftAssert softAssert;

    public ContactUsPage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }

    /* Web Elements of Contact Us Page */

    @FindBy(className = "navigation_page")
    private WebElement contactTab;

    @FindBy(xpath = "//h1[starts-with(@class,'page-heading')]")
    private WebElement pageHeading;

    @FindBy(className = "page-subheading")
    private WebElement pageSubHeading;

    @FindBy(xpath = "//label[@for='id_contact']")
    private WebElement subHeadingLabel;

    private Select subjectOptionsDropDown;

    @FindBy(id = "desc_contact1")
    private WebElement webMasterTechnicalServiceTxt;

    @FindBy(id = "desc_contact2")
    private WebElement customerTechnicalServiceTxt;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailLabel;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//label[text()='Order reference']")
    private WebElement orderReferenceLabel;

    @FindBy(id = "id_order")
    private WebElement getOrderReferenceInput;

    @FindBy(xpath = "//label[@for='fileUpload']")
    private WebElement fileUploadLabel;

    @FindBy(id = "fileUpload")
    private WebElement attachFileInput;

    @FindBy(xpath = "//span[@class='action']")
    private WebElement chooseFileBtn;

    @FindBy(xpath = "//label[@for='message']")
    private WebElement messageLabel;

    @FindBy(id = "message")
    private WebElement messageTextArea;

    @FindBy(id = "submitMessage")
    private WebElement sendBtn;

    @FindBy(xpath = "//p[contains(@class,'alert-success')]")
    private WebElement successAlert;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]/p")
    private WebElement failureToSendAlert;

    @FindBy(id = "id_contact")
    private WebElement selectId;

    @FindBy(linkText = "contact us")
    private WebElement contactUsLink;


    public void visitHomePage(){
        //           http:automationpractice.com
        driver.get( ConfigReader.getProperty("url") );
    }

    public void clickContactUsLink(){
        contactUsLink.click();
    }

    //primary actions on the contact us page
    public void selectSubHeading(String option){
        softAssert.assertEquals(subHeadingLabel.getText(), "Subject Heading");
        subjectOptionsDropDown = new Select(selectId);
        subjectOptionsDropDown.selectByVisibleText(option);
        if (option.equals("Webmaster")){
            softAssert.assertEquals(webMasterTechnicalServiceTxt.getText(),
                    "If a technical problem occurs on this website");
        }else if(option.equals("Customer service")){
            softAssert.assertEquals(customerTechnicalServiceTxt.getText(),
                    "For any question about a product, an order");
        }
    }

    public void enterEmailAddress(String emailAddress){
        softAssert.assertEquals(emailLabel.getText(), "Email address");
        emailInput.sendKeys(emailAddress);
    }

    public void enterOrderReference(String orderRef){
        softAssert.assertEquals(orderReferenceLabel.getText(), "Order reference");
        getOrderReferenceInput.sendKeys(orderRef);
    }

    public void attachFile(String filePath){
    //    "/Users/jack/Downloads/hello.png"
        softAssert.assertEquals(fileUploadLabel.getText(), "Attach File");
        attachFileInput.sendKeys(filePath);
    }

    public void typeMessage(String message){
        softAssert.assertEquals(messageLabel.getText(), "Message");
        messageTextArea.sendKeys(message);
    }

    public void sendMessage() throws InterruptedException {
        softAssert.assertTrue(sendBtn.isDisplayed());
        softAssert.assertTrue(sendBtn.isEnabled());
        sendBtn.click();
        Thread.sleep(3000);
        WebElement successOrFailure = driver.findElement(By.xpath("//div[@id='center_column']"));

        if (successOrFailure.getText().contains("There is 1 error")){
            verifyFailureAlertBanner();
        }else if(successOrFailure.getText().contains("message has been successfully")){
            verifySuccessAlertBanner();
        }
    }

    private void verifySuccessAlertBanner(){
        softAssert.assertTrue(successAlert.isDisplayed());
    }

    private void verifyFailureAlertBanner(){
        softAssert.assertTrue(failureToSendAlert.isDisplayed());
    }
}
