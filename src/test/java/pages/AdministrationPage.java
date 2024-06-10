package pages;

import decorators.ElementDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdministrationPage extends BasePage {

    private final static By DASHBOARD_TAB = By.id("navigation-dashboard");
    private final static String PROJECT_CONTAINER = "//a[text()='%s']/ancestor::div[@class='table summary summary-auto']";
    private final static By SIDEBAR_OVERVIEW = By.cssSelector("[data-testid='administrationSidebarOverview']");
    private final static By NAME_PROJECT_LIST = By.cssSelector("a[href^='index.php?/projects/overview']");

    public AdministrationPage(WebDriver driver)
    {
        super(driver);
    }

    public boolean isSidebarOverviewPresent()
    {
        return driver.findElement(SIDEBAR_OVERVIEW).isDisplayed();
    }

    @Step("Click the tab 'Dashboard'")
    public void clickDashboardTab()
    {
        driver.findElement(DASHBOARD_TAB).click();
    }

    private WebElement getProjectContainerByName(String projectName)
    {
        return driver.findElement(By.xpath(String.format(PROJECT_CONTAINER, projectName)));
    }

    @Step("Click the name of  '{projectName}'")
    public void clickNameProject(String projectName)
    {
        new ElementDecorator(driver, this.getProjectContainerByName(projectName).findElement(NAME_PROJECT_LIST)).click();
    }
}

