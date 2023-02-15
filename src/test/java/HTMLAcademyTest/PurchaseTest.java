package HTMLAcademyTest;

import HTMLAcademy.HTMLAcademyMainPage;
import HTMLAcademy.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PurchaseTest extends AbstractTest{
    @Test
    void PurchaseAsAuthorized() {
        new HTMLAcademyMainPage(getWebDriver()).goToLoginPage();
        new LoginPage(getWebDriver())
                .setLogin("gbmsun_7@gmail.com")
                .setPassword("QETadg135!")
                .submit()
                .subscription()
                .pay();
        Assertions.assertTrue(getWebDriver().getPageSource().contains("card"), "Что-то пошло не так");
    }
}
