package HTMLAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.AcceptPendingException;
import java.time.Duration;

public class HTMLAcademyMainPage extends AbstractPage {

    @FindBy(className = "button--split-effect")
    private WebElement startStudyElement;

    @FindBy(className = "button--close")
    private WebElement startTaskElement;

    @FindBy(className = "js--server-check__message")
    private WebElement checkTaskElement;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/div/ul[1]/li[1]/span")
    private WebElement startElement;

    @FindBy(css = "#main-menu > div > ul.main-menu__list.main-menu__list--main > li:nth-child(1) > ul > li:nth-child(8) > a")
    private WebElement skillElement;

    @FindBy(css = "div.t-btnwrapper:nth-child(2) > a")
    private WebElement chooseSkillElement;

    @FindBy(css = "article.skill:nth-child(1) > div a.button.skill__button")
    private WebElement buySkillElement;

    @FindBy(css = "div.prices button.prices__button.button--transparent")
    private WebElement paySkillElement;

    @FindBy(className = "main-menu__item--login")
    private WebElement loginButton;


    public HTMLAcademyMainPage(WebDriver driver){
        super(driver);
    }

    public void goToLoginPage(){
        loginButton.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("htmlacademy.ru/"));
    }

    public void navigateToStudy(){
       startStudyElement.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("courses/297/run/1"));
    }

    public void startTask(){
        startTaskElement.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("courses/297/run/1"));
    }

}
