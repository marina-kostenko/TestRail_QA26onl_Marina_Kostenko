package tests;

import enums.ProjectType;
import io.qameta.allure.Description;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.GenerateData;

public class CreateProjectTest extends BaseTest {

    @Test(groups = {"need account", "regression"}, description = "positive Add Project Test")
    @Parameters({"email", "password"})
    @Description("this test checks successful adding project")
    public void positiveAddProjectTest()
    {
        String projectName = GenerateData.generateProjectName();
        String announcementText = GenerateData.generateAnnouncementText();
        String expectedMessage = "Successfully added the new project.";
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
        Assert.assertEquals(projectsDetailsPage.getExpectedSuccessfulMessage(), expectedMessage, "message is incorrect or doesn't exist");
        Assert.assertTrue(projectsDetailsPage.isProjectAdded(projectName), "project doesn't exist");
        projectsDetailsPage.clickDashboardTab();
        dashboardPage.isOpen();
        dashboardPage.clickNameProject(projectName);
        overviewProjectPage.isOpen();
        Project actualProject = overviewProjectPage.getProjectInfo();
        Assert.assertEquals(actualProject, testProject, "test project differs from actual project");
    }
}
