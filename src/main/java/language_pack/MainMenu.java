package language_pack;

public class MainMenu extends LanguageElement {
    
    public static final MainMenu WORKANDBUSINESS = new MainMenu("Работа и бизнес", "Darbs un bizness");
    public static final MainMenu ELECTRICAL = new MainMenu("Электротехника", "Elektrotehnika");
    public static final MainMenu TRANSPORT = new MainMenu("Транспорт", "Nekustamie īpašumi");
    public static final MainMenu PROPERTY = new MainMenu("Недвижимость", "Celtniecība");
    
    private MainMenu(String ruName, String lvName) {
        super(ruName, lvName);
        
    }
    
    
}
