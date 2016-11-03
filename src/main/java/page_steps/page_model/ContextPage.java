package page_steps.page_model;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web_driver_bindings.WebDriverBindings;

import java.util.concurrent.TimeoutException;

/**
 * Base class for pages that have menu items
 */
public abstract class ContextPage {
    
    protected WebDriverBindings driverBindings = new WebDriverBindings();
    
    
    public WebElement getMenuByName(String menu) throws TimeoutException {
        return driverBindings.waitForElementPresence(By.linkText(menu));
    }
}
