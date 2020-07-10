package steps;

import io.qameta.allure.Step;
import models.Routine;
import org.openqa.selenium.WebDriver;
import pages.RoutinesPage;
import pages.myjefit.MyRoutinesPage;

public class RoutineSteps extends MyRoutinesPage {

    MyRoutinesPage myRoutinesPage = new MyRoutinesPage(driver);
    RoutinesPage routinesPage = new RoutinesPage(driver);


    public RoutineSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Routine Creation")
    public RoutineSteps routineCreation(Routine routine) {
        myRoutinesPage
                .openPage()
                .isPageOpened()
                .clickCreateNewRoutineButton()
                .routineFormFilling(routine)
                .clickSaveButton();
        return this;
    }

    @Step("Adding Routine {String routineName}")
    public RoutineSteps routineDownloading(String routineName) {
        myRoutinesPage
                .openPage()
                .isPageOpened()
                .clickDownloadNewRoutineButton();
        routinesPage
                .selectCommonRoutines(routineName)
                .clickSaveToMyWorkouts();
        return this;
    }

    @Step("Routine Verification {String routineName}")
    public RoutineSteps routineVerification(String routineName, String frequency, String dayType, String type, String difficulty, String description, String tags) {
        myRoutinesPage
                .routineInformationVerification(routineName, frequency)
                .routineInformationVerification(routineName, dayType)
                .routineInformationVerification(routineName, type)
                .routineInformationVerification(routineName, difficulty)
                .routineInformationVerification(routineName, tags)
                .routineInformationVerification(routineName, description);
        return this;
    }
}

