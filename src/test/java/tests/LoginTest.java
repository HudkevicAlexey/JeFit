package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Successful login test")
    public void loginTest() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        loginPage.successLoginVerification();
    }

    @Test(description = "Error message displaying test")
    public void loginErrorMessageTest() {
        loginStep.login("", "")
                .errorLoginMessageVerification("Invalid username or password")
                .login("", "!QAZ2wsx")
                .errorLoginMessageVerification("Invalid username or password")
                .login("TestsUser", "")
                .errorLoginMessageVerification("Invalid username or password");
    }
}
