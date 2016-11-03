package web_driver_bindings;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class WebDriverBindings {
    
    private final long timeout = 10;
    private WebDriverWait wait;
    
    
    public WebDriverBindings() {
         wait = new WebDriverWait(WebDriverManager.getWebDriver(), timeout);
    }
    
    public WebElement waitForElementPresence(By by) throws TimeoutException {
        return new PageElement(wait.until(ExpectedConditions.presenceOfElementLocated(by)));
        
    }
    
    
    public List<WebElement> waitForElementsPresence(By by) throws TimeoutException {
        List<WebElement> webElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return PageElement.fromWebElementsToPageElements(webElements);
    }
     
    public WebElement waitForElementVisibility(By by) throws TimeoutException {
        return new PageElement(wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }
    
    public WebElement waitForElementVisibility(By by, int timeout) throws TimeoutException, NoSuchElementException {
        WebDriverWait localWait = new WebDriverWait(WebDriverManager.getWebDriver(), timeout);
        return new PageElement(localWait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }
    
    
    public List<WebElement> waitForElementsVisibility(By locator) throws TimeoutException {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
   
    public List<WebElement> waitForNestedElementsVisibility(By locator, By sub_locator, long timeout) throws TimeoutException {
        WebDriverWait localWait = new WebDriverWait(WebDriverManager.getWebDriver(), timeout);
        return localWait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(locator, sub_locator));
    }
    
    public List<WebElement> waitForNestedElementsVisibility(WebElement element, By by, long timeout) throws TimeoutException {
        WebDriverWait localWait = new WebDriverWait(WebDriverManager.getWebDriver(), timeout);
        return localWait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, by));
    }
    
    
    
    public void closePopUp() {
        WebDriverManager.getWebDriver().switchTo().alert().accept();
    }
     
}
