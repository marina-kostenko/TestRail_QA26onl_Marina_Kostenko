package tests;


import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(description = "positive LogIn Test")
    @Description("this test checks successful login on www.testrail.com")
    public void positiveLogInTest()
    {
        loginPage.login("89marisha@gmail.com", "7Qwertyuiop!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardPage.getLocator()));
        Assert.assertTrue(dashboardPage.isAddProjectSidebarButtonPresent());
    }
}
