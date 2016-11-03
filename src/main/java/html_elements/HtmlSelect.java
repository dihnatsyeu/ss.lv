package html_elements;

import exceptions.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import web_driver_bindings.WebDriverBindings;

import java.util.List;


public class HtmlSelect {
    
    private WebElement selector;
    private WebDriverBindings driverBindings = new WebDriverBindings();
    
    public HtmlSelect(WebElement element) {
        this.selector = element;
    }
    
    
    public void selectOptionByText(String text) throws ElementNotFoundException {
        selector.click();
        List<WebElement> options;
        try {
            options = driverBindings.waitForNestedElementsVisibility(selector, By.tagName("option"), 5);
        } catch (TimeoutException e) {
            throw new ElementNotFoundException("Options elements are not visible!");
        }
        WebElement foundedOption = null;
        for (WebElement element: options) {
            if (element.getText().equalsIgnoreCase(text)) {
                foundedOption = element;
            }
        }
        
        if (foundedOption == null) {
            throw new ElementNotFoundException("There is no option with text: " + text);
        }
        foundedOption.click();
    }
}
