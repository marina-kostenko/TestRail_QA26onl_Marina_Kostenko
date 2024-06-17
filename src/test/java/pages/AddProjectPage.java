package pages;

import decorators.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProjectPage extends BasePage {
    private final static By NAME_PROJECT_INPUT = By.cssSelector("[data-testid='addProjectNameInput']");
    private final static By CHECKBOX_SHOW_THE_ANNOUNCEMENT = By.cssSelector("[data-testid='addEditProjectShowAnnouncement']");
    private final static By CHECKBOX_ENABLE_TEST_CASE_APPROVALS = By.cssSelector("[data-testid='addEditProjectCaseStatusesEnabled']");
    private final static By TEXT_IN_ANNOUNCEMENT_AREA = By.cssSelector("[data-testid='addEditProjectAnnouncement']");
    private final static By PROJECT_SUITE_MODE_SINGLE = By.cssSelector("[data-testid='addEditProjectSuiteModeSingle']");
    private final static By PROJECT_SUITE_MODE_SINGLE_BASELINE = By.cssSelector("[data-testid='addEditProjectSuiteModeSingleBaseline']");
    private final static By PROJECT_SUITE_MODE_MULTI = By.cssSelector("[data-testid='addEditProjectSuiteModeMulti']");
    private final static By PROJECT_ADD_BUTTON = By.cssSelector("[data-testid='addEditProjectAddButton']");
    private final static By PROJECT_CANCEL_BUTTON = By.cssSelector("[data-testid='addEditProjectCancelButton']");

    public AddProjectPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(PROJECT_ADD_BUTTON));
    }

    public boolean isNameProjectInputPresent()
    {
        return new InputDecorator(driver, NAME_PROJECT_INPUT).isDisplayed();
    }

    @Step("Set Name Project = '{projectName}'")
    public void setNameProjectInput(String projectName)
    {
        new InputDecorator(driver, NAME_PROJECT_INPUT).sendKeys(projectName);
    }

    @Step("Set Announcement = '{announcementText}'")
    public void setTextInAnnouncementArea(String announcementText)
    {
        new TextAreaDecorator(driver, TEXT_IN_ANNOUNCEMENT_AREA).sendKeys(announcementText);
    }

    @Step("Check Checkbox 'Show The Announcement'")
    public void checkCheckboxShowTheAnnouncement()
    {
        new CheckboxDecorator(driver, CHECKBOX_SHOW_THE_ANNOUNCEMENT).check();
    }

    @Step("Uncheck Checkbox 'Show The Announcement'")
    public void unCheckCheckboxShowTheAnnouncement()
    {
        new CheckboxDecorator(driver, CHECKBOX_SHOW_THE_ANNOUNCEMENT).uncheck();
    }

    public boolean isCheckboxShowTheAnnouncementChecked()
    {
        return new CheckboxDecorator(driver, CHECKBOX_SHOW_THE_ANNOUNCEMENT).isChecked();
    }

    @Step("Check Checkbox 'Enable TestCase Approvals'")
    public void checkCheckboxEnableTestCaseApprovals()
    {
        new CheckboxDecorator(driver, CHECKBOX_ENABLE_TEST_CASE_APPROVALS).check();
    }

    public void unCheckCheckboxEnableTestCaseApprovals()
    {
        new CheckboxDecorator(driver, CHECKBOX_ENABLE_TEST_CASE_APPROVALS).uncheck();
    }

    public boolean isCheckboxEnableTestCaseApprovalsChecked()
    {
        return new CheckboxDecorator(driver, CHECKBOX_ENABLE_TEST_CASE_APPROVALS).isChecked();
    }

    public void selectRadioButtonUseASingleRepositoryForAllCases()
    {
        new RadioButtonDecorator(driver, PROJECT_SUITE_MODE_SINGLE).select();
    }

    public void selectRadioButtonUseASingleRepositoryWithBaseLineSupport()
    {
        new RadioButtonDecorator(driver, PROJECT_SUITE_MODE_SINGLE_BASELINE).select();
    }

    public boolean isRadioButtonUseASingleRepositoryWithBaseLineSupportSelected()
    {
        return new RadioButtonDecorator(driver, PROJECT_SUITE_MODE_SINGLE_BASELINE).isSelected();
    }

    public void selectRadiobuttonUseMultipleTestSuitesToManageCases()
    {
        new RadioButtonDecorator(driver, PROJECT_SUITE_MODE_MULTI).select();
    }

    @Step("Click the button 'Add Project'")
    public void clickButtonAddProject()
    {
        new ButtonDecorator(driver, PROJECT_ADD_BUTTON).click();
    }

    @Step("Click the button 'Cancel'")
    public void clickButtonCancel()
    {
        new ButtonDecorator(driver, PROJECT_CANCEL_BUTTON).click();
    }

    @Step("Creating project '{projectName}'")
    public void addProject(String projectName, String announcementText)
    {
        setNameProjectInput(projectName);
        setTextInAnnouncementArea(announcementText);
        checkCheckboxShowTheAnnouncement();
        selectRadioButtonUseASingleRepositoryWithBaseLineSupport();
        checkCheckboxEnableTestCaseApprovals();
        clickButtonAddProject();
    }
}
