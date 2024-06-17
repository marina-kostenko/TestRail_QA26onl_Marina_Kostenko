package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GenerateData;

public class CreateTestCaseTest extends BaseTest {
    @Test(groups = {"need account", "regression"}, description = "positive Create TestCase Test")
    @Description("this test checks successful creation of TestCase")
    public void positiveCreateTestCaseTest()
    {
        String projectName = GenerateData.generateProjectName();
        String announcementText = GenerateData.generateAnnouncementText();
        String title = "TestCaseTitle";
        String preconditions = "preconditions";
        String steps = "steps";
        String expectedResult = "expectedResult";
        String expectedMessage = "Successfully added the new test case. Add another";
        dashboardPage.isOpen();
        dashboardPage.clickAddProjectButton();
        addProjectPage.isOpen();
        addProjectPage.addProject(projectName, announcementText);
        administrationPage.isOpen();
        administrationPage.clickDashboardTab();
        administrationPage.clickNameProject(projectName);
        overviewPage.isOpen();
        overviewPage.clickAddTestCaseButton();
        addTestCasePage.isOpen();
        addTestCasePage.setTitle(title);
        addTestCasePage.setTextPreconditions(preconditions);
        addTestCasePage.setTextSteps(steps);
        addTestCasePage.setTextExpectedResult(expectedResult);
        addTestCasePage.clickAddTestCaseButton();
        testAddedPage.isOpen();
        Assert.assertEquals(testAddedPage.getExpectedSuccessfulMessage(), expectedMessage, "expected successful message is incorrect");
    }
}
