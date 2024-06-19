package pages;

import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewProjectPage extends BasePage {

    private final static By ADD_TESTCASE_BUTTON = By.id("sidebar-cases-add");
    private final static By ADD_MILESTONE_BUTTON = By.id("sidebar-milestones-add");
    private final static By ADDED_PROJECT_NAME = By.cssSelector("[data-testid='testCaseContentHeaderTitle']");
    private final static By ADDED_ANNOUNCEMENT = By.cssSelector("[data-testid='projectAnnouncement']");

    public OverviewProjectPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_TESTCASE_BUTTON));
    }

    @Step("Click the button 'Add Test Suite'")
    public void clickAddTestCaseButton()
    {
        driver.findElement(ADD_TESTCASE_BUTTON).click();
    }

    @Step("Click the button 'Add Milestone'")
    public void clickAddMilestoneButton()
    {
        driver.findElement(ADD_MILESTONE_BUTTON).click();
    }

    public Project getProjectInfo()
    {
        Project resultProject = new Project.ProjectBuilder(driver.findElement(ADDED_PROJECT_NAME).getText()).withAnnouncement(driver.findElement(ADDED_ANNOUNCEMENT).getText()).build();
        return resultProject;
    }
}
