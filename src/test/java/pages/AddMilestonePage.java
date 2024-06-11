package pages;

import decorators.ButtonDecorator;
import decorators.CheckboxDecorator;
import decorators.InputDecorator;
import decorators.TextAreaDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddMilestonePage extends BasePage {
    private final String milestoneNameInput = "addEditMilestoneName";
    private final String milestoneReferenceInput = "addEditMilestoneReference";
    private final String sectionDescriptionTextArea = "editSectionDescription";
    private final String thisMilestoneIsCompletedCheckbox = "addEditMilestoneIsCompleted";
    private final String addMilestoneButton = "milestoneButtonOk";

    public AddMilestonePage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Set Milestone Name = '{milestoneName}'")
    public void setMilestoneName(String milestoneName)
    {
        new InputDecorator(driver, this.milestoneNameInput).sendKeys(milestoneName);
    }

    @Step("Set Reference = '{reference}'")
    public void setReference(String reference)
    {
        new InputDecorator(driver, this.milestoneReferenceInput).sendKeys(reference);
    }

    @Step("Set Description Text = '{description}'")
    public void setDescriptionText(String description)
    {
        new TextAreaDecorator(driver, this.sectionDescriptionTextArea).sendKeys(description);
    }

    @Step("Check Checkbox This Milestone Is Completed")
    public void checkCheckboxThisMilestoneIsCompleted()
    {
        new CheckboxDecorator(driver, this.thisMilestoneIsCompletedCheckbox).check();
    }

    @Step("Click the button 'Add Milestone'")
    public void clickAddMilestoneButton()
    {
        new ButtonDecorator(driver, this.addMilestoneButton).click();
    }
}

