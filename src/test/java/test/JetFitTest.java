package test;

import org.testng.annotations.Test;

public class JetFitTest extends BaseTest {

    @Test
    public void loginTest() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        loginPage.successLoginVerification();
    }

    @Test
    public void loginErrorMessageTest() {
        loginStep.login("", "")
                 .errorLoginMessageVerification("Invalid username or password")
                 .login("", "!QAZ2wsx")
                 .errorLoginMessageVerification("Invalid username or password")
                 .login("TestsUser", "")
                 .errorLoginMessageVerification("Invalid username or password");
    }

    @Test
    public void addCommonRoutineTest() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        routineSteps.routineDownloading("FitBody Plan");
    }

    @Test
    public void test() {
        loginStep.login("TestsUser", "!QAZ2wsx");
    }
}
