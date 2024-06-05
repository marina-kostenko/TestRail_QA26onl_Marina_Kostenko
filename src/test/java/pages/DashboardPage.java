package pages;

import decorators.ButtonDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final static By ADD_PROJECT_SIDEBAR_BUTTON = By.id("sidebar-projects-add");

    public DashboardPage(WebDriver driver)
    {
        super(driver);
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
}
