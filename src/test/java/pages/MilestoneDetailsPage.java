package pages;

import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MilestoneDetailsPage extends BasePage {

    private final static By START_MILESTONE_BUTTON = By.id("navigation-milestones-start");
    private final static By ACTUAL_NAME_MILESTONE = By.cssSelector("[data-testid='testCaseContentHeaderTitle']");
    private final static By ACTUAL_DESC_MILESTONE = By.xpath("//*[@data-testid='markdown']//following::p");

    public MilestoneDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(START_MILESTONE_BUTTON));
    }

    public boolean isStartMilestoneButtonPresent()
    {
        return driver.findElement(START_MILESTONE_BUTTON).isDisplayed();
    }

    public Milestone getMilestoneInfo()
    {
        Milestone resultMilestone = Milestone.builder()
                .setName(driver.findElement(ACTUAL_NAME_MILESTONE).getText())
                .setDescription(driver.findElement(ACTUAL_DESC_MILESTONE).getText())
                .build();
        return resultMilestone;
    }
}
