package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.Login;
import steps.RoutineCreation;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    Login loginStep;
    RoutineCreation routineCreation;


    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginStep = new Login(driver);
        routineCreation = new RoutineCreation(driver);
    }

    @AfterMethod(alwaysRun=true)
    public void closeBrowser() {
        driver.quit();
    }
}

