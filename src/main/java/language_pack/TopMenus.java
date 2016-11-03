package language_pack;

public class TopMenus extends LanguageElement {
    
    public static final TopMenus SEARCH = new TopMenus("Поиск", "Meklēšana");
    public static final TopMenus BOOKMARKS = new TopMenus("Закладки", "Memo");
    
    private TopMenus(String ruName, String lvName) {
        super(ruName, lvName);
    }
}
