package HTMLAcademyTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class AbstractTest {

    static WebDriver webDriver;

    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(25));


        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    void initMainPage(){
        getWebDriver().navigate().to("https://htmlacademy.ru/");
        driverWait();
        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://htmlacademy.ru/"),
                "Страница не доступна");
        Assertions.assertTrue(true);
    }

    @AfterAll
    public static void exit(){

        if(webDriver !=null) webDriver.quit();
    }

    public WebDriver getWebDriver(){
        return this.webDriver;
    }

    public WebDriver driverWait(){
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        return webDriver;
    }

}
