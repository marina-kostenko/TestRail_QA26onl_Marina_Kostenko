package pages;

import decorators.ButtonDecorator;
import decorators.InputDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TestSuitesAndCasesPage extends BasePage {
    private final static String BASELINE_NAME = "//a[text()='%s']";
    private final static By ADD_BASELINE_BUTTON = By.id("navigation-suites-addbaseline");
    private final static By BASELINE_NAME_INPUT = By.id("addBaselineName");
    private final static By BASELINE_PARENT = By.id("addBaselineParent");
    private final static By BASELINE_SUBMIT_BUTTON = By.id("addBaselineSubmit");
    private final static By TESTCASE_ADD_BUTTON = By.cssSelector("[data-testid='sidebarCasesAdd']");

    public TestSuitesAndCasesPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(TESTCASE_ADD_BUTTON));
    }

    @Step("Click the button 'Add Baseline'")
    public void clickAddBaselineButton()
    {
        new ButtonDecorator(driver, ADD_BASELINE_BUTTON).click();
    }

    @Step("Set Baseline Name = '{baselineName}'")
    public void setBaselineName(String baselineName)
    {
        new InputDecorator(driver, BASELINE_NAME_INPUT).sendKeys(baselineName);
    }

    @Step("Select Baseline Parent = '{baselineParentName}'")
    public void selectBaselineParent(String baselineParentName)
    {
        Select select = new Select(driver.findElement(BASELINE_PARENT));
        select.selectByVisibleText(baselineParentName);
    }

    @Step("Click the submit-button 'Add Baseline'")
    public void clickAddBaselineSubmitButton()
    {
        new ButtonDecorator(driver, BASELINE_SUBMIT_BUTTON).click();
    }

    @Step("Click the name of '{baselineName}'")
    public void clickBaselineName(String baselineName)
    {
        driver.findElement(By.xpath(String.format(BASELINE_NAME, baselineName))).click();
    }

    @Step("Click the button 'Add Cases'")
    public void clickAddCasesButton()
    {
        new ButtonDecorator(driver, TESTCASE_ADD_BUTTON).click();
    }
}
