package page_steps.page_model;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import web_driver_bindings.WebDriverBindings;

import java.util.List;


public class ElectronicSearchPanel implements NavigationPage {
    
    private final String URL = "https://www.ss.lv/ru/electronics/search/";
    
    private WebDriverBindings driverBindings = new WebDriverBindings();
    
    public WebElement getTextField() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.id("ptxt"));
        
    }
    
    public List<WebElement> getPreloadTexts() throws TimeoutException {
        return driverBindings.waitForNestedElementsVisibility(By.id("preload_txt"), By.cssSelector("div[id^=cmp_]"), 2);
    }
    
    public WebElement getMinPrice() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.name("topt[8][min]"));
    }
    
    public WebElement getMaxPrice() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.name("topt[8][max]"));
    }
    
    public WebElement getSubHeadingElement() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.name("sid"));
    }
    
    public WebElement getSearchRegionElement() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.id("s_region_select"));
    }
    
    public WebElement getPeriodElement() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.name("pr"));
    }
    
    public WebElement getSortElement() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.name("sort"));
    }
    
    public WebElement getSearchButton() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.id("sbtn"));
    }
    
    @Override
    public String getURL() {
        return URL;
    }
}
