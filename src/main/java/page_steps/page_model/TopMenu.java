package page_steps.page_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web_driver_bindings.WebDriverBindings;

import java.util.concurrent.TimeoutException;

public class TopMenu {
    
    
    private WebDriverBindings driverBindings = new WebDriverBindings();
    
    public WebElement getTopMenu(String menuText) throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.linkText(menuText));
    }
    
    public WebElement getLanguageSwitch() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.cssSelector("span.menu_lang > a"));
    }
    
    
}
