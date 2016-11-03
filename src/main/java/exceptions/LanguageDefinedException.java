package exceptions;

public class LanguageDefinedException extends Exception {
    
    
    public LanguageDefinedException(String message) {
        super(message);
    }
    
    public LanguageDefinedException(String message, Throwable cause) {
        super(message, cause);
    }
}
