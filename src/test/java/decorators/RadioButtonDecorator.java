package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonDecorator extends ElementDecorator {
    public RadioButtonDecorator(WebDriver driver, By locator)
    {
        super(driver, locator);
    }

    public RadioButtonDecorator(WebDriver driver, String dataTestId)
    {
        super(driver, dataTestId);
    }

    public RadioButtonDecorator(WebDriver driver, WebElement element)
    {
        super(driver, element);
    }

    public void select()
    {
        if (!element.isSelected()) {
            element.click();
        }
    }
}
