package pages;

import decorators.ButtonDecorator;
import decorators.InputDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSuitesAndCasesPage extends BasePage {
    private final static String BASELINE_NAME = "//a[text()='%s']";

    public TestSuitesAndCasesPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Click the button 'Add Baseline'")
    public void clickAddBaselineButton()
    {
        new ButtonDecorator(driver, By.id("navigation-suites-addbaseline")).click();
    }

    @Step("Set Baseline Name = '{baselineName}'")
    public void setBaselineName(String baselineName)
    {
        new InputDecorator(driver, By.id("addBaselineName")).sendKeys(baselineName);
    }

    @Step("Select Baseline Parent = '{baselineParentName}'")
    public void selectBaselineParent(String baselineParentName)
    {
        Select select = new Select(driver.findElement(By.id("addBaselineParent")));
        select.selectByVisibleText(baselineParentName);
    }

    @Step("Click the submit-button 'Add Baseline'")
    public void clickAddBaselineSubmitButton()
    {
        new ButtonDecorator(driver, By.id("addBaselineSubmit")).click();
    }

    @Step("Click the name of '{baselineName}'")
    public void clickBaselineName(String baselineName)
    {
        driver.findElement(By.xpath(String.format(BASELINE_NAME, baselineName))).click();
    }

    @Step("Click the button 'Add Cases'")
    public void clickAddCasesButton()
    {
        new ButtonDecorator(driver, "sidebarCasesAdd").click();
    }
}
