package pages.myjefit;

import models.Routine;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
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
    By deleteButtonXpath = By.xpath("//table[@id='hor-minimalist_3']//a[2]");
    String actualRoutineNameLocator = "//strong[contains(text(),'%s')]/ancestor::tbody";
    By dismissButton = By.xpath("//button[contains(text(),'Dismiss')]");

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
            saveButtonName.click();
        }catch (ElementClickInterceptedException e){
            driver.findElement(dismissButton).click();
            saveButtonName.click();
        }
        return this;
    }

    public MyRoutinesPage clickDownloadNewRoutineButton() {
        downloadRoutineButtonXpath.click();
        return this;
    }

    public MyRoutinesPage routineInformationVerification(String routineName, String routineDetails) {
        String routinesInformation = driver.findElement(By.xpath(String.format(actualRoutineNameLocator, routineName))).getText();
        Assert.assertTrue(routinesInformation.contains(routineDetails), "");
        return this;
    }

    public MyRoutinesPage clickDeleteRoutineButton() {
        driver.findElement(deleteButtonXpath).click();
        driver.switchTo().alert().accept();
        return this;
    }

    public boolean deleteButtonSearch() {
        try {
            driver.findElement(deleteButtonXpath).isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
