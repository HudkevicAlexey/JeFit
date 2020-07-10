package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import steps.LoginSteps;
import steps.RoutineSteps;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    LoginSteps loginStep;
    RoutineSteps routineCreation;
    LoginPage loginPage;


    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginStep = new LoginSteps(driver);
        routineCreation = new RoutineSteps(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}

