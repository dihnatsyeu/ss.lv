package page_steps;

import model.Ad;
import org.openqa.selenium.TimeoutException;
import page_steps.page_model.BookMarksPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Low-level class that encapsulates actions (i.e. interacts with page's web elements)
 * on BookMark page
 */
public class BookMarksPageSteps {
    
    BookMarksPage page = new BookMarksPage();
    
    public List<Ad> getBookMarkedAds() throws TimeoutException {
        List<Ad> bookmarkedAds = new ArrayList<>();
        page.getSearchResults().getSearchResults().forEach(searchRow -> bookmarkedAds.add(
                new Ad(searchRow.getText().getText())));
        return bookmarkedAds;
       
    }
}
