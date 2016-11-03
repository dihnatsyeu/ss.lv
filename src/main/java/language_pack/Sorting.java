package language_pack;

public class Sorting extends LanguageElement {
    
    public static final Sorting PRICE = new Sorting("Цена", "Cena");
    public static final Sorting NOSORTING = new Sorting("", "");
    
    private Sorting(String ruName, String lvName) {
        super(ruName, lvName);
    }
}
