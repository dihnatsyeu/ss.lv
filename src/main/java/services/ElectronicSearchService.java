package services;

import exceptions.ElementNotFoundException;
import language_pack.LanguageElement;
import org.openqa.selenium.TimeoutException;
import page_steps.ElectronicSearchSteps;

/**
 * Represents available actions on Electronice Search Page
 */
public class ElectronicSearchService {
    
    
    private ElectronicSearchSteps searchSteps = new ElectronicSearchSteps();
    
    /**
     * Searches for any electronic add according to given criteria.
     * @param text Free-text to search
     * @param minPrice Min Price
     * @param maxPrice Max Price
     * @param headingSearch Refer to {@link language_pack.SubHeadingSearch} for acceptable values
     * @param city Refer to {@link language_pack.City} for acceptable values
     * @param searchPeriod Refer to {@link language_pack.SearchPeriod} for acceptable values
     * @param sorting Refer to {@link language_pack.Sorting} for acceptable values
     */
    public void searchForElectronics(String text, Integer minPrice, Integer maxPrice, LanguageElement headingSearch,
                                     LanguageElement city, LanguageElement searchPeriod, LanguageElement sorting) {
    
        try {
            if (text != null) {
                searchSteps.fillTextSearch(text);
            }
            if (minPrice != null) {
                searchSteps.fillMinPrice(Integer.toString(minPrice));
            }
            if (maxPrice != null) {
                searchSteps.fillMaxPrice(Integer.toString(maxPrice));
            }
            if (headingSearch != null) {
                searchSteps.selectSubHeadingElement(RunContext.getTextOnLanguage(headingSearch));
            }
            if (city != null) {
                searchSteps.selectSearchRegionElement(RunContext.getTextOnLanguage(city));
            }
            if (searchPeriod != null) {
                searchSteps.selectPeriodElement(RunContext.getTextOnLanguage(searchPeriod));
            }
            if (sorting != null) {
                searchSteps.selectSortingElement(RunContext.getTextOnLanguage(sorting));
            }
            searchSteps.clickSearchButton();
            } catch (TimeoutException | ElementNotFoundException e) {
                throw new RuntimeException("Unknown language is set!");
    
        }
    }
}
