package services;

import exceptions.LanguageDefinedException;
import language_pack.Language;
import language_pack.LanguageElement;
import language_pack.SiteNameSpace;

/**
 * This class is used to access common values across all site(ss.lv)
 */
class RunContext {
    
    private static Language getCurrentLanguage() {
        TopMenuService service = new TopMenuService();
        return service.getCurrentPageLanguage();
    }
    
    /**
     * Helps to get actual representation of textual information based
     * on currently set language
     * @param languageElement that should be translated.
     * @return String representation of languageElement based on the current
     * language set
     */
    static String getTextOnLanguage(LanguageElement languageElement) {
        Language currentLanguage = getCurrentLanguage();
    
        try {
            return SiteNameSpace.getElementName(languageElement, currentLanguage);
        } catch (LanguageDefinedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
