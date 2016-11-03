package language_pack;

import exceptions.LanguageDefinedException;

public class SiteNameSpace {
    
    /**
     * Return representation of any element on the site depends on the set language
     * @param element {@link LanguageElement} to get name within the language
     * @param language {@link Language} to define element's name against.
     * @return String name of element based on language
     * @throws LanguageDefinedException is thrown if
     */
    public static String getElementName(LanguageElement element, Language language) throws LanguageDefinedException {
        if (language.equals(Language.LV)) {
            return element.getLvName();
        }
        else if (language.equals(Language.RU)) {
            return element.getRuName();
        }
        else throw new LanguageDefinedException("Unknown language passed: " + element);
    }
}
