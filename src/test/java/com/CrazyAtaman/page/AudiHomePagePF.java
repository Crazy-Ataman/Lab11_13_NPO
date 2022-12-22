package com.CrazyAtaman.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AudiHomePagePF extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.audi.by/by/web/ru.html";

    @FindBy(xpath = "//*[@id=\"audi-header\"]/div/div[1]/div/div[4]/div/button")
    private WebElement magnifierButton;

    @FindBy(id = "search__basic")
    private WebElement searchInputElement;

    @FindBy(xpath = "//*[@id=\"audi-header\"]/div/div[1]/div[2]/div[5]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/a[2]/span")
    private WebElement q3Button;

    @FindBy(xpath = "//*[@id=\"audi-header\"]/div/div[1]/div/div[3]/nav/div[2]/a/span")
    private WebElement buyersButton;

    @FindBy(xpath = "//*[@id=\"audi-header\"]/div/div[1]/div[2]/div[3]/nav/div[2]/div/div/div/div/div/a/div/span/span")
    private WebElement signUpForTestDriveButton;

    public AudiHomePagePF(WebDriver driver) {
        super(driver);
    }

    public AudiHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public AudiHomePagePF clickMagnifier() {
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
//                        ExpectedConditions.elementToBeClickable(magnifierButton))
//                .click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", magnifierButton);
        return this;
    }

    public AudiHomePagePF inputAndEnterSearchA5() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(searchInputElement))
                .sendKeys("A5");
        searchInputElement.sendKeys(Keys.ENTER);
        return this;
    }

    public AudiHomePagePF inputAndEnterSearchQ3() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(searchInputElement))
                .sendKeys("Q3");
        searchInputElement.sendKeys(Keys.ENTER);
        return this;
    }

    public AudiHomePagePF clickQ3Button() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", q3Button);
        return this;
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getListOfSearchResults() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(By
                                        .xpath("//span[@class='sc-fznKkj dTlhdB']")));
        List<WebElement> searchResults = driver
                .findElements(By.xpath("//span[@class='sc-fznKkj dTlhdB']"));
        return searchResults;
    }
}
