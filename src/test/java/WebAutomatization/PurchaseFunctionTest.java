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

public class PurchaseFunctionTest {

    private By startElement = By.xpath("//*[@id=\"main-menu\"]/div/ul[1]/li[1]/span");

    private By skillElement = By.cssSelector("#main-menu > div > ul.main-menu__list.main-menu__list--main > li:nth-child(1) > ul > li:nth-child(8) > a");

    private By chooseSkillElement = By.cssSelector("div.t-btnwrapper:nth-child(2) > a");

    private By buySkillElement = By.cssSelector("article.skill:nth-child(1) > div a.button.skill__button");

    private By paySkillElement = By.cssSelector("div.prices button.prices__button.button--transparent");


    @BeforeAll
    public static void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(15));
    }


    @Test
    @DisplayName("Check Purchase Function")
    public void checkPurchaseFuncionTest() {
        WebDriver driver = new ChromeDriver();
        Data getData = new Data();

        driver.get(getData.getUrl);
        driver.findElement(startElement).click();
        driver.findElement(skillElement).click();
        driver.findElement(chooseSkillElement).click();
        driver.findElement(buySkillElement).click();
        driver.findElement(paySkillElement).click();
        Assertions.assertTrue(driver.getPageSource().contains("pay-form-single"));
        driver.close();
        driver.quit();
    }

}
