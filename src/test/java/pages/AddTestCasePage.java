package pages;

import decorators.ButtonDecorator;
import decorators.InputDecorator;
import decorators.TextAreaDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BasePage {
    public AddTestCasePage(WebDriver driver)
    {
        super(driver);
    }
    @Step("Set Title = '{title}'")
    public void setTitle(String title)
    {
        new InputDecorator(driver, "addEditCaseTitle").sendKeys(title);
    }
    @Step("Set Preconditions = '{preconditions}'")
    public void setTextPreconditions(String preconditions)
    {
        new TextAreaDecorator(driver, By.cssSelector("[data-attr='custom_preconds']")).sendKeys(preconditions);
    }
    @Step("Set Steps = '{steps}'")
    public void setTextSteps(String steps)
    {
        new TextAreaDecorator(driver, By.cssSelector("[data-attr='custom_steps']")).sendKeys(steps);
    }
    @Step("Set Expected Result = '{expectedResult}'")
    public void setTextExpectedResult(String expectedResult)
    {
        new TextAreaDecorator(driver, By.cssSelector("[data-attr='custom_expected']")).sendKeys(expectedResult);
    }

    @Step("Click the button 'Add Test Case'")
    public void clickAddTestCaseButton()
    {
        new ButtonDecorator(driver, "addTestCaseButton").click();
    }
}
