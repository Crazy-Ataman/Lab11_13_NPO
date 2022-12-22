package com.CrazyAtaman.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AudiTestDrivePagePF extends AbstractPage {
    private static final String TEST_DRIVE_URL = "https://www.audi.by/by/web/ru/contact/test-drive-request.html";

    @FindBy(xpath = "//*[@id=\"textfield-name\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"textfield-surname\"]")
    private WebElement surnameInput;

    @FindBy(xpath = "//*[@id=\"textfield-phone\"]")
    private WebElement telephoneNumberInput;

    @FindBy(xpath = "//*[@id=\"textfield-email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "/html/body/div/form/input")
    private WebElement sendButton;

    @FindBy(xpath = "/html/body/div/div")
    private WebElement successDiv;

    @FindBy(xpath = "/html/body/div/form/div[1]/span")
    private WebElement nameErrorSpan;

    @FindBy(xpath = "/html/body/div/form/div[2]/span")
    private WebElement surnameErrorSpan;

    @FindBy(xpath = "/html/body/div/form/div[3]/span")
    private WebElement telephoneNumberErrorSpan;

    public AudiTestDrivePagePF(WebDriver driver) {
        super(driver);
    }
    private final Logger logger = LogManager.getRootLogger();

    public AudiTestDrivePagePF openPage() {
        driver.get(TEST_DRIVE_URL);
        logger.info("Test drive page opened");
        return this;
    }

    public AudiTestDrivePagePF scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        return this;
    }

    public AudiTestDrivePagePF inputName(String name) {
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(nameInput))
                .sendKeys(name);
        logger.info("Name inputted");
        return this;
    }

    public AudiTestDrivePagePF inputSurname(String surname) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(surnameInput))
                .sendKeys(surname);
        logger.info("Surname inputted");
        return this;
    }

    public AudiTestDrivePagePF inputTelephoneNumber(String telephoneNumber) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(telephoneNumberInput))
                .sendKeys(telephoneNumber);
        logger.info("Telephone number inputted");
        return this;
    }

    public AudiTestDrivePagePF inputEmail(String email) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(emailInput))
                .sendKeys(email);
        logger.info("Email inputted");
        return this;
    }

    public AudiTestDrivePagePF clickSendButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);
        logger.info("Send button clicked");
        return this;
    }

    public String getSuccessDivText() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.visibilityOf(successDiv))
                .getText();
    }

    public String getNameErrorSpanText() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.visibilityOf(nameErrorSpan))
                .getText();
    }

    public String getSurnameErrorSpanText() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.visibilityOf(surnameErrorSpan))
                .getText();
    }

    public String getTelephoneNumberErrorSpanText() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.visibilityOf(telephoneNumberErrorSpan))
                .getText();
    }

}
