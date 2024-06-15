package tests;

import io.qameta.allure.Description;
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
        dashboardPage.isOpen();
        dashboardPage.clickAddProjectButton();
        addProjectPage.isOpen();
        addProjectPage.setNameProjectInput(projectName);
        addProjectPage.setTextInAnnouncementArea(announcementText);
        addProjectPage.checkCheckboxShowTheAnnouncement();
        Assert.assertTrue(addProjectPage.isCheckboxShowTheAnnouncementChecked(), "Checkbox 'Show The Announcement' is unchecked");
        addProjectPage.unCheckCheckboxShowTheAnnouncement();
        Assert.assertFalse(addProjectPage.isCheckboxShowTheAnnouncementChecked(), "Checkbox 'Show The Announcement' is checked");
        addProjectPage.selectRadioButtonUseASingleRepositoryWithBaseLineSupport();
        Assert.assertTrue(addProjectPage.isRadioButtonUseASingleRepositoryWithBaseLineSupportSelected(), "RadioButton 'Use A Single Repository With BaseLine Support' is not selected");
        addProjectPage.checkCheckboxEnableTestCaseApprovals();
        addProjectPage.clickButtonAddProject();
        administrationPage.isOpen();
        Assert.assertTrue(administrationPage.isSidebarOverviewPresent(), "Sidebar 'Overview' is not present");
    }
}
