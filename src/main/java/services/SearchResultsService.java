package services;

import exceptions.ElementNotFoundException;
import language_pack.LanguageElement;
import language_pack.NoSearchResults;
import model.Ad;
import page_steps.ElectronicSearchResultsSteps;
import page_steps.GeneralPageSteps;
import utils.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 * Holds actions that are available from high-level on Search Result page
 */
public class SearchResultsService {
    
    private ElectronicSearchResultsSteps resultsSteps = new ElectronicSearchResultsSteps();
    private Logger logger = Logger.getLogger("SearchResultsService");
    
    /**
     * Allows to sort results by price. Every call to method will change
     * current sorting to opposite.
     */
    public void sortResultsByPrice() {
        boolean noSearchResults = GeneralPageSteps.isTextPresent(RunContext.getTextOnLanguage(NoSearchResults.NORESULTS));
        if (noSearchResults) {
            logger.info("There are no results to the current search criteria! Cannot sort table");
            return;
        }
        try {
            resultsSteps.clickOnPriceColumn();
        } catch (TimeoutException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * Allows to search Ads by search criteria
     * @param text Free-text search
     * @param mode Refer to {@link language_pack.Mode} for acceptable values
     * @param city Refer to {@link language_pack.City} for acceptable values
     * @param transactionType Refer to {@link language_pack.TransactionType} for acceptable values
     */
    public void searchAdBy(String text, LanguageElement mode, LanguageElement city, LanguageElement transactionType) {
        boolean noSearchResults = GeneralPageSteps.isTextPresent(RunContext.getTextOnLanguage(NoSearchResults.NORESULTS));
        if (noSearchResults) {
            logger.info("There are no results to the current search criteria! Cannot search again");
            return;
        }
        try {
            if (text != null) {
                resultsSteps.setTextSearch(text);
            }
            if (mode != null) {
                resultsSteps.selectMode(RunContext.getTextOnLanguage(mode));
            }
            if (city != null) {
                resultsSteps.selectCity(RunContext.getTextOnLanguage(city));
            }
            if (transactionType != null) {
                resultsSteps.selectTransactionType(RunContext.getTextOnLanguage(transactionType));
            }
            resultsSteps.clickOnSearchButton();
        } catch (TimeoutException |ElementNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        
    }
    
    /**
     * Gets list of founded Ads by specified search criteria. If search wasn't performed are there are no found Ads
     * null is returned
     * @return List of founded ads or null if there are no any
     */
    private List<Ad> getSearchResults() {
        boolean noSearchResults = GeneralPageSteps.isTextPresent(RunContext.getTextOnLanguage(NoSearchResults.NORESULTS));
        if (noSearchResults) {
            logger.info("There are no results to the current search criteria! Cannot search again");
            return null;
        }
        try {
            return resultsSteps.getSearchResults();
        } catch (TimeoutException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * Navigates to the Extended Search page
     */
    public void goToExtendedSearch() {
        try {
            resultsSteps.clickOnExtendedSearchLink();
        } catch (TimeoutException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * Adds given number of ads to the Bookmarked ads.
     * Particular ad is selected randomly
     * @param counter number of ads to add
     * @return List of bookmarked ads
     */
    public List<Ad> adAdToBookMarks(int counter) {
        List<Ad> availableAds = getSearchResults();
        if (availableAds == null) {
            throw new RuntimeException("There are no available Ads to add!");
        }
        List<Ad> selectedAds = new ArrayList<>();
        while(counter > 0) {
            int index = Randomizer.randomInteger(0, availableAds.size()-1);
            Ad selectedAd = availableAds.get(index);
            try {
                resultsSteps.selectResultRow(selectedAd.getHeader());
                selectedAds.add(selectedAd);
            } catch (TimeoutException e) {
                throw new RuntimeException(e.getMessage());
            }
            counter--;
        }
        try {
            resultsSteps.clickAddToBookMarkLink();
        } catch (TimeoutException e) {
            throw new RuntimeException(e.getMessage());
        }
        return selectedAds;
    }
}
