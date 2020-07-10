package test;

import models.Routine;
import org.testng.annotations.Test;

public class JetFitTest extends BaseTest {

    @Test
    public void loginTest() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        loginPage.successLoginVerification();
    }

    @Test
    public void loginErrorMessageTest() {
        loginStep
                .login("", "");
        loginPage
                .errorLoginMessageVerification("Invalid username or password")
                .login("", "!QAZ2wsx");
        loginPage
                .errorLoginMessageVerification("Invalid username or password")
                .login("TestsUser", "");
        loginPage
                .errorLoginMessageVerification("Invalid username or password");
    }

    @Test
    public void createNewRoutineTest() {
        Routine routineCase1 = new Routine("RoutineCase1", "0", "0", "0", "0", "NoDescr", "testTag");
        Routine routineCase2 = new Routine("RoutineCase2", "1", "1", "1", "1", "NoDescr", "testTag");
        Routine routineCase3 = new Routine("RoutineCase3", "2", "1", "2", "2", "NoDescr", "testTag");
        Routine routineCase4 = new Routine("RoutineCase4", "3", "1", "3", "2", "NoDescr", "testTag");
        Routine routineCase5 = new Routine("RoutineCase5", "4", "1", "3", "2", "NoDescr", "testTag");
        Routine routineCase6 = new Routine("RoutineCase6", "5", "1", "3", "2", "NoDescr", "testTag");
        Routine routineCase7 = new Routine("RoutineCase7", "6", "1", "3", "2", "NoDescr", "testTag");
        loginStep.login("TestsUser", "!QAZ2wsx");
        routineCreation
                .routineCreation(routineCase1)
                .routineVerification("RoutineCase1", "1 days / week", "Day of the Week", "General Fitness", "Beginner", "testTag", "NoDescr")
                .routineCreation(routineCase2)
                .routineVerification("RoutineCase2", "2 days / week", "Numerical", "Bulking", "Intermediate", "testTag", "NoDescr")
                .routineCreation(routineCase3)
                .routineVerification("RoutineCase3", "3 days / week", "Numerical", "Cutting", "Advanced", "testTag", "NoDescr")
                .routineCreation(routineCase4)
                .routineVerification("RoutineCase4", "4 days / week", "Numerical", "Sport Specific", "Advanced", "testTag", "NoDescr")
                .routineCreation(routineCase5)
                .routineVerification("RoutineCase5", "5 days / week", "Numerical", "Sport Specific", "Advanced", "testTag", "NoDescr")
                .routineCreation(routineCase6)
                .routineVerification("RoutineCase6", "6 days / week", "Numerical", "Sport Specific", "Advanced", "testTag", "NoDescr")
                .routineCreation(routineCase7)
                .routineVerification("RoutineCase7", "7 days / week", "Numerical", "Sport Specific", "Advanced", "testTag", "NoDescr");
    }

    @Test
    public void addCommonRoutineTest() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        routineCreation.routineDownloading("FitBody Plan");
    }

    @Test
    public void test() {
        loginStep.login("TestsUser", "!QAZ2wsx");
    }
}
