package page_steps.page_model;

import html_elements.ResultTable;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import web_driver_bindings.WebDriverBindings;

import java.util.ArrayList;
import java.util.List;


public class BookMarksPage {
    
    public BookmarkedAd getSearchResults() throws TimeoutException {
        BookmarkedAd table = new BookmarkedAd();
        table.initializeTables();
        return table;
    }
    
    
    public class BookmarkedAd {
        
        WebDriverBindings driverBindings = new WebDriverBindings();
        private List<ResultTable> adTables = new ArrayList<>();
    
    
        private void initializeTables() {
            List<WebElement> webTables = driverBindings.waitForElementsVisibility(By.cssSelector("form[name='filter_frm'] > table"));
            for (int i = 1; i <= webTables.size(); i++) {
                ResultTable resultTable = new ResultTable("form[name='filter_frm'] > table:nth-of-type(" + i + ") > tbody");
                resultTable.initializeTable();
                adTables.add(resultTable);
            }
        }
        
        public List<ResultTable.ResultRow> getSearchResults() {
            List<ResultTable.ResultRow> resultRows = new ArrayList<>();
            for (ResultTable table : adTables) {
                resultRows.addAll(table.getSearchResults());
            }
            return resultRows;
            
        }
    
    }
}
