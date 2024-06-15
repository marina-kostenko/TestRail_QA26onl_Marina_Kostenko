package tests;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(groups = {"smoke"}, description = "positive LogIn Test")
    @Description("this test checks successful login on www.testrail.com")
    public void positiveLogInTest()
    {
        loginPage.login("tmsqa26marina@mailinator.com", "xl#H3R0Vu0");
        dashboardPage.isOpen();
        Assert.assertTrue(dashboardPage.isAddProjectSidebarButtonPresent());
    }
}
