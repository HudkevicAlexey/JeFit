package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoutinesPage extends BasePage {

    String commonRoutinesRecordLocatorXpath = "//div[contains(text(),'%s')]/..";
    @FindBy(xpath = "//input[@value='Save To My Workouts']")
    WebElement saveToMyWorkouts;
    By dismissButton = By.xpath("//button[contains(text(),'Dismiss')]");
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    public RoutinesPage(WebDriver driver) {
        super(driver);
    }

    public BasePage openPage() {
        driver.get("https://www.jefit.com/my-jefit/my-routines/routine-manager.php");
        return this;
    }

    protected BasePage isPageOpened() {
        return null;
    }

    public RoutinesPage selectCommonRoutines(String routineName) {
        By commonRoutinesRecord = By.xpath(String.format(commonRoutinesRecordLocatorXpath, routineName));
        driver.findElement(commonRoutinesRecord).click();
        return this;
    }

    public RoutinesPage clickSaveToMyWorkouts() {
        waitForJStoLoad();
        try{
        executor.executeScript("arguments[0].click();", saveToMyWorkouts);
        } catch (UnknownError e) {
            driver.findElement(dismissButton).click();
            saveToMyWorkouts.click();
        }
        return this;
    }
}
