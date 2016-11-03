package language_pack;

public class SubHeadingSearch extends LanguageElement {
    
    public static final SubHeadingSearch SELLING = new SubHeadingSearch("Продают", "Pārdod");
    public static final SubHeadingSearch BYING = new SubHeadingSearch("Покупают", "Pērk");
    public static final SubHeadingSearch OTHER = new SubHeadingSearch("Разное", "Dažādi");
    
    private SubHeadingSearch(String ruName, String lvName) {
        super(ruName, lvName);
    }
}
