package pages;

import decorators.ButtonDecorator;
import decorators.InputDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    private final static By LOG_IN_BUTTON = By.cssSelector("[data-testid='loginButtonPrimary']");

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(LOG_IN_BUTTON));
    }

    @Step("Login with email = '{email}' and password = '{password}'")
    public void login(String email, String password)
    {
        new InputDecorator(driver, "loginIdName").sendKeys(email);
        new InputDecorator(driver, "loginPasswordFormDialog").sendKeys(password);
        new ButtonDecorator(driver, LOG_IN_BUTTON).click();
    }
}
