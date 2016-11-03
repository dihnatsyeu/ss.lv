import language_pack.Language;
import language_pack.LanguageElement;
import language_pack.MainMenu;
import language_pack.TopMenus;
import model.Ad;
import services.*;

import java.util.List;

public class TestSteps {
    
    private static HomePageService homePageService = new HomePageService();
    private static TopMenuService topMenuService = new TopMenuService();
    private static ElectronicSearchService electronicSearchService = new ElectronicSearchService();
    private static SearchResultsService searchResultsService = new SearchResultsService();
    private static BookMarksService bookMarksService = new BookMarksService();
    
    
    static void goToHomePage() {
        homePageService.navigateToPage();
    }
    
    static void switchLanguage(Language language) {
        topMenuService.switchLanguageTo(language);
    }
    
    static void openTopMenu(TopMenus topMenus) {
        topMenuService.openMenu(topMenus);
    }
    
    static void openHomePageMenu(MainMenu menu) {
        homePageService.openMenu(menu);
    }
    
    static void searchForElectronics(String text, Integer minPrice, Integer maxPrice,
                                     LanguageElement headingSearch,
                                     LanguageElement city, LanguageElement searchPeriod,
                                     LanguageElement sorting) {
        electronicSearchService.searchForElectronics(text, minPrice,
                maxPrice, headingSearch, city, searchPeriod, sorting);
    }
    
    static void searchOnSearchResults(String text, LanguageElement mode,
                                      LanguageElement city, LanguageElement transactionType) {
        searchResultsService.searchAdBy(text, mode, city, transactionType);
    }
    
    static void sortByPrice() {
        searchResultsService.sortResultsByPrice();
    }
    
    static void goToExtendedSearch() {
        searchResultsService.goToExtendedSearch();
    }
    
    static List<Ad> addToBookMarks(int counter) {
        return searchResultsService.adAdToBookMarks(counter);
    }
    
    static boolean adsMatchToBookmarked(List<Ad> selected) {
        List<Ad> OnbookMarkAds = bookMarksService.getBookMarks();
        boolean allMatch = true;
        for (Ad ad : selected) {
            boolean inList = false;
            for (Ad adBook : OnbookMarkAds) {
                if (ad.equals(adBook)) {
                    inList = true;
                }
            }
            allMatch = allMatch && inList;
        }
        return allMatch;
    }
}
