package WebAutomatization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test4_StudyProcess {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://htmlacademy.ru/");

        WebElement startStudyElement = driver.findElement(By.className("button--split-effect"));
        startStudyElement.click();

        WebElement startTaskElement = driver.findElement(By.className("button--close"));
        startTaskElement.click();

        WebElement checkTaskElement = driver.findElement(By.className("js--server-check__message"));
        checkTaskElement.click();

        driver.quit();
    }
}
