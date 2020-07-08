package steps;

import io.qameta.allure.Step;
import models.Routine;
import org.openqa.selenium.WebDriver;
import pages.RoutinesPage;
import pages.myjefit.MyRoutinesPage;

public class RoutineCreation extends MyRoutinesPage {

    MyRoutinesPage myRoutinesPage = new MyRoutinesPage(driver);
    RoutinesPage routinesPage = new RoutinesPage(driver);

    public RoutineCreation(WebDriver driver) {
        super(driver);
    }

    @Step("Routine Creation")
    public RoutineCreation routineCreation(Routine routine) {
        myRoutinesPage
                .openPage()
                .isPageOpened()
                .clickCreateNewRoutineButton()
                .routineFormFilling(routine)
                .clickSaveButton();
        return this;
    }

    @Step("Adding Routine")
    public RoutineCreation addRoutine(String routineName) {
        myRoutinesPage
                .openPage()
                .isPageOpened()
                .clickDownloadNewRoutineButton();
        routinesPage
                .selectCommonRoutines(routineName)
                .clickSaveToMyWorkouts();
        return this;
    }

    @Step("Routine Creation Verification")
    public RoutineCreation routineVerification() {
        myRoutinesPage
                .openPage()
                .isPageOpened()
                .routinesInfoSearch();
        return this;
    }

}
