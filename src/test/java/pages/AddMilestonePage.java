package pages;

import decorators.ButtonDecorator;
import decorators.CheckboxDecorator;
import decorators.InputDecorator;
import decorators.TextAreaDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddMilestonePage extends BasePage {
    public AddMilestonePage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Set Milestone Name = '{milestoneName}'")
    public void setMilestoneName(String milestoneName)
    {
        new InputDecorator(driver, "addEditMilestoneName").sendKeys(milestoneName);
    }

    @Step("Set Reference = '{reference}'")
    public void setReference(String reference)
    {
        new InputDecorator(driver, "addEditMilestoneReference").sendKeys(reference);
    }

    @Step("Set Description Text = '{description}'")
    public void setDescriptionText(String description)
    {
        new TextAreaDecorator(driver, "editSectionDescription").sendKeys(description);
    }

    @Step("Check Checkbox This Milestone Is Completed")
    public void checkCheckboxThisMilestoneIsCompleted()
    {
        new CheckboxDecorator(driver, "addEditMilestoneIsCompleted").check();
    }

    @Step("Click the button 'Add Milestone'")
    public void clickAddMilestoneButton()
    {
        new ButtonDecorator(driver, "milestoneButtonOk").click();
    }
}

