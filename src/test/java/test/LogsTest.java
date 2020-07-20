package test;

import org.testng.annotations.Test;

public class LogsTest extends BaseTest {

    @Test
    public void test() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        logsSteps.addWorkoutLog("3", "Back", "Back Relaxation");
    }
}
