package tests;

import enums.*;
import io.qameta.allure.Description;
import models.Project;
import models.TestCase;
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
        String title = "CaseTitle";
        String estimate = "20";
        String references = "Refers";
        String preconditions = "preconditions";
        String steps = "steps";
        String expectedResult = "expectedResult";
        String expectedMessage = "Successfully added the new test case. Add another";
        dashboardPage.isOpen();
        dashboardPage.clickAddProjectButton();
        addProjectPage.isOpen();
        Project testProject = new Project.ProjectBuilder(projectName)
                .withAnnouncement(announcementText)
                .setShowAnnouncement(true)
                .withProjectType(ProjectType.SINGLE_REPO_FOR_ALL_CASES)
                .setEnableTestCaseApprovals(true)
                .build();
        addProjectPage.addProject(testProject);
        projectsDetailsPage.isOpen();
        projectsDetailsPage.clickDashboardTab();
        dashboardPage.isOpen();
        dashboardPage.clickNameProject(projectName);
        overviewProjectPage.isOpen();
        overviewProjectPage.clickAddTestCaseButton();
        addTestCasePage.isOpen();
        TestCase testTestcase = new TestCase.TestCaseBuilder(title)
                // .setTemplateTestCaseType(TemplateTestCaseType.TEST_CASE_TEXT)
                .setTypeTestCase(TypeTestCase.AUTOMATED)
                .setPriorityTestCase(PriorityTestCase.HIGH)
                .setStatusTestCase(StatusTestCase.READY)
                .setAssignedTestCase(AssignedTestCase.NONE)
                .setEstimate(estimate)
                .setReferences(references)
                .setAutomationTypeTestCase(AutomationTypeTestCase.NONE)
                .setPreconditions(preconditions)
                .setSteps(steps)
                .setExpectedResults(expectedResult)
                .build();
        addTestCasePage.addTestCase(testTestcase);
        testCaseDetailsPage.isOpen();
        Assert.assertEquals(testCaseDetailsPage.getExpectedSuccessfulMessage(), expectedMessage, "expected successful message is incorrect");
        TestCase actualTestCase = testCaseDetailsPage.getTestCaseInfo();
        Assert.assertEquals(actualTestCase, testTestcase, " testTestcase differs from actualTestCase");
    }
}
