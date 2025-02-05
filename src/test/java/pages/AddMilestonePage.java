package pages;

import decorators.ButtonDecorator;
import decorators.CheckboxDecorator;
import decorators.InputDecorator;
import decorators.TextAreaDecorator;
import io.qameta.allure.Step;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddMilestonePage extends BasePage {
    private final static By CANCEL_MILESTONE_BUTTON = By.cssSelector("[data-testid='milestoneButtonCancel']");
    private final String milestoneNameInput = "addEditMilestoneName";
    private final String milestoneReferenceInput = "addEditMilestoneReference";
    private final String sectionDescriptionTextArea = "editSectionDescription";
    private final String startDateInput = "addEditMilestoneStartOn";
    private final String endDateInput = "addEditMilestoneDueOn";
    private final String thisMilestoneIsCompletedCheckbox = "addEditMilestoneIsCompleted";
    private final String addMilestoneButton = "milestoneButtonOk";

    public AddMilestonePage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(CANCEL_MILESTONE_BUTTON));
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

    public void addMilestone(Milestone milestone)
    {
        new InputDecorator(driver, this.milestoneNameInput).setValue(milestone.getName());
        new InputDecorator(driver, this.milestoneReferenceInput).setValue(milestone.getReferences());
        new TextAreaDecorator(driver, this.sectionDescriptionTextArea).setValue(milestone.getDescription());
        new InputDecorator(driver, this.startDateInput).setValue(milestone.getStartDate());
        new InputDecorator(driver, this.endDateInput).setValue(milestone.getEndDate());
        if (milestone.isMilestoneCompleted()) {
            checkCheckboxThisMilestoneIsCompleted();
        }
        clickAddMilestoneButton();
    }
}

