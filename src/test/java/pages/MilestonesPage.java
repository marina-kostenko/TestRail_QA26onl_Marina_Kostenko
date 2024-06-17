package pages;

import decorators.ButtonDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MilestonesPage extends BasePage {
    private final static By MESSAGE_TEXT = By.cssSelector("[data-testid='messageSuccessDivBox']");
    private final static By ADD_MILESTONE_BUTTON = By.cssSelector("[data-testid='navigationMilestonesAdd']");

    public MilestonesPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_MILESTONE_BUTTON));
    }

    @Step("Click the button 'Add Milestone'")
    public void clickAddMilestoneButton()
    {
        new ButtonDecorator(driver, ADD_MILESTONE_BUTTON).click();
    }

    @Step("Get Expected Successful Message")
    public String getExpectedSuccessfulMessageMilestone()
    {
        return driver.findElement(MESSAGE_TEXT).getText();
    }
}
