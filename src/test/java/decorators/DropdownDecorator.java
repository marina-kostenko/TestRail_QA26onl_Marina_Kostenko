package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class DropdownDecorator extends ElementDecorator {

    private final By expandButton = By.cssSelector("[data-testid='historyCompareToButton']");
    private final By searchInput = By.cssSelector("input[type='text']");
    private final By options = By.cssSelector("ul[class='chzn-results'] li");

    public DropdownDecorator(WebDriver driver, By locator)
    {
        super(driver, locator);
    }

    public DropdownDecorator(WebDriver driver, String dataTestId)
    {
        super(driver, dataTestId);
    }

    public DropdownDecorator(WebDriver driver, WebElement element)
    {
        super(driver, element);
    }

    public String getSelectedOption()
    {
        return this.element.findElement(expandButton).getText();
    }

    public void selectByVisibleText(String textOption)
    {
        expand();
        WebElement targetOption = this.getOptionByText(textOption);
        try {
            targetOption.click();
        } catch (ElementNotInteractableException exception) {
            log.debug("Setting selected option to {}", textOption);
            setSearchValue(textOption);
            targetOption.click();
        }
    }

    public List<String> getAllOptionsText()
    {
        return this.getAllOptions().stream().map(WebElement::getText).toList();
    }

    private void setSearchValue(String textOption)
    {
        this.element.findElement(searchInput).sendKeys(textOption);
    }

    private void expand()
    {
        this.element.findElement(expandButton).click();
    }

    private WebElement getOptionByText(String textOption)
    {
        return this.getAllOptions().stream().filter(option -> option.getText().equals(textOption)).findFirst().orElse(null);
    }

    private List<WebElement> getAllOptions()
    {
        return this.element.findElements(options);
    }
}
