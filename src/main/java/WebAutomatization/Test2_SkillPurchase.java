package WebAutomatization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test2_SkillPurchase {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://htmlacademy.ru/");

        WebElement startElement = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div/ul[1]/li[1]/span"));
        startElement.click();

        WebElement skillElement = driver.findElement(By.cssSelector("#main-menu > div > ul.main-menu__list.main-menu__list--main > li:nth-child(1) > ul > li:nth-child(8) > a"));
        skillElement.click();

        WebElement chooseSkillElement = driver.findElement(By.cssSelector("div.t-btnwrapper:nth-child(2) > a"));
        chooseSkillElement.click();

        WebElement buySkillElement = driver.findElement(By.cssSelector("article.skill:nth-child(1) > div a.button.skill__button"));
        buySkillElement.click();

        WebElement paySkillElement = driver.findElement(By.cssSelector("div.prices button.prices__button.button--transparent"));
        paySkillElement.click();

        driver.quit();

    }

}
