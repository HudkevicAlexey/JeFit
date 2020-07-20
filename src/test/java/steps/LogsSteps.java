package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.myjefit.MyLogsPage;
import pages.myjefit.MyRoutinesPage;

public class LogsSteps {

    MyLogsPage myLogsPage;

    public LogsSteps(WebDriver driver) {
        myLogsPage = new MyLogsPage(driver);
    }

    @Step("Workout log adding")
    public LogsSteps addWorkoutLog(String day, String bodyPart, String exercise) {
        myLogsPage
                .openPage()
                .daySelection(day)
                .addWorkoutLogsButtonClick()
                .bodyPartSelection(bodyPart)
                .exerciseSelection(exercise)
                .weightFormFilling();
        return this;
    }
}
