package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {

    private final static By ADD_TESTSUITE_BUTTON = By.id("sidebar-suites-add");
    private final static By ADD_MILESTONE_BUTTON = By.id("sidebar-milestones-add");

    public OverviewPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Click the button 'Add Test Suite'")
    public void clickAddTestSuiteButton()
    {
        driver.findElement(ADD_TESTSUITE_BUTTON).click();
    }

    @Step("Click the button 'Add Milestone'")
    public void clickAddMilestoneButton()
    {
        driver.findElement(ADD_MILESTONE_BUTTON).click();
    }
}
