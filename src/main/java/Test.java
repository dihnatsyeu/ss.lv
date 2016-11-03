import language_pack.*;
import model.Ad;
import org.junit.Assert;
import web_driver_bindings.GlobalController;

import java.util.List;

public class Test {
    
    
    public static void main(String[] args) {
        try {
            //Open the browser and maximize it.
            //Open  ss.lv
            TestSteps.goToHomePage();
            //switch to Russian language.
            TestSteps.switchLanguage(Language.RU);
            //Go to the section “Электротехника”
            TestSteps.openHomePageMenu(MainMenu.ELECTRICAL);
            //open search ('Поиск')
            TestSteps.openTopMenu(TopMenus.SEARCH);
            
            //in Search enter the search phrase (eg. 'Computer') and select a different search parameters.
            //Click Search
            TestSteps.searchForElectronics("Компьютер", 1, 500, SubHeadingSearch.SELLING,
                    City.ALL, SearchPeriod.ALL, Sorting.PRICE);
            //Sort the results by price
            TestSteps.sortByPrice();
            //select option 'Продажа' in "Тип сделки" dropdown.
            TestSteps.searchOnSearchResults(null, null, null, TransactionType.SELL);
            // Open “Расширенный поиск”. (advanced search)
            TestSteps.goToExtendedSearch();
            //Enter search option price between 160 and 300.
            TestSteps.searchForElectronics(null, 160, 300, null, null, null, null);
            //Choose at least 3 random ads.
            
            int adsToBookMarks = 3;
            // Press “Добавить выбранные в закладки”
            List<Ad> selectedAds = TestSteps.addToBookMarks(adsToBookMarks);
            Assert.assertTrue(selectedAds.size() == adsToBookMarks);
            //Open “Закладки”
            TestSteps.openTopMenu(TopMenus.BOOKMARKS);
            TestSteps.adsMatchToBookmarked(selectedAds);
            Boolean bookmarkedMatchToSelected = TestSteps.adsMatchToBookmarked(selectedAds);
            Assert.assertTrue(bookmarkedMatchToSelected);
           
        } finally {
            //Close the browser
                GlobalController.closeBrowser();
        }
    }
}
