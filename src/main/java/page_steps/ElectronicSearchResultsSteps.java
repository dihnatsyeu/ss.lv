package page_steps;

import exceptions.ElementNotFoundException;
import html_elements.HtmlSelect;
import html_elements.ResultTable;
import model.Ad;
import page_steps.page_model.SearchResultPage;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class ElectronicSearchResultsSteps {
    
    private SearchResultPage resultPage = new SearchResultPage();
    
    
    public void clickOnExtendedSearchLink() throws TimeoutException {
        resultPage.getExtendedSearchLink().click();
    }
    
    
    public void clickOnPriceColumn() throws TimeoutException {
        SearchResultPage.SearchResultTable resultTable = resultPage.getSearchResults();
        resultTable.getPriceColumn().click();
    }
    
    public void clickAddToBookMarkLink() throws TimeoutException {
        resultPage.getAddToBookMarksLink().click();
    }
    
    public void selectTransactionType(String transactionType) throws TimeoutException, ElementNotFoundException {
        HtmlSelect select = new HtmlSelect(resultPage.getTransactionTypeElement());
        select.selectOptionByText(transactionType);
    }
    
    public void selectMode(String mode) throws TimeoutException, ElementNotFoundException {
        HtmlSelect select = new HtmlSelect(resultPage.getModeSelect());
        select.selectOptionByText(mode);
    }
    
    public void clickOnSearchButton() throws TimeoutException {
        resultPage.getSearchButton().click();
        
    }
    
    public void setTextSearch(String text) throws TimeoutException {
        resultPage.getSearchTextInput().sendKeys(text);
    }
    
    public void selectCity(String city) throws TimeoutException, ElementNotFoundException {
        HtmlSelect select = new HtmlSelect(resultPage.getCitySelect());
        select.selectOptionByText(city);
    }
    
    public void selectResultRow(String ad) throws TimeoutException {
        for (ResultTable.ResultRow row:getResultRows()) {
            if (row.getText().getText().equalsIgnoreCase(ad)) {
                row.getSelector().click();
                return;
            }
        }
        throw new RuntimeException("There are no rows with ad: " + ad);
        
    }
    
    private List<ResultTable.ResultRow> getResultRows() throws TimeoutException {
        SearchResultPage.SearchResultTable resultTable = resultPage.getSearchResults();
        return resultTable.getSearchResults();
    }
    
    public List<Ad> getSearchResults() throws TimeoutException {
        return getResultRows().stream().map(
                row -> new Ad(row.getText().getText()))
                .collect(Collectors.toList());
    }
 }
