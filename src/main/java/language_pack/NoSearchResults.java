package language_pack;

public class NoSearchResults extends LanguageElement {
    
    public static final NoSearchResults NORESULTS = new NoSearchResults("По вашему запросу объявлений не найдено",
            "Pēc Jūsu pieprasījuma netika atrasts neviens sludinājums");
    
    private NoSearchResults(String ruName, String lvName) {
        super(ruName, lvName);
    }
}
