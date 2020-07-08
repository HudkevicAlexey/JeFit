package test;

import models.Routine;
import org.testng.annotations.Test;

public class JetFitTest extends BaseTest {

    @Test
    public void loginTest(){
        loginStep
                .login("TestsUser", "!QAZ2wsx")
                .successLoginVerification();
    }

    @Test
    public void loginErrorMessageTest(){
        loginStep
                .login("", "")
                .failedLoginMessageVerification()
                .login("", "!QAZ2wsx")
                .failedLoginMessageVerification()
                .login("TestsUser", "")
                .failedLoginMessageVerification();
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
        routineCreation.routineCreation(routineCase1);
        routineCreation.routineCreation(routineCase2);
        routineCreation.routineCreation(routineCase3);
        routineCreation.routineCreation(routineCase4);
        routineCreation.routineCreation(routineCase5);
        routineCreation.routineCreation(routineCase6);
        routineCreation.routineCreation(routineCase7);
    }

    @Test
    public void addCommonRoutineTest(){
        loginStep.login("TestsUser", "!QAZ2wsx");
        routineCreation.addRoutine("FitBody Plan");
    }
    @Test
    public void test() {
        loginStep.login("TestsUser", "!QAZ2wsx");
        routineCreation.routineVerification();
    }
}
