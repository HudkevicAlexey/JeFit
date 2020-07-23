package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LogsTest extends BaseTest {

    @Test(description = "Log creation test")
    public void logsRecordVerificationTest() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        logsSteps
                .addWorkoutLogWithWeightInputs("4", "Back", "Barbell Bent Arm Pullover", "4")
                .logRecordVerification("4", "Barbell Bent Arm Pullover", "4", "Data is not matching")
                .addWorkoutLogWithTimeInputs("5", "Back", "Back Relaxation", "4")
                .logRecordVerification("5", "Back Relaxation", "4", "Data is not matching")
                .addCardioWorkoutLog("6", "Cardio", "Indoor Cycling", "4")
                .logRecordVerification("6", "Indoor Cycling", "4", "Data is not matching");
    }

    @AfterMethod(alwaysRun = true)
    public void logsDeleting() {
        logsSteps
                .deleteWorkoutLog("4")
                .deleteWorkoutLog("5")
                .deleteWorkoutLog("6");
    }
}
