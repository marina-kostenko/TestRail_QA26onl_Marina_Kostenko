package tests;

import io.qameta.allure.Description;
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
        String reference = "Reference";
        String description = "Description";
        String expectedMessage = "Successfully added the new milestone.";
        dashboardPage.isOpen();
        dashboardPage.clickAddProjectButton();
        addProjectPage.isOpen();
        addProjectPage.addProject(projectName, announcementText);
        administrationPage.isOpen();
        administrationPage.clickDashboardTab();
        administrationPage.clickNameProject(projectName);
        overviewPage.clickAddMilestoneButton();
        addMilestonePage.isOpen();
        addMilestonePage.setMilestoneName(milestoneName);
        addMilestonePage.setReference(reference);
        addMilestonePage.setDescriptionText(description);
        addMilestonePage.checkCheckboxThisMilestoneIsCompleted();
        addMilestonePage.clickAddMilestoneButton();
        milestonesPage.isOpen();
        Assert.assertEquals(milestonesPage.getExpectedSuccessfulMessageMilestone(), expectedMessage);
    }
}
