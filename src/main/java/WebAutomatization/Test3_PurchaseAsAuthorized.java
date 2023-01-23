package WebAutomatization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test3_PurchaseAsAuthorized {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
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

        WebElement subscriptionButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div[1]/div/a"));
        subscriptionButton.click();

        WebElement payButton = driver.findElement(By.cssSelector(".subscription__item:nth-child(3) .button"));
        payButton.click();

        driver.quit();

    }
}
