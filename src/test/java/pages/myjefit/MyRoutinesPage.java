package pages.myjefit;

import models.Routine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import org.openqa.selenium.support.ui.Select;

public class MyRoutinesPage extends BasePage {

    @FindBy(name = "Submit")
    WebElement saveButtonName;
    @FindBy(className = "mb-2")
    WebElement jeFitLogoImgClass;
    @FindBy(xpath = "//a[contains(text(),'Create New Routine')]")
    WebElement createNewRoutineButtonXpath;
    @FindBy(xpath = "//a[contains(text(),'Download A Routine')]")
    WebElement downloadRoutineButtonXpath;
    String actualRoutineNameLocator = "//strong[contains(text(),'%s')]/../../../../../..//*[contains(text(),'%s')]";

    String routineManagerName = "%s";
    WebElement routineCreationField;

    public MyRoutinesPage(WebDriver driver) {
        super(driver);
    }

    public MyRoutinesPage openPage() {
        driver.get("https://www.jefit.com/my-jefit/my-routines/routine-manager.php");
        return this;
    }

    public MyRoutinesPage isPageOpened() {
        jeFitLogoImgClass.isDisplayed();
        return this;
    }

    public MyRoutinesPage clickCreateNewRoutineButton() {
        createNewRoutineButtonXpath.click();
        return this;
    }

    public MyRoutinesPage filedSelection(WebDriver driver, String name) {
        routineCreationField = driver.findElement(By.name(String.format(routineManagerName, name)));
        return this;
    }

    public MyRoutinesPage write(String text) {
        routineCreationField.sendKeys(text);
        return this;
    }

    public MyRoutinesPage selectValue(String value) {
        Select select = new Select(routineCreationField);
        select.selectByValue(value);
        return this;
    }

    public MyRoutinesPage routineFormFilling(Routine routine) {
        filedSelection(driver, "rpname").write(routine.getRoutineName());
        filedSelection(driver, "dayselect").selectValue(routine.getFrequency());
        filedSelection(driver, "daytype").selectValue(routine.getDataType());
        filedSelection(driver, "typeselect").selectValue(routine.getType());
        filedSelection(driver, "levelselect").selectValue(routine.getDifficulty());
        filedSelection(driver, "rptext").write(routine.getDescription());
        filedSelection(driver, "rtags").write(routine.getTags());
        return this;
    }

    public MyRoutinesPage clickSaveButton() {
        saveButtonName.click();
        return this;
    }

    public MyRoutinesPage clickDownloadNewRoutineButton() {
        downloadRoutineButtonXpath.click();
        return this;
    }

    public MyRoutinesPage routineInformationVerification(String routineName, String routineDetails) {
        WebElement routinesInformation = driver.findElement(By.xpath(String.format(actualRoutineNameLocator, routineName, routineDetails)));
        routinesInformation.isDisplayed();
        return this;
    }
}
