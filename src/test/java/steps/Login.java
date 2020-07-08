package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class Login extends LoginPage {

    LoginPage loginPage = new LoginPage(driver);

    public Login(WebDriver driver) {
        super(driver);
    }

    @Step("Credential Entering")
    public Login login(String username, String password) {
        loginPage
                .openPage()
                .usernameEntering(username)
                .passwordEntering(password)
                .loginButtonClick();
        return this;
    }


}
