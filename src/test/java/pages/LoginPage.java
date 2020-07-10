package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import steps.LoginSteps;

public class LoginPage extends BasePage {


    By USERNAME_id = By.id("navbar_username");
    By PASSWORD_id = By.id("navbar_password");
    By LOGIN_BUTTON_className = By.className("loginblueButton1");
    By LOGIN_ERROR_MESSAGE_id = By.id("invalidpassworderrormessage");
    By googleSignInButton = By.className("googleLoginButton");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get("https://www.jefit.com/login/");
        return this;
    }

    protected LoginPage isPageOpened() {
        driver.findElement(googleSignInButton).isDisplayed();
        return this;
    }

    public LoginPage usernameEntering(String login) {
        driver.findElement(USERNAME_id).sendKeys(login);
        return this;
    }

    public LoginPage passwordEntering(String password) {
        driver.findElement(PASSWORD_id).sendKeys(password);
        return this;

    }

    public LoginPage loginButtonClick() {
        driver.findElement(LOGIN_BUTTON_className).click();
        return this;
    }

    public LoginPage successLoginVerification() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.jefit.com/my-jefit/", "Login was not successfully executed or redirection URL was not matching with Expected URL");
        return this;
    }

    public LoginSteps errorLoginMessageVerification(String expectedErrorMessage) {
        Assert.assertEquals(driver.findElement(LOGIN_ERROR_MESSAGE_id).getText(), expectedErrorMessage, "Error message is not displayed or not matching with Expected text");
        return new LoginSteps(driver);
    }
}
