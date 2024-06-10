package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTestCaseTest extends BaseTest {
    @Test(groups = {"need account"}, description = "positive Create TestCase Test")
    @Description("this test checks successful creation of TestCase")
    public void positiveCreateTestCaseTest()
    {
        String projectName = "NewProject12";
        String announcementText = "AnnouncementArea testing";
        String baselineName = "Version 11.0";
        String baselineParentName = "Master";
        String title = "TestCaseTitle";
        String preconditions = "preconditions";
        String steps = "steps";
        String expectedResult = "expectedResult";
        String expectedMessage = "Successfully added the new test case. Add another";
        dashboardPage.clickAddProjectButton();
        addProjectPage.addProject(projectName, announcementText);
        administrationPage.clickDashboardTab();
        administrationPage.clickNameProject(projectName);
        overviewPage.clickAddTestSuiteButton();
        testSuitesAndCasesPage.clickAddBaselineButton();
        testSuitesAndCasesPage.setBaselineName(baselineName);
        testSuitesAndCasesPage.selectBaselineParent(baselineParentName);
        testSuitesAndCasesPage.clickAddBaselineSubmitButton();
        testSuitesAndCasesPage.clickBaselineName(baselineName);
        testSuitesAndCasesPage.clickAddCasesButton();
        addTestCasePage.setTitle(title);
        addTestCasePage.setTextPreconditions(preconditions);
        addTestCasePage.setTextSteps(steps);
        addTestCasePage.setTextExpectedResult(expectedResult);
        addTestCasePage.clickAddTestCaseButton();
        Assert.assertEquals(testAddedPage.getExpectedSuccessfulMessage(), expectedMessage, "expected successful message is incorrect");
    }
}
