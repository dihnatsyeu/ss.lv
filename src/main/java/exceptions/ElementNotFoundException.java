package exceptions;

public class ElementNotFoundException extends Exception {
    
    public ElementNotFoundException(String message) {
        super(message);
    }
    
    public ElementNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
