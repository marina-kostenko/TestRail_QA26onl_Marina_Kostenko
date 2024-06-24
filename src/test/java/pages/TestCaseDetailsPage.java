package pages;

import enums.*;
import io.qameta.allure.Step;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCaseDetailsPage extends BasePage {
    private final static By MESSAGE_TEXT = By.cssSelector("[data-testid='messageSuccessDivBox']");
    private final static By EDIT_BUTTON = By.cssSelector("[data-testid='testCaseEditButton']");
    private final static By ACTUAL_TITLE = By.cssSelector("[data-testid='testCaseContentHeaderTitle']");
    private final static By ACTUAL_TYPE = By.id("cell_type_id");
    private final static By ACTUAL_PRIORITY = By.id("cell_priority_id");
    private final static By ACTUAL_STATUS = By.id("cell_status");
    private final static By ACTUAL_ASSIGNED = By.id("cell_assignedto");
    private final static By ACTUAL_ESTIMATE = By.id("cell_estimate");
    private final static By ACTUAL_REFERENCES = By.id("cell_refs");
    private final static By ACTUAL_AUTOMATION_TYPE = By.id("cell_custom_automation_type");
    private final static By ACTUAL_PRECONDITIONS = By.xpath("//*[text()='Preconditions']//following::p");
    private final static By ACTUAL_STEPS = By.xpath("//*[text()='Steps']//following::p");
    private final static By ACTUAL_EXPECTED_RESULTS = By.xpath("//*[text()='Expected Result']//following::p");

    public TestCaseDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(EDIT_BUTTON));
    }

    @Step("Get Expected Successful Message")
    public String getExpectedSuccessfulMessage()
    {
        return driver.findElement(MESSAGE_TEXT).getText();
    }

    public TestCase getTestCaseInfo()
    {
        TestCase resultTestCase = new TestCase
                .TestCaseBuilder(driver.findElement(ACTUAL_TITLE).getText())
                .setTypeTestCase(TypeTestCase.getFromName(driver.findElement(ACTUAL_TYPE)
                        .getText().trim().replace("Type", "").trim()))
                .setPriorityTestCase(PriorityTestCase.getFromName(driver.findElement(ACTUAL_PRIORITY)
                        .getText().trim().replace("Priority", "").trim()))
                .setStatusTestCase(StatusTestCase.getFromName(driver.findElement(ACTUAL_STATUS)
                        .getText().trim().replace("Status", "").trim()))
                .setAssignedTestCase(AssignedTestCase.getFromName(driver.findElement(ACTUAL_ASSIGNED)
                        .getText().trim().replace("Assigned To", "").trim()))
                .setEstimate(driver.findElement(ACTUAL_ESTIMATE)
                        .getText().trim().replace("Estimate", "").trim().split(" ")[0])
                .setReferences(driver.findElement(ACTUAL_REFERENCES)
                        .getText().trim().replace("References", "").trim())
                .setAutomationTypeTestCase(AutomationTypeTestCase.getFromName(driver.findElement(ACTUAL_AUTOMATION_TYPE)
                        .getText().trim().replace("Automation Type", "").trim()))
                .setPreconditions(driver.findElement(ACTUAL_PRECONDITIONS).getText())
                .setSteps(driver.findElement(ACTUAL_STEPS).getText())
                .setExpectedResults(driver.findElement(ACTUAL_EXPECTED_RESULTS).getText())
                .build();
        return resultTestCase;
    }
}


