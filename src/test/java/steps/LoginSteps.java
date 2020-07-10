package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;


public class LoginSteps extends BasePage {

    LoginPage loginPage = new LoginPage(driver);


    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        return null;
    }

    @Override
    protected BasePage isPageOpened() {
        return null;
    }

    @Step("Credential Entering")
    public LoginSteps login(String username, String password) {
        loginPage
                .openPage()
                .usernameEntering(username)
                .passwordEntering(password)
                .loginButtonClick();
        return this;
    }


}
