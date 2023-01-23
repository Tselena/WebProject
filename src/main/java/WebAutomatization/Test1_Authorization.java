package WebAutomatization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test1_Authorization {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://htmlacademy.ru/");

        WebElement loginElement = driver.findElement(By.className("main-menu__item--login"));
        loginElement.click();

        WebElement loginEmailElement = driver.findElement(By.id("login-email"));
        loginEmailElement.click();
        loginEmailElement.sendKeys("gbmsun_7@gmail.com");

        WebElement loginPswElement = driver.findElement(By.id("login-password"));
        loginPswElement.click();
        loginPswElement.sendKeys("QETadg135!");

        WebElement loginButton = driver.findElement(By.cssSelector(".js-login .button"));
        loginButton.click();

        driver.quit();

    }


}
