package page_steps;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import web_driver_bindings.WebDriverBindings;


/**
 * Low-level class that encapsulates actions (i.e. interacts with page's web elements)
 * available across all pages
 */
public class GeneralPageSteps {
    
    public static boolean isTextPresent(String text) {
        WebDriverBindings driverBindings = new WebDriverBindings();
        try {
             driverBindings.waitForElementVisibility(By.xpath("//*[contains(text(),'" + text + "')]"), 2);
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
        return true;
    }
    
    
    
}
