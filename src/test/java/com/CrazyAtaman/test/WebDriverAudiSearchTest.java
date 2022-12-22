package com.CrazyAtaman.test;

import com.CrazyAtaman.page.AudiHomePagePF;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

class WebDriverAudiSearchTest {
    private WebDriver driver;

    @BeforeEach
    @DisplayName("Setup Chrome Driver")
    public void initializeDriver() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

//    @Test
//    @DisplayName("Test: search input and results")
//    void clickMagnifierButtonAndInputTextAndPressEnterAndCheckResults()
//            throws InterruptedException {
//        AudiHomePagePF audiHomePagePF =
//                new AudiHomePagePF(driver).openPage()
//                        .clickMagnifier()
//                        .inputAndEnterSearchA5();
//        Assertions.assertTrue(audiHomePagePF.getListOfSearchResults().size() > 0,
//                "Search results are empty!");
//        Thread.sleep(5000);
//    }

    @Test
    @DisplayName("Test: search input and results")
    void clickMagnifierButtonAndInputTextAndPressEnterAndCheckPageUrl()
            throws InterruptedException {
        AudiHomePagePF audiHomePagePF =
                new AudiHomePagePF(driver).openPage()
                        .clickMagnifier()
                        .inputAndEnterSearchQ3();
        audiHomePagePF.clickQ3Button();
        Assertions.assertEquals(
                "https://www.audi.by/by/web/ru/models/q3.html",
                audiHomePagePF.getPageUrl());
        Thread.sleep(5000);
    }

    @AfterEach
    @DisplayName("Close Chrome Driver")
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
