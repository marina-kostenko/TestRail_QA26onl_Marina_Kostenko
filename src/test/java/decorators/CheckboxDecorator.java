package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxDecorator extends ElementDecorator {
    public CheckboxDecorator(WebDriver driver, By locator)
    {
        super(driver, locator);
    }

    public CheckboxDecorator(WebDriver driver, String dataTestId)
    {
        super(driver, dataTestId);
    }

    public CheckboxDecorator(WebDriver driver, WebElement element)
    {
        super(driver, element);
    }

    public void check()
    {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheck()
    {
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isChecked()
    {
        return element.isSelected();
    }
}
