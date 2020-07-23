package pages.myjefit;

import helper.StepHelper;
import models.Routine;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
    String actualRoutineNameLocator = "//strong[contains(text(),'%s')]/ancestor::tbody";
    String deleteButtonXpath = actualRoutineNameLocator + "//a[2]";
    By dismissButton = By.xpath("//button[contains(text(),'Dismiss')]");

    String routineManagerName = "%s";
    WebElement routineCreationField;
    StepHelper step = new StepHelper();

    public MyRoutinesPage(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor executor = (JavascriptExecutor) driver;

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

    public MyRoutinesPage selectValueByName(String value) {
        Select select = new Select(routineCreationField);
        select.selectByVisibleText(value);
        return this;
    }

    public MyRoutinesPage routineFormFilling(Routine routine) {
        filedSelection(driver, "rpname").write(routine.getRoutineName());
        filedSelection(driver, "dayselect").selectValueByName(routine.getFrequency());
        filedSelection(driver, "daytype").selectValueByName(routine.getDataType());
        filedSelection(driver, "typeselect").selectValueByName(routine.getType());
        filedSelection(driver, "levelselect").selectValueByName(routine.getDifficulty());
        filedSelection(driver, "rptext").write(routine.getDescription());
        filedSelection(driver, "rtags").write(routine.getTags());
        return this;
    }

    public MyRoutinesPage clickSaveButton() {
        try {
            executor.executeScript("arguments[0].click();", saveButtonName);
        } catch (UnknownError e) {
            driver.findElement(dismissButton).click();
            saveButtonName.click();
        }
        return this;
    }

    public MyRoutinesPage clickDownloadNewRoutineButton() {
        downloadRoutineButtonXpath.click();
        return this;
    }

    public boolean routineInformationVerification(String routineName, String routineDetails, String message) {
        String routinesInformation = driver.findElement(By.xpath(String.format(actualRoutineNameLocator, routineName))).getText();
        try {
            Assert.assertTrue(routinesInformation.contains(routineDetails), message);
            step.info(routineDetails + " check");
            return true;
        } catch (AssertionError e) {
            step.error(message + "" + routineDetails + " is not presented in routine record ");
            return false;
        }
    }

    public MyRoutinesPage deleteButtonSearch(String routineName) {
        WebElement deleteButton = driver.findElement(By.xpath(String.format(deleteButtonXpath, routineName)));
        executor.executeScript("arguments[0].click();", deleteButton);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }
}
