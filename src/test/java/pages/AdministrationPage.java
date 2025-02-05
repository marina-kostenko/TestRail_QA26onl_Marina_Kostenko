package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdministrationPage extends BasePage {

    private final static By DASHBOARD_TAB = By.id("navigation-dashboard");
    private final static By SIDEBAR_OVERVIEW = By.cssSelector("[data-testid='administrationSidebarOverview']");

    public AdministrationPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(SIDEBAR_OVERVIEW));
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
}

