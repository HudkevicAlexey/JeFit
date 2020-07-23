package pages;

import helper.StepHelper;
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

    StepHelper step = new StepHelper();

    public LoginPage openPage() {
        step.info("login page opening");
        driver.get("https://www.jefit.com/login/");
        return this;
    }

    public LoginPage isPageOpened() {
        driver.findElement(googleSignInButton).isDisplayed();
        return this;
    }

    public LoginPage usernameEntering(String login) {
        step.info("user name entering " + login);
        driver.findElement(USERNAME_id).sendKeys(login);
        return this;
    }

    public LoginPage passwordEntering(String password) {
        step.info("user name entering " + password);
        driver.findElement(PASSWORD_id).sendKeys(password);
        return this;

    }

    public LoginPage loginButtonClick() {
        step.info("login button clicking ");
        driver.findElement(LOGIN_BUTTON_className).click();
        return this;
    }

    public LoginPage successLoginVerification() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.jefit.com/my-jefit/", "Login was not successfully executed or redirection URL was not matching with Expected URL");
        return this;
    }

    public LoginSteps errorLoginMessageVerification(String expectedErrorMessage, String errorMessage) {
        try {
            Assert.assertEquals(driver.findElement(LOGIN_ERROR_MESSAGE_id).getText(), expectedErrorMessage);
        }catch (AssertionError e){
            step.error(errorMessage);
        }
        return new LoginSteps(driver);
    }
}
