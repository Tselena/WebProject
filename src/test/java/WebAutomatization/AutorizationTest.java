package WebAutomatization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AutorizationTest extends Data{

    private By loginButton = By.className("main-menu__item--login");
    private By emailField = By.id("login-email");
    private By passwordField = By.id("login-password");
    private By submitButton = By.cssSelector(".js-login .button");

    @BeforeAll
    public static void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(15));

    }




    @Test
    @DisplayName("Check URL")
    public void checkUrlTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Data getData = new Data();

        driver.get(getData.getUrl);
        Assertions.assertTrue(driver.getTitle().contains("Academy"), "страница входа недоступна");
        driver.close();
        driver.quit();
    }

    @Test
    @DisplayName("Check autorization with valid data")
    public void autorizationTest() {

        WebDriver driver = new ChromeDriver();
        Data getData = new Data();

        driver.get(getData.getUrl);
        driver.findElement(loginButton).click();
        driver.findElement(emailField).sendKeys(getData.email);
        driver.findElement(passwordField).sendKeys(getData.password);
        driver.findElement(submitButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assertions.assertTrue(driver.getPageSource().contains("https://htmlacademy.ru/study"), "Что-то пошло не так");
        driver.close();
        driver.quit();
    }

    @Test
    @DisplayName("Check autorization with not valid data")
    public void autorizationFailedTest() {

        WebDriver driver = new ChromeDriver();
        Data getData = new Data();

        driver.get(getData.getUrl);
        driver.findElement(loginButton).click();
        driver.findElement(emailField).sendKeys(getData.email);
        driver.findElement(passwordField).sendKeys(getData.wrongPassword);
        driver.findElement(submitButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assertions.assertTrue(driver.getTitle().contains("Вход"), "Что-то пошло не так");
        driver.close();
        driver.quit();
    }


}
