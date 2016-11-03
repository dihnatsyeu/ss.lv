package page_steps;

import page_steps.page_model.HomePage;
import page_steps.page_model.Pages;
import web_driver_bindings.Navigator;

import java.util.concurrent.TimeoutException;


/**
 * Low-level class that encapsulates actions (i.e. interacts with page's web elements)
 * on Home page
 */
public class HomePageSteps {
    
    
    private Navigator navigator = new Navigator();
    private HomePage homePage =Pages.getHomePage();
    
    public void navigateToPage() {
        navigator.navigateTo(homePage.getURL());
    }
    
    public void openMenu(String menuName) throws TimeoutException {
        homePage.getMenuByName(menuName).click();
    }
}
