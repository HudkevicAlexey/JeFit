package pages.myjefit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class MyLogsPage extends BasePage {


    String addWorkoutLogsButton = "//button[contains(text(),'+ Add Workout Logs')]";
    String bodyPartLocator = "//div[@class = 'row m-0']/div[1]//div[contains(text(),'%s')]";
    String exerciseLocator = "//div[@class = 'row m-0']/div[2]//div[contains(text(),'%s')]";
    String dateSelectionLocator = "//table[@class='InnerTable']//a[contains(text(),'%s')]";
    By inputsWeightLocator = By.name("weight");
    By inputsRepsLocator = By.name("rep");

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

    public MyLogsPage weightFormFilling() {
        List<WebElement> listOfElements = driver.findElements(inputsWeightLocator);
        for (WebElement element : listOfElements) {
            element.sendKeys("4");
        }
        return this;
    }
}
