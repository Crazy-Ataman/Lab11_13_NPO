package com.CrazyAtaman.test;

import com.CrazyAtaman.driver.DriverSingleton;
import com.CrazyAtaman.page.AudiRepairingBodyPagePF;
import com.CrazyAtaman.page.AudiTestDrivePagePF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class WebDriverAudiRepairingBodyTest {
    private WebDriver webDriver;

    @BeforeEach
    void initWebDriver() {
        webDriver = DriverSingleton.getDriver();
    }

    @Test
    @DisplayName("Test: valid form for repairing body")
    void validFormForRepairingBody() {
        assertThat(new AudiRepairingBodyPagePF(webDriver)
                .openPage()
                .scrollDown()
                .inputName("Test")
                .inputTelephone("+375291234567")
                .inputRegNumber("1234AБ7")
                .inputVin("12345678901234567")
                .selectAuto()
                .selectAutoOptionValid1()
                .clickSendButton()
                .getSuccessDivText().equals("Благодарим за обращение.\n" +
                        "Наши специалисты свяжутся с вами в ближайшее время."));
    }

    @Test
    @DisplayName("Test: invalid form for repairing body")
    void invalidFormForRepairingBodyName() {
        assertThat(new AudiRepairingBodyPagePF(webDriver)
                .openPage()
                .scrollDown()
                .inputName("")
                .inputTelephone("+375291234567")
                .inputRegNumber("1234AБ7")
                .inputVin("12345678901234567")
                .selectAuto()
                .selectAutoOptionValid1()
                .clickSendButton()
                .getNameErrorSpanText().equals("Не указано имя"));
    }

    @Test
    @DisplayName("Test: invalid form for repairing body")
    void invalidFormForRepairingBodyTelephone() {
        assertThat(new AudiRepairingBodyPagePF(webDriver)
                .openPage()
                .scrollDown()
                .inputName("Test")
                .inputTelephone("")
                .inputRegNumber("1234AБ7")
                .inputVin("12345678901234567")
                .selectAuto()
                .selectAutoOptionValid1()
                .clickSendButton()
                .getTelephoneErrorSpanText().equals("Не указан телефон"));
    }

    @Test
    @DisplayName("Test: invalid form for repairing body")
    void invalidFormForRepairingBodySelect() {
        assertThat(new AudiRepairingBodyPagePF(webDriver)
                .openPage()
                .scrollDown()
                .inputName("Test")
                .inputTelephone("+375291234567")
                .inputRegNumber("1234AБ7")
                .inputVin("12345678901234567")
                .clickSendButton()
                .getSelectNumberErrorSpanText().equals("Не указан дилерский центр"));
    }
}
