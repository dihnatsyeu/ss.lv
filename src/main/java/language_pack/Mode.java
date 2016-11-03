package language_pack;

public class Mode extends LanguageElement {
    
    public static final Mode LIST = new Mode("Список", "Saraksts");
    public static final Mode ALBUM = new Mode("Альбом", "Albums");
    
    private Mode(String ruName, String lvName) {
        super(ruName, lvName);
    }
}
