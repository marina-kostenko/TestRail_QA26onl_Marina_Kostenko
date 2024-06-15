package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestAddedPage extends BasePage {
    private final static By MESSAGE_TEXT = By.cssSelector("[data-testid='messageSuccessDivBox']");
    private final static By EDIT_BUTTON = By.className("button-text");

    public TestAddedPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isOpen()
    {
        wait.until(ExpectedConditions.elementToBeClickable(EDIT_BUTTON));
    }

    @Step("Get Expected Successful Message")
    public String getExpectedSuccessfulMessage()
    {
        return driver.findElement(MESSAGE_TEXT).getText();
    }
}
