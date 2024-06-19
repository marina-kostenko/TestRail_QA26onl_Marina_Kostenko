package tests;

import enums.ProjectType;
import io.qameta.allure.Description;
import models.Milestone;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GenerateData;

public class CreateMilestoneTest extends BaseTest {
    @Test(groups = {"need account", "regression"}, description = "positive Create Milestone Test")
    @Description("this test checks successful creation of milestone")
    public void positiveCreateMilestoneTest()
    {
        String projectName = GenerateData.generateProjectName();
        String announcementText = GenerateData.generateAnnouncementText();
        String milestoneName = "NewMilestone";
        String reference = "Refer";
        String description = "Descrip";
        String startDate = "6/17/2024";
        String endDate = "6/17/2025";
        String expectedMessage = "Successfully added the new milestone.";
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
        projectsAddedPage.isOpen();
        projectsAddedPage.clickDashboardTab();
        dashboardPage.isOpen();
        dashboardPage.clickNameProject(projectName);
        overviewProjectPage.isOpen();
        overviewProjectPage.clickAddMilestoneButton();
        addMilestonePage.isOpen();
        Milestone testMilestone = Milestone.builder()
                .setName(milestoneName)
                .setReferences(reference)
                .setDescription(description)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setMilestoneCompleted(true)
                .build();
        addMilestonePage.addMilestone(testMilestone);
        milestonesPage.isOpen();
        Assert.assertEquals(milestonesPage.getExpectedSuccessfulMessageMilestone(), expectedMessage);
        milestonesPage.clickNameMilestone(milestoneName);
        milestoneDetailsPage.isOpen();
        Assert.assertTrue(milestoneDetailsPage.isStartMilestoneButtonPresent());
        Milestone actualMilestone = milestoneDetailsPage.getMilestoneInfo();
        Assert.assertEquals(actualMilestone, testMilestone);
    }
}
