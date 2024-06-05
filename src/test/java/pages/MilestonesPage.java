package pages;

import decorators.ButtonDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilestonesPage extends BasePage {
    public MilestonesPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Click the button 'Add Milestone'")
    public void clickAddMilestoneButton()
    {
        new ButtonDecorator(driver, "navigationMilestonesAdd").click();
    }

    @Step("Get Expected Successful Message")
    public String getExpectedSuccessfulMessageMilestone()
    {
        return driver.findElement(By.cssSelector("[data-testid='messageSuccessDivBox']")).getText();
    }
}
