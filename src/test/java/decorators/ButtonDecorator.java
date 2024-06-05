package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonDecorator extends ElementDecorator {
    public ButtonDecorator(WebDriver driver, By locator)
    {
        super(driver, locator);
    }

    public ButtonDecorator(WebDriver driver, String dataTestId)
    {
        super(driver, dataTestId);
    }

    public ButtonDecorator(WebDriver driver, WebElement element)
    {
        super(driver, element);
    }
}
