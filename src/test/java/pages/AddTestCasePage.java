package pages;

import decorators.ButtonDecorator;
import decorators.InputDecorator;
import decorators.TextAreaDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddTestCasePage extends BasePage {

    private final String caseTitleInput = "addEditCaseTitle";
    private final By CUSTOM_PRECONDS_TEXTAREA = By.cssSelector("[data-attr='custom_preconds']");
    private final By CUSTOM_STEPS_TEXTAREA = By.cssSelector("[data-attr='custom_steps']");
    private final By CUSTOM_EXPECTED_TEXTAREA = By.cssSelector("[data-attr='custom_expected']");
    private final String testCaseButton = "addTestCaseButton";
    private final By CANCEL_TESTCASE_BUTTON = By.cssSelector("[data-testid='addEditCaseCancelButton']");

    public AddTestCasePage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(CANCEL_TESTCASE_BUTTON));
    }

    @Step("Set Title = '{title}'")
    public void setTitle(String title)
    {
        new InputDecorator(driver, this.caseTitleInput).sendKeys(title);
    }

    @Step("Set Preconditions = '{preconditions}'")
    public void setTextPreconditions(String preconditions)
    {
        new TextAreaDecorator(driver, CUSTOM_PRECONDS_TEXTAREA).sendKeys(preconditions);
    }

    @Step("Set Steps = '{steps}'")
    public void setTextSteps(String steps)
    {
        new TextAreaDecorator(driver, CUSTOM_STEPS_TEXTAREA).sendKeys(steps);
    }

    @Step("Set Expected Result = '{expectedResult}'")
    public void setTextExpectedResult(String expectedResult)
    {
        new TextAreaDecorator(driver, CUSTOM_EXPECTED_TEXTAREA).sendKeys(expectedResult);
    }

    @Step("Click the button 'Add Test Case'")
    public void clickAddTestCaseButton()
    {
        new ButtonDecorator(driver, this.testCaseButton).click();
    }
}
