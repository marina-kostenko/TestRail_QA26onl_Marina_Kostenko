package pages;

import decorators.ButtonDecorator;
import decorators.ElementDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    private final static By ADD_PROJECT_SIDEBAR_BUTTON = By.id("sidebar-projects-add");
    private final static String PROJECT_NAME = "//div[@id='content_container']/descendant::a[text()='%s']";

    public DashboardPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_PROJECT_SIDEBAR_BUTTON));
    }

    public boolean isAddProjectSidebarButtonPresent()
    {
        return new ButtonDecorator(driver, ADD_PROJECT_SIDEBAR_BUTTON).isDisplayed();
    }

    public By getLocator()
    {
        return new ButtonDecorator(driver, ADD_PROJECT_SIDEBAR_BUTTON).getLocator();
    }

    @Step("Click the button 'Add Project'")
    public void clickAddProjectButton()
    {
        new ButtonDecorator(driver, ADD_PROJECT_SIDEBAR_BUTTON).click();
    }


    @Step("Click the name of  '{projectName}'")
    public void clickNameProject(String projectName)
    {
        new ElementDecorator(driver, By.xpath(String.format(PROJECT_NAME, projectName))).click();
    }
}
