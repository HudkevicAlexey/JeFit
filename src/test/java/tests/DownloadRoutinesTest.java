package tests;

import org.testng.annotations.Test;


public class DownloadRoutinesTest extends BaseTest {


    @Test(description = "New routine downloading test")
    public void addCommonRoutineTest() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        routineSteps
                .routineDownloading("FitBody Plan")
                .routinesDeleting("FitBody Plan");
    }
}
