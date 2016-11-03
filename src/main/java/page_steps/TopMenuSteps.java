package page_steps;

import language_pack.Language;
import org.openqa.selenium.WebElement;
import page_steps.page_model.Pages;
import page_steps.page_model.TopMenu;

import java.util.concurrent.TimeoutException;

/**
 * Low-level class that encapsulates actions (i.e. interacts with page's web elements)
 * within Top Menu
 */
public class TopMenuSteps {
    
    private TopMenu topMenu = Pages.getTopMenu();
    
    private WebElement getLanguageSwitchElement() throws TimeoutException {
        return topMenu.getLanguageSwitch();
    }
    
    public void switchLanguage() throws TimeoutException {
        getLanguageSwitchElement().click();
    }
    
    public Language getLanguageSwitchOption() throws TimeoutException {
        try {
            String textLanguage = getLanguageSwitchElement().getText();
            return Language.valueOf(textLanguage);
        //current exception handling mechanism doesn't suppose of getting system's language any other
        //way than from language menu. Further it's possible to get language from page's sources.
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new AssertionError("Unable to get current language from system", ex);
        }
    }
    
    public void openMenu(String menuName) throws TimeoutException {
        topMenu.getTopMenu(menuName).click();
    }
}
