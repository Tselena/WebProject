package HTMLAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    @FindBy(className = "main-menu__item--login")
    private WebElement loginButton;

    @FindBy(id="login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(css = ".js-login .button")
    private WebElement submitButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/aside/div[1]/div/a")
    private WebElement subscriptionButton;

    @FindBy(css = ".subscription__item:nth-child(3) .button")
    private WebElement payButton;



    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void logInClick(){
        this.loginButton.click();
    }

    public LoginPage setLogin(String login){
        this.emailField.click();
        this.emailField.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password){
        this.passwordField.click();
        this.passwordField.sendKeys(password);
        return this;
    }

    public LoginPage submit(){
        this.submitButton.click();
        return this;
    }

    public LoginPage subscription(){
        this.subscriptionButton.click();
        return this;
    }

    public LoginPage pay() {
        this.payButton.click();
        return this;
    }


    public void loginIn(String login, String password){
        Actions loginIn = new Actions(getDriver());
        loginIn
                .sendKeys(this.emailField,login)
                .click(this.passwordField)
                .sendKeys(password)
                .click(this.submitButton)
                .build()
                .perform();
    }

    public void purchaseAsAuthorized(String login, String password){
        Actions purchase = new Actions(getDriver());
        purchase
                .sendKeys(this.emailField,login)
                .click(this.passwordField)
                .sendKeys(password)
                .click(this.submitButton)
                .click(this.payButton)
                .build()
                .perform();
    }


}
