package pages;

import decorators.ButtonDecorator;
import decorators.ElementDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MilestonesPage extends BasePage {
    private final static By MESSAGE_TEXT = By.cssSelector("[data-testid='messageSuccessDivBox']");
    private final static By ADD_MILESTONE_BUTTON = By.cssSelector("[data-testid='navigationMilestonesAdd']");
    private final static String MILESTONE_NAME = "//table[@class='run-grid grid']/descendant::a[text()='%s']";


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

    public void clickNameMilestone(String milestoneName)
    {
        new ElementDecorator(driver, By.xpath(String.format(MILESTONE_NAME, milestoneName))).click();
    }
}
