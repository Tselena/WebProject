package HTMLAcademyTest;

import HTMLAcademy.HTMLAcademyMainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HTMLMainPageTest extends AbstractTest {

    @Test
    void clickToStudy(){
        new HTMLAcademyMainPage(getWebDriver()).navigateToStudy();
        Assertions.assertEquals("https://htmlacademy.ru/courses/297/run/1", getWebDriver().getCurrentUrl());
    }

}
