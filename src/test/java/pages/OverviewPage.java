package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Click the button 'Add Test Suite'")
    public void clickAddTestSuiteButton()
    {
        driver.findElement(By.id("sidebar-suites-add")).click();
    }

    @Step("Click the button 'Add Milestone'")
    public void clickAddMilestoneButton()
    {
        driver.findElement(By.id("sidebar-milestones-add")).click();
    }
}
