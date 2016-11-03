package web_driver_bindings;

public class GlobalController {
    
    public static void closeBrowser() {
        WebDriverManager.getWebDriver().quit();
    }
}
