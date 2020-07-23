package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.myjefit.MyLogsPage;

public class LogsSteps {

    MyLogsPage myLogsPage;

    public LogsSteps(WebDriver driver) {
        myLogsPage = new MyLogsPage(driver);
    }

    @Step("Workout log adding")
    public LogsSteps addWorkoutLogWithTimeInputs(String day, String bodyPart, String exercise, String exerciseCount) {
        myLogsPage
                .openPage()
                .daySelection(day)
                .addWorkoutLogsButtonClick()
                .bodyPartSelection(bodyPart)
                .exerciseSelection(exercise)
                .hoursFormFilling(exerciseCount)
                .minFormFilling(exerciseCount)
                .secFormFilling(exerciseCount)
                .createLogButtonClick();
        return this;
    }

    public LogsSteps addWorkoutLogWithWeightInputs(String day, String bodyPart, String exercise, String exerciseCount) {
        myLogsPage
                .openPage()
                .daySelection(day)
                .addWorkoutLogsButtonClick()
                .bodyPartSelection(bodyPart)
                .exerciseSelection(exercise)
                .weightFormFilling(exerciseCount)
                .repsFormFilling(exerciseCount)
                .createLogButtonClick();
        return this;
    }

    public LogsSteps addCardioWorkoutLog(String day, String bodyPart, String exercise, String exerciseCount) {
        myLogsPage
                .openPage()
                .daySelection(day)
                .addWorkoutLogsButtonClick()
                .bodyPartSelection(bodyPart)
                .exerciseSelection(exercise)
                .cardioFormFilling(exerciseCount)
                .hoursFormFilling(exerciseCount)
                .minFormFilling(exerciseCount)
                .secFormFilling(exerciseCount)
                .createLogButtonClick();
        return this;
    }

    public LogsSteps deleteWorkoutLog(String day) {
        myLogsPage
                .openPage()
                .daySelection(day)
                .editButtonClick()
                .deleteButtonClick();
        return this;
    }

    public LogsSteps logRecordVerification(String day, String exercise, String exerciseCount, String message) {
        myLogsPage
                .openPage()
                .daySelection(day)
                .logsRecordVerification(exercise, exerciseCount, message);
        return this;
    }

}
