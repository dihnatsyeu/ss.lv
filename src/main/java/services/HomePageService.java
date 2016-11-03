package services;

import language_pack.MainMenu;
import page_steps.HomePageSteps;

import java.util.concurrent.TimeoutException;

public class HomePageService {
    
    private HomePageSteps pageSteps = new HomePageSteps();
    
    /**
     * Navigates to Home page. URL is hidden in {@link HomePageSteps}
     */
    public void navigateToPage() {
        pageSteps.navigateToPage();
    }
    
    /**
     * Open provided menu on Home page
     * @throws RuntimeException when passed menu doesn't exists
     * @param menu {@link MainMenu} element
     */
    public void openMenu(MainMenu menu) {
        String menuName;
        try {
            menuName = RunContext.getTextOnLanguage(menu);
            pageSteps.openMenu(menuName);
        } catch (TimeoutException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        
    }
    
}
