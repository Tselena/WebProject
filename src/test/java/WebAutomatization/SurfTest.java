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

public class SurfTest {

    private By startStudyElement = By.className("button--split-effect");
    private By startTaskElement = By.className("button--close");
    private By checkTaskElement = By.className("js--server-check__message");


    @BeforeAll
    public static void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(15));

    }


    @Test
    @DisplayName("Check surf function")
    public void checkSurfFunction() {
        WebDriver driver = new ChromeDriver();
        Data getData = new Data();

        driver.get(getData.getUrl);
        driver.findElement(startStudyElement).click();
        driver.findElement(startTaskElement).click();
        driver.findElement(checkTaskElement).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        Assertions.assertTrue(driver.findElement(By.className("course-goals__list-item--failed")).isEnabled());

        driver.close();
        driver.quit();
    }

}
