package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {
    public WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(driver, this);
    }

    protected abstract BasePage openPage();

    protected abstract BasePage isPageOpened();

    public void waitForNumberOfElements(By locator, int numberOfElements) {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, numberOfElements));
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(locator, numberOfElements));
        } catch (TimeoutException ex) {
            Assert.fail("Колличество элементов на стртанице не соответсвует твоим ожидания");
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}
