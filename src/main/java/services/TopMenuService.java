package services;

import language_pack.Language;
import language_pack.TopMenus;
import page_steps.TopMenuSteps;

import java.util.concurrent.TimeoutException;

/**
 * Represents available actions within ss.lv Top Menu
 */
public class TopMenuService {
    
    private TopMenuSteps pageSteps = new TopMenuSteps();
    
    /**
     * Gets current language that is set in the system.
     * @return {@link Language} that is currently set on site.
     */
    Language getCurrentPageLanguage() {
        try {
            return Language.getOpposite(pageSteps.getLanguageSwitchOption());
        } catch (TimeoutException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    /**
     * Switches language on page to desired one if doesn't set already.
     * @param language {@link Language} to switch to
     * @return Current language selected on page.
     */
    public Language switchLanguageTo(Language language) {
        if (getCurrentPageLanguage() != language) {
            try {
                pageSteps.switchLanguage();
            } catch (TimeoutException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return getCurrentPageLanguage();
        
    }
    
    /**
     * Open provided menu on from Header
     * @throws RuntimeException when passed menu doesn't exists
     * @param menu {@link TopMenus} element
     */
    public void openMenu(TopMenus menu) {
        String menuName;
        menuName = RunContext.getTextOnLanguage(menu);
        try {
            pageSteps.openMenu(menuName);
        } catch (TimeoutException e) {
            throw  new RuntimeException(e.getMessage());
        }
    
    
    }
}
