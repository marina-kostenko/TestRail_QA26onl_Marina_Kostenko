package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextAreaDecorator extends ElementDecorator {
    public TextAreaDecorator(WebDriver driver, By locator)
    {
        super(driver, locator);
    }

    public TextAreaDecorator(WebDriver driver, String dataTestId)
    {
        super(driver, dataTestId);
    }

    public TextAreaDecorator(WebDriver driver, WebElement element)
    {
        super(driver, element);
    }

    @Override
    public void sendKeys(CharSequence... keysToSend)
    {
        scrollIntoView();
        element.sendKeys(keysToSend);
    }

    public void clearValue()
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(this.element, Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }
}
