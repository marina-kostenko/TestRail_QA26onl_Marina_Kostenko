package pages;

import decorators.ButtonDecorator;
import decorators.DropdownDecorator;
import decorators.InputDecorator;
import decorators.TextAreaDecorator;
import io.qameta.allure.Step;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddTestCasePage extends BasePage {

    private final String caseTitleInput = "addEditCaseTitle";
    private final By CUSTOM_PRECONDS_TEXTAREA = By.cssSelector("[data-attr='custom_preconds']");
    private final By CUSTOM_STEPS_TEXTAREA = By.cssSelector("[data-attr='custom_steps']");
    private final By CUSTOM_EXPECTED_TEXTAREA = By.cssSelector("[data-attr='custom_expected']");
    private final String testCaseButton = "addTestCaseButton";
    private final By CANCEL_TESTCASE_BUTTON = By.cssSelector("[data-testid='addEditCaseCancelButton']");
    private final By TEMPLATE = By.id("template_id_chzn");
    private final By TYPE = By.id("type_id_chzn");
    private final By PRIORITY = By.id("priority_id_chzn");
    private final By STATUS = By.id("status_id_chzn");
    private final By ASSIGNED = By.id("assigned_to_id_chzn");
    private final String estimateInput = "editCaseEstimate";
    private final String referencesInput = "editCaseRefs";
    private final By AUTOMATION_TYPE = By.id("custom_automation_type_chzn");

    public AddTestCasePage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(CANCEL_TESTCASE_BUTTON));
    }

    @Step("Click the button 'Add Test Case'")
    public void clickAddTestCaseButton()
    {
        new ButtonDecorator(driver, this.testCaseButton).click();
    }

    public void addTestCase(TestCase testCase)
    {
        new InputDecorator(driver, this.caseTitleInput).setValue(testCase.getCaseTitle());
        if (testCase.getTemplateTestCaseType() != null) {
            new DropdownDecorator(driver, TEMPLATE).selectByVisibleText(testCase.getTemplateTestCaseType().getName());
        }
        if (testCase.getTypeTestCase() != null) {
            new DropdownDecorator(driver, TYPE).selectByVisibleText(testCase.getTypeTestCase().getName());
        }
        if (testCase.getPriorityTestCase() != null) {
            new DropdownDecorator(driver, PRIORITY).selectByVisibleText(testCase.getPriorityTestCase().getName());
        }
        if (testCase.getStatusTestCase() != null) {
            new DropdownDecorator(driver, STATUS).selectByVisibleText(testCase.getStatusTestCase().getName());
        }
        if (testCase.getAssignedTestCase() != null) {
            new DropdownDecorator(driver, ASSIGNED).selectByVisibleText(testCase.getAssignedTestCase().getName());
        }
        if (testCase.getEstimate() != null) {
            new InputDecorator(driver, this.estimateInput).setValue(testCase.getEstimate());
        }
        if (testCase.getReferences() != null) {
            new InputDecorator(driver, this.referencesInput).setValue(testCase.getReferences());
        }
        if (testCase.getAutomationTypeTestCase() != null) {
            new DropdownDecorator(driver, AUTOMATION_TYPE).selectByVisibleText(testCase.getAutomationTypeTestCase().getName());
        }
        if (testCase.getPreconditions() != null) {
            new TextAreaDecorator(driver, CUSTOM_PRECONDS_TEXTAREA).setValue(testCase.getPreconditions());
        }
        if (testCase.getSteps() != null) {
            new TextAreaDecorator(driver, CUSTOM_STEPS_TEXTAREA).setValue(testCase.getSteps());
        }
        if (testCase.getExpectedResults() != null) {
            new TextAreaDecorator(driver, CUSTOM_EXPECTED_TEXTAREA).setValue(testCase.getExpectedResults());
        }
        clickAddTestCaseButton();
    }
}
