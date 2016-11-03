package language_pack;

public class City extends LanguageElement {
    
    public static final City ALL = new City("Все объявления", "Visi sludinājumi");
    public static final City RIGA = new City("Рига", "Rīga");
    public static final City URMALA = new City("Юрмала", "Jūrmala");
    
    private City(String ruName, String lvName) {
        super(ruName, lvName);
    }
}
