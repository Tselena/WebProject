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

public class PurchaseAsAuthorizedTest {

    private By loginButton = By.className("main-menu__item--login");
    private By emailField = By.id("login-email");
    private By passwordField = By.id("login-password");
    private By submitButton = By.cssSelector(".js-login .button");
    private By subscriptionButton = By.xpath("/html/body/div[2]/div/div/aside/div[1]/div/a");
    private By payButton = By.cssSelector(".subscription__item:nth-child(3) .button");


    @BeforeAll
    public static void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(15));

    }

    @Test
    @DisplayName("Check purchase function as authorized")
    public void purchaseAsAuthorizedTest() {

        WebDriver driver = new ChromeDriver();
        Data getData = new Data();

        driver.get(getData.getUrl);

        driver.findElement(loginButton).click();
        driver.findElement(emailField).sendKeys(getData.email);
        driver.findElement(passwordField).sendKeys(getData.password);
        driver.findElement(submitButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(subscriptionButton).click();
        driver.findElement(payButton).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assertions.assertTrue(driver.getPageSource().contains("card"), "Что-то пошло не так");
        driver.close();
        driver.quit();
    }

}
