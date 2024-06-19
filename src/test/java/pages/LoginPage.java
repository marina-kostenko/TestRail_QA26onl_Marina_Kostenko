package pages;

import decorators.ButtonDecorator;
import decorators.InputDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
    }

    @Step("Login with email = '{email}' and password = '{password}'")
    public void login(String email, String password)
    {
        new InputDecorator(driver, "loginIdName").sendKeys(email);
        new InputDecorator(driver, "loginPasswordFormDialog").sendKeys(password);
        new ButtonDecorator(driver, "loginButtonPrimary").click();
    }
}
