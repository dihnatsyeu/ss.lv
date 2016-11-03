package services;

import model.Ad;
import page_steps.BookMarksPageSteps;

import java.util.List;

/**
 * Represents available actions on Bookmark page
 */
public class BookMarksService {
    
    private BookMarksPageSteps pageSteps = new BookMarksPageSteps();
    
    /**
     * Gets all ads that are located on Bookmark page
     * @return List of {@link Ad} objects
     */
    public List<Ad> getBookMarks() {
        return pageSteps.getBookMarkedAds();
    }
}
