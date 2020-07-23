package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.RoutinesPage;
import pages.myjefit.MyRoutinesPage;
import models.Routine;

public class RoutineSteps {

    MyRoutinesPage myRoutinesPage;
    RoutinesPage routinesPage;


    public RoutineSteps(WebDriver driver) {
        myRoutinesPage = new MyRoutinesPage(driver);
        routinesPage = new RoutinesPage(driver);
    }


    @Step("Routine Creation")
    public RoutineSteps routineCreation(Routine routine) {
        myRoutinesPage
                .openPage()
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
    public RoutineSteps routineVerification(String routineName, Routine routine, String message) {
        myRoutinesPage
                .routineInformationVerification(routineName, routine.getRoutineName(), message)
                .routineInformationVerification(routineName, routine.getFrequency(), message)
                .routineInformationVerification(routineName, routine.getDataType(), message)
                .routineInformationVerification(routineName, routine.getType(), message)
                .routineInformationVerification(routineName, routine.getDifficulty(), message)
                .routineInformationVerification(routineName, routine.getTags(), message);
        return this;
    }

    @Step("Routines deleting")
    public RoutineSteps routinesDeleting(String routineName) {
        myRoutinesPage
                .openPage()
                .isPageOpened()
                .deleteButtonSearch(routineName)
                .waitForJStoLoad();
        return this;
    }

    public RoutineSteps informationConverter(Routine routine) {
        if (routine.getFrequency().equals("1 day(s) / week")) {
            routine.setFrequency("1 days / week");
        }
        if (routine.getFrequency().equals("2 day(s) / week")) {
            routine.setFrequency("2 days / week");
        }
        if (routine.getFrequency().equals("3 day(s) / week")) {
            routine.setFrequency("3 days / week");
        }
        if (routine.getFrequency().equals("4 day(s) / week")) {
            routine.setFrequency("4 days / week");
        }
        if (routine.getFrequency().equals("5 day(s) / week")) {
            routine.setFrequency("5 days / week");
        }
        if (routine.getFrequency().equals("6 day(s) / week")) {
            routine.setFrequency("6 days / week");
        }
        if (routine.getFrequency().equals("7 day(s) / week")) {
            routine.setFrequency("7 days / week");
        }
        if (routine.getDataType().equals("Day of Week - E.g., Monday, Tuesday...")) {
            routine.setDataType("Day of the Week");
        }
        if (routine.getDataType().equals("Numerical   - E.g., Day1, Day2...")) {
            routine.setDataType("Numerical");
        }
        if (routine.getType().equals("Bulking - focus on gaining muscle")) {
            routine.setType("Bulking");
        }
        if (routine.getType().equals("Cutting - focus on losing body fat")) {
            routine.setType("Cutting");
        }
        if (routine.getDifficulty().equals("Beginner       - lifting experience <6 months")) {
            routine.setDifficulty("Beginner");
        }
        if (routine.getDifficulty().equals("Intermediate - experience >6 and <24 months")) {
            routine.setDifficulty("Intermediate");
        }
        if (routine.getDifficulty().equals("Advanced      - experience >24 months")) {
            routine.setDifficulty("Advanced");
        }
        return this;
    }
}


