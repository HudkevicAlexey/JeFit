package test;

import org.testng.annotations.Test;

public class DownloadRoutinesTest extends BaseTest {


    @Test(description = "Download new routine")
    public void addCommonRoutineTest() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        routineSteps
                .routineDownloading("FitBody Plan")
                .routinesDeleting("FitBody Plan");
    }
}
