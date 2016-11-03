package page_steps.page_model;

import html_elements.ResultTable;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import web_driver_bindings.WebDriverBindings;



public class SearchResultPage {
    
    
    private WebDriverBindings driverBindings = new WebDriverBindings();
    
    public WebElement getSearchTextInput() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.id("ptxt"));
    }
    
    public WebElement getSearchButton() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.cssSelector("input.btn"));
    }
    
    public WebElement getCitySelect() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.cssSelector("select.filter_sel.w140"));
    }
    
    public WebElement getModeSelect() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.cssSelector("select.filter_sel.w95"));
    }
    
    
    public WebElement getExtendedSearchLink() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.className("a9a"));
    }
    
    public WebElement getTransactionTypeElement() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.cssSelector("select[class$='filter_sel"));
        
    }
    
    public SearchResultTable getSearchResults() throws TimeoutException {
        SearchResultTable table = new SearchResultTable();
        table.initializeTable();
        return table;
    }
    
    public WebElement getAddToBookMarksLink() throws TimeoutException {
        return driverBindings.waitForElementVisibility(By.id("a_fav_sel"));
    }
    
    
    public class SearchResultTable extends ResultTable {
    
        SearchResultTable() {
            super("table#page_main >tbody table:nth-of-type(2)>tbody");
        }
    
        public WebElement getPriceColumn() throws TimeoutException {
            return getTable().findElement(By.cssSelector("tr#head_line > td.msg_column_td"));
        }
        
        
    }
    
 }
