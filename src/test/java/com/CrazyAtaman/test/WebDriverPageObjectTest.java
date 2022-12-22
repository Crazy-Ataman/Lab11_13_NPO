package com.CrazyAtaman.test;

import com.CrazyAtaman.driver.DriverSingleton;
import com.CrazyAtaman.page.AudiTestDrivePagePF;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;

public class WebDriverPageObjectTest {
    private WebDriver webDriver;

    @BeforeEach
    void initWebDriver() {
        webDriver = DriverSingleton.getDriver();
    }

    @Test
    @DisplayName("Test: valid form for test drive")
    void validFormForTestDrive()
    {
        assertThat(new AudiTestDrivePagePF(webDriver)
                .openPage()
                .scrollDown()
                .inputName("Test")
                .inputSurname("Test")
                .inputTelephoneNumber("+375291234567")
                .inputEmail("test@mail.ru")
                .clickSendButton()
                .getSuccessDivText().equals("Спасибо за интерес к автомобилям Audi!\n" +
                        "Менеджер свяжется с Вами в ближайшее время!"));
    }

    @Test
    @DisplayName("Test: invalid form for test drive")
    void invalidFormForTestDriveName()
    {
        assertThat(new AudiTestDrivePagePF(webDriver)
                .openPage()
                .scrollDown()
                .inputName("")
                .inputSurname("surname")
                .inputTelephoneNumber("+375291234567")
                .inputEmail("test@mail.ru")
                .clickSendButton()
                .getNameErrorSpanText().equals("Не указано имя"));
    }

    @Test
    @DisplayName("Test: invalid form for test drive")
    void invalidFormForTestDriveSurname()
    {
        assertThat(new AudiTestDrivePagePF(webDriver)
                .openPage()
                .scrollDown()
                .inputName("name")
                .inputSurname("")
                .inputTelephoneNumber("+375291234567")
                .inputEmail("test@mail.ru")
                .clickSendButton()
                .getSurnameErrorSpanText().equals("Не указана фамилия"));
    }

    @Test
    @DisplayName("Test: invalid form for test drive")
    void invalidFormForTestDriveTelephone()
    {
        assertThat(new AudiTestDrivePagePF(webDriver)
                .openPage()
                .scrollDown()
                .inputName("name")
                .inputSurname("surname")
                .inputTelephoneNumber("")
                .inputEmail("test@mail.ru")
                .clickSendButton()
                .getTelephoneNumberErrorSpanText().equals("Не указан телефон"));
    }
}
