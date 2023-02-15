package HTMLAcademyTest;

import HTMLAcademy.HTMLAcademyMainPage;
import HTMLAcademy.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends AbstractTest{

    @Test
    void LoginInWithValidData() {
        new HTMLAcademyMainPage(getWebDriver()).goToLoginPage();
        new LoginPage(getWebDriver())
                .setLogin("gbmsun_7@gmail.com")
                .setPassword("QETadg135!")
                        .submit();
        Assertions.assertTrue(getWebDriver().getPageSource().contains("https://htmlacademy.ru/study"), "Что-то пошло не так");
    }
}
