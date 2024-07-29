package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
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
            log.info("Element {} is not selected. Clicking the element.", this.element.getText());
            element.click();
        }
    }
}
