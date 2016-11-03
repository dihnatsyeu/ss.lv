package web_driver_bindings;

import org.openqa.selenium.WebDriver;

public class Navigator {
    
    private WebDriver driver = WebDriverManager.getWebDriver();
    
    public void navigateTo(String pageURL) {
        driver.navigate().to(pageURL);
    }
}
