package page_steps;

import exceptions.ElementNotFoundException;
import html_elements.HtmlSelect;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import page_steps.page_model.ElectronicSearchPanel;
import page_steps.page_model.Pages;

import java.util.List;
import java.util.logging.Logger;

/**
 * Low-level class that encapsulates actions (i.e. interacts with page's web elements)
 * on Electronic Search page
 */
public class ElectronicSearchSteps {
    
    private ElectronicSearchPanel searchPanel = Pages.getElectronicSearchPanel();
    
    private Logger logger = Logger.getLogger("Electronic search");
    
    public void fillTextSearch(String value) throws TimeoutException {
        try {
            searchPanel.getTextField().sendKeys(value);
            WebElement requiredOption = selectRequiredOption(value);
            if (requiredOption != null) {
                requiredOption.click();
            }
        } catch (TimeoutException e) {
            logger.info("There are no pre-defined options");
        }
    }
    
    private WebElement selectRequiredOption(String value) throws TimeoutException {
        WebElement requiredOption = null;
        try {
            List<WebElement> requiredOptions = searchPanel.getPreloadTexts();
           
            for (WebElement element : requiredOptions) {
                if (element.getText().equalsIgnoreCase(value)) {
                    requiredOption = element;
                }
            }
        } catch (StaleElementReferenceException e) {
            return selectRequiredOption(value);
        }
        return requiredOption;
    }
    
    public void fillMinPrice(String value) throws TimeoutException {
        searchPanel.getMinPrice().sendKeys(value);
    }
    
    public void fillMaxPrice(String value) throws TimeoutException {
        searchPanel.getMaxPrice().sendKeys(value);
    }
    
    public void selectSubHeadingElement(String text) throws TimeoutException, ElementNotFoundException {
        HtmlSelect selectElement = new HtmlSelect(searchPanel.getSubHeadingElement());
        selectElement.selectOptionByText(text);
    }
    
    public void selectSearchRegionElement(String text) throws TimeoutException, ElementNotFoundException {
        HtmlSelect selectElement = new HtmlSelect(searchPanel.getSearchRegionElement());
        selectElement.selectOptionByText(text);
    }
    
    public void selectPeriodElement(String period) throws TimeoutException, ElementNotFoundException {
        HtmlSelect selectElement = new HtmlSelect(searchPanel.getPeriodElement());
        selectElement.selectOptionByText(period);
    }
    
    public void selectSortingElement(String sorting) throws TimeoutException, ElementNotFoundException {
        HtmlSelect selectElement = new HtmlSelect(searchPanel.getSortElement());
        selectElement.selectOptionByText(sorting);
        
    }
    
    public void clickSearchButton() throws TimeoutException {
        searchPanel.getSearchButton().click();
    }
    
   
     
}
