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

    @Step("Login with email = '{email}' and password = '{password}'")
    public void login(String email, String password)
    {
        InputDecorator loginInput = new InputDecorator(driver, "loginIdName");
        InputDecorator passwordInput = new InputDecorator(driver, "loginPasswordFormDialog");
        ButtonDecorator logInButton = new ButtonDecorator(driver, "loginButtonPrimary");
        loginInput.sendKeys(email);
        passwordInput.sendKeys(password);
        logInButton.click();
    }
}
