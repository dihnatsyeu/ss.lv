package language_pack;

public class TransactionType extends LanguageElement {
    
    public static final TransactionType SELL = new TransactionType("Продажа", "Pārdod");
    public static final TransactionType BUY = new TransactionType("Покупка", "Pērk");
    public static final TransactionType EXCHANGE = new TransactionType("Обмен", "Maina");
    public static final TransactionType REPAIR = new TransactionType("Ремонт", "Remonts");
    public static final TransactionType OTHER = new TransactionType("Разное", "Dažādi");
    public static final TransactionType FILL = new TransactionType("Заправка", "Uzpildīšana");
            
            
            
            
    TransactionType(String ruName, String lvName) {
        super(ruName, lvName);
    }
}
