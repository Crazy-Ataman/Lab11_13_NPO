package com.CrazyAtaman.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AudiRepairingBodyPagePF extends AbstractPage {
    private static final String REPAIRING_BODY_FORM_URL = "https://www.audi.by/by/web/ru/audi_service/kuzov/kuzovform.html";

    @FindBy(xpath = "//*[@id=\"textfield-name\"]")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"textfield-phone\"]")
    private WebElement telephoneInput;

    @FindBy(xpath = "//*[@id=\"textfield-regnumber\"]")
    private WebElement regNumberInput;

    @FindBy(xpath = "//*[@id=\"textfield-vin\"]")
    private WebElement vinInput;

    @FindBy(xpath = "//*[@id=\"select-auto\"]")
    private WebElement selectAutoInput;

    @FindBy(xpath = "/html/body/div/form/input")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@id=\"select-auto\"]/option[2]")
    private WebElement selectAutoOptionValid1;

    @FindBy(xpath = "/html/body/div/div[2]")
    private WebElement successDiv;

    @FindBy(xpath = "/html/body/div/form/div[1]/span")
    private WebElement nameError;

    @FindBy(xpath = "/html/body/div/form/div[2]/span")
    private WebElement telephoneError;

    @FindBy(xpath = "/html/body/div/form/div[5]/span[2]")
    private WebElement selectNumberError;

    public AudiRepairingBodyPagePF(WebDriver driver) {
        super(driver);
    }
    private final Logger logger = LogManager.getRootLogger();

    public AudiRepairingBodyPagePF openPage() {
        driver.get(REPAIRING_BODY_FORM_URL);
        logger.info("Repairing body page opened");
        return this;
    }

    public AudiRepairingBodyPagePF scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        return this;
    }

    public AudiRepairingBodyPagePF inputName(String name) {
        driver.switchTo().frame(0);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(nameInput))
                .sendKeys(name);
        logger.info("Name inputted");
        return this;
    }

    public AudiRepairingBodyPagePF inputTelephone(String telephone) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(telephoneInput))
                .sendKeys(telephone);
        logger.info("Telephone inputted");
        return this;
    }

    public AudiRepairingBodyPagePF inputRegNumber(String regNumber) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(regNumberInput))
                .sendKeys(regNumber);
        logger.info("Reg number inputted");
        return this;
    }

    public AudiRepairingBodyPagePF inputVin(String vin) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(vinInput))
                .sendKeys(vin);
        logger.info("Vin inputted");
        return this;
    }

    public AudiRepairingBodyPagePF selectAuto() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(selectAutoInput))
                .click();
        logger.info("Auto selected");
        return this;
    }

    public AudiRepairingBodyPagePF selectAutoOptionValid1() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(selectAutoOptionValid1))
                .click();
        logger.info("Auto option valid 1 selected");
        return this;
    }

    public AudiRepairingBodyPagePF clickSendButton() {
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
                        ExpectedConditions.visibilityOf(nameError))
                .getText();
    }

    public String getTelephoneErrorSpanText() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.visibilityOf(telephoneError))
                .getText();
    }

    public String getSelectNumberErrorSpanText() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.visibilityOf(selectNumberError))
                .getText();
    }
}
