package pages.myjefit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MyLogsPage extends BasePage {

    @FindBy(className = ".btn btn-primary btn-block")
    WebElement addWorkoutLogsButton;

    String dateSelectionLocator = "//table[@class='InnerTable']//a[contains(text(),'%s']";

    public MyLogsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected MyLogsPage openPage() {
        driver.get("https://www.jefit.com/my-jefit/my-logs/");
        return this;
    }

    @Override
    protected MyLogsPage isPageOpened() {
        return this;
    }

    public MyLogsPage daySelection(String day) {
        WebElement date = driver.findElement(By.xpath(String.format(dateSelectionLocator, day)));
        date.click();
        return this;
    }

    public MyLogsPage addWorkoutLogsButtonClick() {
        addWorkoutLogsButton.click();
        return this;
    }


}
