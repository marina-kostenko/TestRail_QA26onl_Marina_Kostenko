package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.PropertyReader;
import utils.TestListener;

import java.time.Duration;

@Listeners({InvokedListener.class, TestListener.class})
public abstract class BaseTest {
    protected static final String BASE_URL = PropertyReader.getProperty("url");
    protected static final String BASE_LOGIN = PropertyReader.getProperty("login");
    protected static final String BASE_PASSWORD = PropertyReader.getProperty("password");
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected AddProjectPage addProjectPage;
    protected OverviewProjectPage overviewProjectPage;
    protected AdministrationPage administrationPage;
    protected TestSuitesAndCasesPage testSuitesAndCasesPage;
    protected AddTestCasePage addTestCasePage;
    protected TestCaseDetailsPage testCaseDetailsPage;
    protected AddMilestonePage addMilestonePage;
    protected MilestonesPage milestonesPage;
    protected ProjectsDetailsPage projectsDetailsPage;
    protected MilestoneDetailsPage milestoneDetailsPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception
    {
        driver = DriverFactory.getDriver(PropertyReader.getProperty("browser"));
        testContext.setAttribute("driver", driver);
        driver.get(BASE_URL);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.addProjectPage = new AddProjectPage(driver);
        this.overviewProjectPage = new OverviewProjectPage(driver);
        this.administrationPage = new AdministrationPage(driver);
        this.testSuitesAndCasesPage = new TestSuitesAndCasesPage(driver);
        this.addTestCasePage = new AddTestCasePage(driver);
        this.testCaseDetailsPage = new TestCaseDetailsPage(driver);
        this.addMilestonePage = new AddMilestonePage(driver);
        this.milestonesPage = new MilestonesPage(driver);
        this.projectsDetailsPage = new ProjectsDetailsPage(driver);
        this.milestoneDetailsPage = new MilestoneDetailsPage(driver);
    }

    @BeforeMethod(alwaysRun = true, onlyForGroups = {"need account"}, dependsOnMethods = "setUp")
    @Parameters({"email", "password"})
    public void setAccount(@Optional("defaultEmail") String email, @Optional("defaultPassword") String password)
    {
        loginPage.login(BASE_LOGIN, BASE_PASSWORD);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}
