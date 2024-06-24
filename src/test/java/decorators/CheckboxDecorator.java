package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
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
            log.info("Element {} is not selected. Clicking the element.", this.element.getText());
            element.click();
        }
    }

    public void uncheck()
    {
        if (element.isSelected()) {
            log.info("Element {} is selected. Clicking the element to uncheck.", this.element.getText());
            element.click();
        }
    }

    public boolean isChecked()
    {
        return element.isSelected();
    }
}
