package HTMLAcademyTest;

import HTMLAcademy.HTMLAcademyMainPage;
import HTMLAcademy.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginNegativeTest extends AbstractTest{

    @Test
    void LoginInWithNotValidData() {
        new HTMLAcademyMainPage(getWebDriver()).goToLoginPage();
        new LoginPage(getWebDriver())
                .setLogin("gbmsun_7@gmail.ru")
                .setPassword("QETadg135!")
                .submit();
        Assertions.assertTrue(getWebDriver().getTitle().contains("Вход"), "Что-то пошло не так");
    }


}
