package test;

import models.Routine;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoutinesCreationTest extends BaseTest {
    @BeforeMethod
    public void login() {
        loginStep.login("TestsUser", "!QAZ2wsx");
    }

    @DataProvider(name = "Data for routine form filling")
    public Object[][] dataForRoutinesInformation() {
        return new Object[][]{
                {"RoutinesName", "1 day(s) / week", "Day of Week - E.g., Monday, Tuesday...", "General Fitness", "Beginner       - lifting experience <6 months", "testTag", "NoDescr"},
                {"RoutineCase2", "2 day(s) / week", "Numerical   - E.g., Day1, Day2...", "Bulking - focus on gaining muscle", "Intermediate - experience >6 and <24 months", "testTag", "NoDescr"},
                {"RoutineCase3", "3 day(s) / week", "Numerical   - E.g., Day1, Day2...", "Cutting - focus on losing body fat", "Advanced      - experience >24 months", "testTag", "NoDescr"},
                {"RoutineCase4", "4 day(s) / week", "Numerical   - E.g., Day1, Day2...", "Sport Specific", "Advanced      - experience >24 months", "testTag", "NoDescr"},
                {"RoutineCase5", "5 day(s) / week", "Numerical   - E.g., Day1, Day2...", "Sport Specific", "Advanced      - experience >24 months", "testTag", "NoDescr"},
                {"RoutineCase6", "6 day(s) / week", "Numerical   - E.g., Day1, Day2...", "Sport Specific", "Advanced      - experience >24 months", "testTag", "NoDescr"},
                {"RoutineCase7", "7 day(s) / week", "Numerical   - E.g., Day1, Day2...", "Sport Specific", "Advanced      - experience >24 months", "testTag", "NoDescr"}
        };
    }

    @Test(dataProvider = "Data for routine form filling")
    public void createNewRoutineTest(String name, String frequency, String dataType, String type, String difficulty, String description, String tags) {
        Routine routine = new Routine(name, frequency, dataType, type, difficulty, tags, description);
        routineSteps
                .routineCreation(routine)
                .informationConverter(routine)
                .routineVerification(name, routine);
    }

    @AfterMethod(alwaysRun = true)
    public void routineDeleting() {
        routineSteps.routinesDeleting();
    }
}
