package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Credential Entering")
    public LoginSteps login(String username, String password) {
        loginPage
                .openPage()
                .isPageOpened()
                .usernameEntering(username)
                .passwordEntering(password)
                .loginButtonClick();
        return this;
    }

    @Step("Verify error message")
    public LoginSteps errorLoginMessageVerification(String expectedErrorMessage, String message) {
        loginPage.errorLoginMessageVerification(expectedErrorMessage, message);
        return this;
    }
}
