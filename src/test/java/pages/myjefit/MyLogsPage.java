package pages.myjefit;

import org.openqa.selenium.*;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

public class MyLogsPage extends BasePage {


    String addWorkoutLogsButton = "//button[contains(text(),'+ Add Workout Logs')]";
    String bodyPartLocator = "//div[@class = 'row m-0']/div[1]//div[contains(text(),'%s')]";
    String exerciseLocator = "//div[@class = 'row m-0']/div[2]//div[contains(text(),'%s')]";
    String dateSelectionLocator = "//table[@class='InnerTable']//a[contains(text(),'%s')]";
    By getInputsWeightLocator = By.xpath("//li//input[@name='weight']");
    By getInputsHoursLocator = By.xpath("//ul[@class='logsetlist']//input[@name='hour']");
    By getInputsMinLocator = By.xpath("//ul[@class='logsetlist']//input[@name='min']");
    By getInputsSecLocator = By.xpath("//ul[@class='logsetlist']//input[@name='sec']");
    By getInputsCardioLocator = By.name("cardio");
    By getInputsRepsLocator = By.xpath("//input[@name='rep']");
    By createLogButton = By.xpath("//button[@class='add-log-button']");
    By editButton = By.xpath("//span[@id='edit-session']");
    By logRecordLocator = By.xpath("//div[@class='exercise-block']");

    public MyLogsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MyLogsPage openPage() {
        driver.get("https://www.jefit.com/my-jefit/my-logs/");
        return this;
    }

    @Override
    public MyLogsPage isPageOpened() {
        return this;
    }

    JavascriptExecutor executor = (JavascriptExecutor) driver;

    public MyLogsPage daySelection(String day) {
        WebElement date = driver.findElement(By.xpath(String.format(dateSelectionLocator, day)));
        date.click();
        return this;
    }

    public MyLogsPage addWorkoutLogsButtonClick() {
        waitForJStoLoad();
        driver.findElement(By.xpath(addWorkoutLogsButton)).click();
        return this;
    }

    public MyLogsPage bodyPartSelection(String bodyPartName) {
        WebElement bodyPartLocatorXpath = driver.findElement(By.xpath(String.format(bodyPartLocator, bodyPartName)));
        executor.executeScript("arguments[0].click();", bodyPartLocatorXpath);
        return this;
    }

    public MyLogsPage exerciseSelection(String exerciseName) {
        WebElement exerciseLocatorXpath = driver.findElement(By.xpath(String.format(exerciseLocator, exerciseName)));
        executor.executeScript("arguments[0].click();", exerciseLocatorXpath);
        return this;
    }

    public MyLogsPage hoursFormFilling(String exerciseCount) {
        waitForJStoLoad();
        List<WebElement> listOfElements = driver.findElements(getInputsHoursLocator);
        for (WebElement element : listOfElements) {
            element.sendKeys(exerciseCount);
        }
        return this;
    }

    public MyLogsPage minFormFilling(String exerciseCount) {
        waitForJStoLoad();
        List<WebElement> listOfElements = driver.findElements(getInputsMinLocator);
        for (WebElement element : listOfElements) {
            element.sendKeys(exerciseCount);
        }
        return this;
    }

    public MyLogsPage secFormFilling(String exerciseCount) {
        waitForJStoLoad();
        List<WebElement> listOfElements = driver.findElements(getInputsSecLocator);
        for (WebElement element : listOfElements) {
            element.sendKeys(exerciseCount);
        }
        return this;
    }

    public MyLogsPage weightFormFilling(String exerciseCount) {
        List<WebElement> listOfElements = driver.findElements(getInputsWeightLocator);
        for (WebElement element : listOfElements) {
            element.sendKeys(exerciseCount);
        }
        return this;
    }

    public MyLogsPage repsFormFilling(String exerciseCount) {
        List<WebElement> listOfElements = driver.findElements(getInputsRepsLocator);
        for (WebElement element : listOfElements) {
            element.sendKeys(exerciseCount);
        }
        return this;
    }

    public MyLogsPage cardioFormFilling(String exerciseCount) {
        List<WebElement> listOfElements = driver.findElements(getInputsCardioLocator);
        for (WebElement element : listOfElements) {
            element.sendKeys(exerciseCount);
        }
        return this;
    }

    public MyLogsPage createLogButtonClick() {
        driver.findElement(createLogButton).click();
        return this;
    }

    public MyLogsPage editButtonClick() {
        waitForJStoLoad();
        driver.findElement(editButton).click();
        return this;
    }

    public MyLogsPage deleteButtonClick() {
        WebElement el = driver.findElement(By.xpath("//div[@class='circle-delete-button']//div[contains(text(),'×')]"));
        executor.executeScript("arguments[0].click();", el);
        return this;
    }

    public MyLogsPage logsRecordVerification(String exercise, String exerciseCount, String message) {
        String routinesInformation = driver.findElement(logRecordLocator).getText();
        Assert.assertTrue(routinesInformation.contains(exercise), message);
        Assert.assertTrue(routinesInformation.contains(exerciseCount), message);
        return this;
    }
}
