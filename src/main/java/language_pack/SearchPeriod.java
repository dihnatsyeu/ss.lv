package language_pack;

public class SearchPeriod extends LanguageElement {
    
    public static final SearchPeriod TODAYS = new SearchPeriod("Cреди сегодняшних объявлений", "Starp šodienas sludinājumiem");
    public static final SearchPeriod LAST3DAYS = new SearchPeriod("За последних 3 дня", "Pēdējās 3 dienās");
    public static final SearchPeriod LASTWEEK = new SearchPeriod("За последнюю неделю", "Pēdejā nedēļā");
    public static final SearchPeriod LASTMONTH = new SearchPeriod("За последний месяц", "Pēdējā mēnesī");
    public static final SearchPeriod ALL = new SearchPeriod("Среди всех объявлений", "Starp visiem sludinājumiem");
            
    private SearchPeriod(String ruName, String lvName) {
        super(ruName, lvName);
    }
}
