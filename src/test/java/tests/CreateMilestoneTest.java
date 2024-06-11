package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateMilestoneTest extends BaseTest {
    @Test(groups = {"need account"}, description = "positive Create Milestone Test")
    @Description("this test checks successful creation of milestone")
    public void positiveCreateMilestoneTest()
    {
        String projectName = "NewProject1";
        String announcementText = "AnnouncementArea testing";
        String milestoneName = "NewMilestone";
        String reference = "Reference";
        String description = "Description";
        String expectedMessage = "Successfully added the new milestone.";
        dashboardPage.clickAddProjectButton();
        addProjectPage.addProject(projectName, announcementText);
        administrationPage.clickDashboardTab();
        administrationPage.clickNameProject(projectName);
        overviewPage.clickAddMilestoneButton();
        addMilestonePage.setMilestoneName(milestoneName);
        addMilestonePage.setReference(reference);
        addMilestonePage.setDescriptionText(description);
        addMilestonePage.checkCheckboxThisMilestoneIsCompleted();
        addMilestonePage.clickAddMilestoneButton();
        Assert.assertEquals(milestonesPage.getExpectedSuccessfulMessageMilestone(), expectedMessage);
    }
}
