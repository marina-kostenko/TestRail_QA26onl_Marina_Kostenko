package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestAddedPage extends BasePage {
    public TestAddedPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Get Expected Successful Message")
    public String getExpectedSuccessfulMessage()
    {
        return driver.findElement(By.cssSelector("[data-testid='messageSuccessDivBox']")).getText();
    }
}
